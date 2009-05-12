package chess;

public class Game {
	private Board actual;
	public Game() {
		actual = new Board();
	}
	public void random(Integer piecesno, double proportion, String disposal) {
		actual.random(piecesno, proportion, disposal);
	}
}
