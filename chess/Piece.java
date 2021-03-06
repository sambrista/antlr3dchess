package chess;
import java.util.*;
import java.io.*;

/** Clase Piece
* es la clase donde se definen los elementos refentes a las piezas
* @author Alfonso Jimnez Vilchez y Francisco Rinc�n Li�vana
*/
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
	private boolean initial;
	public Piece(Color cr, int r, int c) {
		this.color = cr;
		this.row = r;
		original_row = r;
		original_column = c;
		this.column = c;
		dead = false;
		id = next_id++;
		moved = false;
		initial = true;
	}
	public static String colorToString(Color c) {
		String result = null;
		switch (c) {
		case WHITE:
			result = "Blanco";
			break;
		case BLACK:
			result = "Negro";
			break;
		}
		return result;
	}
	public static Color stringToColor(String str) {
		if (str.compareTo("blanco") == 0) {
			return Piece.Color.WHITE;
		} else if (str.compareTo("negro") == 0) {
			return Piece.Color.BLACK;
		} else {
			return null;
		}
	}
	public static String kindToString(Kind k) {
		String result = null;
		switch (k) {
		case PAWN:
			result = "Peon";
			break;
		case KNIGHT:
			result = "Caballo";
			break;
		case ROOK:
			result = "Torre";
			break;
		case BISHOP:
			result = "Alfil";
			break;
		case QUEEN:
			result = "Reina";
			break;
		case KING:
			result = "Rey";
			break;
		}
		return result;
	}
	public static Kind stringToKind(String str) {
		if (str.compareTo("peon") == 0) {
			return Piece.Kind.PAWN;
		} else if (str.compareTo("torre") == 0) {
			return Piece.Kind.ROOK;
		} else if (str.compareTo("caballo") == 0) {
			return Piece.Kind.KNIGHT;
		} else if (str.compareTo("alfil") == 0) {
			return Piece.Kind.BISHOP;
		} else if (str.compareTo("reina") == 0) {
			return Piece.Kind.QUEEN;
		} else if (str.compareTo("rey") == 0) {
			return Piece.Kind.KING;
		} else {
			return null;
		}
	}
	public void setInitial(boolean b) {
		initial = b;
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
		pw.println("\ttranslation "+(-21+(6*original_column)) + (initial == true? " 0.0 " : " -10 " )+ (21-(6*original_row)));
		if (color == Piece.Color.WHITE){
			pw.println("\trotation 0 1 0 3.14");
		}
		if (color == Piece.Color.BLACK){
			pw.println("\trotation 0 1 0 0");
		}
		pw.println("\tchildren Inline{url \""+ get3Dfile() +"\"}},");
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
	public String state() {
		String result = new String("");
		if (isAlive()) {
		result += Board.numberToLetter(column) + "," + (row + 1) + " ";
		}
		result += kindToString(getKind());
		if (!isAlive()) {
			result += " (ficha capturada)";
		}
		return result;
	}
	public static String getPieceLettersFromString(String source) {
		String result = "";
		if (source.indexOf("PAWN") != -1) {
			result += "P";
		} else if (source.indexOf("ROOK") != -1) {
			result += "T";
		} else if (source.indexOf("KNIGHT") != -1) {
			result += "C";
		} else if (source.indexOf("BISHOP") != -1) {
			result += "A";
		} else if (source.indexOf("KING") != -1) {
			result += "R";
		} else if (source.indexOf("QUEEN") != -1) {
			result += "D";
		}
		if (source.indexOf("BLACK") != -1) {
			result += "N";
		} else {
			result += "B";
		}
		return result;
	}
	
	public void write3D(PrintWriter file) {
		//TODO
	}
	//Virtual functions
	public double getPoints() {return(0);}
	public String getKindString() {return "";}
	public String get3Dfile() {return "";}
	public ArrayList<int[]> getTeoricalMovements() {return null;}
	public boolean canMoveTo(int target_row, int target_column) {return false;}
	public boolean isBlockedBy(int target_row, int target_column, int obstacle_row, int obstacle_column) {return false;}
	public boolean hasAttackBlockedBy(int target_row, int target_column, int obstacle_row, int obstacle_column) {return isBlockedBy(target_row, target_column, obstacle_row, obstacle_column);}
	public boolean canAttack(int target_row, int target_column) {return canMoveTo(target_row, target_column);}
	public boolean isInPathTo(int obstacle_row, int obstacle_column, int target_row, int target_column) {return false;}
}