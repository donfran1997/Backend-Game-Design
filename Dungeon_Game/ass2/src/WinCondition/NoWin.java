package WinCondition;

import ass2.Dungeon;
import ass2.Player;
import ass2.WinCondition;

public class NoWin extends WinCondition {

	public boolean checkWin(Dungeon d, Player player) {
		return false;
	}

}
