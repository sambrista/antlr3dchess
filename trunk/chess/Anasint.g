header{
	package chess;
	import java.util.*;
	import java.lang.*;
	import java.io.*;
}

/** Clase Anasint
* realiza el analisis sintactico y semantico
* @author Alfonso Jimenez y Francisco Rincon
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
  ArrayList<Variable> listaVars = new ArrayList<Variable>();
  int contId = 0;
  ArrayList listaNombres = new ArrayList();
  boolean dentroBucle=false;
  int salirBucle = -1 ;
  Game partida;
  boolean ejecucion;
  int bloqueo;
}

/** regla inicial
* @ -> indica el fin de la ejecucion
*/
instrucciones : (BEGIN_BOARD {partida = new Game(); ejecucion = true; bloqueo = 0;} board_zone END_BOARD BEGIN_GAME game_zone END_GAME )* OP_FIN
 ;

/** expresiones de tablero
*/
board_expr :
  common_fun
  | board_fun  
  | buc_ske
  | board_cond;
  
/** zona de tablero
*/
board_zone : 
  (BEGIN_VARIABLES zona_decl END_VARIABLES
  | board_expr)* ;

/** expresiones de juego
*/
game_expr : 
  common_fun
  | game_fun  
  | buc_tran
  | game_cond;

/** zona de juego
*/  
game_zone : 
  (BEGIN_VARIABLES zona_decl END_VARIABLES
  | game_expr)* ;

/**declaraciones en la zona de variables
*/
zona_decl : (
          declaracion_int
          //| declaracion_chr
          | declaracion_log
          | declaracion_str
          | declaracion_flo)* ;

/** declaracion de entero
*/
declaracion_int{int val = 0, val2 = 0; boolean cons = false, cons2 = false;}:
	INT n1:IDENT (CNST {cons = true;})? (OP_ASIG val = expr_entero)? {
		boolean existent = false;
	for (int i = 0; i < listaVars.size(); i++) {
		if (listaVars.get(i).getName().compareTo(n1.getText()) == 0) {
			existent = true;
		}
	}
	if (!existent) {
		Variable var = new Variable(Variable.Kind.INT, n1.getText());
		var.setConstant(cons);
		var.setValue("" + val);
		listaVars.add(var);	
	}
} (OP_SEPA {cons2 = false;} (CNST {cons2 = true;})? n2:IDENT (OP_ASIG val2 = expr_entero)? {
	boolean existent = false;
	for (int i = 0; i < listaVars.size(); i++) {
		if (listaVars.get(i).getName().compareTo(n2.getText()) == 0) {
			existent = true;
		}
	}
	if (!existent) {
		Variable var2 = new Variable(Variable.Kind.INT, n2.getText());
		var2.setConstant(cons2);
		var2.setValue("" + val2);
		listaVars.add(var2);	
	}
})* OP_DELI;

/** declaracion de cadenas
*/
declaracion_str{String val = "", val2 = ""; boolean cons = false, cons2 = false;}:
 	STR n1:IDENT (CNST {cons = true;})? (OP_ASIG val = expr_cadena)? {
		boolean existent = false;
	for (int i = 0; i < listaVars.size(); i++) {
		if (listaVars.get(i).getName().compareTo(n1.getText()) == 0) {
			existent = true;
		}
	}
	if (!existent) {
		Variable var = new Variable(Variable.Kind.STR, n1.getText());
		var.setConstant(cons);
		var.setValue(val);
		listaVars.add(var);	
	}
} (OP_SEPA {cons2 = false;} (CNST {cons2 = true;})? n2:IDENT (OP_ASIG val2 = expr_cadena)? {
	boolean existent = false;
	for (int i = 0; i < listaVars.size(); i++) {
		if (listaVars.get(i).getName().compareTo(n2.getText()) == 0) {
			existent = true;
		}
	}
	if (!existent) {
		Variable var2 = new Variable(Variable.Kind.STR, n2.getText());
		var2.setConstant(cons2);
		var2.setValue(val2);
		listaVars.add(var2);	
	}
})* OP_DELI;

