package chess;
import java.util.*;

public class Board {
	private ArrayList<Piece> blackPieceList;
	private ArrayList<Piece> whitePieceList;
	private Random generator = new Random();
	public Board() {
		whitePieceList = new ArrayList<Piece>();
		blackPieceList = new ArrayList<Piece>();
	}
	public Board(Board b) {
		whitePieceList = new ArrayList<Piece>();
		blackPieceList = new ArrayList<Piece>();
		for (int i = 0; i < b.getWhitePieces().size(); ++i) {
			whitePieceList.add(b.getWhitePieces().get(i));
		}
		for (int i = 0; i < b.getBlackPieces().size(); ++i) {
			blackPieceList.add(b.getBlackPieces().get(i));
		}		
	}
	private ArrayList<Piece> getBlackPieces() {
		return blackPieceList;
	}
	private ArrayList<Piece> getWhitePieces() {
		return whitePieceList;
	}
	//Añadir pieza
	public boolean addPiece(Piece.Kind kind, Piece.Color color, int row, int column) {
		Board b = new Board(this);
		ArrayList<Piece> list;
		if (color == Piece.Color.BLACK) {
			list = b.getBlackPieces();
		} else {
			list = b.getWhitePieces();
		}
		switch(kind) {
		case PAWN:
			Pawn p = new Pawn(color, row, column);
			list.add(p);
			break;
		case BISHOP:
			Bishop q = new Bishop(color, row, column);
			list.add(q);
			break;
		case ROOK:
			Rook r = new Rook(color, row, column);
			list.add(r);
			break;
		case KNIGHT:
			Knight s = new Knight(color, row, column);
			list.add(s);
			break;
		case QUEEN:
			Queen t = new Queen(color, row, column);
			list.add(t);
			break;
		case KING:
			King u = new King(color, row, column);
			list.add(u);
			break;
		}
		if (b.isValid()) {
			if (color == Piece.Color.BLACK) {
				list = blackPieceList;
			} else {
				list = whitePieceList;
			}
			switch(kind) {
			case PAWN:
				Pawn p = new Pawn(color, row, column);
				list.add(p);
				break;
			case BISHOP:
				Bishop q = new Bishop(color, row, column);
				list.add(q);
				break;
			case ROOK:
				Rook r = new Rook(color, row, column);
				list.add(r);
				break;
			case KNIGHT:
				Knight s = new Knight(color, row, column);
				list.add(s);
				break;
			case QUEEN:
				Queen t = new Queen(color, row, column);
				list.add(t);
				break;
			case KING:
				King u = new King(color, row, column);
				list.add(u);
				break;
			}
			return true;
		} else {
			return false;
		}
	}
	//Generación del tablero
	public void random(Integer piecesno, double proportion, String disposal) {
		//Pieces generation
		Piece q;
		int row;
		int col;
		//Kings
		if (disposal.equals("original")) {
			q = new King(Piece.Color.WHITE, 4,0);
			whitePieceList.add(q);
			q = new King(Piece.Color.BLACK, 4,7);
			blackPieceList.add(q);
		} else {
			q = new King(Piece.Color.WHITE, generator.nextInt(8), generator.nextInt(8));
			whitePieceList.add(q);
			do {
				row = generator.nextInt(8);
				col = generator.nextInt(8);
			} while (q.isAt(row, col));
			q = new King(Piece.Color.BLACK, row ,col);
			blackPieceList.add(q);
		}
//		Available pieces
		

		if (disposal.equals("original")) {
			ArrayList<Piece> availableWPieces = new ArrayList<Piece>();
			ArrayList<Piece> availableBPieces = new ArrayList<Piece>();
			//White Queen
			availableWPieces.add((Piece) new Queen(Piece.Color.WHITE,3,0));
			//Black Queen
			availableBPieces.add((Piece) new Queen(Piece.Color.BLACK,3,0));
			//White Bishops
			availableWPieces.add((Piece) new Bishop(Piece.Color.WHITE,2,0));
			availableWPieces.add((Piece) new Bishop(Piece.Color.WHITE,4,0));
			//Black Bishops
			availableBPieces.add((Piece) new Bishop(Piece.Color.BLACK,2,0));
			availableBPieces.add((Piece) new Bishop(Piece.Color.BLACK,4,0));
			//White Knights
			availableWPieces.add((Piece) new Knight(Piece.Color.WHITE,1,0));
			availableWPieces.add((Piece) new Knight(Piece.Color.WHITE,6,0));
			//Black Knights
			availableBPieces.add((Piece) new Knight(Piece.Color.BLACK,1,0));
			availableBPieces.add((Piece) new Knight(Piece.Color.BLACK,6,0));
			//White Rooks
			availableWPieces.add((Piece) new Rook(Piece.Color.WHITE,0,0));
			availableWPieces.add((Piece) new Rook(Piece.Color.WHITE,7,0));
			//Black Rooks
			availableBPieces.add((Piece) new Rook(Piece.Color.BLACK,0,0));
			availableBPieces.add((Piece) new Rook(Piece.Color.BLACK,7,0));
			//Pawns
			for (int i = 0; i<8 ; ++i) {
				availableWPieces.add((Piece) new Pawn(Piece.Color.WHITE,i,1));
				availableBPieces.add((Piece) new Pawn(Piece.Color.BLACK,i,1));
			}
			for (int i = 0; i < piecesno  - 1; ++i) {
				whitePieceList.add(availableWPieces.remove(generator.nextInt(availableWPieces.size())));
			}
			for (int i = 0; i < Math.round(piecesno * proportion) - 1; ++i) {
				blackPieceList.add(availableBPieces.remove(generator.nextInt(availableBPieces.size())));	
			}
			
		} else {
			//White pieces
			ArrayList<Piece.Kind> availablePieces = new ArrayList<Piece.Kind>();
			availablePieces.add(Piece.Kind.PAWN);
			availablePieces.add(Piece.Kind.PAWN);
			availablePieces.add(Piece.Kind.PAWN);
			availablePieces.add(Piece.Kind.PAWN);
			availablePieces.add(Piece.Kind.PAWN);
			availablePieces.add(Piece.Kind.PAWN);
			availablePieces.add(Piece.Kind.PAWN);
			availablePieces.add(Piece.Kind.PAWN);
			availablePieces.add(Piece.Kind.BISHOP);
			availablePieces.add(Piece.Kind.BISHOP);
			availablePieces.add(Piece.Kind.QUEEN);
			availablePieces.add(Piece.Kind.ROOK);
			availablePieces.add(Piece.Kind.ROOK);
			availablePieces.add(Piece.Kind.KNIGHT);
			availablePieces.add(Piece.Kind.KNIGHT);
			
			for (int i = 0; i < piecesno  - 1; ++i) {
				while(!this.addPiece((Piece.Kind) availablePieces.remove(generator.nextInt(availablePieces.size())), Piece.Color.WHITE, generator.nextInt(8), generator.nextInt(8)));
			}
			availablePieces = new ArrayList<Piece.Kind>();
			availablePieces.add(Piece.Kind.PAWN);
			availablePieces.add(Piece.Kind.PAWN);
			availablePieces.add(Piece.Kind.PAWN);
			availablePieces.add(Piece.Kind.PAWN);
			availablePieces.add(Piece.Kind.PAWN);
			availablePieces.add(Piece.Kind.PAWN);
			availablePieces.add(Piece.Kind.PAWN);
			availablePieces.add(Piece.Kind.PAWN);
			availablePieces.add(Piece.Kind.BISHOP);
			availablePieces.add(Piece.Kind.BISHOP);
			availablePieces.add(Piece.Kind.QUEEN);
			availablePieces.add(Piece.Kind.ROOK);
			availablePieces.add(Piece.Kind.ROOK);
			availablePieces.add(Piece.Kind.KNIGHT);
			availablePieces.add(Piece.Kind.KNIGHT);
			Piece.Kind k;
			for (int i = 0; i < Math.round(piecesno * proportion) - 1; ++i) {
				k = (Piece.Kind) availablePieces.remove(generator.nextInt(availablePieces.size()));
				while(!this.addPiece(k, Piece.Color.BLACK, generator.nextInt(8), generator.nextInt(8)));
			}
		}
	}
	public void printSituation() {
		for (int i = 0; i < whitePieceList.size(); ++i) {
			System.out.println(whitePieceList.get(i).toString());
		}
		for (int i = 0; i < blackPieceList.size(); ++i) {
			System.out.println(blackPieceList.get(i).toString());
		}
	}
	
