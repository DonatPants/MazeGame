package data;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject{

	private int x, y, speedX, speedY;
	private Game game;
	private ID[][] map;
	public static boolean noClip;
	
	public Player(int x, int y, ID id, int width, int height, Handler handler, ID[][] map, Game game) {
		super(x, y, width, height, id);
		this.map = map;
		this.game = game;
		this.speedX = 0;
		this.speedY = 0;
		Player.noClip = false;
	}
	
	// move the player if he is not gonna run into a wall
	@Override
	public void tick() {
		ID posId = positionID(this.map);
		if (posId == ID.End) {
			game.setFinished(true);
			System.out.print("end");
		}
		else if (posId == ID.Treasure) {
			this.map[super.x/(Game.WIDTH/Game.TILES_WIDE)][super.y/(Game.WIDTH/Game.TILES_WIDE)] = ID.Path;
			this.game.getHud().treasureMoney();
			System.out.println("got 40 cash for treasure, current money = " + this.game.getHud().getMoney());
		}
		if (!Player.noClip) {
			if (validMoveX(this.map)) // X direction movement
				super.x += speedX;
			if (validMoveY(this.map)) // Y direction movement
				super.y += speedY;
		}
		else 
			if (inMap(this.map)) {
				super.x += speedX;
				super.y += speedY;
			}
	}
	
	// returns false if moving in the X direction with our current speed will end up on a tile of type 0 (wall), true otherwise
	private boolean validMoveX(ID[][] map) {
		int tileSize = Game.WIDTH/Game.TILES_WIDE;
		if (map[(super.x + speedX)/tileSize][(super.y)/tileSize] == ID.Wall || map[(super.x + super.width + speedX)/tileSize][(super.y)/tileSize] == ID.Wall || map[(super.x + speedX)/tileSize][(super.y + super.height)/tileSize] == ID.Wall || map[(super.x + super.width + speedX)/tileSize][(super.y + super.height)/tileSize] == ID.Wall)
			return false;
		return true;
	}
	// returns false if moving in the Y direction with our current speed will end up on a tile of type 0 (wall), true otherwise
	private boolean validMoveY(ID[][] map) {
		int tileSize = Game.WIDTH/Game.TILES_WIDE;
		if (map[(super.x)/tileSize][(super.y + speedY)/tileSize] == ID.Wall || map[(super.x + super.width)/tileSize][(super.y + speedY)/tileSize] == ID.Wall || map[(super.x)/tileSize][(super.y + super.height + speedY)/tileSize] == ID.Wall || map[(super.x + super.width)/tileSize][(super.y + super.height + speedY)/tileSize] == ID.Wall)
			return false;
		return true;
	}
	
	public ID positionID(ID[][] map) {
		return this.map[super.x/(Game.WIDTH/Game.TILES_WIDE)][super.y/(Game.WIDTH/Game.TILES_WIDE)];
	}
	
	public boolean inMap(ID[][] map) {
		return super.x + this.speedX >= 0 && super.y + this.speedY >= 0 && super.x + this.speedX < Game.WIDTH && super.y + this.speedY < Game.HEIGHT;
	}

	// draw the player
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(super.x, super.y, super.width, super.height);
	}
	
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)super.x, (int)super.y, super.width, super.height);
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		super.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		super.height = height;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Player [x=" + x + ", y=" + y + "]";
	}
}