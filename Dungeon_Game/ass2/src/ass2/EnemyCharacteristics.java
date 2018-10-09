 package ass2;

public abstract class EnemyCharacteristics {
	
	protected String name;
	protected int xCoord;
	protected int yCoord;
	
	public String getName() {
		return this.name;
	}
	
	public boolean equals(EnemyCharacteristics ec) {
		return(ec.getName() == this.name);
	}
	
	public int getxCoord() {
		return xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}
	
	public abstract boolean checkCollision(Player p);
	
	public abstract void move(int x, int y, Square s);

	public abstract void movement(Player p, Square[][] s);
}
