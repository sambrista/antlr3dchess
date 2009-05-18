header{
	package chess;
	import java.util.*;
	import java.lang.*;
	import java.io.*;
}

/** Clase Anasint
* realiza el analisis sintactico y semantico
* @author Manuel Cruz Ramrez - Marta Lpez Cceres
*/
class Anasint extends Parser;
options{
  k=3;
  buildAST = true;	
}

{
  //zona de declaracion nuestra
  ArrayList listaRes = new ArrayList();
  int contRes = 0; 
  ArrayList listaIden = new ArrayList();
  int contId = 0;
  ArrayList listaNombres = new ArrayList();
  boolean dentroBucle=false;
  int salirBucle = 0 ;
  Game partida = new Game();
}

/** regla inicial
* @ -> indica el fin de la ejecucion
*/
instrucciones : (BEGIN_BOARD board_zone END_BOARD BEGIN_GAME game_zone END_GAME )* OP_FIN
 ;

/** zona sketch
*/
board_zone : 
  (BEGIN_VARIABLES zona_decl END_VARIABLES
  | fun_comun
  | board_fun  
  | buc_ske)* ;

/** zona transform
*/
game_zone : 
  (BEGIN_VARIABLES zona_decl END_VARIABLES
  | fun_comun
  | game_fun  
  | buc_tran)* ;


/**declaraciones en la zona declare
*/
zona_decl : {System.out.println("  <VARIABLES>");}
  (declaracion)* {System.out.println("  </VARIABLES>");} ;

/** declaracion de variables
*/
declaracion {int num=0;}: 
  n1:IDENT (OP_SEPA n2:IDENT {listaNombres.add(n2.getText());})* OP_DECL num=tipo_decl OP_DELI 
  { //se busca el numero de declaracion en la lista, se le aade el nombre y se vuelve a guardar
  	Iden id = new Iden();
    for(int i=0;i<listaIden.size();i++) 
    {
   	  id = (Iden)listaIden.get(i);
      if(id.obtenerNumId() == num)
        break;
    }  

    Iden mismoNom = new Iden();
    int igual=0;
    for(int i=0;i<listaIden.size();i++) 
    {
   	  mismoNom = (Iden)listaIden.get(i);
      if(n1.getText().equals(mismoNom.obtenerNombre())){
      	igual=1;
        break; 
      }   
    }	
    
    if(igual == 0)
    {
      listaIden.remove(id);    
      id.establecerNombre(n1.getText());
      listaIden.add(id);
    }
    else
    {
      System.out.println("    Ya existe una variable con " + n1.getText() + " por nombre.");
      listaIden.remove(id); 
    }
    //si hay varios identificadores, se obtienen sus nombres y se van guardando las nuevas declaraciones
    String nom;
    int total=listaNombres.size();
    for(int i=total-1;i>=0;i--) 
    {
      nom = (String)listaNombres.get(i);	
      listaNombres.remove(nom);
      
      igual=0;
      for(int j=0;j<listaIden.size();j++) 
      {
   	    mismoNom = (Iden)listaIden.get(j);
        if(nom.equals(mismoNom.obtenerNombre())){
      	  igual=1;
          break; 
        }   
      }	
      if(igual == 0)
      {
        Iden id2 = new Iden();
        id2.establecerNombre(nom);
        id2.establecerTipo(id.obtenerTipo());
        id2.establecerValor(id.obtenerValor());
        id2.establecerNumId(id.obtenerNumId());
        id2.establecerConst(id.obtenerConst());
        listaIden.add(id2);
      }
      else
      {
        System.out.println("    Ya existe una variable con " + nom + " por nombre.");
      }
    }	  
  };
  
/** tipo de variable
*/
tipo_decl returns [int id=0]{int num=0;}: 
  (num=decl_real | num=decl_int | num=decl_bool | num=decl_cad | num=decl_cons) 
  {id=num;}
  ;

/** variable real
*/
decl_real returns [int num=0]{double e1;}: 
  (REAL OP_ASIG) => REAL OP_ASIG e1=expr_real //si tiene valor asignado
    {   contId++;
        Iden id = new Iden();
        id.establecerTipo("real");
        id.establecerValor(String.valueOf(e1));
        id.establecerNumId(contId);
        listaIden.add(id);
        num=contId;
    }
  | REAL    //si no tiene valor
    { contId++;
      Iden id = new Iden();
      id.establecerTipo("real");
      id.establecerNumId(contId);
      listaIden.add(id);
      num=contId;
    }  
  ;

/** variable entero
*/  
decl_int returns [int num=0]{int i1;}: 
  (ENTERO OP_ASIG) => ENTERO OP_ASIG i1=expr_entero 
    {  	contId++;
        Iden id = new Iden();
        id.establecerTipo("entero");
        id.establecerValor(String.valueOf(i1));
        id.establecerNumId(contId);
        listaIden.add(id);
        num=contId;
    }
  | ENTERO
    { contId++;
      Iden id = new Iden();
      id.establecerTipo("entero");
      id.establecerNumId(contId);
      listaIden.add(id);
      num=contId;
    }  
  ;
  
/** variable booleana
*/
decl_bool returns [int num=0]{boolean b1;}:
  (BOOLEANO OP_ASIG) => BOOLEANO OP_ASIG b1=expr_bool
    { contId++;
      Iden id = new Iden();
      id.establecerTipo("booleano");
      id.establecerValor(String.valueOf(b1));
      id.establecerNumId(contId);
      listaIden.add(id);
      num=contId;
    }
  | BOOLEANO
    { contId++;
      Iden id = new Iden();
      id.establecerTipo("booleano");
      id.establecerNumId(contId);
      listaIden.add(id);
      num=contId;
    }  
  ;

/** variable cadena
*/
decl_cad returns [int num=0]{String s1;}:
  (CADENA OP_ASIG) => CADENA OP_ASIG s1=expr_cadena 
    {  	contId++;
        Iden id = new Iden();
        id.establecerTipo("cadena");
        id.establecerValor(s1);
        id.establecerNumId(contId);
        listaIden.add(id);
        num=contId;
    }  
  | CADENA
    { contId++;
      Iden id = new Iden();
      id.establecerTipo("cadena");
      id.establecerNumId(contId);
      listaIden.add(id);
      num=contId;
    }    
  ;

