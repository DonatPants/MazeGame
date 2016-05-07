package data;

public class Spawn {
	private Handler handler;
	
	public Spawn(Handler handler) {
		this.handler = handler;
		spawn();
	}
	
	public void spawn() {
		System.out.println("(" + this.handler.getMaze().getEnd().getI() * (Game.WIDTH/Game.TILES_WIDE) + " , " + this.handler.getMaze().getEnd().getJ() * (Game.HEIGHT/Game.TILES_HIGH) + ")");
		//this.handler.addObject(new BasicEnemy(this.handler.getMaze().getEnd().getI() * (Game.WIDTH/Game.TILES_WIDE), this.handler.getMaze().getEnd().getJ() * (Game.HEIGHT/Game.TILES_HIGH), 11, 11, ID.EnemySpawn, this.handler.getMaze()));
	}
	
	public Handler getHandler() {
		return handler;
	}
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	
}
