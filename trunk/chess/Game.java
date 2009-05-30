package chess;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/** Clase Game
* es la clase donde se definen los elementos referidos a los elementos de la partida
* @author Alfonso Jimnez Vilchez y Francisco Rincón Liévana
*/
public class Game {
	private static Board board;
	private static ArrayList<String> events;
	private static int turn = 1;
	/** 
     * Constructor de la clase 
     */
	public Game() {
		board = new Board();
		events = new ArrayList<String>();
	}
	/** 
     * Ve el turno si son de blancas o negras
     * @return devuelve blanco o negro 
     */
	public Piece.Color turn() {
		if (turn % 2 == 0) {
			return Piece.Color.BLACK;
		} else {
			return Piece.Color.WHITE;
		}
	}
	//Funciones que se usaran en ANTLR
	/** 
     * Genera un tablero aleatorio
     * @param piecesno es el numero de piezas
     * @param proportion es la proporcion de unas sobre las otras
     * @param disposal si es original o aleatorio
     */
	public void random(Integer piecesno, double proportion, String disposal) {
		board.random(piecesno, proportion, disposal);
	}
	/** 
     * Añade una pieza al tablero
     * @param knd es el tipo de la pieza
     * @param clr es color de la pieza
     * @param rw es la fila donde se añadira
     * @param clmn es la columna donde se añadira
     * @return devuelve true si se a podido añadir false en caso contrario
     */
	public boolean addPiece (String knd, String clr, String clmn, int rw) {
		Piece.Kind kind = Piece.stringToKind(knd);
		Piece.Color color = Piece.stringToColor(clr);
		int column = Board.letterToNumber(clmn);
		--rw;
		if (kind != null && color != null && board.validCell(rw, column)) {
			return board.addPiece(kind, color, rw, column);
		} else {
			return false;
		}
	}
	/** 
     * Comprobar si se puede mover una pieza de donde esta a donde quiere
     * @param Clmn1 es la letra origen
     * @param rw1 es la fila origen
     * @param clmn2 es la letra destino
     * @param rw2 es la fila destino
     * @return devuelve true si se puede mover o false en caso contrario
     */
	public boolean setupPiece (String clmn1, int rw1, String clmn2, int rw2) {
		int column1 = Board.letterToNumber(clmn1);
		int column2 = Board.letterToNumber(clmn2);
		--rw2;
		--rw1;
		if (board.validCell(rw1, column1) && board.validCell(rw2, column2)) {
			return board.setupPiece(rw1, column1, rw2, column2);
		} else {
			return false;
		}
	}
	/** 
     * Eliminar una pieza del tablero segun fila y columna
     * @param clmn es la letra de la columna
     * @param rw es la fila 
     * @return devuelve true si se puede eliminar o false en caso contrario
     */
	public boolean removePiece (String clmn, int rw) {
		int column = Board.letterToNumber(clmn);
		--rw;
		if (board.validCell(rw, column)) {
			return board.removePiece(rw, column);
		} else {
			return false;
		}
	}
	/** 
     * Eliminar una pieza del tablero por color y tipo
     * @param knd es el tipo de pieza a eliminar
     * @param clr es el color de la pieza
     * @return devuelve true si se puede eliminar o false en caso contrario
     */
	public boolean removePiece (String knd, String clr) {
		Piece.Kind kind = Piece.stringToKind(knd);
		Piece.Color color = Piece.stringToColor(clr);
		if (kind != null && color != null) {
			return board.removePiece(kind, color);
		} else {
			return false;
		}
	}
	/** 
     * Genera el fichero para que se vea en el repdroductor
     * @param path es la ruta donde se ubicara el fichero
     * @return devuleve false si no se ha podido crear el fichero
     */
	public boolean generate3D (String path) throws IOException {
		board.generate3D(path,"ajedrez.wrl");
		return false;
	}
	