/** declaracion de flotantes
*/
declaracion_flo{double val = 0, val2 = 0; boolean cons = false, cons2 = false;}:
	FLO n1:IDENT (CNST {cons = true;})? (OP_ASIG val = expr_real)? {
		boolean existent = false;
	for (int i = 0; i < listaVars.size(); i++) {
		if (listaVars.get(i).getName().compareTo(n1.getText()) == 0) {
			existent = true;
		}
	}
	if (!existent) {
		Variable var = new Variable(Variable.Kind.FLO, n1.getText());
		var.setConstant(cons);
		var.setValue("" + val);
		listaVars.add(var);	
	}
} (OP_SEPA {cons2 = false;} (CNST {cons2 = true;})? n2:IDENT {val2 = 0;} (OP_ASIG val2 = expr_real)? {
	boolean existent = false;
	for (int i = 0; i < listaVars.size(); i++) {
		if (listaVars.get(i).getName().compareTo(n2.getText()) == 0) {
			existent = true;
		}
	}
	if (!existent) {
		Variable var2 = new Variable(Variable.Kind.FLO, n2.getText());
		var2.setConstant(cons2);
		var2.setValue("" + val2);
		listaVars.add(var2);	
	}
})* OP_DELI;

/** declaracion de booleanos
*/
declaracion_log{boolean val = false, val2 = false; boolean cons = false, cons2 = false;}:
	LOG n1:IDENT (CNST {cons = true;})? (OP_ASIG val = expr_logica)? {
		boolean existent = false;
	for (int i = 0; i < listaVars.size(); i++) {
		if (listaVars.get(i).getName().compareTo(n1.getText()) == 0) {
			existent = true;
		}
	}
	if (!existent) {
		Variable var = new Variable(Variable.Kind.LOG, n1.getText());
		var.setConstant(cons);
		var.setValue("" + val);
		listaVars.add(var);	
	}
} (OP_SEPA {cons2 = false;} (CNST {cons2 = true;})? n2:IDENT (OP_ASIG val2 = expr_logica)? {
	boolean existent = false;
	for (int i = 0; i < listaVars.size(); i++) {
		if (listaVars.get(i).getName().compareTo(n2.getText()) == 0) {
			existent = true;
		}
	}
	if (!existent) {
		Variable var2 = new Variable(Variable.Kind.LOG, n2.getText());
		var2.setConstant(cons2);
		var2.setValue("" + val2);
		listaVars.add(var2);	
	}
})* OP_DELI;
//TODO CHR
/*
declaracion_int{int val = 0; boolean cons = false;}:
	INT n1:IDENT (CNST {cons = true;})? (OP_ASIG val = expr_entero)? {
		bool existent = false;
	for (int i = 0; i < listaVars.size(); i++) {
		if (listaVars.get(i).getName().compareTo(n1.getText()) == 0) {
			existent = true;
		}
	}
	if (!existent) {
		Variable var = new Variable(Variable.Kind.INT, n1.getText());
		var.setConstant(cons);
		var.setValue("" + val);
		listaVars.add(var);	
	}
} (OP_SEPA {boolean cons2 = false;} (CNST {cons2 = true;})? n2:IDENT {String n2.getText() = n2.getText(); int val2 = 0;} (OP_ASIG val2 = expr_entero)? {
	bool existent = false;
	for (int i = 0; i < listaVars.size(); i++) {
		if (listaVars.get(i).getName().compareTo(n2.getText()) == 0) {
			existent = true;
		}
	}
	if (!existent) {
		Variable var2 = new Variable(Variable.Kind.INT, n2.getText());
		var2.setConstant(cons2);
		var2.setValue("" + val2);
		listaVars.add(var2);	
	}
})* OP_DELI;
*/

