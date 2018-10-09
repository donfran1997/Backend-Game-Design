package ass2;

import java.util.ArrayList;

/**
 * The player character which is controlled by the player
 *
 */

public class Player {
	/** x and y represent the index of the player's location in dungeon
	 * dir is the direction the player is currently facing
	 * inventory
	 */
	private int x;
	private int y;
	private Direction dir;
	private Inventory inventory;
	private Status status;
	private int lives;
	
	public Player() {
		x = 1;
		y = 1;
		dir = Direction.RIGHT;
		status = Status.NONE;
		inventory = new Inventory();
		lives = 3;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Direction getDirection() {
		return this.dir;
	}
	
	public void setDirection(Direction dir) {
		this.dir = dir;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void addItem(Entity item) {
		inventory.addItem(item);
	}
	
	public int getNumItem(Entity item) {
		return inventory.getNumItem(item);
	}
	
	public void printInventory() {
		inventory.printInventory();
	}
	
	
	
	public int getLives() {
		return lives;
	}

	public void die() {
		lives--;
		if(lives > 0) {
			this.status = status.NONE;
			respawn();
		} else {
			
		}
	}
	
//	public void printInfo() {
//		System.out.println("Sword: " + this.inventory.getSwordNum());
//		System.out.println("Arrow: " + this.inventory.getArrowNum());
//		System.out.println("Key: " + this.inventory.getKeyNum());
//		System.out.println("Bomb: " + this.inventory.getBombNum());
//		System.out.println("Treasure: " + this.inventory.getTreasureNum());
//	}
	
	public Inventory getInventory() {
		return this.inventory;
	}
	/*
	 *  not sure if this is a good implementation, by passing in the dungeon
	 *  i think player should be responsible for moving, but i dont see how 
	 *  else
	 *  
	 *  also maybe replace with a different design pattern later
	 */
	
	public void respawn() {
		this.x = 1;
		this.y = 1;
	}

	
	public void moveUp(Square[][] dungeon) {
		move(x, y-1, dungeon[y-1][x]);
		setDirection(Direction.UP);
		if(dungeon[y][x].doAction(this)) {
			dungeon[y][x].removeEntity();
		}
	}
	
	public void moveDown(Square[][] dungeon) {
		move(x, y+1, dungeon[y+1][x]);
		setDirection(Direction.DOWN);
		if(dungeon[y][x].doAction(this)) {
			dungeon[y][x].removeEntity();
		}
	}
	
	public void moveLeft(Square[][] dungeon) {
		move(x-1, y, dungeon[y][x-1]);
		setDirection(Direction.LEFT);
		if(dungeon[y][x].doAction(this)) {
			dungeon[y][x].removeEntity();
		}
	}
	
	public void moveRight(Square[][] dungeon) {
		move(x+1, y, dungeon[y][x+1]);
		setDirection(Direction.RIGHT);
		if(dungeon[y][x].doAction(this)) {
			dungeon[y][x].removeEntity();
		}
	}
	
	public void move(int x, int y, Square s) {
		if(!s.isBlocked()) {
			this.x = x;
			this.y = y;
		}
		
		//System.out.println("Boudler x: " + s.getBoulder().getxCoord() + " y: " + s.getBoulder().getyCoord());
	}
	
	public void attackSword(Square[][] dungeon, ArrayList<EnemyCharacteristics> eList) {
		switch(dir) {
			case UP:
				inventory.attackSword(dungeon[y-1][x], eList, x, y-1);
				System.out.println("Attack " + x + " " + (y-1));
				break;
			case DOWN:
				inventory.attackSword(dungeon[y+1][x], eList, x, y+1);
				System.out.println("Attack " + x + " " + (y+1));
				break;
			case LEFT:
				inventory.attackSword(dungeon[y][x-1], eList, x-1, y);
				System.out.println("Attack " + (x-1) + " " + y);
				break;
			case RIGHT:
				inventory.attackSword(dungeon[y][x+1], eList, x+1, y);
				System.out.println("Attack " + (x+1) + " " + y);
				break;
		}
	}
	
	public void attackArrow(Square[][] dungeon, Player player, ArrayList<EnemyCharacteristics> eList) {
		inventory.attackArrow(dungeon, this, eList);
	}
	
	public void placeBomb(Square[][] dungeon, Player player) {
		inventory.attackBomb(dungeon, this);
		
	}
	
}
