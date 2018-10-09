package WinCondition;

import ass2.Dungeon;
import ass2.Player;
import ass2.WinCondition;

public class ExitWin extends WinCondition {

	private int xWinCoord;
	private int yWinCoord;
	
	/**
	 * 
	 * @param xWinCoord, the x coordinate of the exit
	 * @param yWinCoord, the y coordinate of the exit
	 */
	public ExitWin(int xWinCoord, int yWinCoord) {
		this.xWinCoord = xWinCoord;
		this.yWinCoord = yWinCoord;
	}
	
	/**
	 * get the player's position, if the player's position is the same as the position of the exit
	 * which means it meet the requirement of win condition, return true
	 * otherwise, return false
	 */
	@Override
	public boolean checkWin(Dungeon d, Player player) {
		if((this.xWinCoord == player.getX()) && this.yWinCoord == player.getY()) {
			return true;
		}
		return false;
	}

}
