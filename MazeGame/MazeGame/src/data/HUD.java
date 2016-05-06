package data;

import java.util.Stack;

// stores money, time it took to pass each maze, health

public class HUD {

	private int health, level, money;
	private Stack<Float> times;
	
	public HUD() {
		this.health = 10;
		this.level = 1;
		this.money = 0;
		this.times = new Stack<Float>();
	}
	
	public void treasureMoney() {
		this.money += 40;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Stack<Float> getTimes() {
		return times;
	}

	public void setTimes(Stack<Float> times) {
		this.times = times;
	}
	
	public void pushTime(float time) {
		this.times.push(new Float(time));
		money += 1/(time/150000);
	}
}