	public boolean removePiece(int row, int column) {
		boolean found = false;
		Piece p;
		int index;
		for (int i = 0; i < whitePieceList.size() && !found; ++i) {
			if (whitePieceList.get(i).isAt(row,column)) {
				p = whitePieceList.get(i);
				index = i;
				found = true;
			}
		}
		for (int i = 0; i < blackPieceList.size() && !found; ++i) {
			if (blackPieceList.get(i).isAt(row,column)) {
				p = blackPieceList.get(i);
				found = true;
			}
		}
		if (found) {
			return false; //TODO
		} else {
			return false;
		}
	}
	
	//Devuelve si hay jaque
	public boolean isColorCheck(Piece.Color color) {
		ArrayList<Piece> friends;
		ArrayList<Piece> enemies;
		ArrayList<Piece> otherFriends = new ArrayList<Piece>();
		if (color == Piece.Color.WHITE) {
			friends = whitePieceList;
			enemies = blackPieceList;
		} else {
			friends = blackPieceList;
			enemies = whitePieceList;	
		}
		King king = null;
		boolean check = false;
		for (int i = 0; i < friends.size(); ++i) {
			if (friends.get(i).getKind() == Piece.Kind.KING) {
				king = (King) friends.get(i);
			} else if (friends.get(i).isAlive()){
				otherFriends.add(friends.get(i));
			}
		}
		if (king != null) {
			for (int i = 0; i < enemies.size() && !check; ++i) {
				if (enemies.get(i).isAlive() && enemies.get(i).canAttack(king.getRow(), king.getColumn())) {
					System.out.println("***DEBUG " + enemies.get(i).toString() + " can attack " + king.toString());
					//Checking if there are friends between
					for (int j = 0; j < otherFriends.size() && !check; ++j) {
						check = !enemies.get(i).hasAttackBlockedBy(king.getRow(), king.getColumn(), otherFriends.get(j).getRow(), otherFriends.get(j).getColumn());
					}
					//Checking if there are other enemies between
					for (int j = 0; j < enemies.size() && !check; ++j) {
						if (j != i) {
							check = !enemies.get(i).hasAttackBlockedBy(king.getRow(), king.getColumn(), enemies.get(j).getRow(), enemies.get(j).getColumn());
						}
					}
				}
			} 
		}
		return check;
	}
	//Devuelve si el rey blanco está en jaque
	public boolean isWhiteCheck() {
		return isColorCheck(Piece.Color.WHITE);
	}
	//Devuelve si el rey negro está en jaque
	public boolean isBlackCheck() {
		return isColorCheck(Piece.Color.BLACK);
	}
	//Numero de fichas en una celda, 0 = vacia, 1 = normal, > 1 = FALLO!
	public int cellOccupants(int row, int column) {
		int counter = 0;
		for (int i = 0; i < whitePieceList.size(); ++i) {
			if(whitePieceList.get(i).isAt(row,column)) {
				++counter;
			}
		}
		for (int i = 0; i < blackPieceList.size(); ++i) {
			if (blackPieceList.get(i).isAt(row,column)) {
				++counter;
			}
		}
		return (counter);
	}
	//Devuelve si el tablero generado cumple con las normas
	public boolean isValid() {
		boolean valid = true;
		//No jaques
		valid = !isWhiteCheck() && ! isBlackCheck();
		//DEBUG
		if (!valid) System.out.println("***DEBUG Check detected!");
		//Casillas ocupadas por una sola pieza
		for (int i = 0; i < whitePieceList.size() && valid; ++i) {
			valid = cellOccupants(whitePieceList.get(i).getRow(), whitePieceList.get(i).getColumn()) < 2;
			//DEBUG
			if (!valid) System.out.println("***DEBUG More than 1 piece in a cell!");
		}
		for (int i = 0; i < blackPieceList.size() && valid; ++i) {
			valid = cellOccupants(blackPieceList.get(i).getRow(), blackPieceList.get(i).getColumn()) < 2;
			//DEBUG
			if (!valid) System.out.println("***DEBUG More than 1 piece in a cell!");
		}
		//No álfiles en casillas de mismo color
		for (int i = 0, black_bishop = 0, white_bishop = 0; i < whitePieceList.size() && valid; ++i) {
			if (whitePieceList.get(i).getKind() == Piece.Kind.BISHOP) {
				if ((whitePieceList.get(i).getRow() + whitePieceList.get(i).getColumn()) % 2 == 0) {
					++black_bishop;
				} else {
					++white_bishop;
				}
				valid = !(black_bishop > 1 || white_bishop > 1);
				//DEBUG
				if (!valid) System.out.println("***DEBUG 2 Bishops in the same color");
			}
		}
		for (int i = 0, black_bishop = 0, white_bishop = 0; i < blackPieceList.size() && valid; ++i) {
			if (blackPieceList.get(i).getKind() == Piece.Kind.BISHOP) {
				if ((blackPieceList.get(i).getRow() + blackPieceList.get(i).getColumn()) % 2 == 0) {
					++black_bishop;
				} else {
					++white_bishop;
				}
				valid = !(black_bishop > 1 || white_bishop > 1);
				//DEBUG
				if (!valid) System.out.println("***DEBUG 2 Bishops in the same color");
			}
		}
		//No más de 1 rey
		for (int i = 0, kings = 0; i < whitePieceList.size() && valid; ++i) {
			if (whitePieceList.get(i).getKind() == Piece.Kind.KING) {
				++kings;
				valid = !(kings > 1);
				//DEBUG
				if (!valid) System.out.println("***DEBUG > 1 king");
			}
		}
		for (int i = 0, kings = 0; i < blackPieceList.size() && valid; ++i) {
			if (blackPieceList.get(i).getKind() == Piece.Kind.KING) {
				++kings;
				valid = !(kings > 1);
				//DEBUG
				if (!valid) System.out.println("***DEBUG > 1 king");
			}
		}
		//No peones en última fila
		for (int i = 0; i < whitePieceList.size() && valid; ++i) {
			if (whitePieceList.get(i).getKind() == Piece.Kind.PAWN) {
				valid = !(whitePieceList.get(i).getRow() == 7);
				//DEBUG
				if (!valid) System.out.println("***DEBUG Pawns at last row");
			}
		}
		for (int i = 0; i < blackPieceList.size() && valid; ++i) {
			if (blackPieceList.get(i).getKind() == Piece.Kind.PAWN) {
				valid = !(blackPieceList.get(i).getRow() == 0);
				//DEBUG
				if (!valid) System.out.println("***DEBUG Pawns at last row");
			}
		}
		return valid;
	}
}