/** declaracion variables constantes
*/
decl_cons returns [int id=0]{int num=0;}: 
  CTE (num=cte_real | num=cte_int | num=cte_bool | num=cte_cad) 
  { if(num==0)
  	  throw new NullPointerException("    Debe asignar un valor a la variable constante.");
  	else  
  	  id=num;}
  ;

/** variable constante real 
*/
cte_real returns [int num=0]{double e1=0.;}: 
  REAL OP_ASIG e1=expr_real 
  {   contId++;
      Iden id = new Iden();
      id.establecerTipo("real");
      id.establecerValor(String.valueOf(e1));
      id.establecerNumId(contId);
      id.establecerConst(true);
      listaIden.add(id);
      num=contId;
  };

/** variable constante entero 
*/
cte_int returns [int num=0]{int i1=0;}: 
  ENTERO OP_ASIG i1=expr_entero
  {	  contId++;
      Iden id = new Iden();
      id.establecerTipo("entero");
      id.establecerValor(String.valueOf(i1));
      id.establecerNumId(contId);
      id.establecerConst(true);
      listaIden.add(id);
      num=contId;
  };

/** variable constante booleana 
*/
cte_bool returns [int num=0]{boolean b1;}: 
  BOOLEANO OP_ASIG b1=expr_bool
  { contId++;
    Iden id = new Iden();
    id.establecerTipo("booleano");
    id.establecerValor(String.valueOf(b1));
    id.establecerNumId(contId);
    id.establecerConst(true);
    listaIden.add(id);
    num=contId;
  };

/** variable constante cadena 
*/
cte_cad returns [int num=0]{String s1;}: 
  CADENA OP_ASIG s1=expr_cadena
  {   contId++;
      Iden id = new Iden();
      id.establecerTipo("cadena");
      id.establecerValor(s1);
      id.establecerNumId(contId);
      id.establecerConst(true);
      listaIden.add(id);
      num=contId;
  };


/**funciones comunes a las zonas sketch y transform
*/
fun_comun {String s1="";}: (S_W fun_s_w | S_D fun_s_d | EXI fun_exi | G_N fun_g_n | G_III fun_g_iii | G_II fun_g_ii 
  | X_P fun_x_p | Y_P fun_y_p | XO_S fun_xo_s | YO_S fun_yo_s | XE_S fun_xe_s | YE_S fun_ye_s
  | X_C fun_x_c | Y_C fun_y_c | R_C fun_r_c | MI fun_mi | MII fun_mii | MIII fun_miii
  | GEO fun_geo | EXP fun_exp | R_ENTERO fun_r_entero | R_REAL fun_r_real | R_BOOL fun_r_bool
  | R_CADENA fun_r_cadena | WRI fun_wri 
  | PAU {
  	InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader (isr);
  	try{
      System.out.println("  En PAUSE hasta que pulse ENTER.");
      String texto = br.readLine();
    }catch(Exception e){ e.printStackTrace();}
  	}
  | n:IDENT OP_ASIG s1=expresion
    {
      int existe=0;      
      Iden id = new Iden();
      for(int i=0;i<listaIden.size();i++) 
      {
   	    id = (Iden)listaIden.get(i);
   	    if(n.getText().equals(id.obtenerNombre())){
   	      existe=1;
   	      break;
   	    }	
      }
      if(existe == 1)
      {
      	if(id.obtenerConst())  //si es constante
      	  System.out.println("  Variable constante, no se puede modificar su valor");
      	else   //si no
      	{
      	  String tipo="";
      	  tipo=id.obtenerTipo();
      	    if(tipo.equals("real"))  //si es real
      	    {
              if(s1.substring(0,1).equals("D")){
                double valor = Double.parseDouble(s1.substring(1)); 
                listaIden.remove(id);    
                id.establecerValor(String.valueOf(valor));
                listaIden.add(id);
              }
              else
                System.out.println("  No se puede realizar la asignacin. Tipos incompatibles.");
      	    }
            else
      	    {
      	      if(tipo.equals("entero"))  //si es entero
      	      {
      	  	    if(s1.substring(0,1).equals("E")){
                  int valor = Integer.parseInt(s1.substring(1)); 
                  listaIden.remove(id);    
                  id.establecerValor(String.valueOf(valor));
                  listaIden.add(id);
                }	  
                else
                  System.out.println("  No se puede realizar la asignacin. Tipos incompatibles.");
      	      }
      	      else
      	      {
                if(tipo.equals("booleano")) //si es booleano
      	        {
      	          if(s1.substring(0,1).equals("B")){
                    boolean valor = Boolean.parseBoolean(s1.substring(1)); 
                    listaIden.remove(id);    
                    id.establecerValor(String.valueOf(valor));
                    listaIden.add(id);
                  }	  
                  else
                    System.out.println("  No se puede realizar la asignacin. Tipos incompatibles.");
      	        }
      	        else  //si es una cadena
      	        {
      	          if(s1.substring(0,1).equals("S")){	
                    String valor = s1.substring(1); 
                    listaIden.remove(id);    
                    id.establecerValor(String.valueOf(valor));
                    listaIden.add(id);
                  }  
                  else
                    System.out.println("  No se puede realizar la asignacin. Tipos incompatibles.");
      	        }
      	      }
      	    }    	  	
      	}
      }
      else
      	System.out.println("  La variable de la asignacin " + n.getText() + " no existe.");
    }	
  ) OP_DELI ;
  
/**funcion SKETCH_WIDTH()
* Devuelve un flotante indicando la dimensin en X del croquis.
*/
fun_s_w returns [double valor=0.]: OP_PAR_I OP_PAR_D 
  {
  System.out.println("WOLOLO");
  };
  
/**funcion SKETCH_DEPTH()
* Devuelve un flotante indicando la dimensin en Z del croquis.
*/
fun_s_d returns [double valor=0.]: OP_PAR_I OP_PAR_D 
  {
  System.out.println("WOLOLO");
  };
  
/**funcion EXIST(expr_ent)
* Devuelve TRUE si existe la instancia de identidad especificada
* por la expresin entera expr_ent y FALSE en caso contrario.
*/
fun_exi returns [boolean valor=false]{int i1;} : OP_PAR_I i1=expr_entero OP_PAR_D 
  {  System.out.println("WOLOLO");
  };

