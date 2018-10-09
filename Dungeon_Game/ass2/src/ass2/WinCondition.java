package ass2;

public abstract class WinCondition {

	/**
	 * check if the player meet the win condition or not
	 * @param d, the dungeon
	 * @param palyer, the player character plays the dungeon
	 * @return
	 */
	public abstract boolean checkWin(Dungeon d, Player palyer);
}
