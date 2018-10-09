package collectables;

import ass2.Player;

public class Key extends Collectable {
	private static int id = 0;
	
	public Key() {
		this.maxCapacity = 1;
		this.name = "Key";
		this.id++;
	}
	
	@Override
	public boolean doAction(Player player) {
		if(player.getNumItem(this) < maxCapacity) {
			player.addItem(this);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	public int getID() {
		return this.id;
	}
}
