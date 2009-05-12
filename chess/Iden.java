package chess;

public class Iden {
  String nombre;
  String valor="";
  String tipo;         //entero, real, cadena, booleano
  boolean cte=false;   //si true, variable constante
  int num;
  
  /** 
  * metodo para establecer el nombre de la variable
  */
  public void establecerNombre (String nom) {
	  nombre=nom;
  }
  /** 
  * metodo para establecer el valor de la variable
  */
  public void establecerValor (String val) {
	  valor=val;
  }
  /** 
  * metodo para establecer el tipo
  */
  public void establecerTipo (String tip) {
	  tipo=tip;
  }
  /** 
  * metodo para establecer si es o no constante
  */
  public void establecerConst (boolean con) {
	cte=con;
  }
  /** 
  * metodo para establecer el numero de la variable
  */
  public void establecerNumId (int n) {
	num=n;
  }
  
  /** 
  * metodo para obtener el nombre de la variable
  */
  public String obtenerNombre() {
    return nombre;
  }
  /** 
  * metodo para obtener el valor de la variable
  */
  public String obtenerValor() {
    return valor;
  }
  /** 
  * metodo para obtener el tipo
  */
  public String obtenerTipo() {
    return tipo;
  }
  /** 
  * metodo para obtener si es o no constante
  */
  public boolean obtenerConst() {
    return cte;
  }
  /** 
  * metodo para obtener el numero de la variable
  */
  public int obtenerNumId() {
    return num;
  }
}