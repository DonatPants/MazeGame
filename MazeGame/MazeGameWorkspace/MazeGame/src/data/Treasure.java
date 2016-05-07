package data;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Treasure extends GameObject{

	public Treasure(int x, int y, ID id, int width, int height) {
		super(x, y, width, height, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		g.fillRect(super.x, super.y, super.width, super.height);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(super.x, super.y, super.width, super.height);
	}
	
}
