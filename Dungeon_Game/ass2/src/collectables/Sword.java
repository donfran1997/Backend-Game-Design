package collectables;

import java.util.ArrayList;

import ass2.EnemyCharacteristics;
import ass2.Player;
import ass2.Square;

public class Sword extends Collectable {
	
	private int durability = 5;
	
	public Sword() {
		this.maxCapacity = 1;
		this.name = "Sword";
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

	
	
	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	/**
	 * attacks a given square and kills an enemy if present
	 * @param s
	 * @return true = sword has run out of durability and broken, false = not broken
	 */
	public boolean attack(Square s, ArrayList<EnemyCharacteristics> eList, int x, int y) {
		if(s.isEnemy()) {
			s.killEnemy();
			durability--;
			if(durability <= 0) {
				return true;
			}
		}
		
		for(EnemyCharacteristics e : eList) {
			if(e.getxCoord() == x && e.getyCoord() == y) {
				eList.remove(e);
				durability--;
				if(durability <= 0) {
					return true;
				}
				break;
			}
			
		}
		return false;
	}
	
}
