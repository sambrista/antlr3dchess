package chess;
import java.util.*;
import java.io.*;

/** Clase Board
* es la clase donde se definen los elementos referidos al tablero
* @author Alfonso Jimnez Vilchez y Francisco Rincón Liévana
*/
public class Board {
	private ArrayList<Piece> blackPieceList;
	private ArrayList<Piece> whitePieceList;
	private static ArrayList<String> letters;
	private Random generator = new Random();
	 /** 
     * Cronstuctor de la clase crea el trablero
     */
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
	/** 
     * Constructor de la clase parametrizado
     * @param b se le pasa un tablero creado
     * @return nada
     */
	public Board(Board b) {
		whitePieceList = new ArrayList<Piece>();
		blackPieceList = new ArrayList<Piece>();
		for (int i = 0; i < b.getWhitePieces().size(); ++i) {
			Piece p = b.getWhitePieces().get(i);
			switch(p.getKind()) {
			case PAWN:
				Pawn v = new Pawn(p.getColor(), p.getRow(), p.getColumn());
				v.setMoved(p.hasMoved());
				if (!b.getWhitePieces().get(i).isAlive()) {
					v.kill();
				}
				whitePieceList.add(v);
				break;
			case BISHOP:
				Bishop q = new Bishop(p.getColor(), p.getRow(), p.getColumn());
				q.setMoved(p.hasMoved());
				if (!b.getWhitePieces().get(i).isAlive()) {
					q.kill();
				}
				whitePieceList.add(q);
				break;
			case ROOK:
					Rook r = new Rook(p.getColor(), p.getRow(), p.getColumn());
					r.setMoved(p.hasMoved());
					if (!b.getWhitePieces().get(i).isAlive()) {
						r.kill();
					}
					whitePieceList.add(r);
					break;
				case KNIGHT:
					Knight s = new Knight(p.getColor(), p.getRow(), p.getColumn());
					s.setMoved(p.hasMoved());
					if (!b.getWhitePieces().get(i).isAlive()) {
						s.kill();
					}
					whitePieceList.add(s);
					break;
				case QUEEN:
					Queen t = new Queen(p.getColor(), p.getRow(), p.getColumn());
					t.setMoved(p.hasMoved());
					if (!b.getWhitePieces().get(i).isAlive()) {
						t.kill();
					}
					whitePieceList.add(t);
					break;
				case KING:
					King u = new King(p.getColor(), p.getRow(), p.getColumn());
					u.setMoved(p.hasMoved());
					if (!b.getWhitePieces().get(i).isAlive()) {
						u.kill();
					}
					whitePieceList.add(u);
					break;
				}
		}
		for (int i = 0; i < b.getBlackPieces().size(); ++i) {
			Piece p = b.getBlackPieces().get(i);
				switch(p.getKind()) {
				case PAWN:
					Pawn v = new Pawn(p.getColor(), p.getRow(), p.getColumn());
					if (!b.getBlackPieces().get(i).isAlive()) {
						v.kill();
					}
					v.setMoved(p.hasMoved());
					blackPieceList.add(v);
					break;
				case BISHOP:
					Bishop q = new Bishop(p.getColor(), p.getRow(), p.getColumn());
					q.setMoved(p.hasMoved());
					if (!b.getBlackPieces().get(i).isAlive()) {
						q.kill();
					}
					blackPieceList.add(q);
					break;
				case ROOK:
					Rook r = new Rook(p.getColor(), p.getRow(), p.getColumn());
					r.setMoved(p.hasMoved());
					if (!b.getBlackPieces().get(i).isAlive()) {
						r.kill();
					}
					blackPieceList.add(r);
					break;
				case KNIGHT:
					Knight s = new Knight(p.getColor(), p.getRow(), p.getColumn());
					s.setMoved(p.hasMoved());
					if (!b.getBlackPieces().get(i).isAlive()) {
						s.kill();
					}
					blackPieceList.add(s);
					break;
				case QUEEN:
					Queen t = new Queen(p.getColor(), p.getRow(), p.getColumn());
					t.setMoved(p.hasMoved());
					if (!b.getBlackPieces().get(i).isAlive()) {
						t.kill();
					}
					blackPieceList.add(t);
					break;
				case KING:
					King u = new King(p.getColor(), p.getRow(), p.getColumn());
					u.setMoved(p.hasMoved());
					if (!b.getBlackPieces().get(i).isAlive()) {
						u.kill();
					}
					blackPieceList.add(u);
					break;
				}
			}
	}
	/** 
     * Devuelve el vector con las piezas negras
     * @return Vector blackPieceList
     */
	public ArrayList<Piece> getBlackPieces() {
		return blackPieceList;
	}
	/** 
     * Devuelve el vector con las piezas blancas
     * @return Vector whitePieceList
     */
	public ArrayList<Piece> getWhitePieces() {
		return whitePieceList;
	}
	/** 
     * Comprueba si una celda del tablero es valida de 8x8
     * @param r numero de fila
     * @param c numero de columna
     * @return true si se puede false en caso de que no se pueda
     */
	public boolean validCell(int r, int c) {
		if (r >= 0 && r < 8 && c >= 0 && c < 8  ) {
			return true;
		} else {
			return false;
		}
	}
	/** 
     * Pasa el numero que se le pase, al numero de letra que le corresponde
     * @param n numero que se quiere saber la letra
     * @return devuelve la letra del vector letters
     */
	public static String numberToLetter(int n) {
		return letters.get(n);
	}
	/** 
     * Convierte la letra que se le pase en un numero
     * @param l es un string 
     * @return devuelve el numero que corresponde a la letra
     */
	public static int letterToNumber(String l) {
		return letters.indexOf(l);
	}
	/** 
     * Promocion de un peon, ve en que se va a promocionar
     * @param p es la pieza peon que va a promocionar
     */
	public void promotePawn(Piece p) {
		ArrayList<Piece> list = (p.getColor() == Piece.Color.WHITE ? whitePieceList : blackPieceList);
		switch(generator.nextInt(4)) {
		case 0:
			Rook r = new Rook(p.getColor(), p.getRow(), p.getColumn());
			r.setMoved(true);
			r.setInitial(false);
			list.add((Piece) r);
			break;
		case 1:
			Knight k = new Knight(p.getColor(), p.getRow(), p.getColumn());
			k.setMoved(true);
			k.setInitial(false);
			list.add((Piece) k);
			break;
		case 2:
			Bishop b = new Bishop(p.getColor(), p.getRow(), p.getColumn());
			b.setMoved(true);
			b.setInitial(false);
			list.add((Piece) b);
			break;
		case 3:
			Queen q = new Queen(p.getColor(), p.getRow(), p.getColumn());
			q.setMoved(true);
			q.setInitial(false);
			list.add((Piece) q);
			break;
		}
		p.kill();
	}
	/** 
     * Añade una pieza al tablero
     * @param kind es el tipo de la pieza
     * @param color es color de la pieza
     * @param row es la fila donde se añadira
     * @param column es la columna donde se añadira
     * @return devuelve true si se a podido añadir false en caso contrario
     */
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
				p.setMoved(true);
				list.add(p);
				break;
			case BISHOP:
				Bishop q = new Bishop(color, row, column);
				q.setMoved(true);
				list.add(q);
				break;
			case ROOK:
				Rook r = new Rook(color, row, column);
				r.setMoved(true);
				list.add(r);
				break;
			case KNIGHT:
				Knight s = new Knight(color, row, column);
				s.setMoved(true);
				list.add(s);
				break;
			case QUEEN:
				Queen t = new Queen(color, row, column);
				t.setMoved(true);
				list.add(t);
				break;
			case KING:
				King u = new King(color, row, column);
				u.setMoved(true);
				list.add(u);
				break;
			}
			return true;
		} else {
			return false;
		}
	}
	/** 
     * Genera un tablero aleatorio
     * @param piecesno es el numero de piezas
     * @param proportion es la proporcion de unas sobre las otras
     * @param disposal si es original o aleatorio
     */
	public void random(Integer piecesno, double proportion, String disposal) {
		//Pieces generation
		Piece q;
		int row;
		int col;
		whitePieceList = new ArrayList<Piece>();
		blackPieceList = new ArrayList<Piece>();
		//Kings
		if (disposal.equals("original")) {
			q = new King(Piece.Color.WHITE, 0,4);
			whitePieceList.add(q);
			q = new King(Piece.Color.BLACK, 7,4);
			blackPieceList.add(q);
		} else {
			q = new King(Piece.Color.WHITE, generator.nextInt(8), generator.nextInt(8));
			q.setMoved(true);
			whitePieceList.add(q);
			do {
				row = generator.nextInt(8);
				col = generator.nextInt(8);
			} while (q.isAt(row, col));
			q = new King(Piece.Color.BLACK, row ,col);
			q.setMoved(true);
			blackPieceList.add(q);
		}
//		Available pieces
		

		if (disposal.equals("original")) {
			ArrayList<Piece> availableWPieces = new ArrayList<Piece>();
			ArrayList<Piece> availableBPieces = new ArrayList<Piece>();
			//White Queen
			availableWPieces.add((Piece) new Queen(Piece.Color.WHITE,0,3));
			//Black Queen
			availableBPieces.add((Piece) new Queen(Piece.Color.BLACK,7,3));
			//White Bishops
			availableWPieces.add((Piece) new Bishop(Piece.Color.WHITE,0,2));
			availableWPieces.add((Piece) new Bishop(Piece.Color.WHITE,0,5));
			//Black Bishops
			availableBPieces.add((Piece) new Bishop(Piece.Color.BLACK,7,2));
			availableBPieces.add((Piece) new Bishop(Piece.Color.BLACK,7,5));
			//White Knights
			availableWPieces.add((Piece) new Knight(Piece.Color.WHITE,0,1));
			availableWPieces.add((Piece) new Knight(Piece.Color.WHITE,0,6));
			//Black Knights
			availableBPieces.add((Piece) new Knight(Piece.Color.BLACK,7,1));
			availableBPieces.add((Piece) new Knight(Piece.Color.BLACK,7,6));
			//White Rooks
			availableWPieces.add((Piece) new Rook(Piece.Color.WHITE,0,0));
			availableWPieces.add((Piece) new Rook(Piece.Color.WHITE,0,7));
			//Black Rooks
			availableBPieces.add((Piece) new Rook(Piece.Color.BLACK,7,0));
			availableBPieces.add((Piece) new Rook(Piece.Color.BLACK,7,7));
			//Pawns
			for (int i = 0; i<8 ; ++i) {
				availableWPieces.add((Piece) new Pawn(Piece.Color.WHITE,1,i));
				availableBPieces.add((Piece) new Pawn(Piece.Color.BLACK,6,i));
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
			Piece.Kind k;
			for (int i = 0; i < piecesno  - 1; ++i) {
				k = (Piece.Kind) availablePieces.remove(generator.nextInt(availablePieces.size()));
				while(!this.addPiece(k, Piece.Color.WHITE, generator.nextInt(8), generator.nextInt(8)));
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
			for (int i = 0; i < Math.round(piecesno * proportion) - 1; ++i) {
				k = (Piece.Kind) availablePieces.remove(generator.nextInt(availablePieces.size()));
				while(!this.addPiece(k, Piece.Color.BLACK, generator.nextInt(8), generator.nextInt(8)));
			}
		}
	}
	/** 
     * Imprime la situacion de la partida
     */
	public void printSituation() {
		for (int i = 0; i < whitePieceList.size(); ++i) {
			System.out.println(whitePieceList.get(i).toString());
		}
		for (int i = 0; i < blackPieceList.size(); ++i) {
			System.out.println(blackPieceList.get(i).toString());
		}
	}
	/** 
     * Genera el fichero para que se vea en el repdroductor
     * @param path es la ruta donde se ubicara el fichero
     * @param filename es el nombre del fichero
     */
	public void generate3D(String path, String filename ) throws IOException{
		
		
		
		FileReader filein = null;
		FileWriter fileout=null;
		PrintWriter pw=null;
		
		Piece k = null;
		
		
		try {
			filein = new FileReader("./3D/base.wrl");

			BufferedReader bf = new BufferedReader(filein); 
			String sCadena;
			
			fileout=new FileWriter(path+filename);
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
		


	}
	
	/** 
     * Comprobar si se puede mover una pieza de donde esta a donde quiere
     * @param originRow es la fila de origen
     * @param originColumn es la columna origen
     * @param targetRow es la fila destino
     * @param targetColumn es la columna destino
     * @return devuelve true si se puede mover o false en caso contrario
     */
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
						}
					}
				} else {
					for (int i = 0; i < whitePieceList.size() && k == null; ++i) {
						if (whitePieceList.get(i).getKind() == Piece.Kind.KING) {
							k = whitePieceList.get(i);
							kingIndex = i;
						}
					}
				}
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
			p.setAsInitialCell();
			if (moveKing) {
				if (p.getColor() == Piece.Color.WHITE) {
					blackPieceList.get(kingIndex).setPosition(kingNewRow, kingNewColumn);
					blackPieceList.get(kingIndex).setAsInitialCell();
				} else {
					whitePieceList.get(kingIndex).setPosition(kingNewRow, kingNewColumn);
					whitePieceList.get(kingIndex).setAsInitialCell();
				}
			}
			return true;
		} else {
			return false;
		}
	}
	/** 
     * Eliminar una pieza del tablero
     * @param kind es el tipo de pieza a eliminar
     * @param color es el color de la pieza
     * @return devuelve true si se puede eliminar o false en caso contrario
     */
	public boolean removePiece(Piece.Kind kind, Piece.Color color) {
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		Piece p = null;
		if (color == Piece.Color.WHITE) {
			for (int i = 0; i < whitePieceList.size() && p == null; ++i) {
				if (whitePieceList.get(i).getKind() == kind) {
					pieces.add(whitePieceList.get(i));
				}
			}
		} else {
			for (int i = 0; i < blackPieceList.size() && p == null; ++i) {
				if (blackPieceList.get(i).getKind() == kind) {
					pieces.add(blackPieceList.get(i));
				}
			}
		}
		if (!pieces.isEmpty()) {
			p = pieces.remove(generator.nextInt(pieces.size()));
			return (removePiece(p.getRow(), p.getColumn()));
		} else {
			return false;
		}
	}
	/** 
     * Mover aleatoriamente una pieza
     * @param color es el color de la pieza a mover
     * @param movList es el vector de movimientos
     * @param register si se ha movido o no
     * @return devuelve el vector de movimientos
     */
	public boolean moveRandom(Piece.Color color, ArrayList<String> movList, boolean register) {
		ArrayList<Piece> availablePieces = new ArrayList<Piece>();
		if (color == Piece.Color.WHITE) {
			for(int i = 0; i < whitePieceList.size(); ++i) {
				if (whitePieceList.get(i).isAlive()) {
					availablePieces.add(whitePieceList.get(i));
				}
			}
		} else {
			for(int i = 0; i < blackPieceList.size(); ++i) {
				if (blackPieceList.get(i).isAlive()) {
					availablePieces.add(blackPieceList.get(i));
				}
			}
		}
		boolean moved = false;
		while (!availablePieces.isEmpty() && !moved) {
			Piece p = availablePieces.remove(generator.nextInt(availablePieces.size()));
			ArrayList<int[]> possibleMovements = p.getTeoricalMovements();
			while(!possibleMovements.isEmpty() && !moved) {
				int pos[] = possibleMovements.remove(generator.nextInt(possibleMovements.size()));
				if (move(p.getRow(), p.getColumn(), pos[0], pos[1], movList, register)) {
					moved = true;
				}
			}
		}
		return (moved);
	}
	
	/** 
     * Devuelve la pieza segun dada una columna y fila
     * @param row es la fila 
     * @param column es la columna
     * @return devuelve la pieza
     */
	public Piece getPieceAt(int row, int column) {
		Piece p = null;
		for (int i = 0; i < whitePieceList.size() && p == null; ++i) {
			if (whitePieceList.get(i).isAt(row,column) && whitePieceList.get(i).isAlive()) {
				p = whitePieceList.get(i);
			}
		}
		for (int i = 0; i < blackPieceList.size() && p == null; ++i) {
			if (blackPieceList.get(i).isAt(row,column) && blackPieceList.get(i).isAlive()) {
				p = blackPieceList.get(i);
			}
		}
		return p;
	}
	/** 
     * Realiza los movientos 
     * @param originRow es la fila de origen
     * @param originColumn es la columna origen
     * @param targetRow es la fila destino
     * @param targetColumn es la columna destino
     * @param movList vector donde se almacenan los movimientos
     * @param registrer registra si se ha validado el movimiento
     * @return devuelve true si se puede mover o false en caso contrario
     */
	public boolean move(int originRow, int originColumn, int targetRow, int targetColumn, ArrayList<String> movList, boolean register) {
		Piece p = null;
		int index = -1;
		for (int i = 0; i < whitePieceList.size() && p == null; ++i) {
			if (whitePieceList.get(i).isAt(originRow,originColumn) && whitePieceList.get(i).isAlive()) {
				p = whitePieceList.get(i);
				index = i;
			}
		}
		for (int i = 0; i < blackPieceList.size() && p == null; ++i) {
			if (blackPieceList.get(i).isAt(originRow,originColumn) && blackPieceList.get(i).isAlive()) {
				p = blackPieceList.get(i);
				index = i;
			}
		}
		if (p == null) {	
			return (false);
		}
		
		Piece p2 = null;
		int index2 = -1;
		for (int i = 0; i < whitePieceList.size() && p2 == null; ++i) {
			if (whitePieceList.get(i).isAt(targetRow,targetColumn) && whitePieceList.get(i).isAlive()) {
				p2 = whitePieceList.get(i);
				index2 = i;
			}
		}
		for (int i = 0; i < blackPieceList.size() && p2 == null; ++i) {
			if (blackPieceList.get(i).isAt(targetRow,targetColumn) && blackPieceList.get(i).isAlive()) {
				p2 = blackPieceList.get(i);
				index2 = i;
			}
		}
		if (p2 != null && p2.getColor() == p.getColor()) {
			//TODO considerar enroque
			return (false);
		}
		
		//Comprobar si puede mover y si no hay nadie en medio
		
		if ((p2 != null ?
				p.canAttack(targetRow, targetColumn)
				:
				p.canMoveTo(targetRow, targetColumn)
			) == false) {
			return(false);
		}
		
		boolean blocked = false;
		//Checking if there are friends between
		ArrayList<Piece> friends = (p.getColor() == Piece.Color.WHITE ? whitePieceList : blackPieceList);
		for (int j = 0; j < friends.size() && !blocked; ++j) {
			if (j != index && friends.get(j).isAlive()) {
				blocked = (p2 != null ?
						p.hasAttackBlockedBy(targetRow, targetColumn, friends.get(j).getRow(), friends.get(j).getColumn())
					:
						p.isBlockedBy(targetRow, targetColumn, friends.get(j).getRow(), friends.get(j).getColumn())
				);
			}
			
		}
		//Checking if there are other enemies between
		friends = (p.getColor() == Piece.Color.WHITE ? blackPieceList : whitePieceList);
		for (int j = 0; j < friends.size() && !blocked; ++j) {
			if (j != index2  && friends.get(j).isAlive()) {
				blocked = (p2 != null ?
						p.hasAttackBlockedBy(targetRow, targetColumn, friends.get(j).getRow(), friends.get(j).getColumn())
					:
						p.isBlockedBy(targetRow, targetColumn, friends.get(j).getRow(), friends.get(j).getColumn())
				);
			}
			
		}
		if (blocked) {
			return false;
		}
		
		
		Board b = new Board(this);
		if (p.getColor() == Piece.Color.WHITE) {
			b.getWhitePieces().remove(index);
		} else {
			b.getBlackPieces().remove(index);
		}
		if (p2 != null) {
			if (p2.getColor() == Piece.Color.WHITE) {
				b.getWhitePieces().remove(index2);
			} else {
				b.getBlackPieces().remove(index2);
			}
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
		if (p.getColor() == Piece.Color.WHITE ? b.isWhiteCheck() : b.isBlackCheck()) {
			return false;
		}
		//Adelante!
		//Cambiar posicion de pieza
		p.move(targetRow, targetColumn);
		//Generar evento
		if (register) {
			movList.add("MOV-"+ p.get3DId() + "-"+originRow + "-"+originColumn + "-"+ targetRow + "-" + targetColumn);
		}
		//Matar pieza oponente si hay
		if (p2 != null) {
			if (register) {
				movList.add("KILL-"+ p2.get3DId() + "-"+targetRow + "-"+targetColumn);
			}
			p2.kill();
		}
		//Si es peon
		if (p.getKind() == Piece.Kind.PAWN && p.canPromote()) {
			String result = "";
			if (register) {
				result += "PPW-"+ p.get3DId() + "-";
			}
			promotePawn(p);
//			Generar evento
			if (register) {
				ArrayList<Piece> list2 = (p.getColor() != Piece.Color.WHITE ? blackPieceList : whitePieceList);
				movList.add(result + list2.get(list2.size()-1).get3DId() +"-"+ targetRow + "-" + targetColumn);
			}
		}
		if (register) {
			//Comprobar si hay jaque
			if (p.getColor() == Piece.Color.WHITE? isBlackCheck() : isWhiteCheck()) {
				boolean found = false;
				ArrayList<Piece> list3 = (p.getColor() == Piece.Color.WHITE ? blackPieceList : whitePieceList);
				for (int i = 0; i < list3.size() && !found; ++i) {
					if (list3.get(i).getKind() == Piece.Kind.KING) {
						movList.add(((p.getColor() == Piece.Color.WHITE? isBlackCheckMate() : isWhiteCheckMate()) ? "MATE-" : "CHK-")+ list3.get(i).get3DId() + "-"+list3.get(i).getRow() + "-"+list3.get(i).getColumn());
						found = true;
					}
				}
			} else if (p.getColor() == Piece.Color.WHITE? isBlackStale() : isWhiteStale()) {
				boolean found = false;
				ArrayList<Piece> list3 = (p.getColor() == Piece.Color.WHITE ? blackPieceList : whitePieceList);
				for (int i = 0; i < list3.size() && !found; ++i) {
					if (list3.get(i).getKind() == Piece.Kind.KING) {
						movList.add("STL-"+ list3.get(i).get3DId() + "-"+list3.get(i).getRow() + "-"+list3.get(i).getColumn());
						found = true;
					}
				}
			}
		}
		return (true);
	}
	/** 
     * Elimina una pieza segun la fila y la columna dadas 
     * @param row es la fila de origen
     * @param column es la columna origen
     * @return devuelve true si se puede mover o false en caso contrario
     */
	public boolean removePiece(int row, int column) {
		Piece p = null;
		int index = -1;
		for (int i = 0; i < whitePieceList.size() && p == null; ++i) {
			if (whitePieceList.get(i).isAt(row,column)) {
				p = whitePieceList.get(i);
				index = i;
			}
		}
		for (int i = 0; i < blackPieceList.size() && p == null; ++i) {
			if (blackPieceList.get(i).isAt(row,column)) {
				p = blackPieceList.get(i);
				index = i;
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
				if (b.isBlackCheck()) {
					for (int i = 0; i < blackPieceList.size() && k == null; ++i) {
						if (blackPieceList.get(i).getKind() == Piece.Kind.KING) {
							k = blackPieceList.get(i);
							kingIndex = i;
						}
					}
				} else {
					for (int i = 0; i < whitePieceList.size() && k == null; ++i) {
						if (whitePieceList.get(i).getKind() == Piece.Kind.KING) {
							k = whitePieceList.get(i);
							kingIndex = i;
						}
					}
				}
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
	/** 
     * Realiza los movientos 
     * @param color es el color de la pieza que se comprueba si es jauque mate
     * @return devuelve true si es jaque mate o false si no lo es
     */
	public boolean isColorCheckMate(Piece.Color color) {
		Board copyb = new Board(this);
		return((color == Piece.Color.WHITE ? isWhiteCheck() && !copyb.moveRandom(color, null,false) : isBlackCheck() && !copyb.moveRandom(color, null,false)));
	}
	//all revisar comentario
	/** 
     * Realiza los movientos 
     * @param color es el color de la pieza que se comprueba si es jauque mate
     * @return devuelve el color que es jaque mate
     */
	public boolean isColorStale(Piece.Color color) {
		Board copyb = new Board(this);
		return(!isColorCheck(color) && !copyb.moveRandom(color, null, false)); 
	}
	/** 
     * Comprueba si es jaque mate del color blanco
     * @return true si es asi o false en caso contrario
     */
	public boolean isWhiteCheckMate() {
		return isColorCheckMate(Piece.Color.WHITE);
	}
	/** 
     * Comprueba si es jaque mate del color negro
     * @return true si es asi o false en caso contrario
     */
	public boolean isBlackCheckMate() {
		return isColorCheckMate(Piece.Color.BLACK);
	}
	/** 
     * Comprueba si es ahogamiento del color blanco
     * @return true si es asi o false en caso contrario
     */
	public boolean isWhiteStale() {
		return isColorStale(Piece.Color.WHITE);
	}
	/** 
     * Comprueba si es ahogamiento del color negro
     * @return true si es asi o false en caso contrario
     */
	public boolean isBlackStale() {
		return isColorStale(Piece.Color.BLACK);
	}
	/** 
     * Comprueba si hay jaque 
     * @param color es el color de la pieza que se comprueba si es jauque
     * @return devuelve true si es jaque y false si no
     */
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
					check = true;
					//Checking if there are friends between
					for (int j = 0; j < otherFriends.size() && check; ++j) {
						if (otherFriends.get(j).isAlive()) {
							check = !enemies.get(i).hasAttackBlockedBy(king.getRow(), king.getColumn(), otherFriends.get(j).getRow(), otherFriends.get(j).getColumn());
							}
						}
					//Checking if there are other enemies between
					for (int j = 0; j < enemies.size() && check; ++j) {
						if (j != i) {
							if (enemies.get(j).isAlive()){
								check = !enemies.get(i).hasAttackBlockedBy(king.getRow(), king.getColumn(), enemies.get(j).getRow(), enemies.get(j).getColumn());
							}	
						}
					}
				}
			} 
		}
		return check;
	}
	/** 
     * Devuelve si el rey blanco esta en jaque 
     * @return devuelve true si es jaque o false en caso contrario
     */
	public boolean isWhiteCheck() {
		return isColorCheck(Piece.Color.WHITE);
	}
	/** 
     * Devuelve si el rey negro esta en jaque 
     * @return devuelve true si es jaque o false en caso contrario
     */
	public boolean isBlackCheck() {
		return isColorCheck(Piece.Color.BLACK);
	}
	/** 
     * Numero de fichas vivas en una celda, 0 = vacia, 1 = normal, > 1 = FALLO!
     * @param row es la fila
     * @param column es la columna 
     * @return devuelve el valor entero 
     */
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
		return (counter);
	}
	 /** 
     * Devuelve si el tablero generado cumple con las normas
     * @return devuelve true si es valido, false en caso contrario 
     */
	public boolean isValid() {
		boolean valid = true;
		//No jaques
		valid = !isWhiteCheck() && ! isBlackCheck();
		//Casillas ocupadas por una sola pieza
		for (int i = 0; i < whitePieceList.size() && valid; ++i) {
			valid = cellOccupants(whitePieceList.get(i).getRow(), whitePieceList.get(i).getColumn()) < 2;
		}
		for (int i = 0; i < blackPieceList.size() && valid; ++i) {
			valid = cellOccupants(blackPieceList.get(i).getRow(), blackPieceList.get(i).getColumn()) < 2;
		}
		//No √°lfiles en casillas de mismo color
		for (int i = 0, black_bishop = 0, white_bishop = 0; i < whitePieceList.size() && valid; ++i) {
			if (whitePieceList.get(i).getKind() == Piece.Kind.BISHOP) {
				if ((whitePieceList.get(i).getRow() + whitePieceList.get(i).getColumn()) % 2 == 0) {
					++black_bishop;
				} else {
					++white_bishop;
				}
				valid = !(black_bishop > 1 || white_bishop > 1);
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
			}
		}
		//No m√°s de 1 rey
		for (int i = 0, kings = 0; i < whitePieceList.size() && valid; ++i) {
			if (whitePieceList.get(i).getKind() == Piece.Kind.KING) {
				++kings;
				valid = !(kings > 1);
			}
		}
		for (int i = 0, kings = 0; i < blackPieceList.size() && valid; ++i) {
			if (blackPieceList.get(i).getKind() == Piece.Kind.KING) {
				++kings;
				valid = !(kings > 1);
			}
		}
		//No peones en √∫ltima fila
		for (int i = 0; i < whitePieceList.size() && valid; ++i) {
			if (whitePieceList.get(i).getKind() == Piece.Kind.PAWN) {
				valid = !(whitePieceList.get(i).getRow() == 7);
			}
		}
		for (int i = 0; i < blackPieceList.size() && valid; ++i) {
			if (blackPieceList.get(i).getKind() == Piece.Kind.PAWN) {
				valid = !(blackPieceList.get(i).getRow() == 0);
			}
		}
		return valid;
	}
}
