package ass2;

import java.util.ArrayList;

import collectables.*;

/**
 * A class holding all the items the player has picked up
 */

// will need to rework/refactor with the new entities

public class Inventory {
	
	private ArrayList<Entity> inventory;
	private  static int swordNum = 0;
	private static int arrowNum = 0;
	private static int treasureNum = 0;
	private static int bombNum = 0;
	private static int keyNum = 0;
	
	/**
	 * Constructor
	 */
	public Inventory() {
		inventory = new ArrayList<Entity>();
	}
	
	 //getters here
	
	public int getSwordNum() {
		return this.swordNum;
	}
	
	public int getArrowNum() {
		return this.arrowNum;
	}
	public int getTreasureNum() {
		return this.treasureNum;
	}
	
	public int getBombNum() {
		return this.bombNum;
	}
	
	public int getKeyNum() {
		return this.keyNum;
	}
	
	/**
	 * Adds an item to the inventory, checks if the inventory can hold any more of the given item
	 * @param item the item to be added
	 */
	public void addItem(Entity item) {
		inventory.add(item);
		String name = item.getName();
		switch (name) {
			case "Sword":
				swordNum++;
				break;
			case "Arrow":
				arrowNum++;
				break;
			case "Treasure":
				treasureNum++;
				break;
			case "Bomb":
				bombNum++;
				break;
			case "Key":
				keyNum++;
				break;
		}
	}
	
	/**
	 * Removes an item from inventory, first checks if the inventory has the item 
	 * @param item the item to be removed
	 */
	public void removeItem(Entity item) {
		if(!isEmpty(item)) {
			inventory.remove(item);
			String name = item.getName();
			switch (name) {
				case "Sword":
					swordNum--;
					break;
				case "Arrow":
					arrowNum--;
					break;
				case "Treasure":
					treasureNum--;
					break;
				case "Bomb":
					bombNum--;
					break;
				case "Key":
					keyNum--;
					break;
			}
		}
	}
	
	/**
	 * Checks if there is any of a given item in the inventory
	 * @param item
	 * @return
	 */
	public boolean isEmpty(Entity item) {
		return (!inventory.contains(item));
	}
	
	/**
	 * returns the number of a given item currently in the inventory
	 * @param item
	 * @return
	 */
	public int getNumItem(Entity item) {
		int numItem = 0;
		for(Entity e : inventory) {
			if(item.equals(e)) {
				numItem++;
			}
		}
		return numItem;
	}
	
	/**
	 * returns an item of a given type
	 * @param item
	 * @return
	 */
	public Entity getItem(String item) {
		for(Entity e : inventory) {
			if(item.equals(e)) {
				return e;
			}
		}
		return null;
	}
	
	/**
	 * finds the a sword in the inventory and attacks a square
	 * will remove sword from inventory if it breaks
	 * @param s
	 */
	public void attackSword(Square s, ArrayList<EnemyCharacteristics> eList, int x, int y) {
		for(Entity e : inventory) {
			if(e instanceof Sword) {
				if(((Sword) e).attack(s, eList, x, y)) {
					inventory.remove(e);
				}
				break;	
			}
		}	
	}
	
	public void attackArrow(Square[][] dungeon, Player player, ArrayList<EnemyCharacteristics> eList) {
		for(Entity e : inventory) {
			if(e instanceof Arrow) {
				((Arrow) e).attack(dungeon, player, eList);
				inventory.remove(e);
				break;
			}
		}		
	}
	
	public void attackBomb(Square[][] dungeon, Player player) {
		for(Entity e : inventory) {
			if(e instanceof Bomb) {
				((Bomb) e).placeBomb(dungeon,player);
				inventory.remove(e);
				break;
			}
		}
	}
	
	public void reset() {
		inventory.clear();
		keyNum = 0;
		bombNum = 0;
		arrowNum = 0;
		swordNum = 0;
	}
	
	public void printInventory() {
		System.out.print("Inventory: ");
		for(Entity e : inventory) {
			System.out.print(e + ", ");
		}
		System.out.print("\n");
	}

	
}