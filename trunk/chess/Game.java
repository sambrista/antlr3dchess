package chess;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Game {
	private Board board;
	private ArrayList<String> events;
	private static int turn = 1;
	public Game() {
		board = new Board();
		events = new ArrayList<String>();
	}
	public Piece.Color turn() {
		if (turn % 2 == 0) {
			return Piece.Color.BLACK;
		} else {
			return Piece.Color.WHITE;
		}
	}
	/*
	 * Funciones que usa ANTLR
	 */
	/*
	 * Board Zone
	 */
	public void random(Integer piecesno, double proportion, String disposal) {
		board.random(piecesno, proportion, disposal);
	}
	public boolean addPiece (String knd, String clr, String clmn, int rw) {
		Piece.Kind kind = Piece.stringToKind(knd);
		Piece.Color color = Piece.stringToColor(clr);
		int column = board.letterToNumber(clmn);
		if (kind != null && color != null && board.validCell(rw, column)) {
			return board.addPiece(kind, color, rw, column);
		} else {
			return false;
		}
	}
	public boolean setupPiece (String clmn1, int rw1, String clmn2, int rw2) {
		int column1 = board.letterToNumber(clmn1);
		int column2 = board.letterToNumber(clmn2);
		if (board.validCell(rw1, column1) && board.validCell(rw2, column2)) {
			return board.setupPiece(rw1, column1, rw2, column2);
		} else {
			return false;
		}
	}
	public boolean removePiece (String clmn, int rw) {
		int column = board.letterToNumber(clmn);
		if (board.validCell(rw, column)) {
			return board.removePiece(rw, column);
		} else {
			return false;
		}
	}
	public boolean removePiece (String knd, String clr) {
		Piece.Kind kind = Piece.stringToKind(knd);
		Piece.Color color = Piece.stringToColor(clr);
		if (kind != null && color != null) {
			return board.removePiece(kind, color);
		} else {
			return false;
		}
	}
	public boolean generate3D (String path) {
		//TODO adaptar la funcion de generar 3D. Esta genera el tablero sin animaciones
		return false;
	}
	/*
	 * Fin de Board Zone
	 */
	/*
	 * Game Zone
	 */
	
	/*
	 * Fin de Game Zone
	 */
	/*
	 * Common Zone
	 */
	public boolean movePlayerColor (String clmn1, int rw1, String clmn2, int rw2, Piece.Color clr) {
		int column1 = board.letterToNumber(clmn1);
		int column2 = board.letterToNumber(clmn2);
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
	public boolean movePlayerW (String clmn1, int rw1, String clmn2, int rw2) {
		return(movePlayerColor (clmn1, rw1, clmn2, rw2, Piece.Color.WHITE));
	}
	public boolean movePlayerB (String clmn1, int rw1, String clmn2, int rw2) {
		return(movePlayerColor (clmn1, rw1, clmn2, rw2, Piece.Color.BLACK));
	}
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
	public boolean moveRandomlyW () {
		return(moveRandomlyColor (Piece.Color.WHITE));
	}
	public boolean moveRandomlyB () {
		return(moveRandomlyColor (Piece.Color.BLACK));
	}
	public void state(String path) {
		//TODO escribir a fichero
		System.out.println("");
		System.out.println("PIEZAS BLANCAS");
		System.out.println("");

		for (int i = 0; i < board.getWhitePieces().size(); ++i) {
			System.out.println(((Piece)board.getWhitePieces().get(i)).state());
			System.out.println("");

		}
		System.out.println("");
		System.out.println("PIEZAS NEGRAS");
		System.out.println("");
		for (int i = 0; i < board.getBlackPieces().size(); ++i) {
			System.out.println(((Piece)board.getBlackPieces().get(i)).state());
			System.out.println("");

		}
		System.out.println("");
		System.out.println("SITUACI�N ACTUAL");
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
	public void movementsList() {
		
	}
	/*
	 * Fin de Common Zone
	 */
	/*
	 * Fin de las funciones que usa ANTLR
	 */
	public static void generate3D(Board tablero, String path, ArrayList<String> eventos) {
		
		FileWriter fileout=null;
		PrintWriter pw=null;
		double actualmove=0.0;
		String moves = "";
		String moves2 = "";
		String [] aux = null;
		Piece pieza = null;
		
		ArrayList<Piece> fichas;
		
	
		
		try {
			 
		
			
			fileout=new FileWriter(path+"ajedrez.wrl",true);
			pw = new PrintWriter(fileout);
			
			
			
			pw.println("]}]}]}]}");
			pw.println("\nDEF Timer TimeSensor{cycleInterval " + (turn - 1) +" loop FALSE startTime 0.0 stopTime 1 }" + "\n"+ "ROUTE Touch.touchTime TO Timer.set_startTime");

			
			fichas=tablero.getWhitePieces();
			
			for (int i=0; i<fichas.size();i++){			
				for (int j = 0; j< eventos.size() ; j++){
					aux = eventos.get(j).split("-");				
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
			
					
				}
				actualmove = 0;
				if ( moves != ""){
				pw.println("DEF MOV" + fichas.get(i).get3DId() + " PositionInterpolator{\nkey[" + moves +"]"+"\nkeyValue["+ moves2 +"]}" +
						   "\nROUTE Timer.fraction_changed TO MOV" + fichas.get(i).get3DId()+ ".set_fraction" +
						  "\nROUTE MOV" + fichas.get(i).get3DId() + ".value_changed TO " + fichas.get(i).get3DId() + ".set_translation");
				}
				moves= "";
				moves2= "";
			}
			
			
			fichas=tablero.getBlackPieces();
			
			for (int i=0; i<fichas.size();i++){			
				for (int j = 0; j< eventos.size(); j++){
					aux = eventos.get(j).split("-");				
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
						/*
						if (aux[0].compareTo("CHK") == 0){
							if ( aux[1].compareTo( fichas.get(i).get3DId()) == 0 ){
								moves += ((actualmove-1)/(turn-1)) +  ","  + (actualmove/(turn-1))+ ",";
								moves2 +=  (-21+(6*Integer.parseInt(aux[3]))) +" 0 "+ (+21-(6*Integer.parseInt(aux[2])))+","+
								(-21+(6*Integer.parseInt(aux[3]))) +" 3 "+ (+21-(6*Integer.parseInt(aux[2]))) + "," ;
							}
						}*/
						
					
			
			
					
				}
				actualmove = 0;
				if (moves != ""){
					pw.println("DEF MOV" + fichas.get(i).get3DId() + " PositionInterpolator{\nkey[" + moves +"]"+"\nkeyValue["+ moves2 +"]}" +
							   "\nROUTE Timer.fraction_changed TO MOV" + fichas.get(i).get3DId()+ ".set_fraction" +
							  "\nROUTE MOV" + fichas.get(i).get3DId() + ".value_changed TO " + fichas.get(i).get3DId() + ".set_translation");
				}
				
				moves= "";
				moves2= "";
			}
			
			
			
		fileout.close();
		} catch (IOException e) {
			e.printStackTrace();	
		}		
		
		System.out.println("Archivo generado");
		
		
		
		
		
		
	}
	public static void main(String args[]) throws IOException {
		//PLATAFORMA DE DEBUG
		//Para añadir nuevas pruebas, añade un nuevo campo CASE y cambia el número de camino.

		int camino = 2;

		ArrayList<String> movs = new ArrayList<String>();
		switch (camino) {
		case 0: //Prueba de generación aleatoria
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
			b3.generate3D("./3D/");
			generate3D(b3,"./3D/",movs);
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