/**funcion GET_NAME(expr_ent)
* Devuelve el nombre del objeto 3D correspondiente a la instancia
* cuya identidad es especificada en la expresin entera expr_ent.
* En caso de no existir tal objeto, devuelve la CADENA NULA.
*/
fun_g_n returns [String valor=""]{int i1;}: OP_PAR_I i1=expr_entero OP_PAR_D 
  {
  System.out.println("WOLOLO");
  }; 
  
/** funcion GET_3DFILE(expr_cad)
* Devuelve la cadena de caracteres correspondiente al fichero
* X3D/VRML asociado al objeto 3D cuyo nombre es especificado
* en la expresin de cadena de caracteres expr_cad. En caso de no
* existir tal objeto, devuelve la CADENA NULA.
*/
fun_g_iii returns [String valor=""]{String s1;}: OP_PAR_I s1=expr_cadena OP_PAR_D 
  {
  System.out.println("WOLOLO");
  };
  
/**funcion GET_2DTYPE(expr_cad)
* Devuelve la cadena de caracteres correspondiente al tipo de
* representante 2D (P: punto, S: segmento y C: crculo)
* asociado al objeto 3D cuyo nombre es especificado en la
* expresin de cadena de caracteres expr_cad. En caso de no existir
* tal objeto, devuelve la CADENA NULA.
*/
fun_g_ii returns [String valor=""]{String s1;}: OP_PAR_I s1=expr_cadena OP_PAR_D 
  {
  System.out.println("WOLOLO");
  };
  
/** funcion X_P_INSTANCE(expr_ent)
* Devuelve un flotante correspondiente al valor actual de la
* coordenada X del punto representante 2D de la instancia 3D cuya
* identidad queda especificada por la expresin entera expr_ent.
*/
fun_x_p returns [double valor=-1.]{int i1;}: OP_PAR_I i1=expr_entero OP_PAR_D 
  {
  System.out.println("WOLOLO");
  };
  
/**funcion Y_P_INSTANCE(expr_ent)
* Devuelve un flotante correspondiente al valor actual de la
* coordenada Y del punto representante 2D de la instancia 3D cuya
* identidad queda especificada por la expresin entera expr_ent.
*/
fun_y_p returns [double valor=-1.]{int i1;}: OP_PAR_I i1=expr_entero OP_PAR_D 
  {
  System.out.println("WOLOLO");
  };  	
  
/**funcion XO_S_INSTANCE(expr_ent)
* Devuelve un flotante correspondiente al valor actual de la
* coordenada X del punto origen del segmento representante 2D de
* la instancia 3D cuya identidad queda especificada por la
* expresin entera expr_ent.
*/
fun_xo_s returns [double valor=-1.]{int i1;}: OP_PAR_I i1=expr_entero OP_PAR_D 
  {
  System.out.println("WOLOLO");
  };
  
/**funcion YO_S_INSTANCE(expr_ent)
* Devuelve un flotante correspondiente al valor actual de la
* coordenada Y del punto origen del segmento representante 2D de
* la instancia 3D cuya identidad queda especificada por la
* expresin entera expr_ent.
*/
fun_yo_s returns [double valor=-1.]{int i1;}: OP_PAR_I i1=expr_entero OP_PAR_D 
  {
  System.out.println("WOLOLO");
  };
  
/** funcion XE_S_INSTANCE(expr_ent)
* Devuelve un flotante correspondiente al valor actual de la
* coordenada X del punto destino del segmento representante 2D
* de la instancia 3D cuya identidad queda especificada por la
* expresin entera expr_ent.
*/
fun_xe_s returns [double valor=-1.]{int i1;}: OP_PAR_I i1=expr_entero OP_PAR_D 
  {
  System.out.println("WOLOLO");
  };
  
/**funcion YE_S_INSTANCE(expr_ent)
* Devuelve un flotante correspondiente al valor actual de la
* coordenada Y del punto destino del segmento representante 2D
* de la instancia 3D cuya identidad queda especificada por la
* expresin entera expr_ent.
*/
fun_ye_s returns [double valor=-1.]{int i1;}: OP_PAR_I i1=expr_entero OP_PAR_D 
  {
  System.out.println("WOLOLO");
  };

/**funcion X_C_INSTANCE(expr_ent)
* Devuelve un flotante correspondiente al valor actual de la
* coordenada X del centro del crculo representante 2D de la
* instancia 3D cuya identidad queda especificada por la expresin
* entera expr_ent.
*/
fun_x_c returns [double valor=-1.]{int i1;}: OP_PAR_I i1=expr_entero OP_PAR_D 
  {
  System.out.println("WOLOLO");
  };
  
/**funcion Y_C_INSTANCE(expr_ent)
* Devuelve un flotante correspondiente al valor actual de la
* coordenada Y del centro del crculo representante 2D de la
* instancia 3D cuya identidad queda especificada por la expresin
* entera expr_ent.
*/
fun_y_c returns [double valor=-1.]{int i1;}: OP_PAR_I i1=expr_entero OP_PAR_D 
  {
  System.out.println("WOLOLO");
  };
  
/**funcion R_C_INSTANCE(expr_ent)
* Devuelve un flotante correspondiente al valor actual del radio del
* crculo representante 2D de la instancia 3D cuya identidad queda
* especificada por la expresin entera expr_ent.
*/
fun_r_c returns [double valor=-1.]{int i1;}: OP_PAR_I i1=expr_entero OP_PAR_D 
  {
  System.out.println("WOLOLO");
  };
  
/**funcion M1_GEOM_CONST(exp_ent)
* Devuelve la identidad de la instancia 3D correspondiente al
* primer elemento geomtrico que relaciona la restriccin
* geomtrica cuya identidad queda especificada por la expresin
* entera exp_ent. Si la identidad indicada no est asociada a
* ninguna restriccin geomtrica existente devuelve -1.
*/
fun_mi returns [int valor=-1]{int i1;}: OP_PAR_I i1=expr_entero OP_PAR_D 
  {
  System.out.println("WOLOLO");
  };
  
