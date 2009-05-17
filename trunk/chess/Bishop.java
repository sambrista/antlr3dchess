package chess;

import java.util.ArrayList;

public class Bishop extends Piece {
	public Bishop(Color cr, int r, int c) {
		super(cr,r, c);
		this.setKind(Piece.Kind.BISHOP);
	}
	public String getKindString() {
		return "Bishop";
	}
	public String get3Dfile() {
		return "Alfil" + (this.getColor() == Piece.Color.WHITE ? "B" : "N") + ".wrl";
	}
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
