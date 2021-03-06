package chess;

import java.util.ArrayList;

/** Clase Pawn
* es la clase donde se definen los elementos del peon
* @author Alfonso Jimnez Vilchez y Francisco Rinc�n Li�vana
*/
public class Pawn extends Piece {
	/** 
     * Constructor de la clase parametrizado 
     * @param cr es el color de la pieza
     * @param r es la fila
     * @param c es la columna
     */ 
	public Pawn(Color cr, int r, int c) {
		super(cr,r, c);
		this.setKind(Piece.Kind.PAWN);
	}
	/** 
     * Comprueba si puede promocionar un peon
     * @return devuelve true si es posible y false si no lo es
     */ 
	public boolean canPromote() {
		if (getColor() == Piece.Color.WHITE) {
			return (getRow() == 7);
		} else {
			return (getRow() == 0);
		}
	}
	/** 
     * Devuelve el tipo de la pieza  
     * @return devuelve el tipo de la pieza
     */ 
	public String getKindString() {
		return "Pawn";
	}
	/** 
     * Devuelve el fichero segun la pieza que es
     * @return devuelve la cadena del fichero 
     */ 
	public String get3Dfile() {
		return "Peon" + (this.getColor() == Piece.Color.WHITE ? "B" : "N") + ".wrl";
	}
	/** 
     * Comprueba si se puede mover la pieza a al destino
     * @param target_row el la fila destino
     * @param target_column es la columna destino
     * @return devuelve true si se puede hacer y false en caso contrario
     */ 
	public boolean canMoveTo(int target_row, int target_column) {
		if (!((target_row - this.getRow() > 0) ^ ((this.getColor() == Piece.Color.WHITE ? 1 : -1) > 0)) && Math.abs(target_row - this.getRow()) <= (!moved ? 2 : 1) && this.getColumn() == target_column) {
			return true;
		} else {
			return false;
		}
	}
	public boolean canAttack(int target_row, int target_column) {
		if (target_row == this.getRow() + (this.getColor() == Piece.Color.WHITE ? 1 : -1) && Math.abs(this.getColumn() - target_column) == 1) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isBlockedBy(int target_row, int target_column, int obstacle_row, int obstacle_column) {
		return(this.canMoveTo(target_row, target_column) && this.canMoveTo(obstacle_row, obstacle_column) && this.isInPathTo(obstacle_row, obstacle_column, target_row, target_column) && this.isInPathTo(obstacle_row, obstacle_column, target_row, target_column));
	}
	public boolean isInPathTo(int obstacle_row, int obstacle_column, int target_row, int target_column) {
		if (moved) {
			return false;
		} else {
			int distance_to_target = target_row - this.getRow();
			int distance_to_obstacle = obstacle_row - this.getRow();;
			return (!(distance_to_target > 0 ^ distance_to_obstacle > 0) && Math.abs(distance_to_obstacle) < Math.abs(distance_to_target));
		}
	}
	public boolean hasAttackBlockedBy(int target_row, int target_column, int obstacle_row, int obstacle_column) {
		return false;
	}
	/** 
     * Devuelve los movimientos posible de la pieza 
     * @return devuelve el vector con los movimientos posible
     */ 
	public ArrayList<int[]> getTeoricalMovements() {
		ArrayList<int[]> list = new ArrayList<int[]>();
		//Movement
		//Normal

		int target = getRow() + (this.getColor() == Piece.Color.WHITE ? 1 : -1);
		if (target >= 0 && target < 8) {
			int pos[] = {target,getColumn()};
			list.add(pos);
		}
		//Extra
		if (!moved) {
		target = getRow() + (this.getColor() == Piece.Color.WHITE ? 2 : -2);
			if (target >= 0 && target < 8) {
				int pos[] = {target,getColumn()};
				list.add(pos);
			}
		}
		//Attack
		int target_y = getRow() + (this.getColor() == Piece.Color.WHITE ? 1 : -1);
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
		//End
		return list;
	}
	public double getPoints() {
		return 1;
	}
}