/**funcion M2_GEOM_CONST(exp_ent)
* Devuelve la identidad de la instancia 3D correspondiente al
* segundo elemento geomtrico que relaciona la restriccin
* geomtrica cuya identidad queda especificada por la expresin
* entera exp_ent. Si la identidad indicada no est asociada a
* ninguna restriccin geomtrica existente devuelve -1.
*/
fun_mii returns [int valor=-1]{int i1;}: OP_PAR_I i1=expr_entero OP_PAR_D 
  {
  System.out.println("WOLOLO");
  };
  
/**funcion M3_GEOM_CONST(exp_ent)
* Devuelve la identidad de la instancia 3D correspondiente al
* tercer elemento geomtrico que relaciona la restriccin
* geomtrica cuya identidad queda especificada por la expresin
* entera exp_ent. Si la identidad indicada no est asociada a
* ninguna restriccin geomtrica existente devuelve -1. Si la
* restriccin geomtrica especificada no relaciona 3 elementos
* geomtricos entre s devuelve -2.
*/
fun_miii returns [int valor=-1]{int i1;}: OP_PAR_I i1=expr_entero OP_PAR_D
  {
  System.out.println("WOLOLO");
  };
  
/**funcion GEOM_CONST_TYPE(exp_ent)
* Devuelve una cadena de caracteres que representa el tipo (D:
* istancia, O: orientacin, A: ngulo) de la restriccin
* geomtrica cuya identidad queda especificada en la expresin
* entera exp_ent. Si la identidad indicada no est asociada a
* ninguna restriccin geomtrica existente devuelve la CADENA
* NULA.
*/
fun_geo returns [String valor=""]{int i1;}: OP_PAR_I i1=expr_entero OP_PAR_D
  {
  System.out.println("WOLOLO");
  };
  
/**funcion EXPORT_ 3D(expr_cad)
*  Genera un fichero VRML/X3D, con el nombre especificado en la
* expresin de cadenas de caracteres expr_cad, en el que aparezca
* la representacin 3D para el croquis definido hasta el momento
* actual: elementos geomtricos representados por instancias 3D y
* restricciones geomtricas representadas por cilindros del mismo
* radio (diferente color para cada tipo de restriccin geomtrica)
* que unan los puntos representativos de la ubicacin de cada
* elemento geomtrico.
*/
fun_exp {String s1="";}: 
  OP_PAR_I s1=expr_cadena OP_PAR_D 
  {
  System.out.println("WOLOLO");
  };
  
/**funcion READ_INTEGER()
* Lee un entero de teclado y lo devuelve.
*/
fun_r_entero returns [int valor=-1]: OP_PAR_I OP_PAR_D 
  { InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader (isr);
  	try{
  	  System.out.println("  READ_INTEGER -> Introduzca un valor entero.");	
      int num = Integer.parseInt(br.readLine());
      valor=num;
      System.out.println("  READ_INTEGER -> El valor entero ledo es: " + valor);
    }catch(Exception e){ e.printStackTrace();}
  };
  
/**funcion READ_DOUBLE()
* Lee un flotante de teclado y lo devuelve.
*/
fun_r_real returns [double valor=-1.]: OP_PAR_I OP_PAR_D 
  {	InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader (isr);
  	try{
  	  System.out.println("  READ_DOUBLE -> Introduzca un valor real.");		
      double num = Double.parseDouble(br.readLine());
      valor=num;
      System.out.println("  READ_DOUBLE -> El valor real ledo es: " + valor);
    }catch(Exception e){ e.printStackTrace();}
  };
  
/**funcion READ_BOOL ()
* Lee un booleano de teclado y lo devuelve (TRUE o FALSE).
*/
fun_r_bool returns [boolean valor=false]: OP_PAR_I OP_PAR_D 
  {	InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader (isr);
  	try{
  	  System.out.println("  READ_BOOL -> Introduzca un valor booleano.");	
      boolean val = Boolean.parseBoolean(br.readLine().toLowerCase());
      valor=val;
      System.out.println("  READ_BOOL -> El valor booleano ledo es: " + valor);
    }catch(Exception e){ e.printStackTrace();}
  };
  
/**funcion READ_STRING()
* Lee una cadena de teclado y la devuelve.
*/
fun_r_cadena returns [String valor=""]: OP_PAR_I OP_PAR_D 
  {	InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader (isr);
  	try{
  	  System.out.println("  READ_STRING -> Introduzca una cadena.");	
      String texto = br.readLine();
      valor=texto;
      System.out.println("  READ_STRING -> La cadena leda es: " + valor);
    }catch(Exception e){ e.printStackTrace();}
  };
  
/**funcion WRITE (expresion)
* Escribe el valor de la expresin expresion en pantalla en
* una nueva lnea.
*/
fun_wri {String s1;}: OP_PAR_I s1=expresion OP_PAR_D 
  { System.out.println("  WRITE -> " + s1.substring(1));
  };
  

/**funciones de la zona sketch
*/
board_fun : 
  (RANDOM_BOARD r_b_fun | ADD_PIECE a_p_fun | SETUP_PIECE s_p_fun | REMOVE_PIECE r_p_fun | GENERATE_3D_BOARD g_3_fun ) OP_DELI ;

/**funcion SKETCH_SURFACE (expr_flot1, expr_flot2)
* La superficie XZ sobre la que se ubicarn las instancias de los
* objetos 3D del croquis ser por defecto de 50x50 m. Estar
* representada por un paraleleppedo (Box) de altura (Y) 1 m,
* cuya base superior tendr los vrtices en las siguientes
* ubicaciones: (0,0,0), (0,0,50), (50,0,0) y (50,0,50).
*
* La invocacin de esta orden permitir modificar sus
* dimensiones (sin modificar su orientacin y manteniendo un
* vrtice de la base superior en el origen de coordenadas)
* aadiendo el resultado de la expresin flotante expr_flot1 a la
* dimensin en X y aadiendo el resultado de la expresin
* expr_flot2 a la dimensin en Z. La superficie del croquis
* podr aumentar o disminuir sus dimensiones siempre y
* cuando no queden fuera de la nueva superficie los
* representantes 2D de las instancias de objetos 3D que se
* encuentren presentes en la antigua superficie.
*/
r_b_fun {double prop = 1; String disp; int num_pics;}: OP_PAR_I num_pics=expr_entero (OP_SEPA prop=expr_real)? OP_SEPA disp=expr_cadena OP_PAR_D 
  {
  	System.out.println("***DEBUG WOLOLO");
  	partida.random(num_pics, prop, disp);
  };
  