/** asignacion de entero
*/
asig_entero {int i1 = 0;}: n:IDENT OP_ASIG i1=expr_entero {
	if (ejecucion) {
      Variable var = null;
      for(int i=0;i<listaVars.size();i++) 
      {
      	if (listaVars.get(i).getName().compareTo(n.getText()) == 0) {
      			var = listaVars.get(i);
      			break;
      	}	
      }
      if(var != null && var.getKind() == Variable.Kind.INT)
      {
      	var.setValue("" + i1);
      }
	}
};

/** asignacion de flotantes
*/
asig_real {double i1 = 0;}: n:IDENT OP_ASIG i1=expr_real {
	if (ejecucion) {
      Variable var = null;
      for(int i=0;i<listaVars.size();i++) 
      {
      	if (listaVars.get(i).getName().compareTo(n.getText()) == 0) {
      			var = listaVars.get(i);
      			break;
      	}	
      }
      if(var != null && var.getKind() == Variable.Kind.FLO)
      {
      	var.setValue("" + i1);
      }
	}
};

/** asignacion de booleanos
*/
asig_log {boolean i1 = false;}: n:IDENT OP_ASIG i1=expr_bool {
	if (ejecucion) {
      Variable var = null;
      for(int i=0;i<listaVars.size();i++) 
      {
      	if (listaVars.get(i).getName().compareTo(n.getText()) == 0) {
      			var = listaVars.get(i);
      			break;
      	}	
      }
      if(var != null && var.getKind() == Variable.Kind.LOG)
      {
      	var.setValue("" + i1);
      }
	}
};

/** asignacion de cadenas
*/
asig_str {String i1 = "";}: n:IDENT OP_ASIG i1=expr_cadena {
	if (ejecucion) {
      Variable var = null;
      for(int i=0;i<listaVars.size();i++) 
      {
      	if (listaVars.get(i).getName().compareTo(n.getText()) == 0) {
      			var = listaVars.get(i);
      			break;
      	}	
      }
      if(var != null && var.getKind() == Variable.Kind.STR)
      {
      	var.setValue(i1);
      }
	}
};

/** funciones comunes a ambas zonas
*/
common_fun {String s1="";}: ( WRT fun_wri 
  | WAIT {
  	if (ejecucion) {
  	InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader (isr);
  	try{
      System.out.println("  En PAUSE hasta que pulse ENTER.");
      String texto = br.readLine();
    }catch(Exception e){ e.printStackTrace();}
  	}
  }
  | asig_entero
  | asig_str
  | asig_log
  | asig_real
  ) OP_DELI ;
  
/**funcion check_fun
* Devuelve si hay jaque al color especificado.
*/
check_fun returns [boolean valor=false]{String s1;}: OP_PAR_I s1=expr_cadena OP_PAR_D 
  {
  	if (ejecucion) {
  		valor = partida.check(s1);
  	}
  };
  
/**funcion checkmate_fun
* Devuelve si hay jaque mate al color especificado.
*/
checkmate_fun returns [boolean valor=false]{String s1;}: OP_PAR_I s1=expr_cadena OP_PAR_D 
  {
  	  	if (ejecucion) {
  	valor = partida.checkMate(s1);
  	}
  };
  
/**funcion stalemate_fun
* Devuelve si hay ahogado en el color especificado.
*/
stalemate_fun returns [boolean valor=false]{String s1;}: OP_PAR_I s1=expr_cadena OP_PAR_D 
  {
  	  	  	if (ejecucion) {
  	valor = partida.staleMate(s1);
  	}
  };
  
/**funcion piece_type_fun
* Devuelve el tipo de pieza.
*/
piece_type_fun returns [String res = ""]{int i1; String s1;} : OP_PAR_I s1=expr_cadena OP_SEPA i1=expr_entero OP_PAR_D 
  {
  	  	  	if (ejecucion) {
  	res = partida.pieceType(s1,i1);
  	  	}
  };


