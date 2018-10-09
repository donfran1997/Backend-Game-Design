package consumables;

import ass2.Player;
import ass2.Status;

public class HoverPotion extends Consumable {

	public HoverPotion() {
		this.name = "HoverPotion";
	}
	
	@Override
	public boolean doAction(Player player) {
		player.setStatus(Status.HOVER);
		return true;
	}

}
