package chess;
import java.util.*;

public class Game {
	private Board actual;
	private ArrayList<Board> boardList;
	public Game() {
		actual = new Board();
		boardList = new ArrayList<Board>();
	}
	public void random(Integer piecesno, double proportion, String disposal) {
		actual.random(piecesno, proportion, disposal);
		boardList.add(actual);
	}
	public void generate3D(String file) {
		
	}
}
