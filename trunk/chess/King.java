package chess;

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
		if (Math.abs(this.getColumn() - target_column) == 1 || Math.abs(this.getRow() - target_row) == 1) {
			return true;
		} else {
			return false;
		}
	}
}
