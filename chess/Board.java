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
	public void random(Integer piecesno, double proportion, String disposal) {
		//Pieces generation
		Piece q;
		//Kings
		if (disposal.equals("original")) {
			q = new King(Piece.Color.WHITE, 4,0);
			whitePieceList.add(q);
			q = new King(Piece.Color.BLACK, 4,7);
			blackPieceList.add(q);
		} else {
			q = new King(Piece.Color.WHITE, generator.nextInt(8), generator.nextInt(8));
			whitePieceList.add(q);
			q = new King(Piece.Color.BLACK, generator.nextInt(8),generator.nextInt(8));
			blackPieceList.add(q);
		}
		//White pieces
		//Available pieces
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
			switch ((Piece.Kind) availablePieces.remove(generator.nextInt(availablePieces.size()))) {
				case PAWN:
					q = new Pawn(Piece.Color.WHITE, generator.nextInt(8),generator.nextInt(8));
					break;
				case BISHOP:
					q = new Bishop(Piece.Color.WHITE, generator.nextInt(8),generator.nextInt(8));
					break;
				case KNIGHT:
					q = new Knight(Piece.Color.WHITE, generator.nextInt(8),generator.nextInt(8));
					break;
				case ROOK:
					q = new Rook(Piece.Color.WHITE, generator.nextInt(8),generator.nextInt(8));
					break;
				case QUEEN:
					q = new Queen(Piece.Color.WHITE, generator.nextInt(8),generator.nextInt(8));
					break;
			}
			whitePieceList.add(q);
		}
		//Black pieces
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
			switch ((Piece.Kind) availablePieces.remove(generator.nextInt(availablePieces.size()))) {
			case PAWN:
				q = new Pawn(Piece.Color.BLACK, generator.nextInt(8),generator.nextInt(8));
				break;
			case BISHOP:
				q = new Bishop(Piece.Color.BLACK, generator.nextInt(8),generator.nextInt(8));
				break;
			case KNIGHT:
				q = new Knight(Piece.Color.BLACK, generator.nextInt(8),generator.nextInt(8));
				break;
			case ROOK:
				q = new Rook(Piece.Color.BLACK, generator.nextInt(8),generator.nextInt(8));
				break;
			case QUEEN:
				q = new Queen(Piece.Color.BLACK, generator.nextInt(8),generator.nextInt(8));
				break;
			}
			blackPieceList.add(q);
		}
		for (int i = 0; i < whitePieceList.size(); ++i) {
			System.out.println(whitePieceList.get(i).toString());
		}
		for (int i = 0; i < blackPieceList.size(); ++i) {
			System.out.println(blackPieceList.get(i).toString());
		}
	}
}