/**funcion OBJECT_3D (expr_cad1, expr_cad2)
* Crea un objeto 3D de nombre nico especificado por la
* expresin de cadenas de caracteres expr_cad1. El objeto 3D,
* con base centrada en el origen de coordenadas (0,0,0), se
* encuentra definido en el fichero VRML/X3D especificado por
* la expresin de cadena de caracteres expr_cad2 (la extensin
* del fichero debe ser propia de VRML/X3D). El elemento
* geomtrico 2D que lo representar ser un punto.
*
* OBJECT_3D (expr_cad1, expr_cad2, exp_fl1, exp_fl2)
* Crea un objeto 3D de nombre nico especificado por la
* expresin de cadenas de caracteres expr_cad1. El objeto 3D,
* con base centrada en el origen de coordenadas (0,0,0), se
* encuentra definido en el fichero VRML/X3D especificado por
* la expresin de cadena de caracteres expr_cad2 (la extensin
* del fichero debe ser propia de VRML/X3D). El elemento
* geomtrico 2D que lo representar ser un segmento. La
* longitud y orientacin de tal segmento la define como punto
* medio el origen de coordenadas (0,0,0) y como uno de los
* extremos, incluido en el croquis, las coordenadas (c1, c2),
* siendo c1 (eje X) el resultado de evaluar la expresin flotante
* expr_fl1 y siendo c2 (eje Z) el resultado de evaluar la
* expresin flotante expr_fl2.
*
* OBJECT_3D (expr_cad1, expr_cad2, exp_fl)
* Crea un objeto 3D de nombre nico especificado por la
* expresin de cadenas de caracteres expr_cad1. El objeto 3D,
* con base centrada en el origen de coordenadas (0,0,0), se
* encuentra definido en el fichero VRML/X3D especificado por
* la expresin de cadena de caracteres expr_cad2 (la extensin
* del fichero debe ser propia de VRML/X3D). El elemento
* geomtrico 2D que lo representar ser un crculo cuyo radio
* vendr determinado por el resultado de la expresin flotante
* exp_fl.
*/
a_p_fun {String s1="",s2="", s3=""; int e1=1;}: 
  OP_PAR_I s1=expr_cadena OP_SEPA s2=expr_cadena OP_SEPA s3=expr_cadena
  OP_SEPA e1=expr_entero OP_PAR_D 
  {
  partida.addPiece(s1,s2,s3,e1);
  };
  
/**funcion INSTANCE (expr_ent1, expr_cad, expr_fl1, expr_fl2)
* Crea una instancia de un objeto cuya identidad queda
* especificada en la expresin entera expr_ent1 (la identidad
* ser un nmero natural nico para todas las instancias de
* objetos 3D). La instancia corresponder al objeto 3D cuyo
* nombre es resultado de la expresin de cadenas de caracteres
* expr_cad. El representante 2D de la instancia vendr definido
* por el punto de coordenadas (c1, c2), siendo c1 (eje X) el
* resultado de evaluar la expresin flotante expr_fl1 y siendo c2
* (eje Z) el resultado de evaluar la expresin flotante expr_fl2.
* Si el objeto 3D es de tipo punto, (c1, c2) ser tal
* representante; si es de tipo segmento, (c1, c2) corresponder
* al punto medio del segmento; si es de tipo crculo, (c1, c2) ser
* el centro del crculo. La instancia ser ubicada sobre el
* croquis en esta localizacin.
*/
s_p_fun {int i1, i2; String s1, s2;}: 
  OP_PAR_I s1=expr_cadena OP_SEPA i1=expr_entero OP_SEPA s2=expr_cadena OP_SEPA i2=expr_entero OP_PAR_D 
  {
  partida.setupPiece(s1,i1,s2,i2);
  };
  
/**funcion DISTANCE (exp_ent1, exp_ent2)
* Crea una restriccin geomtrica de distancia entre dos
* instancias cuya identidad viene representada respectivamente
* como el resultado de la evaluacin de las expresiones enteras
* exp_ent1 y exp_ent2 (la identidad ser un nmero natural
* nico para todas las restricciones geomtricas). El valor
* inicial de esta restriccin geomtrica ser el de la distancia
* eucldea entre los representantes 2D de las instancias
* correspondientes. Devuelve un identificador entero nico
* para la restriccin geomtrica creada.
*/
r_p_fun {int i1 = -1; String s1, s2 = "";}: 
  OP_PAR_I s1=expr_cadena (OP_SEPA i1=expr_entero | OP_SEPA s2=expr_cadena) OP_PAR_D 
  {
  	if (i1 == -1) {
  		partida.removePiece(s1,s2);
  	} else {
  		partida.removePiece(s1,i1);
  	}
  };
  
/**funcion ANGLE (exp_ent1, exp_ent2)
* Crea una restriccin geomtrica de ngulo entre dos
* instancias cuya identidad viene representada respectivamente
* como el resultado de la evaluacin de las expresiones enteras
* exp_ent1 y exp_ent2 (la identidad ser un nmero natural
* nico para todas las restricciones geomtricas). El valor
* inicial de esta restriccin geomtrica ser el del ngulo entre
* los representantes 2D de las instancias correspondientes.
* Devuelve un identificador entero nico para la restriccin
* geomtrica creada.
*/
g_3_fun {String s1;}: 
  OP_PAR_I s1=expr_cadena OP_PAR_D 
  {
  	try{
		 	partida.generate3D(s1);
		} catch (IOException e) {
			e.printStackTrace();	
		}
 
  };
  
/**funciones de la zona de transform
*/
game_fun : 
  (MOVE_PLAYER_W m_p_w_fun | MOVE_PLAYER_B m_p_b_fun | MOVE_RANDOMLY_W m_r_w_fun | MOVE_RANDOMLY_B m_r_b_fun | STATE s_fun
   | MOVEMENTS_LIST m_l_fun | STATE_3D s_3_fun | TRA fun_tra | ROT fun_rot | SCA fun_sca) OP_DELI ;

