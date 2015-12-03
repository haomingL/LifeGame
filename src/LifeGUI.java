
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * 
 * @author Haoming Liu
 *
 */
public class LifeGUI {
	private static JFrame frame = null;
	
	private static CellPanel cellPanel;
	
	public static JFrame getInstance(Cell[][] model) {
		if (frame == null) {
			setUp(model);
		}
		return frame;
	}

	private static void setUp(Cell[][] model) {
		
		frame = new JFrame();
		//frame.setPreferredSize(new Dimension(720, 720));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		cellPanel = new CellPanel(model, frame);
		cellPanel.setPreferredSize(new Dimension(720, 720));
		frame.add(cellPanel);
		
		
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void drawCells() {
		cellPanel.repaint();
	}
}
