package chess;
import java.util.*;
import java.io.*;

public class Board {
	private ArrayList<Piece> blackPieceList;
	private ArrayList<Piece> whitePieceList;
	private ArrayList<String> letters;
	private Random generator = new Random();
	public Board() {
		whitePieceList = new ArrayList<Piece>();
		blackPieceList = new ArrayList<Piece>();
		letters = new ArrayList<String>();
		letters.add("A");
		letters.add("B");
		letters.add("C");
		letters.add("D");
		letters.add("E");
		letters.add("F");
		letters.add("G");
		letters.add("H");
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
	public String numberToLetter(int n) {
		return letters.get(n);
	}
	public int LetterTonumber(String l) {
		return letters.indexOf(l);
	}
	public void promotePawn(Piece p) {
		ArrayList<Piece> list = (p.getColor() == Piece.Color.WHITE ? whitePieceList : blackPieceList);
		switch(generator.nextInt(4)) {
		case 0:
			Rook r = new Rook(p.getColor(), p.getRow(), p.getColumn());
			r.setMoved(true);
			list.add((Piece) r);
			break;
		case 1:
			Knight k = new Knight(p.getColor(), p.getRow(), p.getColumn());
			k.setMoved(true);
			list.add((Piece) k);
			break;
		case 2:
			Bishop b = new Bishop(p.getColor(), p.getRow(), p.getColumn());
			b.setMoved(true);
			list.add((Piece) b);
			break;
		case 3:
			Queen q = new Queen(p.getColor(), p.getRow(), p.getColumn());
			q.setMoved(true);
			list.add((Piece) q);
			break;
		}
		list.remove((Piece) p);
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
	
	public void generate3D(String path ) throws IOException{
		
		
		System.out.println("Generando archivo...");
		FileReader filein = null;
		FileWriter fileout=null;
		PrintWriter pw=null;
		
		Piece k = null;
		
		
		for(int i=0; i<blackPieceList.size();i++){
			k = whitePieceList.get(i);
		}
	
		
		
		
		try {
			filein = new FileReader("./3D/base.wrl");

			BufferedReader bf = new BufferedReader(filein); 
			String sCadena;
			
			fileout=new FileWriter(path+"ajedrez.wrl");
			pw = new PrintWriter(fileout);
			
			while ((sCadena = bf.readLine())!=null) 
				pw.println(sCadena);
			
			filein.close();
			
			for(int j=0; j<blackPieceList.size();j++){
				k = blackPieceList.get(j);
				k.generate3D(pw);
			}
			for(int j=0; j<whitePieceList.size();j++){
				k = whitePieceList.get(j);
				k.generate3D(pw);
			}
			
			pw.println("]}]}]}]}");
		fileout.close();
		} catch (IOException e) {
			e.printStackTrace();	
		}		
		System.out.println("Archivo generado");


	}
	
	
	public boolean setupPiece(int originRow, int originColumn, int targetRow, int targetColumn) {
		Piece p = null;
		int index = -1;
		for (int i = 0; i < whitePieceList.size() && p == null; ++i) {
			if (whitePieceList.get(i).isAt(originRow,originColumn) && whitePieceList.get(i).isAlive()) {
				p = whitePieceList.get(i);
				index = i;
				System.out.println("***DEBUG Piece found! " + p.toString());
			}
		}
		for (int i = 0; i < blackPieceList.size() && p == null; ++i) {
			if (blackPieceList.get(i).isAt(originRow,originColumn) && blackPieceList.get(i).isAlive()) {
				p = blackPieceList.get(i);
				index = i;
				System.out.println("***DEBUG Piece found! " + p.toString());
			}
		}
		if (p != null) {
			boolean moveKing = false;
			Board b = new Board(this);
			int kingIndex = -1;
			Piece k = null;
			int kingNewRow = -1;
			int kingNewColumn = -1;
			if (p.getColor() == Piece.Color.WHITE) {
				b.getWhitePieces().remove(index);
			} else {
				b.getBlackPieces().remove(index);
			}
			ArrayList<Piece> list;
			if (p.getColor() == Piece.Color.BLACK) {
				list = b.getBlackPieces();
			} else {
				list = b.getWhitePieces();
			}
			switch(p.getKind()) {
			case PAWN:
				Pawn v = new Pawn(p.getColor(), targetRow, targetColumn);
				list.add(v);
				break;
			case BISHOP:
				Bishop q = new Bishop(p.getColor(), targetRow, targetColumn);
				list.add(q);
				break;
			case ROOK:
				Rook r = new Rook(p.getColor(), targetRow, targetColumn);
				list.add(r);
				break;
			case KNIGHT:
				Knight s = new Knight(p.getColor(), targetRow, targetColumn);
				list.add(s);
				break;
			case QUEEN:
				Queen t = new Queen(p.getColor(), targetRow, targetColumn);
				list.add(t);
				break;
			case KING:
				King u = new King(p.getColor(), targetRow, targetColumn);
				list.add(u);
				break;
			}
			if (!b.isValid() && (b.isBlackCheck() || b.isWhiteCheck())) {
				System.out.println("***Warning!! Check!!");
				if (b.isBlackCheck()) {
					for (int i = 0; i < blackPieceList.size() && k == null; ++i) {
						if (blackPieceList.get(i).getKind() == Piece.Kind.KING) {
							k = blackPieceList.get(i);
							kingIndex = i;
							System.out.println("***DEBUG King found! " + k.toString());
						}
					}
				} else {
					for (int i = 0; i < whitePieceList.size() && k == null; ++i) {
						if (whitePieceList.get(i).getKind() == Piece.Kind.KING) {
							k = whitePieceList.get(i);
							System.out.println("***DEBUG King found! " + k.toString());
							kingIndex = i;
						}
					}
				}
				System.out.println("***DEBUG rey enemigo: " + k.toString());
				int down_row = k.getRow() == 0 ? 0 : k.getRow() - 1;
				int up_row = k.getRow() == 7 ? 7 : k.getRow() + 1;
				int left_column = k.getColumn() == 0 ? 0 : k.getColumn() - 1;
				int right_column = k.getColumn() == 7 ? 7 : k.getColumn() + 1;
				kingNewRow = k.getRow();
				kingNewColumn = k.getColumn();
				for (int c = left_column; c <= right_column && !moveKing; ++c) {
					for (int r = down_row; r <= up_row && !moveKing; ++r) {
						k.setPosition(r, c);
						if (b.isValid()) {
							moveKing = true;
							kingNewRow = r;
							kingNewColumn = c;
						}
					}
				}
				if (!moveKing) {
					k.setPosition(kingNewRow, kingNewColumn);
					return false;
				}
			}
			p.setPosition(targetRow, targetColumn);
			if (moveKing) {
				if (p.getColor() == Piece.Color.WHITE) {
					blackPieceList.get(kingIndex).setPosition(kingNewRow, kingNewColumn);
				} else {
					whitePieceList.get(kingIndex).setPosition(kingNewRow, kingNewColumn);
				}
			}
			return true;
		} else {
			return false;
		}
	}
	public boolean removePiece(Piece.Kind kind, Piece.Color color) {
		Piece p = null;
		if (color == Piece.Color.WHITE) {
			for (int i = 0; i < whitePieceList.size() && p == null; ++i) {
				if (whitePieceList.get(i).getKind() == kind) {
					p = whitePieceList.get(i);
					System.out.println("***DEBUG Piece found! " + p.toString());
				}
			}
		} else {
			for (int i = 0; i < blackPieceList.size() && p == null; ++i) {
				if (blackPieceList.get(i).getKind() == kind) {
					p = blackPieceList.get(i);
					System.out.println("***DEBUG Piece found! " + p.toString());
				}
			}
		}
		if (p != null) {
			return (removePiece(p.getRow(), p.getColumn()));
		} else {
			return false;
		}
	}
	public boolean move(int originRow, int originColumn, int targetRow, int targetColumn) {
		Piece p = null;
		int index = -1;
		for (int i = 0; i < whitePieceList.size() && p == null; ++i) {
			if (whitePieceList.get(i).isAt(originRow,originColumn) && whitePieceList.get(i).isAlive()) {
				p = whitePieceList.get(i);
				index = i;
				System.out.println("***DEBUG Piece found! " + p.toString());
			}
		}
		for (int i = 0; i < blackPieceList.size() && p == null; ++i) {
			if (blackPieceList.get(i).isAt(originRow,originColumn) && blackPieceList.get(i).isAlive()) {
				p = blackPieceList.get(i);
				index = i;
				System.out.println("***DEBUG Piece found! " + p.toString());
			}
		}
		if (p == null) {
			System.out.println("***DEBUG No existe la pieza");			
			return (false);
		}
		
		Piece p2 = null;
		int index2 = -1;
		for (int i = 0; i < whitePieceList.size() && p2 == null; ++i) {
			if (whitePieceList.get(i).isAt(targetRow,targetColumn) && whitePieceList.get(i).isAlive()) {
				p2 = whitePieceList.get(i);
				index2 = i;
				System.out.println("***DEBUG Target Piece found! " + p2.toString());
			}
		}
		for (int i = 0; i < blackPieceList.size() && p2 == null; ++i) {
			if (blackPieceList.get(i).isAt(targetRow,targetColumn) && blackPieceList.get(i).isAlive()) {
				p2 = blackPieceList.get(i);
				index2 = i;
				System.out.println("***DEBUG Target Piece found! " + p2.toString());
			}
		}
		if (p2 != null && p2.getColor() == p.getColor()) {
			System.out.println("***DEBUG " + p.toString() + " ataca a su compañero " + p2.toString());
			return (false);
		}
		
		//Comprobar si puede mover y si no hay nadie en medio
		
		boolean blocked = false;
		System.out.println("***DEBUG Now checking friends");
		//Checking if there are friends between
		ArrayList<Piece> friends = (p.getColor() == Piece.Color.WHITE ? whitePieceList : blackPieceList);
		for (int j = 0; j < friends.size() && !blocked; ++j) {
			if (j != index) {
				blocked = (p2 != null ?
						p.hasAttackBlockedBy(targetRow, targetColumn, friends.get(j).getRow(), friends.get(j).getColumn())
					:
						p.isBlockedBy(targetRow, targetColumn, friends.get(j).getRow(), friends.get(j).getColumn())
				);
				System.out.println("***DEBUG Check if " + friends.get(j).toString() + " is between and the result is " + blocked);
			}
			
		}
		System.out.println("***DEBUG Now checking enemies");
		//Checking if there are other enemies between
		friends = (p.getColor() == Piece.Color.WHITE ? blackPieceList : whitePieceList);
		for (int j = 0; j < friends.size() && !blocked; ++j) {
			if (j != index2) {
				blocked = (p2 != null ?
						p.hasAttackBlockedBy(targetRow, targetColumn, friends.get(j).getRow(), friends.get(j).getColumn())
					:
						p.isBlockedBy(targetRow, targetColumn, friends.get(j).getRow(), friends.get(j).getColumn())
				);
				System.out.println("***DEBUG Check if " + friends.get(j).toString() + " is between and the result is " + blocked);
			}
			
		}
		if (blocked) {
			System.out.println("***DEBUG Movement Blocked!");
			return false;
		}
		
		
		Board b = new Board(this);
		if (p.getColor() == Piece.Color.WHITE) {
			b.getWhitePieces().remove(index);
		} else {
			b.getBlackPieces().remove(index);
		}
		if (p2 != null) {
			b.printSituation();
			if (p2.getColor() == Piece.Color.WHITE) {
				b.getWhitePieces().remove(index2);
			} else {
				b.getBlackPieces().remove(index2);
			}
			System.out.println("***DEBUG ---");
			b.printSituation();
		}
		ArrayList<Piece> list;
		if (p.getColor() == Piece.Color.BLACK) {
			list = b.getBlackPieces();
		} else {
			list = b.getWhitePieces();
		}
		switch(p.getKind()) {
		case PAWN:
			Pawn v = new Pawn(p.getColor(), targetRow, targetColumn);
			list.add(v);
			break;
		case BISHOP:
			Bishop q = new Bishop(p.getColor(), targetRow, targetColumn);
			list.add(q);
			break;
		case ROOK:
			Rook r = new Rook(p.getColor(), targetRow, targetColumn);
			list.add(r);
			break;
		case KNIGHT:
			Knight s = new Knight(p.getColor(), targetRow, targetColumn);
			list.add(s);
			break;
		case QUEEN:
			Queen t = new Queen(p.getColor(), targetRow, targetColumn);
			list.add(t);
			break;
		case KING:
			King u = new King(p.getColor(), targetRow, targetColumn);
			list.add(u);
			break;
		}
		System.out.println("***DEBUG Comprobando nueva situación");
		if (p.getColor() == Piece.Color.WHITE ? b.isWhiteCheck() : b.isBlackCheck()) {
			System.out.println("***DEBUG Si mueves proocas jaque!");
			return false;
		}
		//Adelante!
		//Cambiar posición de pieza
		p.move(targetRow, targetColumn);
		//Generar evento
		//TODO
		//Matar pieza oponente si hay
		if (p2 != null) {
			p2.kill();
		}
		//Si es peon
		if (p.getKind() == Piece.Kind.PAWN && p.canPromote()) {
			promotePawn(p);
		}
		//Generar evento
		//TODO
		return (true);
	}
	
	public boolean removePiece(int row, int column) {
		Piece p = null;
		int index = -1;
		for (int i = 0; i < whitePieceList.size() && p == null; ++i) {
			if (whitePieceList.get(i).isAt(row,column)) {
				p = whitePieceList.get(i);
				index = i;
				System.out.println("***DEBUG Piece found! " + p.toString());
			}
		}
		for (int i = 0; i < blackPieceList.size() && p == null; ++i) {
			if (blackPieceList.get(i).isAt(row,column)) {
				p = blackPieceList.get(i);
				index = i;
				System.out.println("***DEBUG Piece found! " + p.toString());
			}
		}
		if (p != null && p.getKind() != Piece.Kind.KING) {
			boolean moveKing = false;
			Board b = new Board(this);
			int kingIndex = -1;
			Piece k = null;
			int kingNewRow = -1;
			int kingNewColumn = -1;
			if (p.getColor() == Piece.Color.WHITE) {
				b.getWhitePieces().remove(index);
			} else {
				b.getBlackPieces().remove(index);
			}
			if (!b.isValid()) {
				System.out.println("***Warning!! Check!!");
				if (b.isBlackCheck()) {
					for (int i = 0; i < blackPieceList.size() && k == null; ++i) {
						if (blackPieceList.get(i).getKind() == Piece.Kind.KING) {
							k = blackPieceList.get(i);
							kingIndex = i;
							System.out.println("***DEBUG King found! " + k.toString());
						}
					}
				} else {
					for (int i = 0; i < whitePieceList.size() && k == null; ++i) {
						if (whitePieceList.get(i).getKind() == Piece.Kind.KING) {
							k = whitePieceList.get(i);
							System.out.println("***DEBUG King found! " + k.toString());
							kingIndex = i;
						}
					}
				}
				System.out.println("***DEBUG rey enemigo: " + k.toString());
				int down_row = k.getRow() == 0 ? 0 : k.getRow() - 1;
				int up_row = k.getRow() == 7 ? 7 : k.getRow() + 1;
				int left_column = k.getColumn() == 0 ? 0 : k.getColumn() - 1;
				int right_column = k.getColumn() == 7 ? 7 : k.getColumn() + 1;
				kingNewRow = k.getRow();
				kingNewColumn = k.getColumn();
				for (int c = left_column; c <= right_column && !moveKing; ++c) {
					for (int r = down_row; r <= up_row && !moveKing; ++r) {
						k.setPosition(r, c);
						if (b.isValid()) {
							moveKing = true;
							System.out.println("***DEBUG Posición a salvo: " + r + "," + c);
							kingNewRow = r;
							kingNewColumn = c;
						}
					}
				}
				if (!moveKing) {
					k.setPosition(kingNewRow, kingNewColumn);
					return false;
				}
			}
			if (p.getColor() == Piece.Color.WHITE) {
				whitePieceList.remove(index);
			} else {
				blackPieceList.remove(index);
			}
			if (moveKing) {
				if (p.getColor() == Piece.Color.WHITE) {
					blackPieceList.get(kingIndex).setPosition(kingNewRow, kingNewColumn);
				} else {
					whitePieceList.get(kingIndex).setPosition(kingNewRow, kingNewColumn);
				}
			}
			return true;
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
					check = true;
					System.out.println("***DEBUG Now checking friends");
					//Checking if there are friends between
					for (int j = 0; j < otherFriends.size() && check; ++j) {
						check = !enemies.get(i).hasAttackBlockedBy(king.getRow(), king.getColumn(), otherFriends.get(j).getRow(), otherFriends.get(j).getColumn());
						if (!check) 	System.out.println("***DEBUG " + otherFriends.get(j).toString() + " blocks the attack!");
					}
					System.out.println("***DEBUG Now checking enemies");
					//Checking if there are other enemies between
					for (int j = 0; j < enemies.size() && check; ++j) {
						if (j != i) {
							check = !enemies.get(i).hasAttackBlockedBy(king.getRow(), king.getColumn(), enemies.get(j).getRow(), enemies.get(j).getColumn());
							if (!check) 	System.out.println("***DEBUG " + enemies.get(j).toString() + " blocks the attack!");
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
	//Numero de fichas vivas en una celda, 0 = vacia, 1 = normal, > 1 = FALLO!
	public int cellOccupants(int row, int column) {
		int counter = 0;
		for (int i = 0; i < whitePieceList.size(); ++i) {
			if(whitePieceList.get(i).isAt(row,column) && whitePieceList.get(i).isAlive()) {
				++counter;
			}
		}
		for (int i = 0; i < blackPieceList.size(); ++i) {
			if (blackPieceList.get(i).isAt(row,column) && blackPieceList.get(i).isAlive()) {
				++counter;
			}
		}
		System.out.println("***DEBUG Pieces at " + row + ","+column + " = "+ counter);
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