/**funcion piece_color_fun
* Devuelve el color de pieza.
*/
piece_color_fun returns [String res = ""]{int i1; String s1;} : OP_PAR_I s1=expr_cadena OP_SEPA i1=expr_entero OP_PAR_D 
  {
  	  	  	if (ejecucion) {
  	res = partida.pieceColor(s1,i1);
  	  	  	}
  };
  
/**funcion points_fun
* Devuelve los puntos del jugador del color especificado.
*/
points_fun returns [int ret = 0]{String s1;}: OP_PAR_I s1=expr_cadena OP_PAR_D 
  {
  	  	  	if (ejecucion) {
  ret = partida.points(s1);
  	  	  	}
};
  
/**funcion c_o_last_mov_fun
* Devuelve la columna de origen del ultimo movimiento del color especificado.
*/
c_o_last_mov_fun returns [String c = "";]{String s1;}: OP_PAR_I s1=expr_cadena OP_PAR_D 
  {
  	  	  	if (ejecucion) {
  	c = partida.cOLastMov(s1);
  	  	  	}
  };
  
/**funcion f_o_last_mov_fun
* Devuelve la fila de origen del ultimo movimiento del color especificado.
*/
f_o_last_mov_fun returns [int valor = 0;]{String s1;}: OP_PAR_I s1=expr_cadena OP_PAR_D 
  {
  	  	  	if (ejecucion) {
  	valor = partida.fOLastMov(s1);
  	  	  	}
  };
  
  
/**funcion c_d_last_mov_fun
* Devuelve la columna de destino del ultimo movimiento del color especificado.
*/
c_d_last_mov_fun returns [String c = "";]{String s1;}: OP_PAR_I s1=expr_cadena OP_PAR_D 
  {
  	  	  	if (ejecucion) {
  	c = partida.cDLastMov(s1);
  	  	  	}
  };
  
/**funcion f_d_last_mov_fun
* Devuelve la columna de origen del ultimo movimiento del color especificado.
*/
f_d_last_mov_fun returns [int valor = 0;]{String s1;}: OP_PAR_I s1=expr_cadena OP_PAR_D 
  {
  	  	  	if (ejecucion) {
  	valor = partida.fDLastMov(s1);
  	  	  	}
  };
/**funcion ratio_wb_fun
* Devuelve el ratio de piezas entre blancas y negras.
*/
ratio_wb_fun returns [double ret = 0]: OP_PAR_I  OP_PAR_D 
  {
  	  	  	if (ejecucion) {
  ret = partida.ratioWB();
  	  	  	}
};

/**funcion ratio_points_wb_fun
* Devuelve el ratio de puntos entre blancas y negras.
*/
ratio_points_wb_fun returns [double ret = 0]: OP_PAR_I  OP_PAR_D 
  {
  	  	  	if (ejecucion) {
  ret = partida.ratioPointsWB();
  	  	  	}
};

/**funcion captured_piece_type_fun
* Devuelve el tipo de la ultima pieza capturada por el color especificado.
*/
captured_piece_type_fun returns [String res = ""]{String s1;} : OP_PAR_I s1=expr_cadena OP_PAR_D 
  {
  	  	  	if (ejecucion) {
  	res = partida.capturedPieceType(s1);
  	  	  	}
  };
 
/**funcion captured_piece_color_fun
* Devuelve el color de la ultima pieza capturada del tipo especificado.
*/  
captured_piece_color_fun returns [String res = ""]{String s1;} : OP_PAR_I s1=expr_cadena OP_PAR_D 
  {
  	  	  	if (ejecucion) {
  	res = partida.capturedPieceColor(s1);
  	  	  	}
  };
  
/**funcion castling_fun
* Devuelve si hay enroque.
*/
castling_fun returns [boolean valor = false]{String s1;} : OP_PAR_I s1=expr_cadena OP_PAR_D 
  {
  	  	  	if (ejecucion) {
  	valor = partida.castling(s1);
  	  	  	}
  };
  
