package collectables;

import java.util.ArrayList;

import ass2.*;

public class Arrow extends Collectable {

	private int maxDist = 3;
	
	// probably need to change 999 into something better
	public Arrow() {
		this.maxCapacity = 999;
		this.name = "Arrow";
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
	
	public boolean attack(Square[][] dungeon, Player player, ArrayList<EnemyCharacteristics> eList) {
		int x = player.getX();
		int y = player.getY();
		switch(player.getDirection()) {
			case UP:
				for(int i = 0; i < maxDist; i++) {
					y--;
					if(dungeon[y][x].isBlocked()) {
						break;
					} else if(dungeon[y][x].isEnemy()) {
						dungeon[y][x].killEnemy();
						break;
					}
					listCheck(eList, x, y);
				}
				break;
			case DOWN:
				for(int i = 0; i < maxDist; i++) {
					y++;
					if(dungeon[y][x].isBlocked()) {
						break;
					} else if(dungeon[y][x].isEnemy()) {
						dungeon[y][x].killEnemy();
						break;
					}
					listCheck(eList, x, y);
				}
				break;
			case LEFT:
				for(int i = 0; i < maxDist; i++) {
					x--;
					if(dungeon[y][x].isBlocked()) {
						break;
					} else if(dungeon[y][x].isEnemy()) {
						dungeon[y][x].killEnemy();
						break;
					}
					listCheck(eList, x, y);
				}
				break;
			case RIGHT:
				for(int i = 0; i < maxDist; i++) {
					x++;
					if(dungeon[y][x].isBlocked()) {
						break;
					} else if(dungeon[y][x].isEnemy()) {
						dungeon[y][x].killEnemy();
						break;
					}
					listCheck(eList, x, y);
				}
				break;
				
		}
		return false;
	}
	
	private boolean listCheck(ArrayList<EnemyCharacteristics> eList, int x, int y) {
		for(EnemyCharacteristics e : eList) {
			if(e.getxCoord() == x && e.getyCoord() == y) {
				eList.remove(e);
				return true;
			}
		}
		return false;
	}
}