m_p_w_fun {int i1, i2; String s1, s2;}: 
  OP_PAR_I s1=expr_cadena OP_SEPA i1=expr_entero OP_SEPA s2=expr_cadena OP_SEPA i2=expr_entero OP_PAR_D 
  {
  partida.movePlayerW(s1,i1,s2,i2);
  };
  
  m_p_b_fun {int i1, i2; String s1, s2;}: 
  OP_PAR_I s1=expr_cadena OP_SEPA i1=expr_entero OP_SEPA s2=expr_cadena OP_SEPA i2=expr_entero OP_PAR_D 
  {
  partida.movePlayerB(s1,i1,s2,i2);
  };
  
  m_r_w_fun {}: 
  OP_PAR_I OP_PAR_D 
  {
  partida.moveRandomlyW();
  };
  
  m_r_b_fun {}: 
  OP_PAR_I OP_PAR_D 
  {
  partida.moveRandomlyB();
  };
  
  s_fun {String s1 = null;}: 
  OP_PAR_I (s1=expr_cadena)? OP_PAR_D 
  {
  	partida.state(s1);
  };
  
  s_3_fun {String s1 = "./3D/";}: 
  OP_PAR_I s1=expr_cadena OP_PAR_D 
  {
  	

  	try{
		  	partida.state3D(s1);
		} catch (IOException e) {
			e.printStackTrace();	
		}
  };
  
  m_l_fun {}: 
  OP_PAR_I OP_PAR_D 
  {
  partida.movementsList();
  };
  
/**funcion TRANSLATE (expr_ent1, expr_fl1, expr_fl2)
* Traslacin de la instancia de identidad especificada por la
* expresin entera expr_ent1. El resultado de evaluar la
* expresin flotante expr_fl1 establece la traslacin en el eje X y
* el resultado de evaluar la expresin entera expr_ent2 indica la
* correspondiente traslacin en Z. El representante 2D de la
* instancia y las restricciones geomtricas asociadas a la misma
* se modificarn de acuerdo a la mencionada traslacin.
*/
fun_tra {int i1=-1; double e1=-1.,e2=-1.;}: OP_PAR_I i1=expr_entero OP_SEPA e1=expr_real 
  OP_SEPA e2=expr_real OP_PAR_D 
  {
  System.out.println("WOLOLO");
  };
  
/**funcion ROTATE(expr_ent1, expr_fl1)
* Rotacin con respecto al eje Y de la instancia de identidad
* especificada por la expresin entera expr_ent1. El resultado
* de evaluar la expresin flotante expr_fl1 establece los grados
* correspondientes a la misma. El representante 2D de la
* instancia y las restricciones geomtricas asociadas a la misma
* se modificarn de acuerdo a la mencionada rotacin.
*/
fun_rot {int i1=-1; double e1=0.;}: OP_PAR_I i1=expr_entero OP_SEPA e1=expr_real OP_PAR_D 
  {
  System.out.println("WOLOLO");
  };
  
/**funcion SCALE (expr_ent1, expr_fl1, expr_fl2)
* Escalado de la instancia de identidad especificada por la
* expresin entera expr_ent1. El resultado de evaluar la
* expresin flotante expr_fl1 establece el escalado en el eje X y
* el resultado de evaluar la expresin flotante expr_fl2 indica el
* escalado en Z. El representante 2D de la instancia y las
* restricciones geomtricas asociadas a la misma se modificarn
* de acuerdo al mencionado escalado.
*/
fun_sca {int i1=-1; double e1=-1.,e2=-1.;}: 
  OP_PAR_I i1=expr_entero OP_SEPA e1=expr_real (OP_SEPA e2=expr_real)? OP_PAR_D 
  {
  System.out.println("WOLOLO");
  };


/**expresiones 
*/
expresion returns [String res=null]{int i1; double e1; String s1; boolean b1;}: 
  //se le aade al principio su tipo
  (i1=expr_entero {res = "E" + String.valueOf(i1);}
  |e1=expr_real {res = "D" + String.valueOf(e1);} 
  |s1=expr_cadena {res = "S" + s1;}  
  |b1=expr_bool {res = "B" + String.valueOf(b1);}
  );
  
/**expresion para enteros.
* suma
*/
expr_entero returns [int res=0]{int i1=0, i2=0;}: 
  (i1=expr_e_resta {res = i1;}
  | )  //para los numeros con signo
    (OP_SUMA i2=expr_e_resta {res = res+i2;})*  
  ; 
  
/** resta enteros
*/ 
expr_e_resta returns [int res=0]{int i1=0, i2=0;}: 
  (i1=exp_e_mult {res = i1;}
  | )  //para los numeros con signo
    (OP_REST i2=exp_e_mult {res=res-i2;})* 
  ;  

/** multiplicacion enteros
*/ 
exp_e_mult returns [int res=0]{int i1=0, i2=0;}:
  i1=exp_e_divi {res = i1;}
    (OP_MULT i2=exp_e_divi {res=res*i2;})* 
  ;
  
/** division enteros
*/ 
exp_e_divi returns [int res=0]{int i1=0, i2=0;}:
  i1=exp_e_modu {res = i1;}
    (OP_DIVI i2=exp_e_modu 
      {if(i2==0)
         throw new ArithmeticException("      Divisin por cero.");
       else
         res=res/i2;})* 
  ;
  
/** modulo enteros
*/ 
exp_e_modu returns [int res=0]{int i1=0, i2=0;}:
  i1=exp_e_pot {res = i1;}
    (OP_MODU i2=exp_e_pot {res=res%i2;})* 
  ;
  
/** potencia enteros
*/ 
exp_e_pot returns [int res=0]{int i1=0, i2=0;}:
  i1=exp_e_base {res = i1;}
    (OP_EXPO i2=exp_e_base {res=(int)Math.pow(res,i2);})* 
  ;
  
/** expresion base enteros
*/ 
exp_e_base returns [int res=0]{int i1=0;} : 
  n:LIT_ENTERO {res= new Integer (n.getText()).intValue();} 
  | OP_PAR_I i1=expr_entero OP_PAR_D {res = i1;}
  | n1:IDENT 
      {
       int existe=0;      
       Iden id = new Iden();
       for(int i=0;i<listaIden.size();i++) 
       {
   	     id = (Iden)listaIden.get(i);
   	     if(n1.getText().equals(id.obtenerNombre())){
   	       existe=1;
   	       break;
   	     }	
       }
       if(existe == 1)
       {
         String tipo="";
         tipo=id.obtenerTipo();
         if(tipo.equals("entero")) 
         {
           res=Integer.parseInt(id.obtenerValor());
         }
         else
           System.out.println("  No se puede realizar la asignacin. Tipos incompatibles.");
       }
       else
         System.out.println("  La variable " + n1.getText() + " no existe.");
      }
  ;

