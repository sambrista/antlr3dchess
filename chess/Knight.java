package chess;

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
}