/**funcion fun_r_entero
* Lee un entero de teclado y lo devuelve.
*/
fun_r_entero returns [int valor=-1]: OP_PAR_I OP_PAR_D 
  {
  	  	  	if (ejecucion) {
  	  	  		 InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader (isr);
  	try{
  	  System.out.println("  READ_INTEGER -> Introduzca un valor entero.");	
      int num = Integer.parseInt(br.readLine());
      valor=num;
      System.out.println("  READ_INTEGER -> El valor entero ledo es: " + valor);
    }catch(Exception e){ e.printStackTrace();}
  	  	  	}
  };
  
/**funcion fun_r_real
* Lee un flotante de teclado y lo devuelve.
*/
fun_r_real returns [double valor=-1.]: OP_PAR_I OP_PAR_D 
  {
  	  	  	if (ejecucion) {
  	  	  			InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader (isr);
  	try{
  	  System.out.println("  READ_DOUBLE -> Introduzca un valor real.");		
      double num = Double.parseDouble(br.readLine());
      valor=num;
      System.out.println("  READ_DOUBLE -> El valor real ledo es: " + valor);
    }catch(Exception e){ e.printStackTrace();}
  	  	  	}
  };
  
/**funcion fun_r_bool
* Lee un booleano de teclado y lo devuelve (TRUE o FALSE).
*/
fun_r_bool returns [boolean valor=false]: OP_PAR_I OP_PAR_D 
  {
  	  	  	if (ejecucion) {
  	  	  			InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader (isr);
  	try{
  	  System.out.println("  READ_BOOL -> Introduzca un valor booleano.");	
      boolean val = Boolean.parseBoolean(br.readLine().toLowerCase());
      valor=val;
      System.out.println("  READ_BOOL -> El valor booleano ledo es: " + valor);
    }catch(Exception e){ e.printStackTrace();}
  	  	  	}
  };
  
/**funcion fun_r_cadena
* Lee una cadena de teclado y la devuelve.
*/
fun_r_cadena returns [String valor=""]: OP_PAR_I OP_PAR_D 
  {
  	  	  	if (ejecucion) {
  		InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader (isr);
  	try{
  	  System.out.println("  READ_STRING -> Introduzca una cadena.");	
      String texto = br.readLine();
      valor=texto;
      System.out.println("  READ_STRING -> La cadena leda es: " + valor);
    }catch(Exception e){ e.printStackTrace();}
  	  	  	}
  };
  
/**funcion fun_wri
* Escribe el valor de la expresin expresion en pantalla en
* una nueva lnea.
*/
fun_wri {String s1;}: OP_PAR_I s1=expresion OP_PAR_D 
  {
  	  	  	if (ejecucion) {
  	  	  		 System.out.println("  WRITE -> " + s1);
  	  	  	}
  };
  

/**condicional de la zona board
*/

board_cond {boolean b1;}: IF b1=expr_bool { if (ejecucion) {ejecucion = b1; } else {++bloqueo;}
						 } THEN board_zone (ELSE {if (bloqueo == 0) {ejecucion = !ejecucion;}} board_zone)? END_IF {if (bloqueo == 0) { ejecucion = true; } else {--bloqueo;}}OP_DELI ;

/**funciones de la zona board
*/
board_fun : 
  (RANDOM_BOARD r_b_fun | ADD_PIECE a_p_fun | SETUP_PIECE s_p_fun | REMOVE_PIECE r_p_fun | GENERATE_3D_BOARD g_3_fun ) OP_DELI ;

/**funcion r_b_fun
* Crea partida aleatoria
*/
r_b_fun {double prop = 1; String disp; int num_pics;}: OP_PAR_I num_pics=expr_entero (OP_SEPA prop=expr_real)? OP_SEPA disp=expr_cadena OP_PAR_D 
  {
  	  	  	if (ejecucion) {
  	partida.random(num_pics, prop, disp);
  	  	  	}
  };
  