/**expresion para reales
* suma
*/
expr_real returns [double res=0.]{double e1=0., e2=0.;}: 
  (e1=expr_r_resta {res=e1;}
  | )  //para los numeros con signo
    (OP_SUMA e2=expr_r_resta {res = res+e2;})*  
  ;  
  
/** resta reales
*/ 
expr_r_resta returns [double res=0.]{double e1=0., e2=0.;}: 
  (e1=exp_r_mult {res = e1;}
  | )  //para los numeros con signo
    (OP_REST e2=exp_r_mult {res=res-e2;})* 
  ;  
  
/** multiplicacion reales
*/ 
exp_r_mult returns [double res=0.]{double e1=0., e2=0.;}:
  e1=exp_r_divi {res = e1;}
    (OP_MULT e2=exp_r_divi {res=res*e2;})* 
  ;

/** division reales
*/ 
exp_r_divi returns [double res=0.]{double e1=0., e2=0.;}:
  e1=exp_r_pot {res = e1;}
    (OP_DIVI e2=exp_r_pot 
      {if(e2==0.0)
         throw new ArithmeticException("      Divisin por cero.");
       else
         res=res/e2;})* 
  ;
  
/** potencia reales
*/ 
exp_r_pot returns [double res=0.]{double e1=0., e2=0.;}:
  e1=exp_r_base {res = e1;}
    (OP_EXPO e2=exp_r_base {res=(double)Math.pow(res,e2);})* 
  ;
  
/** expresion base reales
*/ 
exp_r_base returns [double res=0.]{double e1=0.;} : 
  n:LIT_REAL {res= new Double (n.getText()).doubleValue();}
  | OP_PAR_I e1=expr_real OP_PAR_D {res = e1;}
  | n1:IDENT 
      {
       int existe=0;      
       Iden id = new Iden();
       for(int i=0;i<listaIden.size();i++) 
       {
   	     id = (Iden)listaIden.get(i);
   	     if(n1.getText().equals(id.obtenerNombre())){
   	       existe=1;
   	       break;
   	     }	
       }
       if(existe == 1)
       {
         String tipo="";
         tipo=id.obtenerTipo();
         if(tipo.equals("real")) 
         {
           res=Double.parseDouble(id.obtenerValor());
         }
         else
           System.out.println("  No se puede realizar la asignacin. Tipos incompatibles.");
       }
       else
         System.out.println("  La variable " + n1.getText() + " no existe.");
      }
  ;

/**expresion para bool
*/
expr_bool returns [boolean res=false]{boolean b1=false;}:
  (b1=expr_logica {res = b1;}
  | b1=expr_relac {res = b1;} 
  );

/**expresiones logicas
* AND
*/
expr_logica returns [boolean res=false]{boolean b1=false, b2=false;}:
  b1=expr_b_or {res = b1;} 
    (OP_AND b2=expr_b_or {res = res && b2;})*
  ;

/** OR logico
*/ 
expr_b_or returns [boolean res=false]{boolean b1=false, b2=false;}:
  b1=expr_b_not {res = b1;} 
    (OP_OR b2=expr_b_not {res = res || b2;})*
  ;

/** NOT logico
*/ 
expr_b_not returns [boolean res=false]{boolean b1=false;}: 
    (OP_NOT ) => OP_NOT b1=expr_b_base 
             {res = !b1;}
    | b1=expr_b_base
             {res = b1;}
  ;
    
/** expresion base booleanos
*/ 
expr_b_base returns [boolean res=false]{boolean b1=false;}:
  n:LIT_BOOL {res = Boolean.parseBoolean(n.getText().toLowerCase());}
  | OP_PAR_I b1=expr_bool OP_PAR_D {res = b1;}
  | n1:IDENT 
      {
       int existe=0;      
       Iden id = new Iden();
       for(int i=0;i<listaIden.size();i++) 
       {
   	     id = (Iden)listaIden.get(i);
   	     if(n1.getText().equals(id.obtenerNombre())){
   	       existe=1;
   	       break;
   	     }	
       }
       if(existe == 1)
       {
         String tipo="";
         tipo=id.obtenerTipo();
         if(tipo.equals("booleano")) 
         {
           res=Boolean.parseBoolean(id.obtenerValor());
         }
         else
           System.out.println("  No se puede realizar la asignacin. Tipos incompatibles.");
       }
       else
         System.out.println("  La variable " + n1.getText() + " no existe.");
      }
  ;
  
/**expresiones relacionales
*/
expr_relac returns [boolean res=false]{boolean b1=false;}:
  (b1=relac_entero {res = b1;}
  | b1=relac_real {res = b1;}
  | b1=relac_cadena {res = b1;}
  );

/**expresiones relacionales enteros
*/
relac_entero returns[boolean res=false]{int i1=0, i2=0;}:
  (i1=expr_entero OP_IGUA i2=expr_entero 
      {if(i1 == i2)
         res = true;
       else
         res = false;}
   | i1=expr_entero OP_DESI i2=expr_entero 
      {if(i1 != i2)
         res = true;
       else
         res = false;}   
   | i1=expr_entero OP_MAYO i2=expr_entero 
      {if(i1 > i2)
         res = true;
       else
         res = false;} 
   | i1=expr_entero OP_MENO i2=expr_entero 
      {if(i1 < i2)
         res = true;
       else
         res = false;} 
  );

/**expresiones relacionales reales
*/
relac_real returns[boolean res=false]{double e1=0., e2=0.;}:
  (e1=expr_real OP_IGUA e2=expr_real 
      {if(e1 == e2)
         res = true;
       else
         res = false;}
   | e1=expr_real OP_DESI e2=expr_real 
      {if(e1 != e2)
         res = true;
       else
         res = false;}   
   | e1=expr_real OP_MAYO e2=expr_real 
      {if(e1 > e2)
         res = true;
       else
         res = false;} 
   | e1=expr_real OP_MENO e2=expr_real 
      {if(e1 < e2)
         res = true;
       else
         res = false;} 
  );

