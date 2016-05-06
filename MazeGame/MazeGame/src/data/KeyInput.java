package data;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Player player;
	
	private boolean[] keyDown = new boolean[4]; 
	private final int MOVMENT_INTENSITY = 3;
	
	public KeyInput(Player player) {
		this.player = player;
		
		for (int i = 0; i < keyDown.length; i++)
			keyDown[i] = false;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		// pressing W = moving up
		if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
			player.setSpeedY(-MOVMENT_INTENSITY);
			keyDown[0] = true;
		}
		// pressing A = moving left
		if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
			player.setSpeedX(-MOVMENT_INTENSITY);
			keyDown[1] = true;
		}
		// pressing S = moving down
		if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
			player.setSpeedY(MOVMENT_INTENSITY);
			keyDown[2] = true;
		}
		// pressing D = moving right
		if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
			player.setSpeedX(MOVMENT_INTENSITY);
			keyDown[3] = true;
		}
		if (key == KeyEvent.VK_ESCAPE)
			System.exit(1);
		if (key == KeyEvent.VK_E)
			Player.noClip = !Player.noClip;
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		// pressing W = moving up
		if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP)
			keyDown[0] = false;
			//go.setSpeedY(0);
		// pressing A = moving left
		if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT)
			keyDown[1] = false;
			//go.setSpeedX(0);
		// pressing S = moving down
		if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN)
			keyDown[2] = false;
			//go.setSpeedY(0);
		// pressing D = moving right
		if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT)
			keyDown[3] = false;
			//go.setSpeedX(0);
		
		// vertical speed
		if (!keyDown[0] && !keyDown[2])
			this.player.setSpeedY(0);
		// horizontal speed
		if (!keyDown[1] && !keyDown[3])
			this.player.setSpeedX(0);
	}
	
	public void moveX(int speed) {
		this.player.setSpeedX(speed);
	}
	public void moveY(int speed) {
		this.player.setSpeedY(speed);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
