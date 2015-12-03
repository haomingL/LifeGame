/**
 * @author Haoming Liu
 * This class stores the information about each single cell
 */
public class Cell {
	private int x;
	private int y;
	private boolean currentStatus;
	private boolean nextStatus;
	private Cell[][] map;
	
	public Cell(int xCor, int yCor, boolean current, Cell[][] map2) {
		this.x = xCor;
		this.y = yCor;
		this.currentStatus = current;
		this.nextStatus = currentStatus;
		this.map = map2;
	}

	public void setNextStatus() {
		int count = 0;// count how many live cells are around the cell
		
		
		if (x == 0) { // at the top level
			if (map[x + 1][y].currentStatus) {
				count++;
			}
			if (y == 0) { // at the upper left corner
				if (map[x][y + 1].currentStatus) {
					count++;
				}
				if (map[x + 1][y + 1].currentStatus) {
					count++;
				}
			} else if (y == map.length - 1){ // at the lower left corner
				if (map[x][y - 1].currentStatus) {
					count++;
				}
				if (map[x + 1][y - 1].currentStatus) {
					count++;
				}
			} else { // at the left, in the middle
				if (map[x][y + 1].currentStatus) {
					count++;
				}
				if (map[x][y - 1].currentStatus) {
					count++;
				}
				if (map[x + 1][y - 1].currentStatus) {
					count++;
				}
				if (map[x + 1][y + 1].currentStatus) {
					count++;
				}
			}
			
		} else if (x == map[0].length - 1) { // at the right
			if (map[x - 1][y].currentStatus) {
				count++;
			}
			if (y == 0) { // at the upper right corner
				if (map[x - 1][y + 1].currentStatus) {
					count++;
				}
				if (map[x][y + 1].currentStatus) {
					count++;
				}
			} else if (y == map.length - 1){ // at the lower right corner
				if (map[x - 1][y - 1].currentStatus) {
					count++;
				}
				if (map[x][y - 1].currentStatus) {
					count++;
				}
			} else { // at the right, in the middle
				if (map[x][y + 1].currentStatus) {
					count++;
				}
				if (map[x][y - 1].currentStatus) {
					count++;
				}
				if (map[x - 1][y - 1].currentStatus) {
					count++;
				}
				if (map[x - 1][y + 1].currentStatus) {
					count++;
				}
			}
			
		} else { // in the middle in terms of x
			if (map[x - 1][y].currentStatus) {
				count++;
			}
			if (map[x + 1][y].currentStatus) {
				count++;
			}
			if (y == 0) {
				for (int i = x - 1; i <= x + 1; i++) {
					if (map[i][y + 1].currentStatus) {
						count++;
					}
				}
			} else if (y == map.length - 1){
				for (int i = x - 1; i <= x + 1; i++) {
					if (map[i][y - 1].currentStatus) {
						count++;
					}
				}
			} else {
				for (int i = x - 1; i <= x + 1; i++) {
					if (map[i][y - 1].currentStatus) {
						count++;
					}
					if (map[i][y + 1].currentStatus) {
						count++;
					}
				}
			}
		}
		
		
		if (count > 3 || count < 2) {
			nextStatus = false;
		} else if (count == 3) {
			nextStatus = true;
		}
	}
	
	public void updateStatus() {
		currentStatus = nextStatus;
	}
	
	public boolean getCurrentStatus() {
		return this.currentStatus;
	}
	
	public boolean getNextStatus() {
		return this.nextStatus;
	}
}
