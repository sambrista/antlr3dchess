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
	public void random(Integer piecesno, double proportion, String disposal) {
		board.random(piecesno, proportion, disposal);
	}
	
	public static void generate3D(Board tablero, String path, ArrayList<String> eventos) {
		
		FileWriter fileout=null;
		PrintWriter pw=null;
		double actualmove=0.0;
		
		
		
		try {
			 
		
			
			fileout=new FileWriter(path+"ajedrez.wrl",true);
			pw = new PrintWriter(fileout);
			
			
			
			for (int j = 1; j< turn ; j++){
			String [] aux = eventos.get(j-1).split("-");
			
			if (aux[0].compareTo("MOV") == 0){
				actualmove++;
			
				
					
					
					
			pw.println("DEF MOV" + aux[1] + " PositionInterpolator{\nkey[" + ((actualmove-1)/(turn-1)) + "," +
					  (actualmove/(turn-1)) +",]"+"\nkeyValue["+ (-21+(6*Integer.parseInt(aux[3]))) +" 0.0 "+ (+21-(6*Integer.parseInt(aux[2])))+","+
					  (-21+(6* (Integer.parseInt(aux[5]))) )+" 0.0 "+ (+21-(6*Integer.parseInt(aux[4]))) +",]}" +
					  "\nROUTE Timer.fraction_changed TO MOV" + aux[1]+ ".set_fraction" +
					  "\nROUTE MOV" + aux[1] + ".value_changed TO " + aux[1] + ".set_translation");
			
					
				}
				
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

		int camino = 4;

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
		//	b3.random(1,1,"random");
			b3.addPiece(Piece.Kind.ROOK, Piece.Color.BLACK, 5,3);
			b3.addPiece(Piece.Kind.KING, Piece.Color.WHITE, 0,0);
			b3.generate3D("./3D/");
			b3.printSituation();
			System.out.println("\n\n\n");
			System.out.println(b3.moveRandom(Piece.Color.WHITE, movs));
			++turn;
			b3.printSituation();
			System.out.println("\n\n\n");
			System.out.println(b3.moveRandom(Piece.Color.BLACK, movs));
			++turn;
			b3.printSituation();
			System.out.println("\n\n\n");			
			generate3D(b3,"./3D/",movs);
			for (int i = 0; i < movs.size(); ++i) {
				System.out.println(movs.get(i));
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
			System.out.println(b4.move(5,3,6,3, movs));
			b4.printSituation();
			System.out.println("\n\n\n");
			System.out.println(b4.move(5,3,5,1,movs));
			b4.printSituation();
			System.out.println("\n\n\n");
			System.out.println(b4.move(6,7,7,7,movs));
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
			System.out.println(b5.moveRandom(Piece.Color.WHITE,movs));
			b5.printSituation();
			System.out.println("\n\n\n");
			System.out.println(b5.moveRandom(Piece.Color.BLACK,movs));
			b5.printSituation();
			System.out.println("\n\n\n");
			System.out.println(b5.moveRandom(Piece.Color.WHITE,movs));
			b5.printSituation();
			for (int i = 0; i < movs.size(); ++i) {
				System.out.println(movs.get(i));
			}
			break;
		}
	}
}