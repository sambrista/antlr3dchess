package chess;

import java.util.ArrayList;

/** Clase Bishop
* es la clase donde se definen los elementos del ‡lfil
* @author Alfonso Jimnez Vilchez y Francisco Rinc—n LiŽvana
*/
public class Bishop extends Piece {
	/** 
     * Constructor de la clase parametrizado 
     * @param cr es el color de la pieza
     * @param r es la fila
     * @param c es la columna
     */ 
	public Bishop(Color cr, int r, int c) {
		super(cr,r, c);
		this.setKind(Piece.Kind.BISHOP);
	}
	/** 
     * Devuelve el tipo de la pieza  
     * @return devuelve el tipo de la pieza
     */ 
	public String getKindString() {
		return "Bishop";
	}
	/** 
     * Devuelve el fichero segun la pieza que es
     * @return devuelve la cadena del fichero 
     */ 
	public String get3Dfile() {
		return "Alfil" + (this.getColor() == Piece.Color.WHITE ? "B" : "N") + ".wrl";
	}
	/** 
     * Comprueba si se puede mover la pieza a al destino
     * @param target_row el la fila destino
     * @param target_column es la columna destino
     * @return devuelve true si se puede hacer y false en caso contrario
     */ 
	public boolean canMoveTo(int target_row, int target_column) {
		if (Math.abs(this.getRow() - target_row) == Math.abs(this.getColumn() - target_column)) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isBlockedBy(int target_row, int target_column, int obstacle_row, int obstacle_column) {
		if (this.isInPathTo(obstacle_row, obstacle_column, target_row, target_column)) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isInPathTo(int obstacle_row, int obstacle_column, int target_row, int target_column) {
		if (Math.abs(this.getRow() - target_row) == Math.abs(this.getColumn() - target_column) && Math.abs(this.getRow() - obstacle_row) == Math.abs(this.getColumn() - obstacle_column)) {
			int distance_to_target_y = target_row - this.getRow();
			int distance_to_obstacle_y = obstacle_row - this.getRow();
			int distance_to_target_x = target_column - this.getColumn();
			int distance_to_obstacle_x = obstacle_column - this.getColumn();
			double dbl_distance_to_target = Math.sqrt(Math.pow(distance_to_target_x, 2) + Math.pow(distance_to_target_y, 2));
			double dbl_distance_to_obstacle = Math.sqrt(Math.pow(distance_to_obstacle_x, 2) + Math.pow(distance_to_obstacle_y, 2));
			return(!(distance_to_target_y > 0 ^ distance_to_obstacle_y > 0) && !(distance_to_target_x > 0 ^ distance_to_obstacle_x > 0) && dbl_distance_to_obstacle < dbl_distance_to_target);
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
		int x, y;
		//Upper diagonal
		x = getColumn();
		y = getRow();
		while (++x < 8 && ++y < 8) {
			int pos[] = {y,x};
			list.add(pos);
		}
		x = getColumn();
		y = getRow();
		while (--x >= 0 && --y >= 0) {
			int pos[] = {y,x};
			list.add(pos);
		}
		//Downing diagonal
		x = getColumn();
		y = getRow();
		while (--x >= 0 && ++y < 8) {
			int pos[] = {y,x};
			list.add(pos);
		}
		x = getColumn();
		y = getRow();
		while (++x < 8 && --y >= 0) {
			int pos[] = {y,x};
			list.add(pos);
		}
		//Attack
		
		//End
		return list;
	}
	public double getPoints() {
		return 3.5;
	}
}
