package chess;

public class Queen extends Piece {
	public Queen(Color cr, int r, int c) {
		super(cr,r, c);
		this.setKind(Piece.Kind.QUEEN);
	}
	
	public String get3Dfile() {
		return "Reina" + (this.getColor() == Piece.Color.WHITE ? "B" : "N") + ".wrl";
	}
	public String getKindString() {
		return "Queen";
	}
	public boolean canMoveTo(int target_row, int target_column) {
		if (this.getRow() == target_row || this.getColumn() == target_column || Math.abs(this.getRow() - target_row) == Math.abs(this.getColumn() - target_column)) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isBlockedBy(int target_row, int target_column, int obstacle_row, int obstacle_column) {
		if (this.isInPathTo(obstacle_row, obstacle_column, target_row, target_column)) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isInPathTo(int obstacle_row, int obstacle_column, int target_row, int target_column) {
		int distance_to_target = 1;
		int distance_to_obstacle = -1;
		if (this.getRow() == target_row && target_row == obstacle_row) {
			distance_to_target = target_column - this.getColumn();
			distance_to_obstacle = obstacle_column - this.getColumn();
		} else if (this.getColumn() == target_column && target_column == obstacle_column) {
			distance_to_target = target_row - this.getRow();
			distance_to_obstacle = obstacle_row - this.getRow();
		} else if (Math.abs(this.getRow() - target_row) == Math.abs(this.getColumn() - target_column) && Math.abs(this.getRow() - obstacle_row) == Math.abs(this.getColumn() - obstacle_column)) {
			int distance_to_target_y = target_row - this.getRow();
			int distance_to_obstacle_y = obstacle_row - this.getRow();
			int distance_to_target_x = target_column - this.getColumn();
			int distance_to_obstacle_x = obstacle_column - this.getColumn();
			double dbl_distance_to_target = Math.sqrt(Math.pow(distance_to_target_x, 2) + Math.pow(distance_to_target_y, 2));
			double dbl_distance_to_obstacle = Math.sqrt(Math.pow(distance_to_obstacle_x, 2) + Math.pow(distance_to_obstacle_y, 2));
			return(!(distance_to_target_y > 0 ^ distance_to_obstacle_y > 0) && !(distance_to_target_x > 0 ^ distance_to_obstacle_x > 0) && dbl_distance_to_obstacle < dbl_distance_to_target);
		}
		return (!(distance_to_target > 0 ^ distance_to_obstacle > 0) && Math.abs(distance_to_obstacle) < Math.abs(distance_to_target));
	}
}