a_p_fun {String s1="",s2="", s3=""; int e1=1;}: 
  OP_PAR_I s1=expr_cadena OP_SEPA s2=expr_cadena OP_SEPA s3=expr_cadena
  OP_SEPA e1=expr_entero OP_PAR_D 
  {
  	  	  	if (ejecucion) {
  partida.addPiece(s1,s2,s3,e1);
  	  	  	}
  };
  
/**funcion s_p_fun
* Fija el sitio de una pieza existente
*/
s_p_fun {int i1, i2; String s1, s2;}: 
  OP_PAR_I s1=expr_cadena OP_SEPA i1=expr_entero OP_SEPA s2=expr_cadena OP_SEPA i2=expr_entero OP_PAR_D 
  {
  	  	  	if (ejecucion) {
  partida.setupPiece(s1,i1,s2,i2);
  	  	  	}
  };
  
/**funcion r_p_fun
* Elimina una pieza
*/
r_p_fun {int i1 = -1; String s1, s2 = "";}: 
  OP_PAR_I s1=expr_cadena (OP_SEPA i1=expr_entero | OP_SEPA s2=expr_cadena) OP_PAR_D 
  {
  	
  	  	  	if (ejecucion) {
  	if (i1 == -1) {
  		partida.removePiece(s1,s2);
  	} else {
  		partida.removePiece(s1,i1);
  	}
  	  	  	}
  };
  

g_3_fun {String s1;}: 
  OP_PAR_I s1=expr_cadena OP_PAR_D 
  {
  	  	  	if (ejecucion) {
  	try{
		 	partida.generate3D(s1);
		} catch (IOException e) {
			e.printStackTrace();	
		}
  	  	  	}
  };
  
/**condiciones de la zona de juego
*/

game_cond {boolean b1;}: IF b1=expr_bool { if (ejecucion) {ejecucion = b1; } else {++bloqueo;}
						 } THEN game_zone (ELSE {if (bloqueo == 0) {ejecucion = !ejecucion;}} game_zone)? END_IF {if (bloqueo == 0) { ejecucion = true; } else {--bloqueo;}}OP_DELI ;

/**funciones de la zona de juego
*/
game_fun : 
  (MOVE_PLAYER_W m_p_w_fun | MOVE_PLAYER_B m_p_b_fun | MOVE_RANDOMLY_W m_r_w_fun | MOVE_RANDOMLY_B m_r_b_fun | STATE s_fun
   | MOVEMENTS_LIST m_l_fun | STATE_3D s_3_fun) OP_DELI ;

/**funcion m_p_w_fun
* Movimiento del jugador blanco
*/
m_p_w_fun {int i1, i2; String s1, s2;}: 
  OP_PAR_I s1=expr_cadena OP_SEPA i1=expr_entero OP_SEPA s2=expr_cadena OP_SEPA i2=expr_entero OP_PAR_D 
  {
  	if (ejecucion) {
  partida.movePlayerW(s1,i1,s2,i2);
  	}
  };
  
/**funcion m_p_b_fun
* Movimiento del jugador negro
*/
  m_p_b_fun {int i1, i2; String s1, s2;}: 
  OP_PAR_I s1=expr_cadena OP_SEPA i1=expr_entero OP_SEPA s2=expr_cadena OP_SEPA i2=expr_entero OP_PAR_D 
  {
  	  	if (ejecucion) {
  partida.movePlayerB(s1,i1,s2,i2);
  	  	}
  };

/**funcion m_r_w_fun
* Movimiento aleatorio del jugador blanco
*/
  m_r_w_fun {}: 
  OP_PAR_I OP_PAR_D 
  {
  	  	if (ejecucion) {
  partida.moveRandomlyW();
  	  	}
  };

/**funcion m_r_b_fun
* Movimiento aleatorio del jugador negro
*/  
  m_r_b_fun {}: 
  OP_PAR_I OP_PAR_D 
  {
  	  	if (ejecucion) {
  partida.moveRandomlyB();
  	  	}
  };

