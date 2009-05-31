package chess;

import java.util.ArrayList;

/** Clase Knight
* es la clase donde se definen los elementos del caballo
* @author Alfonso Jimnez Vilchez y Francisco Rincón Liévana
*/
public class Knight extends Piece {
	/** 
     * Constructor de la clase parametrizado 
     * @param cr es el color de la pieza
     * @param r es la fila
     * @param c es la columna
     */ 
	public Knight(Color cr, int r, int c) {
		super(cr,r, c);
		this.setKind(Piece.Kind.KNIGHT);
	}
	/** 
     * Devuelve el tipo de la pieza  
     * @return devuelve el tipo de la pieza
     */ 
	public String getKindString() {
		return "Knight";
	}
	/** 
     * Devuelve el fichero segun la pieza que es
     * @return devuelve la cadena del fichero 
     */ 
	public String get3Dfile() {
		return "Caballo" + (this.getColor() == Piece.Color.WHITE ? "B" : "N") + ".wrl";
	}
	/** 
     * Comprueba si se puede mover la pieza a al destino
     * @param target_row el la fila destino
     * @param target_column es la columna destino
     * @return devuelve true si se puede hacer y false en caso contrario
     */ 
	public boolean canMoveTo(int target_row, int target_column) {
		if ( Math.sqrt(Math.pow(target_column - this.getColumn(), 2) + Math.pow(target_row - this.getRow(), 2)) == Math.sqrt(5)) {
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
		int target_y = getRow() + 2;
		if (target_y >= 0 && target_y < 8) {
			int target_x = getColumn() - 1;
			if (target_x >= 0 && target_x < 8) {
				int pos[] = {target_y,target_x};
				list.add(pos);
			}
			target_x = getColumn() + 1;
			if (target_x >= 0 && target_x < 8) {
				int pos[] = {target_y,target_x};
				list.add(pos);
			}
		}
		target_y = getRow() -2;
		if (target_y >= 0 && target_y < 8) {
			int target_x = getColumn() - 1;
			if (target_x >= 0 && target_x < 8) {
				int pos[] = {target_y,target_x};
				list.add(pos);
			}
			target_x = getColumn() + 1;
			if (target_x >= 0 && target_x < 8) {
				int pos[] = {target_y,target_x};
				list.add(pos);
			}
		}
		int target_x = getColumn() -2;
		if (target_x >= 0 && target_x < 8) {
			target_y = getRow() - 1;
			if (target_y >= 0 && target_y < 8) {
				int pos[] = {target_y,target_x};
				list.add(pos);
			}
			target_y = getRow() + 1;
			if (target_y >= 0 && target_y < 8) {
				int pos[] = {target_y,target_x};
				list.add(pos);
			}
		}
		target_x = getColumn() + 2;
		if (target_x >= 0 && target_x < 8) {
			target_y = getRow() - 1;
			if (target_y >= 0 && target_y < 8) {
				int pos[] = {target_y,target_x};
				list.add(pos);
			}
			target_y = getRow() + 1;
			if (target_y >= 0 && target_y < 8) {
				int pos[] = {target_y,target_x};
				list.add(pos);
			}
		}
		//End
		return list;
	}
	public double getPoints() {
		return 3;
	}
}
