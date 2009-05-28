package chess;

public class Variable {
	public enum Kind {CHR, STR, INT, FLO, LOG};
  String name;
  String value="";
  Kind kind;         //entero, real, cadena, booleano
  boolean constant=false;   //si true, variable constante
  int id;

  public Variable(Kind k,String n) {
	  name = n;
	  kind = k;
  }
  
  public Kind stringToKind(String s) {
	  if (s.compareTo("CHR") == 0) {
		  return Kind.CHR;
	  } else  if (s.compareTo("STR") == 0) {
		  return Kind.STR;
	  } else if (s.compareTo("INT") == 0) {
		  return Kind.INT;
	  } else if (s.compareTo("FLO") == 0) {
		  return Kind.FLO;
	  } else {
		  return Kind.LOG;
	  }
  }
  
  /** 
  * metodo para establecer el valor de la variable
  */
  public boolean setValue (String val) {
	  if (!constant) {
		  value=val;
		  return true;
	  } else {
		  return false;
	  }
  }
  /** 
  * metodo para establecer si es o no constante
  */
  public void setConstant (boolean con) {
	constant=con;
  }
  /** 
  * metodo para obtener el nombre de la variable
  */
  public String getName() {
    return name;
  }
  /** 
  * metodo para obtener el valor de la variable
  */
  public String getValue() {
    return value;
  }
  /** 
  * metodo para obtener el tipo
  */
  public Kind getKind() {
    return kind;
  }
  /** 
  * metodo para obtener si es o no constante
  */
  public boolean isConstant() {
    return constant;
  }
}