package data;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Stack;

public class BasicEnemy extends GameObject{
	
	private Stack<Location> path;
	private Maze maze;
	private int moveSpeed;

	// constructor
	public BasicEnemy(int x, int y, int width, int height, ID id, Maze maze) {
		super(x, y, width, height, id);
		this.maze = maze;
		path = this.maze.path(new Location(super.x, super.y), this.maze.getStart());
		moveSpeed = 0;
	}

	@Override
	
	public void tick() {
		
		if (moveSpeed <= 0) {
			moveSpeed = 30;
			Location destination = path.pop(); // get the location we need to go to next
			super.x = destination.getI() * (Game.WIDTH/Game.TILES_WIDE); // set the x and y values to the location we want to go to
			super.y = destination.getJ() * (Game.HEIGHT/Game.TILES_HIGH);
		}
		else 
			moveSpeed--;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.MAGENTA); 
		g.fillOval(super.x, super.y, super.width, super.height);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)super.x, (int)super.y, super.width, super.height);
	}
}
