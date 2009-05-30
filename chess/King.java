package chess;

import java.util.ArrayList;

/** Clase King
* es la clase donde se definen los elementos del rey
* @author Alfonso Jimnez Vilchez y Francisco Rincón Liévana
*/
public class King extends Piece {
	/** 
     * Constructor de la clase parametrizado 
     * @param cr es el color de la pieza
     * @param r es la fila
     * @param c es la columna
     * @return devuelve true si se puede hacer
     */ 
	public King(Color cr, int r, int c) {
		super(cr,r, c);
		this.setKind(Piece.Kind.KING);
	}
	/** 
     * Devuelve el tipo de la pieza  
     * @return devuelve el tipo de la pieza
     */ 
	public String getKindString() {
		return "King";
	}
	/** 
     * Devuelve el fichero segun la pieza que es
     * @return devuelve la cadena del fichero 
     */ 
	public String get3Dfile() {
		return "Rey" + (this.getColor() == Piece.Color.WHITE ? "B" : "N") + ".wrl";
	}
	/** 
     * Comprueba si se puede mover la pieza a al destino
     * @param target_row el la fila destino
     * @param target_column es la columna destino
     * @return devuelve true si se puede hacer y false en caso contrario
     */ 
	public boolean canMoveTo(int target_row, int target_column) {
		if (Math.abs(this.getColumn() - target_column) <= 1 && Math.abs(this.getRow() - target_row) <= 1) {
			return true;
		} else {
			return false;
		}
	}
	/** 
     * Devuelve los movimientos posible de la pieza 
     * @return devuelve el vector con los movimientos posible
     */ 
	public ArrayList<int[]> getTeoricalMovements() {
		ArrayList<int[]> list = new ArrayList<int[]>();
		//Movement
		//Normal
		for (int i = (getColumn() == 0 ? 0 : getColumn()-1); i <= (getColumn() == 7 ? 7 : getColumn()+1); ++i) {
			for (int j = (getRow() == 0 ? 0 : getRow()-1); j <= (getRow() == 7 ? 7 : getRow()+1); ++j) {
				if (!this.isAt(j,i)) {
					int pos[] = {j,i};
					list.add(pos);
				}
			}
		}
		//Attack
		//End
		return list;
	}
}
