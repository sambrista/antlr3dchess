package chess;
import java.io.*;

public class Piece {
	static int next_id = 0;
	boolean moved;
	public enum Color { BLACK, WHITE };
	public enum Kind { KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN };
	private Color color;
	private Kind kind;
	private int row;
	private int column;
	private boolean dead;
	private int id;
	public Piece(Color cr, int r, int c) {
		this.color = cr;
		this.row = r;
		this.column = c;
		dead = false;
		id = next_id++;
		moved = false;
	}
	public void move(int row, int column) {
		moved = true;
		setPosition(row, column);
	}
	public Piece(Piece p) {
		this.color = p.getColor();
		this.row = p.getRow();
		this.column = p.getColumn();
		dead = !p.isAlive();
		id = next_id++;
		moved = p.hasMoved();
		kind = p.getKind();
	}
	public boolean hasMoved() {
		return moved;
	}
	public void setColor(Color c) {
		this.color = c;
	}
	public void kill() {
		dead = true;
	}
	public boolean isAlive() {
		return !dead;
	}
	public void setPosition(int r, int c) {
		this.row = r;
		this.column = c;
	}
	public void setKind(Kind k) {
		this.kind = k;
	}
	public Kind getKind() {
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
	public boolean isAt(int r, int c) {
		return (r == row && c == column);
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
		result += " (" + (dead? "dead" : "alive") + ")";
		result += " ID " + id;
		return result;
	}
	public void write3D(PrintWriter file) {
		//TODO
	}
	//Virtual functions
	public String getKindString() {return "";}
	public String get3Dfile() {return "";}
	public boolean canMoveTo(int target_row, int target_column) {return false;}
	public boolean isBlockedBy(int target_row, int target_column, int obstacle_row, int obstacle_column) {return false;}
	public boolean hasAttackBlockedBy(int target_row, int target_column, int obstacle_row, int obstacle_column) {return isBlockedBy(target_row, target_column, obstacle_row, obstacle_column);}
	public boolean canAttack(int target_row, int target_column) {return canMoveTo(target_row, target_column);}
	public boolean isInPathTo(int obstacle_row, int obstacle_column, int target_row, int target_column) {return false;}
}