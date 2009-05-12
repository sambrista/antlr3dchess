package chess;

public class Piece {
	public enum Color { BLACK, WHITE };
	public enum Kind { KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN };
	private Color color;
	private Kind kind;
	private int row;
	private int column;
	public Piece(Color cr, int r, int c) {
		this.color = cr;
		this.row = r;
		this.column = c;
	}
	public void setColor(Color c) {
		this.color = c;
	}
	public void setPosition(int r, int c) {
		this.row = r;
		this.column = c;
	}
	public void setKind(Kind k) {
		this.kind = k;
	}
	public Kind getKind(Kind k) {
		return kind;
	}
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
	public Color getColor() {
		return color;
	}
	public String toString() {
		String result = new String();
		result += row + "," + column;
		result += " ";
		switch (this.color) {
			case BLACK:
				result += "Black";
				break;
			case WHITE:
				result += "White";
				break;
		}
		result += " " + this.getKindString();
		return result;
	}
	//Virtual functions
	public String getKindString() {return "";}
	public boolean canMoveTo(int target_row, int target_column) {return false;}
	public boolean isBlockedBy(int target_row, int target_column, int obstacle_row, int obstacle_column) {return false;}
	public boolean hasAttackBlockedBy(int target_row, int target_column, int obstacle_row, int obstacle_column) {return isBlockedBy(target_row, target_column, obstacle_row, obstacle_column);}
	public boolean canAttack(int target_row, int target_column) {return canMoveTo(target_row, target_column);}
	public boolean isInPathTo(int obstacle_row, int obstacle_column, int target_row, int target_column) {return false;}
}