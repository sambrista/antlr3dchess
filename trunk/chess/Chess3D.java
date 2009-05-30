package chess;

import java.io.*;
import antlr.*;

/** Clase Chess3D
* inicia la ejecucion.
* obtiene la entrada para los analizadores y los lanza
* @author Alfonso Jimnez Vilchez y Francisco Rinc—n LiŽvana
*/
public class Chess3D {
  public static void main(String args[]) throws IOException{
    try{
      if (args.length != 0)
      {
        try{
    	  FileInputStream fis=new FileInputStream(args[0]);
          Analex analex = new Analex(fis);
          Anasint anasint = new Anasint(analex);
          anasint.instrucciones();
          
          CommonAST a = (CommonAST)anasint.getAST();
          System.out.println("\nResultado ASA: " + a.toStringList());
        }
        catch (ArithmeticException ae){
            System.err.println(ae.getMessage());
        }
        catch (FileNotFoundException fnfe){
          System.err.println("No se encontr el fichero");
        }
      }
      else
      {
    	String entrada="";
    	String total="";
    	Analex analex=null;
    	Anasint anasint=null;
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
    	System.out.print("\nPulse @ cuando desee salir\n");

    	do{
    	  System.out.print("\n-> ");
    	  entrada=in.readLine();
    	  total=total + "\n" + entrada;
    	}while(!entrada.equals("@"));
    	  
  	  	try{
   	  	  analex=new Analex(new StringReader(total));
      	  anasint=new Anasint(analex);

      	  anasint.instrucciones();
      	  
      	  CommonAST a = (CommonAST)anasint.getAST();
          System.out.println("\nResultado ASA: " + a.toStringList());
    	}
    	catch(ArithmeticException ae){
    	  System.err.println(ae.getMessage());
    	} 
      }
    }
    catch(ANTLRException ae){
      System.err.println(ae.getMessage());
    }
    catch(NullPointerException ae){
      System.err.println(ae.getMessage());
    }
  }
}
