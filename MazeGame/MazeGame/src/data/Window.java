package data;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {
	
	private static final long serialVersionUID = -6112428091888191314L;
	
	/** creates a new window with set size that is unreshapable
	 * @param width - width of the screen
	 * @param height - height of the screen
	 * @param title - title at the top of the screen
	 * @param game - the game with all the runnable functions
	 */
	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
	
}