/**expresiones relacionales cadenas
*/ 
relac_cadena returns[boolean res=false]{String s1="", s2="";}:
  (s1=expr_cadena OP_IGUA s2=expr_cadena 
      {if(s1.equals(s2))
         res = true;
       else
         res = false;}
   | s1=expr_cadena OP_DESI s2=expr_cadena 
      {if(!s1.equals(s2))
         res = true;
       else
         res = false;}   
   | s1=expr_cadena OP_MAYO s2=expr_cadena 
      {if(s1.compareTo(s2)>0)
         res = true;
       else
         res = false;} 
   | s1=expr_cadena OP_MENO s2=expr_cadena 
      {if(s1.compareTo(s2)<0)
         res = true;
       else
         res = false;} 
  );
  
/**expresion para cadenas
* concatenacion
*/
expr_cadena returns [String res=""]{String s1="", s2="";}: 
  s1=exp_c_conca {res=s1;}
  (OP_SUMA s2=exp_c_conca {res = res+s2;} )*
  ;
  
/**expresion base cadenas
*/
exp_c_conca returns [String res=""]: 
  n:LIT_CADENA {res= new String (n.getText());}
  | n1:IDENT 
      {
       int existe=0;      
       Iden id = new Iden();
       for(int i=0;i<listaIden.size();i++) 
       {
   	     id = (Iden)listaIden.get(i);
   	     if(n1.getText().equals(id.obtenerNombre())){
   	       existe=1;
   	       break;
   	     }	
       }
       if(existe == 1)
       {
         String tipo="";
         tipo=id.obtenerTipo();
         if(tipo.equals("cadena")) 
         {
           res=id.obtenerValor();
         }
         else
           System.out.println("  No se puede realizar la asignacin. Tipos incompatibles.");
       }
       else
         System.out.println("  La variable " + n1.getText() + " no existe.");
      }
  ;
  
/**bucles zona sketch
*/
buc_ske :
  (buc_for_s | buc_while_s)
  ;
  
/**for zona sketch
*/
buc_for_s {int i1=0,i2=0; 
	       int mark = getInputState().getInput().mark();
	       Iden id = new Iden();}:
  INIT_FOR n:IDENT F_FROM i1=expr_entero F_UNTIL i2=expr_entero F_DO 
    {
     if(i1<i2)
     {
       int existe=0;      
       for(int i=0;i<listaIden.size();i++) 
       {
   	     id = (Iden)listaIden.get(i);
   	     if(n.getText().equals(id.obtenerNombre())){
   	       existe=1;
   	       break;
   	     }	
       }
       if(existe == 1)
       {
         String tipo="";
         tipo=id.obtenerTipo();
         if(tipo.equals("entero") && !id.obtenerConst()) 
         { 
           if(dentroBucle == false)
           {
             id.establecerValor(String.valueOf(i1));
             dentroBucle=true;
           }
         }
         else
           System.out.println("  No se puede realizar el bucle. La variable no es entera o es un entero constante.");
       }
       else
         System.out.println("  La variable " + n.getText() + " no existe.");
     }
     else
       System.out.println("  La segunda expresion entera debe ser mayor que la primera.");
   }
  board_zone FIN_FOR OP_DELI 
  {
    if(Integer.parseInt(id.obtenerValor())<i2-1){
      id.establecerValor(String.valueOf(Integer.parseInt(id.obtenerValor())+1));
      rewind(mark);
    }  
  else
    dentroBucle=false; 	
  }
  {System.out.println("  Fin for sketch.");}
  ;
  
/**while zona sketch
*/
buc_while_s {boolean b1=false;
             int mark = getInputState().getInput().mark();
             }:
  INIT_WHILE b1=expr_bool W_BEGIN 
    { if(b1 == false)
        rewind(salirBucle);
    }
  board_zone {salirBucle = getInputState().getInput().mark();}  
  FIN_WHILE OP_DELI 
    {
      if(b1 == true)
        rewind(mark);
    }	 
    {System.out.println("  Fin while sketch.");} 
  ;
  
/**bucles zona transform
*/
buc_tran :
  (buc_for_t | buc_while_t)
  ;
  
/**for zona transform
*/
buc_for_t {int i1=0,i2=0; 
	       int mark = getInputState().getInput().mark();
	       Iden id = new Iden();}:
  INIT_FOR n:IDENT F_FROM i1=expr_entero F_UNTIL i2=expr_entero F_DO 
    {
     if(i1<i2)
     {
       int existe=0;      
       for(int i=0;i<listaIden.size();i++) 
       {
   	     id = (Iden)listaIden.get(i);
   	     if(n.getText().equals(id.obtenerNombre())){
   	       existe=1;
   	       break;
   	     }	
       }
       if(existe == 1)
       {
         String tipo="";
         tipo=id.obtenerTipo();
         if(tipo.equals("entero") && !id.obtenerConst()) 
         { 
           if(dentroBucle == false)
           {
             id.establecerValor(String.valueOf(i1));
             dentroBucle=true;
           }
         }
         else
           System.out.println("  No se puede realizar el bucle. La variable no es entera o es un entero constante.");
       }
       else
         System.out.println("  La variable " + n.getText() + " no existe.");
     }
     else
       System.out.println("  La segunda expresion entera debe ser mayor que la primera.");
   }
  game_zone FIN_FOR OP_DELI 
  {
    if(Integer.parseInt(id.obtenerValor())<i2-1){
      id.establecerValor(String.valueOf(Integer.parseInt(id.obtenerValor())+1));
      rewind(mark);
    }  
  else
    dentroBucle=false; 	
  }
  {System.out.println("  Fin for transform.");}
  ;
  
/**while zona transform
*/
buc_while_t {boolean b1=false;
             int mark = getInputState().getInput().mark();
             }:
  INIT_WHILE b1=expr_bool W_BEGIN 
    { if(b1 == false)
        rewind(salirBucle);
    }
  game_zone {salirBucle = getInputState().getInput().mark();}  
  FIN_WHILE OP_DELI 
    {
      if(b1 == true)
        rewind(mark);
    }	 
    {System.out.println("  Fin while transform.");} 
  ;
