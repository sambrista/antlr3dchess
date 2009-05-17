package chess;

import java.util.ArrayList;

public class Knight extends Piece {
	public Knight(Color cr, int r, int c) {
		super(cr,r, c);
		this.setKind(Piece.Kind.KNIGHT);
	}
	
	public String getKindString() {
		return "Knight";
	}
	public String get3Dfile() {
		return "Caballo" + (this.getColor() == Piece.Color.WHITE ? "B" : "N") + ".wrl";
	}
	public boolean canMoveTo(int target_row, int target_column) {
		if ( Math.sqrt(Math.pow(target_column - this.getColumn(), 2) + Math.pow(target_row - this.getRow(), 2)) == Math.sqrt(5)) {
			return true;
		} else {
			return false;
		}
	}
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