/**funcion s_fun
* Estado de la partida
*/
  s_fun {String s1 = null;}: 
  OP_PAR_I (s1=expr_cadena)? OP_PAR_D 
  {
  	  	if (ejecucion) {
  	partida.state(s1);
  	  	}
  };

  s_3_fun {String s1 = "./3D/";}: 
  OP_PAR_I s1=expr_cadena OP_PAR_D 
  {
  	  	if (ejecucion) {

  	try{
		  	partida.state3D(s1);
		} catch (IOException e) {
			e.printStackTrace();	
		}
  	  	}
  };

/**funcion m_l_fun
* Lista de movimientos
*/
  m_l_fun {}: 
  OP_PAR_I OP_PAR_D 
  {
  	  	if (ejecucion) {
  partida.movementsList();
  	  	}
  };

/**expresiones 
*/
expresion returns [String res=null]{int i1; double e1; String s1; boolean b1;}: 
  //se le aade al principio su tipo
  (i1=expr_entero {res = String.valueOf(i1);}
  |e1=expr_real {res = String.valueOf(e1);} 
  |s1=expr_cadena {res = s1;}  
  |b1=expr_bool {res = String.valueOf(b1);}
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
         throw new ArithmeticException("Division por cero.");
       else
         res=res/i2;})* 
  ;
  
/** modulo enteros
*/ 
exp_e_modu returns [int res=0]{int i1=0, i2=0;}:
  i1=exp_e_pot {res = i1;}
    (MOD i2=exp_e_pot {res=res%i2;})* 
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
      	
     if (ejecucion) {
      Variable var = null;
      for(int i=0;i<listaVars.size();i++) 
      {
      	if (listaVars.get(i).getName().compareTo(n1.getText()) == 0) {
      			var = listaVars.get(i);
      			break;
      	}	
      }
      if(var != null && var.getKind() == Variable.Kind.INT)
      {
      	res = Integer.parseInt(var.getValue());
       }
	}
  }
  | READ_NUMBER res = fun_r_entero
  | POINTS res = points_fun
  | F_O_LAST_MOV res = f_o_last_mov_fun 
  | F_D_LAST_MOV res = f_d_last_mov_fun
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
         throw new ArithmeticException("Division por cero.");
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
      	
     if (ejecucion) {
      Variable var = null;
      for(int i=0;i<listaVars.size();i++) 
      {
      	if (listaVars.get(i).getName().compareTo(n1.getText()) == 0) {
      			var = listaVars.get(i);
      			break;
      	}	
      }
      if(var != null && var.getKind() == Variable.Kind.FLO)
      {
      	res = Double.parseDouble(var.getValue());
      }
	}
      }
  | R_REAL res = fun_r_real
  | RATIO_WB res = ratio_wb_fun
  | RATIO_POINTS_WB res = ratio_points_wb_fun
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
    (OP_AND b2=expr_b_or { res = res && b2;})*
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
      	
     if (ejecucion) {
      Variable var = null;
      for(int i=0;i<listaVars.size();i++) 
      {
      	if (listaVars.get(i).getName().compareTo(n1.getText()) == 0) {
      			var = listaVars.get(i);
      			break;
      	}	
      }
      if(var != null && var.getKind() == Variable.Kind.LOG)
      {
      	res = Boolean.parseBoolean(var.getValue());
      }
	}
      }
  | CHECK res=check_fun
  | CHECKMATE res=checkmate_fun
  | STALEMATE res=stalemate_fun
  | CASTLING res=castling_fun 
  | R_BOOL res = fun_r_bool
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
      	
     if (ejecucion) {
      Variable var = null;
      for(int i=0;i<listaVars.size();i++) 
      {
      	if (listaVars.get(i).getName().compareTo(n1.getText()) == 0) {
      			var = listaVars.get(i);
      			break;
      	}	
      }
      if(var != null && var.getKind() == Variable.Kind.STR)
      {
      	res = var.getValue();
      }
	}
      }
  | PIECE_TYPE res=piece_type_fun
  | PIECE_COLOR res=piece_color_fun
  | CAPTURED_PIECE_TYPE res=captured_piece_type_fun
  | CAPTURED_PIECE_COLOR res=captured_piece_color_fun
  | READ_STR res = fun_r_cadena
  | C_D_LAST_MOV res = c_d_last_mov_fun
  | C_O_LAST_MOV res = c_o_last_mov_fun
  ;
  
