package chess;
import java.io.IOException;

public class Game {
	private Board board;
	private int turn = 1;
	public Game() {
		board = new Board();
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
	
	public void generate3D(String file) {
		//
	}
	public static void main(String args[]) throws IOException {
		//PLATAFORMA DE DEBUG
		//Para añadir nuevas pruebas, añade un nuevo campo CASE y cambia el número de camino.
		int camino = 2;
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
			b3.random(6,1,"random");
			b3.generate3D("./3D/");	
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
			System.out.println(b4.move(5,3,6,3));
			b4.printSituation();
			System.out.println("\n\n\n");
			System.out.println(b4.move(5,3,5,1));
			b4.printSituation();
			System.out.println("\n\n\n");
			System.out.println(b4.move(6,7,7,7));
			b4.printSituation();
			break;
		}
	}
}
