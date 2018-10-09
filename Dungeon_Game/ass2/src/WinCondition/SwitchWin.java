package WinCondition;


import java.util.ArrayList;
import java.util.List;

import ass2.Dungeon;
import ass2.Player;
import ass2.WinCondition;
import structures.Structure;
import structures.Switch;

public class SwitchWin extends WinCondition {
	
	public SwitchWin() {
		
	}
	
	/**
	 * get the switches list from the dungeon
	 * if all the switch's top has a boulder, then means all the switches been activated, return true
	 * otherwise, return false
	 */
	@Override
	public boolean checkWin(Dungeon d, Player player) {
		// TODO Auto-generated method stub
		ArrayList<Structure> switches = (ArrayList<Structure>) d.getSwitches();
		
		for (Structure s : switches) {
			if (d.getBoulder(((Switch) s).getX(), ((Switch) s).getY()) == null) {
				return false;
			}
			
			if (!d.getBoulder(((Switch) s).getX(), ((Switch) s).getY()).getName().equals("Boulder")) {
				return false;
			}
		}
		return true;
	}
	
}
