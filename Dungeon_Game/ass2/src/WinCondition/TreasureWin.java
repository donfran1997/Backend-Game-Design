package WinCondition;

import ass2.Dungeon;
import ass2.Player;
import ass2.WinCondition;

public class TreasureWin extends WinCondition {
	
	private int treasureNum;
	
	/**
	 * 
	 * @param num, set the number of treasure need to collect to meet the win condition
	 */
	public TreasureWin(int num) {
		this.treasureNum = num;
	}
	
	/**
	 * if the number of treasure be set equal to the number of treasure in player's inventory, return true
	 * otherwise, return false
	 */
	@Override
	public boolean checkWin(Dungeon d, Player player) {
		// TODO Auto-generated method stub
		if (this.treasureNum == player.getInventory().getTreasureNum()) {
			return true;
		}
		return false;
	}
}
