import java.util.Random;

public class LifeMain {
	public static void main(String[] args) {
		Cell[][] cells = new Cell[100][100];
		
		Random r = new Random();
		
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				if (r.nextInt(2) == 0) {
					cells[i][j] = new Cell(i, j, false, cells);
				} else {
					cells[i][j] = new Cell(i, j, true, cells);
				}
			}
		}
		//cells[0][0] = new Cell(0, 0, true, cells);
		//cells[0][2] = new Cell(0, 2, true, cells);
		//cells[1][1] = new Cell(1, 1, true, cells);
		//cells[1][2] = new Cell(1, 2, true, cells);
		//cells[2][1] = new Cell(2, 1, true, cells);
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				cells[i][j].setNextStatus();
			}
		}
		
		LifeGUI.getInstance(cells);
		
		
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.err.println(e.toString());
				e.printStackTrace();
			}
			for (int i = 0; i < cells.length; i++) {
				for (int j = 0; j < cells[0].length; j++) {
					cells[i][j].updateStatus();
				}
			}
			for (int i = 0; i < cells.length; i++) {
				for (int j = 0; j < cells[0].length; j++) {
					cells[i][j].setNextStatus();
				}
			}
			LifeGUI.drawCells();
		}
	}
}