	// Fin de Board Zone
	
	
	// Game Zone
	/** 
     * Mueve la pieza segun el color
     * @param clmn1 es la letra origen
     * @param rw1 la fila origen
     * @param clmn2 es la letra destino
     * @param rw2 es la fila destino
     * @param clr es el color de la pieza a mover
     * @return devuelve true si se puede hacer
     */
	public boolean movePlayerColor (String clmn1, int rw1, String clmn2, int rw2, Piece.Color clr) {
		int column1 = Board.letterToNumber(clmn1);
		int column2 = Board.letterToNumber(clmn2);
		--rw1;
		--rw2;
		if (board.validCell(rw1, column1) && board.validCell(rw2, column2) && turn() == clr && board.getPieceAt(rw1, column1).getColor() == clr) {
			if (board.move(rw1,column1,rw2,column2, events, true)) {
				if (clr == Piece.Color.WHITE ? board.isBlackCheck() : board.isWhiteCheck()) {
					//TODO REVISAR LO DE GENERAR 3D del JAQUE
				}
				++turn;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	/** 
     * Mueve la pieza segun el color blanco
     * @param clmn1 es la letra origen
     * @param rw1 la fila origen
     * @param clmn2 es la letra destino
     * @param rw2 es la fila destino
     * @return devuelve true si se puede hacer
     */
	public boolean movePlayerW (String clmn1, int rw1, String clmn2, int rw2) {
		return(movePlayerColor (clmn1, rw1, clmn2, rw2, Piece.Color.WHITE));
	}
	/** 
     * Mueve la pieza segun el color negro
     * @param clmn1 es la letra origen
     * @param rw1 la fila origen
     * @param clmn2 es la letra destino
     * @param rw2 es la fila destino
     * @return devuelve true si se puede hacer
     */
	public boolean movePlayerB (String clmn1, int rw1, String clmn2, int rw2) {
		return(movePlayerColor (clmn1, rw1, clmn2, rw2, Piece.Color.BLACK));
	}
	/** 
     * Mueve la pieza segun el color aleatoriamente
     * @param clr es color de la pieza a mover aleatoriamente
     * @return devuelve true si se puede hacer
     */
	public boolean moveRandomlyColor (Piece.Color clr) {
		if (turn() == clr) {
			if (board.moveRandom(clr, events, true)) {
				if (clr == Piece.Color.WHITE ? board.isBlackCheck() || board.isWhiteStale() : board.isWhiteCheck() || board.isBlackStale()) {
					//TODO REVISAR LO DE GENERAR 3D del JAQUE
				}
				++turn;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	/** 
     * Mueve la pieza aleatoriamente segun el color blanco
     * @return devuelve true si se puede hacer
     */
	public boolean moveRandomlyW () {
		return(moveRandomlyColor (Piece.Color.WHITE));
	}
	/** 
     * Mueve la pieza aleatoriamente segun el color negro
     * @return devuelve true si se puede hacer
     */
	public boolean moveRandomlyB () {
		return(moveRandomlyColor (Piece.Color.BLACK));
	}
	/** 
     * Guarda en un fichero el estado de la partida
     * @param file es el nombre del fichero
     */
	public void state(String file) {
		
		FileWriter fileout = null;
		PrintWriter pw = null;
		if (file != null) {
			try {
				fileout = new FileWriter(file,false);
				pw = new PrintWriter(fileout);
				pw.println("");
				pw.println("PIEZAS BLANCAS");
				pw.println("");
				for (int i = 0; i < board.getWhitePieces().size(); ++i) {
					pw.println(((Piece)board.getWhitePieces().get(i)).state());
				}
				pw.println("");
				pw.println("PIEZAS NEGRAS");
				pw.println("");
				for (int i = 0; i < board.getBlackPieces().size(); ++i) {
					pw.println(((Piece)board.getBlackPieces().get(i)).state());		
				}
				pw.println("");
				pw.println("SITUACION ACTUAL");
				pw.println("");
				pw.println("Turno: " + Piece.colorToString(turn()));
				if (board.isWhiteCheck()) {
					if (board.isWhiteCheckMate()) {
						pw.println("Jaque mate a las blancas");
					} else {
						pw.println("Jaque a las blancas");
					}
				} else if (board.isWhiteStale()) {
					pw.println("Blancas ahogadas.");
				}
				if (board.isBlackCheck()) {
					if (board.isBlackCheckMate()) {
						pw.println("Jaque mate a las negras");
					} else {
						pw.println("Jaque a las negras");
					}
				} else if (board.isBlackStale()) {
					pw.println("Negras ahogadas.");
				}
				fileout.close();
			} catch (IOException e) {
				e.printStackTrace();	
			}	
		} else {
			System.out.println("");
			System.out.println("PIEZAS BLANCAS");
			System.out.println("");

			for (int i = 0; i < board.getWhitePieces().size(); ++i) {
				System.out.println(((Piece)board.getWhitePieces().get(i)).state());
			}
			System.out.println("");
			System.out.println("PIEZAS NEGRAS");
			System.out.println("");
			for (int i = 0; i < board.getBlackPieces().size(); ++i) {
				System.out.println(((Piece)board.getBlackPieces().get(i)).state());
			}
			System.out.println("");
			System.out.println("SITUACION ACTUAL");
			System.out.println("");
			System.out.println("Turno: " + Piece.colorToString(turn()));
			if (board.isWhiteCheck()) {
				if (board.isWhiteCheckMate()) {
					System.out.println("Jaque mate a las blancas");
				} else {
					System.out.println("Jaque a las blancas");
				}
			} else if (board.isWhiteStale()) {
				System.out.println("Blancas ahogadas.");
			}
			if (board.isBlackCheck()) {
				if (board.isBlackCheckMate()) {
					System.out.println("Jaque mate a las negras");
				} else {
					System.out.println("Jaque a las negras");
				}
			} else if (board.isBlackStale()) {
				System.out.println("Negras ahogadas.");
			}
		}
	}
	/** 
     * Muestra el estado de los movimientos por consola
     */
	public void movementsList() {
		for (int i = 0; i < events.size(); ++i) {
			String aux[] = events.get(i).split("-");				
			if (aux[0].compareTo("MOV") == 0) {
				System.out.print("\n" + Piece.getPieceLettersFromString(aux[1]) +" (" + Board.numberToLetter(Integer.parseInt(aux[3])) + ","+ (Integer.parseInt(aux[2]) + 1) + ") -> (" + Board.numberToLetter(Integer.parseInt(aux[5])) + ","+ (Integer.parseInt(aux[4]) + 1) + ")");
			} else if (aux[0].compareTo("KILL") == 0) {
				System.out.print(" (Captura " + Piece.getPieceLettersFromString(aux[1]) + ")");
			} else if (aux[0].compareTo("PPW") == 0) {
				System.out.print(" (Promociona a " + Piece.getPieceLettersFromString(aux[2]) + ")");
			} else if (aux[0].compareTo("CHK") == 0) {
				System.out.print(" (Jaque)");				
			} else if (aux[0].compareTo("STL") == 0) {
				System.out.print(" (Ahogamiento)");				
			} else if (aux[0].compareTo("MATE") == 0) {
				System.out.print(" (Jaque Mate)");
			}
		}
		System.out.println("");
	}
	/** 
     * Crea el estado 3D de la partida
     * @param path es la ruta para el fichero
     */
	public void state3D (String path) throws IOException {
		try{
		board.generate3D(path,"ajedrez.wrl");
		generate3Dmoves(path,"ajedrez.wrl");
		} catch (IOException e) {
			e.printStackTrace();	
		}	
		
		
	}
	
	// Fin de Game Zone
	
	
	// Common Zone
	/** 
     * Comprueba si es jaque 
     * @param color de la pieza que esta en jaque
     * @return devuelve true si se puede hacer
     */ 
	public boolean check(String color) {
		return (board.isColorCheck(Piece.stringToColor(color)));
	}
	/** 
     * Comprueba si es jaque mate
     * @param color de la pieza que esta en jaque
     * @return devuelve true si se puede hacer
     */ 
	public boolean checkMate(String color) {
		return (board.isColorCheckMate(Piece.stringToColor(color)));
	}
	/** 
     * Mueve la pieza segun el color
     * @param color el color de la pieza ahogada
     * @return devuelve true si se puede hacer
     */
	public boolean staleMate(String color) {
		return (board.isColorStale(Piece.stringToColor(color)));
	}
	/** 
     * Devuelve el tipo de la pieza segun la fila y la columna
     * @param clmn es la letra de la columna
     * @param rw es la fila 
     * @return devuelve el tipo de la pieza
     */ 
	public String pieceType(String clmn, int rw) {
		String result = "";
		int column = Board.letterToNumber(clmn);
		--rw;
		if (board.validCell(rw, column)) {
	 		Piece p = board.getPieceAt(rw, column);
	 	if (p != null) {
	 		result = Piece.kindToString(p.getKind());
	 	}

		}
		return (result);
	}
	/** 
     * Devuelve el color de la pieza segun la fila y la columna
     * @param clmn es la letra de la columna
     * @param rw es la fila 
     * @return devuelve el color de la pieza
     */ 
	public String pieceColor(String clmn, int rw) {
		String result = "";
		int column = Board.letterToNumber(clmn);
		--rw;
		if (board.validCell(rw, column)) {
	 		Piece p = board.getPieceAt(rw, column);
	 	if (p != null) {
	 		result = Piece.colorToString(p.getColor());
	 	}

		}
		return (result);
	}
	/** 
     * Devuelve los puntos del color que se le indique
     * @param color del equipo para saber sus puntos
     * @return devuelve los puntos
     */ 
	public int points(String color) {
		ArrayList<Piece> list;
		switch (Piece.stringToColor(color)) {
			case WHITE:
				list = board.getWhitePieces();
				break;
			case BLACK:
				list = board.getBlackPieces();
				break;
			default:
				list = null;
				break;
		}
		if (list != null) {
			int counter = 0;
			for (int i = 0; i < list.size(); ++i) {
				if (!list.get(i).isAlive()) {
					counter += list.get(i).getPoints();
				}
			}
			return (counter);
		} else {
			return 0;
		}
	}
	/** 
     * Devuelve la columna origen del ultimo movimiento
     * @param color del equipo que se quiere saber 
     * @return devuelve la columna
     */ 
	public String cOLastMov(String color) {
		String result = "";
		String filter = "";
		switch (Piece.stringToColor(color)) {
		case WHITE:
			filter = "WHITE";
			break;
		case BLACK:
			filter = "BLACK";
			break;
		}
		for (int i = events.size() - 1; i >= 0 && result.compareTo("") == 0; --i) {
			String aux[] = events.get(i).split("-");				
			if (aux[0].compareTo("MOV") == 0) {
				if (aux[1].indexOf(filter) != -1) {
					result = Board.numberToLetter(Integer.parseInt(aux[3]));
				}
			}
		}
		return result;
	}
	/** 
     * Devuelve la fila origen del ultimo movimiento
     * @param color del equipo que se quiere saber 
     * @return devuelve la fila
     */
	public int fOLastMov(String color) {
		int result = -1;
		String filter = "";
		switch (Piece.stringToColor(color)) {
		case WHITE:
			filter = "WHITE";
			break;
		case BLACK:
			filter = "BLACK";
			break;
		}
		for (int i = events.size() - 1; i >= 0 && result == -1; --i) {
			String aux[] = events.get(i).split("-");				
			if (aux[0].compareTo("MOV") == 0) {
				if (aux[1].indexOf(filter) != -1) {
					result = (Integer.parseInt(aux[2]) + 1);
				}
			}
		}
		return result;
	}
	/** 
     * Devuelve la columna destino del ultimo movimiento
     * @param color del equipo que se quiere saber 
     * @return devuelve la columna
     */
	public String cDLastMov(String color) {
		String result = "";
		String filter = "";
		switch (Piece.stringToColor(color)) {
		case WHITE:
			filter = "WHITE";
			break;
		case BLACK:
			filter = "BLACK";
			break;
		}
		for (int i = events.size() - 1; i >= 0 && result.compareTo("") == 0; --i) {
			String aux[] = events.get(i).split("-");				
			if (aux[0].compareTo("MOV") == 0) {
				if (aux[1].indexOf(filter) != -1) {
					result = Board.numberToLetter(Integer.parseInt(aux[5]));
				}
			}
		}
		return result;
	}
	/** 
     * Devuelve la fila destino del ultimo movimiento
     * @param color del equipo que se quiere saber 
     * @return devuelve la fila
     */
	public int fDLastMov(String color) {
		int result = -1;
		String filter = "";
		switch (Piece.stringToColor(color)) {
		case WHITE:
			filter = "WHITE";
			break;
		case BLACK:
			filter = "BLACK";
			break;
		}
		for (int i = events.size() - 1; i >= 0 && result == -1; --i) {
			String aux[] = events.get(i).split("-");				
			if (aux[0].compareTo("MOV") == 0) {
				if (aux[1].indexOf(filter) != -1) {
					result = (Integer.parseInt(aux[4]) + 1);
				}
			}
		}
		return result;
	}
	/** 
     * Devuelve la fila origen del ultimo movimiento
     * @return devuelve el ratio de las blancas y las negras
     */
	double ratioWB() {
		double numWhite = 0;
		double numBlack = 0;
		for (int i = 0; i < board.getWhitePieces().size(); ++i) {
			if (((Piece)board.getWhitePieces().get(i)).isAlive()) {
				++numWhite;
			}
		}
		for (int i = 0; i < board.getBlackPieces().size(); ++i) {
			if (((Piece)board.getBlackPieces().get(i)).isAlive()) {
				++numBlack;
			}
		}
		if (numWhite == 0) {
			return -1;
		} else {
			return (numBlack / numWhite);
		}
	}
	/** 
     * Devuelve el ratio de puntos entre las blancas y las negras
     * @return devuelve el ratio de las blancas y las negras
     */
	double ratioPointsWB() {
		double numWhite = points("blanco");
		double numBlack = points("negro");
		if (numWhite == 0) {
			return -1;
		} else {
			return ((numBlack * 1.0 )/(1.0 * numWhite));
		}
	}
	/** 
     * Devuelve el color de la pieza capturada 
     * @param type de la pieza que se acaba de capturar
     * @return devuelve el color de la pieza
     */
	public String capturedPieceColor(String type) {
		String result = "";
		String filter = "";
		switch (Piece.stringToKind(type)) {
		case KING:
			filter = "KING";
			break;
		case QUEEN:
			filter = "QUEEN";
			break;
		case BISHOP:
			filter = "BISHOP";
			break;
		case KNIGHT:
			filter = "KNIGHT";
			break;
		case ROOK:
			filter = "ROOK";
			break;
		case PAWN:
			filter = "PAWN";
			break;
		}
		for (int i = events.size() - 1; i >= 0 && result.compareTo("") == 0; --i) {
			String aux[] = events.get(i).split("-");				
			if (aux[0].compareTo("MOV") == 0) {
				if (aux[1].indexOf(filter) != -1) {
					if (aux[1].indexOf("WHITE") != -1) {
						result = "blanco";
					} else {
						result = "negro";
					}
				}
			}
		}
		return result;
	}
	/** 
     * Devuelve el tipo de la pieza capturada 
     * @param color del equipo que se acaba de capturar la pieza
     * @return devuelve el tipo de la pieza
     */
	public String capturedPieceType(String color) {
		String result = "";
		String filter = "";
		if (Piece.stringToColor(color) == Piece.Color.WHITE) {
			filter = "WHITE";
		} else {
			filter = "BLACK";
		}
		for (int i = events.size() - 1; i >= 0 && result.compareTo("") == 0; --i) {
			String aux[] = events.get(i).split("-");				
			if (aux[0].compareTo("MOV") == 0) {
				if (aux[1].indexOf(filter) != -1) {
					if (aux[1].indexOf("PAWN") != -1) {
						result = "peon";
					} else if (aux[1].indexOf("ROOK") != -1) {
						result = "torre";
					} else if (aux[1].indexOf("KING") != -1) {
						result = "rey";
					} else if (aux[1].indexOf("QUEEN") != -1) {
						result = "reina";
					} else if (aux[1].indexOf("KNIGHT") != -1) {
						result = "caballo";
					} else if (aux[1].indexOf("BISHOP") != -1) {
						result = "alfil";
					}
				}
			}
		}
		return result;
	}
	/** 
     * Devuelve si se ha podido hacer un enroque
     * @param color del equipo que se enroca
     * @return devuelve true si se ha enrocado 
     */
	public boolean castling (String color) {
		//TODO True si el color especificado ha hecho enroque
		return (false);
	}

	/*
	 * Fin de Common Zone
	 */
	/*
	 * Fin de las funciones que usa ANTLR
	 */
	/** 
     * Funcion que genera los movimientos en 3D de las piezas movidas
     * @param path es la ruta del fichero donde se crea
     * @param filename es el nombre del fichero que se creara
     */
	public static void generate3Dmoves(String path, String filename) {
		FileWriter fileout=null;
		PrintWriter pw=null;
		double actualmove=0.0;
		String moves = "";
		String moves2 = "";
		String movesMate = "";
		String moves2Mate = "";
		String [] aux = null;
		
		ArrayList<Piece> fichas;
		
	
		
		try {
			 
		
			
			fileout=new FileWriter(path+filename,true);
			pw = new PrintWriter(fileout);
			
			
			
			
			pw.println("\nDEF Timer TimeSensor{cycleInterval " + (turn - 1) +" loop FALSE startTime 0.0 stopTime 1 }" + "\n"+ "ROUTE Touch.touchTime TO Timer.set_startTime");

			
			fichas=board.getWhitePieces();
			
			for (int i=0; i<fichas.size();i++){			
				for (int j = 0; j< events.size() ; j++){
					aux = events.get(j).split("-");				
						if (aux[0].compareTo("MOV") == 0  || aux[0].compareTo("KILL") == 0 ){
							if ( aux[0].compareTo("MOV") == 0 )
							actualmove++;
							
							if ( aux[1].compareTo( fichas.get(i).get3DId()) == 0 ){
								
								moves += ((actualmove-1)/(turn-1)) + "," + (actualmove/(turn-1))+ ",";
								moves2 +=  (-21+(6*Integer.parseInt(aux[3]))) +" 0.0 "+ (+21-(6*Integer.parseInt(aux[2])))+","+
								(aux[0].compareTo("MOV") == 0 ? (-21+(6* ((Integer.parseInt(aux[5])))) ) : (- 21 + 6 * (i % 8))) + " 0.0 " + (aux[0].compareTo("MOV") == 0 ? (+21-(6*Integer.parseInt(aux[4]))) : (35 + 6 * (i/8)))+ ",";

								//System.out.print(moves + "+++++++++++ " + moves2);
							}
							
								
						}		
						if (aux[0].compareTo("PPW") == 0){
							if ( aux[1].compareTo( fichas.get(i).get3DId()) == 0 ){
								moves += ((actualmove-1)/(turn-1)) + "," + (actualmove/(turn-1))+ ",";
								moves2 +=  (-21+(6*Integer.parseInt(aux[4]))) +" 0.0 "+ (+21-(6*Integer.parseInt(aux[3])))+","+
								(-21+(6*Integer.parseInt(aux[4]))) +" -6 "+ (+21-(6*Integer.parseInt(aux[3]))) + ",";
							}
							if ( aux[2].compareTo( fichas.get(i).get3DId()) == 0 ){
								moves += ((actualmove-1)/(turn-1)) + "," + ((actualmove-1)/(turn-1)) + "," + ((actualmove-1)/(turn-1)) + "," + (actualmove/(turn-1))+ ",";
								moves2 +=  (-21+(6*Integer.parseInt(aux[4]))) +" -10 "+ (+21-(6*Integer.parseInt(aux[3])))+","+
								(-21+(6*Integer.parseInt(aux[4]))) +" 100 "+ (+21-(6*Integer.parseInt(aux[3]))) + ",";
								moves2 +=  (-21+(6*Integer.parseInt(aux[4]))) +" 100 "+ (+21-(6*Integer.parseInt(aux[3])))+","+
								(-21+(6*Integer.parseInt(aux[4]))) +" 0 "+ (+21-(6*Integer.parseInt(aux[3]))) + ",";
							}
						}
						if (aux[0].compareTo("CHK") == 0){
							if ( aux[1].compareTo( fichas.get(i).get3DId()) == 0 ){
								moves += ((actualmove-0.7)/(turn-1)) +  ","  + ((actualmove-0.8)/(turn-1))+ "," + ((actualmove-0.9)/(turn-1)) +  ","  + (actualmove/(turn-1))+ ",";
								moves2 +=  (-21+(6*Integer.parseInt(aux[3]))) +" 0.0 "+ (+21-(6*Integer.parseInt(aux[2])))+","+
								(-21+(6*Integer.parseInt(aux[3]))) +" 3.0 "+ (+21-(6*Integer.parseInt(aux[2]))) + "," ;
								moves2 +=  (-21+(6*Integer.parseInt(aux[3]))) +" 3.0 "+ (+21-(6*Integer.parseInt(aux[2])))+","+
								(-21+(6*Integer.parseInt(aux[3]))) +" 0.0 "+ (+21-(6*Integer.parseInt(aux[2]))) + "," ;
							}
						}
						if (aux[0].compareTo("MATE") == 0){
							if ( aux[1].compareTo( fichas.get(i).get3DId()) == 0 ){
								moves+= ((actualmove-0.1)/(turn-1)) +  ","  + (actualmove/(turn-1))+ ",";
								moves2 +=  (-21+(6*Integer.parseInt(aux[3]))) +" 0.0 "+ (+21-(6*Integer.parseInt(aux[2])))+","+
								(-21+(6*Integer.parseInt(aux[3]))) +" 1.5 "+ (+21-(6*Integer.parseInt(aux[2]))) + ",";
							}
						}
						if (aux[0].compareTo("MATE") == 0){
							if ( aux[1].compareTo( fichas.get(i).get3DId()) == 0 ){
								movesMate += ((actualmove-0.1)/(turn-1)) +  ","  + (actualmove/(turn-1))+ ",";
								moves2Mate +=  "0 " + "1 " + "0 " + "3.14 " + ", " + "0.7 " +"1 "+  "0.9 " +"3.14 " + ", " ;
							}
						}
			
					
				}
				actualmove = 0;
				if ( moves != ""){
				pw.println("DEF MOV" + fichas.get(i).get3DId() + " PositionInterpolator{\nkey[" + moves +"]"+"\nkeyValue["+ moves2 +"]}" +
						   "\nROUTE Timer.fraction_changed TO MOV" + fichas.get(i).get3DId()+ ".set_fraction" +
						  "\nROUTE MOV" + fichas.get(i).get3DId() + ".value_changed TO " + fichas.get(i).get3DId() + ".set_translation");
				}
				moves= "";
				moves2= "";
				if ( movesMate != ""){
				pw.println("DEF ROT" + fichas.get(i).get3DId() + " OrientationInterpolator{\nkey[" + movesMate +"]"+"\nkeyValue["+ moves2Mate +"]}" +
						   "\nROUTE Timer.fraction_changed TO ROT" + fichas.get(i).get3DId()+ ".set_fraction" +
						  "\nROUTE ROT" + fichas.get(i).get3DId() + ".value_changed TO " + fichas.get(i).get3DId() + ".set_rotation");
				}
				movesMate= "";
				moves2Mate= "";
			}
			
			
			fichas=board.getBlackPieces();
			
			for (int i=0; i<fichas.size();i++){			
				for (int j = 0; j< events.size(); j++){
					aux = events.get(j).split("-");				
						if (aux[0].compareTo("MOV") == 0 || aux[0].compareTo("KILL") == 0 ){
							if ( aux[0].compareTo("MOV") == 0 )
							actualmove++;
							
							if ( aux[1].compareTo( fichas.get(i).get3DId()) == 0 ){
								
								moves += ((actualmove-1)/(turn-1)) + "," + (actualmove/(turn-1))+ ",";
								moves2 +=  (-21+(6*Integer.parseInt(aux[3]))) +" 0.0 "+ (+21-(6*Integer.parseInt(aux[2])))+","+

							 (aux[0].compareTo("MOV") == 0 ? (-21+(6* ((Integer.parseInt(aux[5])))) ) : (- 21 + 6 * (i % 8))) + " 0.0 " + (aux[0].compareTo("MOV") == 0 ? (+21-(6*Integer.parseInt(aux[4]))) : (-35 - 6 * (i/8)))+ ","; 

								//System.out.print(moves + "+++++++++++ " + moves2);
							}
							
									
						}
						if (aux[0].compareTo("PPW") == 0){
							if ( aux[1].compareTo( fichas.get(i).get3DId()) == 0 ){
								moves += ((actualmove-1)/(turn-1)) + "," + (actualmove/(turn-1))+ ",";
								moves2 +=  (-21+(6*Integer.parseInt(aux[4]))) +" 0.0 "+ (+21-(6*Integer.parseInt(aux[3])))+","+
								(-21+(6*Integer.parseInt(aux[4]))) +" -6 "+ (+21-(6*Integer.parseInt(aux[3]))) + ",";
							}
							if ( aux[2].compareTo( fichas.get(i).get3DId()) == 0 ){
								moves += ((actualmove-1)/(turn-1)) + "," + ((actualmove-1)/(turn-1)) + "," + ((actualmove-1)/(turn-1)) + "," + (actualmove/(turn-1))+ ",";
								moves2 +=  (-21+(6*Integer.parseInt(aux[4]))) +" -10 "+ (+21-(6*Integer.parseInt(aux[3])))+","+
								(-21+(6*Integer.parseInt(aux[4]))) +" 100 "+ (+21-(6*Integer.parseInt(aux[3]))) + ",";
								moves2 +=  (-21+(6*Integer.parseInt(aux[4]))) +" 100 "+ (+21-(6*Integer.parseInt(aux[3])))+","+
								(-21+(6*Integer.parseInt(aux[4]))) +" 0 "+ (+21-(6*Integer.parseInt(aux[3]))) + ",";
							}
						}
						if (aux[0].compareTo("CHK") == 0){
							if ( aux[1].compareTo( fichas.get(i).get3DId()) == 0 ){
								moves += ((actualmove-0.8)/(turn-1)) +  ","  + ((actualmove-0.9)/(turn-1))+ "," + ((actualmove-0.9)/(turn-1)) +  ","  + (actualmove/(turn-1))+ ",";
								moves2 +=  (-21+(6*Integer.parseInt(aux[3]))) +" 0.0 "+ (+21-(6*Integer.parseInt(aux[2])))+","+
								(-21+(6*Integer.parseInt(aux[3]))) +" 3.0 "+ (+21-(6*Integer.parseInt(aux[2]))) + "," ;
								moves2 +=  (-21+(6*Integer.parseInt(aux[3]))) +" 3.0 "+ (+21-(6*Integer.parseInt(aux[2])))+","+
								(-21+(6*Integer.parseInt(aux[3]))) +" 0.0 "+ (+21-(6*Integer.parseInt(aux[2]))) + "," ;
								}
						}
						if (aux[0].compareTo("MATE") == 0){
							if ( aux[1].compareTo( fichas.get(i).get3DId()) == 0 ){
								moves+= ((actualmove-0.1)/(turn-1)) +  ","  + (actualmove/(turn-1))+ ",";
								moves2 +=  (-21+(6*Integer.parseInt(aux[3]))) +" 0.0 "+ (+21-(6*Integer.parseInt(aux[2])))+","+
								(-21+(6*Integer.parseInt(aux[3]))) +" 1.7 "+ (+21-(6*Integer.parseInt(aux[2]))) + ",";
							}
						}
						if (aux[0].compareTo("MATE") == 0){
							if ( aux[1].compareTo( fichas.get(i).get3DId()) == 0 ){
								movesMate += ((actualmove-0.1)/(turn-1)) +  ","  + (actualmove/(turn-1))+ ",";
								moves2Mate +=  "0 " + "1 " + "0 " + "0 " + ", " + "0.6 " +"0 "+ "1 " +"4.6 " + ", " ;
							}
						}
						
			
			
					
				}
				actualmove = 0;
				if (moves != ""){
					pw.println("DEF MOV" + fichas.get(i).get3DId() + " PositionInterpolator{\nkey[" + moves +"]"+"\nkeyValue["+ moves2 +"]}" +
							   "\nROUTE Timer.fraction_changed TO MOV" + fichas.get(i).get3DId()+ ".set_fraction" +
							  "\nROUTE MOV" + fichas.get(i).get3DId() + ".value_changed TO " + fichas.get(i).get3DId() + ".set_translation");
				}
				
				moves= "";
				moves2= "";
				if ( movesMate != ""){
					pw.println("DEF ROT" + fichas.get(i).get3DId() + " OrientationInterpolator{\nkey[" + movesMate +"]"+"\nkeyValue["+ moves2Mate +"]}" +
							   "\nROUTE Timer.fraction_changed TO ROT" + fichas.get(i).get3DId()+ ".set_fraction" +
							  "\nROUTE ROT" + fichas.get(i).get3DId() + ".value_changed TO " + fichas.get(i).get3DId() + ".set_rotation");
					}
					movesMate= "";
					moves2Mate= "";
			}
			
			
			
		fileout.close();
		} catch (IOException e) {
			e.printStackTrace();	
		}		
		
		System.out.println("Archivo generado");
		
		
		
		
		
		
	}
	/** 
     * Funcion para la prueba del resto de funciones
     */
	public static void main(String args[]) throws IOException {
		//PLATAFORMA DE DEBUG
		//Para a√±adir nuevas pruebas, a√±ade un nuevo campo CASE y cambia el n√∫mero de camino.

		int camino = 2;

		ArrayList<String> movs = new ArrayList<String>();
		switch (camino) {
		case 0: //Prueba de generaci√≥n aleatoria
			Board b = new Board();
			System.out.println("Add white king to 0,0");
			if (b.addPiece(Piece.Kind.KING, Piece.Color.WHITE, 0,0)) {
				System.out.println("Succeed!");
			} else {
				System.out.println("FAIL!");
			}
			System.out.println("Add black king to 2,0");
			if (b.addPiece(Piece.Kind.KING, Piece.Color.BLACK, 2,0)) {
				System.out.println("Succeed!");
			} else {
				System.out.println("FAIL!");
			}
			System.out.println("Add black pawn to 2,0");
			if (b.addPiece(Piece.Kind.PAWN, Piece.Color.BLACK, 2,0)) {
				System.out.println("Succeed!");
			} else {
				System.out.println("FAIL!");
			}
			System.out.println("Add black pawn to 5,0");
			if (b.addPiece(Piece.Kind.PAWN, Piece.Color.BLACK, 5,0)) {
				System.out.println("Succeed!");
			} else {
				System.out.println("FAIL!");
			}
			System.out.println("Is that black check?");
			System.out.println(b.isBlackCheck()? "Yes": "No");
			System.out.println("Is that white check?");
			System.out.println(b.isWhiteCheck()? "Yes": "No");
			System.out.println("Add black Queen to 6,0");
			if (b.addPiece(Piece.Kind.QUEEN, Piece.Color.BLACK, 6,0)) {
				System.out.println("Succeed!");
			} else {
				System.out.println("FAIL!");
			}
			System.out.println("Is that white check?");
			System.out.println(b.isWhiteCheck()? "Yes": "No");
			System.out.println("Add black Queen to 0,6");
			if (b.addPiece(Piece.Kind.QUEEN, Piece.Color.BLACK, 0,6)) {
				System.out.println("Succeed!");
			} else {
				System.out.println("FAIL!");
			}
			System.out.println("Is that white check?");
			System.out.println(b.isWhiteCheck()? "Yes": "No");
			b.printSituation();
			System.out.println("\n\n\n");
			b = new Board();
			b.random(16, 1, "original");
			b.printSituation();
			b = new Board();
			System.out.println("\n\n\n");
			b.random(4, 1.5, "original");
			b.printSituation();
			b = new Board();
			System.out.println("\n\n\n RANDOM!");
			b.random(10, 1, "random");
			b.printSituation();
			b = new Board();
			System.out.println("\n\n\n RANDOM 2!");
			b.random(4, 1.5, "random");
			b.printSituation();
			break;
		case 1: //Prueba de borrar pieza
			Board b2 = new Board();
			System.out.println("\n\n\n");
			System.out.println("Add white king to 0,0");
			if (b2.addPiece(Piece.Kind.KING, Piece.Color.WHITE, 0,0)) {
				System.out.println("Succeed!");
			} else {
				System.out.println("FAIL!");
			}
			System.out.println("\n\n\n");
			System.out.println("Add black king to 2,1");
			if (b2.addPiece(Piece.Kind.KING, Piece.Color.BLACK, 2,1)) {
				System.out.println("Succeed!");
			} else {
				System.out.println("FAIL!");
			}
			System.out.println("\n\n\n");
			System.out.println("Add black pawn to 2,0");
			if (b2.addPiece(Piece.Kind.PAWN, Piece.Color.BLACK, 2,0)) {
				System.out.println("Succeed!");
			} else {
				System.out.println("FAIL!");
			}
			System.out.println("\n\n\n");
			System.out.println("Add black Queen to 6,0");
			if (b2.addPiece(Piece.Kind.QUEEN, Piece.Color.BLACK, 6,0)) {
				System.out.println("Succeed!");
			} else {
				System.out.println("FAIL!");
			}
			System.out.println("\n\n\n");
			System.out.println("Is that white check?");
			System.out.println(b2.isWhiteCheck()? "Yes": "No");
			b2.printSituation();
			System.out.println("\n\n\n");
			System.out.println("Remove piece at 2,0");
			if (b2.removePiece(2,0)) {
				System.out.println("Succeed!");
			} else {
				System.out.println("FAIL!");
			}
			System.out.println("\n\n\n");
			System.out.println("Is that white check?");
			System.out.println(b2.isWhiteCheck()? "Yes": "No");
			b2.printSituation();
			System.out.println("\n\n\n");
			System.out.println("Setup Queen to 2,0");
			if (b2.setupPiece(6,0,3,0)) {
				System.out.println("Succeed!");
			} else {
				System.out.println("FAIL!");
			}
			System.out.println("\n\n\n");
			System.out.println("Is that white check?");
			System.out.println(b2.isWhiteCheck()? "Yes": "No");
			b2.printSituation();
			System.out.println("Setup King to 7,7");
			if (b2.setupPiece(2,1,7,7)) {
				System.out.println("Succeed!");
			} else {
				System.out.println("FAIL!");
			}
			System.out.println("Setup Queen to 2,0");
			if (b2.setupPiece(3,0,7,1)) {
				System.out.println("Succeed!");
			} else {
				System.out.println("FAIL!");
			}
			System.out.println("\n\n\n");
			System.out.println("Is that white check?");
			System.out.println(b2.isWhiteCheck()? "Yes": "No");
			b2.printSituation();
			break;
		case 2:
			Board b3 = new Board();
			b3.random(16,1,"original");
			b3.printSituation();
			System.out.println("\n\n\n");
			boolean mate = false;
			while (turn < 500 && !mate){
			System.out.println("Turno " + turn + " (Blancas)" );
			mate = !b3.moveRandom(Piece.Color.WHITE, movs, true);
			System.out.println(mate);
			if (b3.isWhiteCheck()) {
				System.out.println("***DEBUG -----------------------------------------");
			}
			if (mate) {
				b3.printSituation();
				break;
			}
			++turn;
			System.out.println("Turno " + turn + " (Negras)" );
			if (!mate) {
			mate = !b3.moveRandom(Piece.Color.BLACK, movs, true);
			System.out.println(mate);
			if (b3.isBlackCheck()) {
				System.out.println("***DEBUG -----------------------------------------");
			}
			if (mate) {
				b3.printSituation();
				break;
			}
			++turn;
			}
			}
			
			b3.printSituation();
			System.out.println("\n\n\n");	
			b3.generate3D("./3D/", "ajedrez.wrl");
			generate3Dmoves("./3D/", "ajedrez.wrl");
			int turnos = 1;
			for (int i = 0; i < movs.size(); ++i) {
				String aux[] = movs.get(i).split("-");
				System.out.println(turnos + ": "+ movs.get(i));
				if (aux[0].compareTo("MOV") == 0) ++turnos;
			}
			break;
		case 3:
			Board b4 = new Board();
			b4.addPiece(Piece.Kind.KING, Piece.Color.WHITE, 0,0);
			b4.addPiece(Piece.Kind.KING, Piece.Color.BLACK, 5,5);
			b4.addPiece(Piece.Kind.ROOK, Piece.Color.BLACK, 5,3);
			b4.addPiece(Piece.Kind.ROOK, Piece.Color.WHITE, 5,1);
			b4.addPiece(Piece.Kind.PAWN, Piece.Color.WHITE, 6,3);
			b4.addPiece(Piece.Kind.PAWN, Piece.Color.WHITE, 6,7);
			b4.printSituation();
			System.out.println("\n\n\n");
			System.out.println(b4.move(5,3,6,3, movs, true));
			b4.printSituation();
			System.out.println("\n\n\n");
			System.out.println(b4.move(5,3,5,1,movs, true));
			b4.printSituation();
			System.out.println("\n\n\n");
			System.out.println(b4.move(6,7,7,7,movs, true));
			b4.printSituation();
			for (int i = 0; i < movs.size(); ++i) {
				System.out.println(movs.get(i));
			}
			break;
		case 4:
			Board b5 = new Board();
			b5.addPiece(Piece.Kind.KING, Piece.Color.WHITE, 0,0);
			b5.addPiece(Piece.Kind.KING, Piece.Color.BLACK, 5,5);
			b5.addPiece(Piece.Kind.ROOK, Piece.Color.BLACK, 5,3);
			b5.addPiece(Piece.Kind.ROOK, Piece.Color.WHITE, 5,1);
			b5.addPiece(Piece.Kind.PAWN, Piece.Color.WHITE, 6,3);
			b5.addPiece(Piece.Kind.PAWN, Piece.Color.WHITE, 6,7);
			b5.printSituation();
			System.out.println("\n\n\n");
			System.out.println(b5.moveRandom(Piece.Color.WHITE,movs, true));
			b5.printSituation();
			System.out.println("\n\n\n");
			System.out.println(b5.moveRandom(Piece.Color.BLACK,movs, true));
			b5.printSituation();
			System.out.println("\n\n\n");
			System.out.println(b5.moveRandom(Piece.Color.WHITE,movs, true));
			b5.printSituation();
			for (int i = 0; i < movs.size(); ++i) {
				System.out.println(movs.get(i));
			}
			break;
		}
	}
}
