package chess;
import java.util.*;
import java.io.*;

public class Piece {
	static int next_id = 0;
	boolean moved;
	public enum Color { BLACK, WHITE };
	public enum Kind { KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN };
	private Color color;
	private Kind kind;
	private int row;
	private int original_row;
	private int column;
	private int original_column;
	private boolean dead;
	private int id;
	public Piece(Color cr, int r, int c) {
		this.color = cr;
		this.row = r;
		original_row = r;
		original_column = c;
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
	public String get3DId () {
		return "PIEZA"+ getKind() + id + getColor();
	}
	public void generate3D (PrintWriter pw) {
		pw.println("\nDEF " + get3DId()  +" Transform{");
		pw.println("\ttranslation "+(-21+(6*original_column)) +" 0.0 "+ (21-(6*original_row)));
		pw.println("\tchildren Inline{url \""+ get3Dfile()+"\"}},");
	}
	public boolean hasMoved() {
		return moved;
	}
	public void setAsInitialCell() {
		original_column = column;
		original_row = row;
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
	public void setMoved(boolean b) {
		moved = b;
	}
	public boolean canPromote() {return false;}
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
	public ArrayList<int[]> getTeoricalMovements() {return null;}
	public boolean canMoveTo(int target_row, int target_column) {return false;}
	public boolean isBlockedBy(int target_row, int target_column, int obstacle_row, int obstacle_column) {return false;}
	public boolean hasAttackBlockedBy(int target_row, int target_column, int obstacle_row, int obstacle_column) {return isBlockedBy(target_row, target_column, obstacle_row, obstacle_column);}
	public boolean canAttack(int target_row, int target_column) {return canMoveTo(target_row, target_column);}
	public boolean isInPathTo(int obstacle_row, int obstacle_column, int target_row, int target_column) {return false;}
}