/**bucles zona board
*/
buc_ske :
  (buc_for_s | buc_while_s)
  ;
  
/**for zona board
*/
buc_for_s {int i1=0,i2=0; 
	       int mark = getInputState().getInput().mark();
	       Variable var = null;}:
  FOR n:IDENT FROM i1=expr_entero TO i2=expr_entero DO 
    {
		if(i1<i2) {
     		if (ejecucion) {
				for(int i=0;i<listaVars.size();i++) {
					if (listaVars.get(i).getName().compareTo(n.getText()) == 0) {
						var = listaVars.get(i);
						break;
					}	
				}
				if(var != null && var.getKind() == Variable.Kind.INT) {
					if(dentroBucle == false) {
						var.setValue(String.valueOf(i1));
						dentroBucle=true;
					}
				}
			}
		}
    }
  board_zone END_FOR OP_DELI 
  {
    if(Integer.parseInt(var.getValue())<i2-1){
      var.setValue(String.valueOf(Integer.parseInt(var.getValue())+1));
      rewind(mark);
    }  
  else
    dentroBucle=false; 	
  }
  ;
  
/**while zona board
*/
buc_while_s {boolean b1=false;
             int mark = getInputState().getInput().mark();
             }:
  WHILE b1=expr_bool DO
    { if(b1 == false) {
    	if (salirBucle != -1) {
        rewind(salirBucle);
    	}
    	}
    }
  board_zone {salirBucle = getInputState().getInput().mark();}  
  END_WHILE OP_DELI 
    {
    	if(b1 == true) {
        rewind(mark);
   		} else {
   			salirBucle = -1;
    	}
    }
  ;
  
/**bucles zona game
*/
buc_tran :
  (buc_for_t | buc_while_t)
  ;
  
/**for zona game
*/
buc_for_t {int i1=0,i2=0; 
	       int mark = getInputState().getInput().mark();
	       Variable var = null;}:
  FOR n:IDENT FROM i1=expr_entero TO i2=expr_entero DO 
    {
		if(i1<i2) {
     		if (ejecucion) {
				for(int i=0;i<listaVars.size();i++) {
					if (listaVars.get(i).getName().compareTo(n.getText()) == 0) {
						var = listaVars.get(i);
						break;
					}	
				}
				if(var != null && var.getKind() == Variable.Kind.INT) {
					if(dentroBucle == false) {
						var.setValue(String.valueOf(i1));
						dentroBucle=true;
					}
				}
			}
		}
    }
  game_zone END_FOR OP_DELI 
  {
    if(Integer.parseInt(var.getValue())<i2-1){
      var.setValue(String.valueOf(Integer.parseInt(var.getValue())+1));
      rewind(mark);
    }  
  else
    dentroBucle=false; 	
  }
  ;
  
/**while zona game
*/
buc_while_t {boolean b1=false;
             int mark = getInputState().getInput().mark();
             }:
  WHILE b1=expr_bool DO
    { if(b1 == false) {
    	if (salirBucle != -1) {
        rewind(salirBucle);
    	}
    	}
    }
  game_zone {salirBucle = getInputState().getInput().mark();}  
  END_WHILE OP_DELI 
    {
    	if(b1 == true) {
        rewind(mark);
   		} else {
   			salirBucle = -1;
    	}
    }
  ;
