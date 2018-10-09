package collectables;

import ass2.Player;

public class Treasure extends Collectable {
	
	public Treasure() {
		this.maxCapacity = 999;
		this.name = "Treasure";
	}

	@Override
	public boolean doAction(Player player) {
		player.addItem(this);
		return true;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	
}
