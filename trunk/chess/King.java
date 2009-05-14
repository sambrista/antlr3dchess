package chess;

import java.util.ArrayList;

public class King extends Piece {
	public King(Color cr, int r, int c) {
		super(cr,r, c);
		this.setKind(Piece.Kind.KING);
	}
	public String getKindString() {
		return "King";
	}
	public String get3Dfile() {
		return "Rey" + (this.getColor() == Piece.Color.WHITE ? "B" : "N") + ".wrl";
	}
	public boolean canMoveTo(int target_row, int target_column) {
		if (Math.abs(this.getColumn() - target_column) < 1 && Math.abs(this.getRow() - target_row) < 1) {
			return true;
		} else {
			return false;
		}
	}
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
