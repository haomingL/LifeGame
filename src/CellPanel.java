import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author Haoming Liu
 *
 */
public class CellPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -520937320235266096L;
	Cell[][] cells;
	JFrame frame;
	
	public CellPanel(Cell[][] cells, JFrame frame) {
		super();
		this.cells = cells;
		this.frame = frame;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				if (cells[i][j].getCurrentStatus()) {
					g.fillRect(frame.getWidth() / cells.length * i, frame.getHeight() / cells.length * j, 
							frame.getWidth() / cells.length, frame.getHeight() / cells.length);
				} else {
					g.drawRect(frame.getWidth() / cells.length * i, frame.getHeight() / cells.length * j, 
							frame.getWidth() / cells.length, frame.getHeight() / cells.length);
				}
			}
		}
	}
}
