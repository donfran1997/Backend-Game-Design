package WinCondition;

import java.util.ArrayList;

import Enemies.Enemies;
import ass2.Dungeon;
import ass2.EnemyCharacteristics;
import ass2.Player;
import ass2.WinCondition;

public class EnemiesWin extends WinCondition{

	@Override
	public boolean checkWin(Dungeon d, Player player) {
		// TODO Auto-generated method stub
		ArrayList<EnemyCharacteristics> enemies = d.getEnemies();
		if (enemies.size() == 0) {
			return true;
		}
		return false;
	}

}
