package chess;
import java.util.*;

/** Clase Rook
* es la clase donde se definen los elementos de la torre
* @author Alfonso Jimnez Vilchez y Francisco Rinc—n LiŽvana
*/
public class Rook extends Piece {
	/** 
     * Constructor de la clase parametrizado 
     * @param cr es el color de la pieza
     * @param r es la fila
     * @param c es la columna
     */ 
	public Rook(Color cr, int r, int c) {
		super(cr,r, c);
		this.setKind(Piece.Kind.ROOK);
	}
	/** 
     * Devuelve el tipo de la pieza  
     * @return devuelve el tipo de la pieza
     */ 
	public String getKindString() {
		return "Rook";
	}
	/** 
     * Devuelve el fichero segun la pieza que es
     * @return devuelve la cadena del fichero 
     */ 
	public String get3Dfile() {
		return "Torre" + (this.getColor() == Piece.Color.WHITE ? "B" : "N") + ".wrl";
	}
	/** 
     * Comprueba si se puede mover la pieza a al destino
     * @param target_row el la fila destino
     * @param target_column es la columna destino
     * @return devuelve true si se puede hacer y false en caso contrario
     */ 
	public boolean canMoveTo(int target_row, int target_column) {
		if (this.getRow() == target_row || this.getColumn() == target_column) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isBlockedBy(int target_row, int target_column, int obstacle_row, int obstacle_column) {
		return(this.isInPathTo(obstacle_row, obstacle_column, target_row, target_column));
	}
	public boolean isInPathTo(int obstacle_row, int obstacle_column, int target_row, int target_column) {
		int distance_to_target = 1;
		int distance_to_obstacle = -1;
		if (this.getRow() == target_row && target_row == obstacle_row) {
			distance_to_target = target_column - this.getColumn();
			distance_to_obstacle = obstacle_column - this.getColumn();
		} else if (this.getColumn() == target_column && target_column == obstacle_column) {
			distance_to_target = target_row - this.getRow();
			distance_to_obstacle = obstacle_row - this.getRow();
		}
		return (!(distance_to_target > 0 ^ distance_to_obstacle > 0) && Math.abs(distance_to_obstacle) < Math.abs(distance_to_target));
	}
	public double getPoints() {
		return 5;
	}
	/** 
     * Devuelve los movimientos posible de la pieza 
     * @return devuelve el vector con los movimientos posible
     */ 
	public ArrayList<int[]> getTeoricalMovements() {
		ArrayList<int[]> list = new ArrayList<int[]>();
		//Movement
		//Horizontal
		for (int i = 0; i < 8; ++i) {
			if (i != getColumn()) {
				int pos[] = {getRow(),i};
				list.add(pos);
			}
		}
		//Vertical
		for (int i = 0; i < 8; ++i) {
			if (i != getRow()) {
				int pos[] = {i,getColumn()};
				list.add(pos);
			}
		}
		//Attack
		
		//End
		return list;
	}
}