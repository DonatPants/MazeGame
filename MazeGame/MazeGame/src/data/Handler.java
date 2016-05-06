package data;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;

// all of the game objects should be put into the LinkedList<GameObject> objects so that the handler can update and render everything at once

public class Handler {

	LinkedList<GameObject> objects = new LinkedList<GameObject>();
	private Maze maze;
	private Game game;
	
	public Handler(Game game, Maze maze) {
		this.game = game;
		this.maze = maze;
	}

	/** goes through every GameObject in the objects list and runs object.tick on it
	 */
	public void tick() {
		for (GameObject go : objects)
			go.tick();
	}

	/** goes through every GameObject in the objects list and runs object.render(g) on it
	 * @param g - graphics used for the game
	 */
	public void render(Graphics g) {
		for (GameObject go : objects)
			go.render(g);
	}

	/** Appends the specified element to the end of this list. 
	 * @param object - element to be appended to this list 
	 */
	public void addObject(GameObject object) {
		this.objects.add(object);
	}

	/** Removes the first occurrence of the specified element from this list, if it is present. If this list does not contain the element, it is unchanged.
	 * @param object - element to be removed from this list, if present 
	 */
	public void removeObject(GameObject object) {
		this.objects.remove(object);
	}
	
	public void clearEnemies() {
		objects.clear();
		addObject(new Player(this.maze.getStart().getI() * (Game.WIDTH/Game.TILES_WIDE), this.maze.getStart().getJ() * (Game.HEIGHT/Game.TILES_HIGH), ID.Player, Game.PLAYER_WIDTH, Game.PLAYER_HEIGHT, this, this.maze.getMap(), this.game));
	}
	/** moves the player to the specified location *** (there might be something wrong here but it could be omething else cusing this to fail) ***
	 * @param loc the location to move the player to
	 */
	public void updatePlayerLocation(Location loc) {
		for (GameObject go : objects) 
			if (go.id == ID.Player) {
				go.setX(loc.getI() * (Game.WIDTH/Game.TILES_WIDE));
				go.setY(loc.getJ() * (Game.HEIGHT/Game.TILES_HIGH));
			}
	}
	// this probably doesn't work as intended
	public Player getPlayer() {
		for (GameObject go : objects) 
			if (go.id == ID.Player)
				return (Player) go;
		return null;
	}

	public Maze getMaze() {
		return maze;
	}

	public void setMaze(Maze maze) {
		this.maze = maze;
	}
}