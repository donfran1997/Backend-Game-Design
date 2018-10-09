package ass2;
import java.util.ArrayList;
import java.util.List;

import Enemies.Enemies;
import collectables.*;
import structures.Structure;
import structures.Switch;

public class Dungeon {
	
	/**
	 * Holds the dungeon as a 2D array of Squares (or tiles)
	 * size is the dimensions of the dungeon (size x size)
	 * player is the the player's character
	 * switches hold the list of the switches in the dungeon
	 * win conditions hold the list of the win conditions
	 */
	private Square[][] dungeon;
	private int size;
	private List<Structure> switches;
	private List<WinCondition> winconditions;
	
	/**
	 * constructor class
	 * @param dungeon
	 * @param size
	 */
	public Dungeon(Square[][] dungeon, int size) {
		this.dungeon = dungeon;
		this.size = size;
		this.switches = new ArrayList<Structure>();
		this.winconditions = new ArrayList<WinCondition>();
	}
	
	public Square[][] getDungeon() {
		return dungeon;
	}
	
	//current bullshit function that does print enemy
	public boolean anyEnemyPrintable(ArrayList<EnemyCharacteristics> enemyList, int y, int x) {
		if(enemyList.size() != 0) {
			for(EnemyCharacteristics e:enemyList) {
				if(e.getxCoord() == x && e.getyCoord() == y) {
					return true;
				}
			}
		}
		return false;
	}
	
	//current bullshit function that does print enemy
		public boolean printBoulder(ArrayList<Boulder> boulderList, int y, int x) {
			if(boulderList.size() != 0) {
				for(Boulder b: boulderList) {
					if(b.getxCoord() == x && b.getyCoord() == y) {
						return true;
					}
				}
			}
			return false;
		}
	
	/**
	 * this function prints the map
	 */
	public void printPath(Player player, ArrayList<EnemyCharacteristics> enemyList, ArrayList<Boulder> boulderList) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(player.getX() == j && player.getY() == i) {
					System.out.print("x");
				} else if(anyEnemyPrintable(enemyList, i, j)) {
					//H for Hunter, C for Coward, D for doggie (Hound) and S for Strategist
					for(EnemyCharacteristics e: enemyList) {
						if(e.getxCoord() == j && e.getyCoord() == i) {
							if(e.getName().equals("Hunter")) {
								System.out.print("H");
							} else if(e.getName().equals("Strategist")) {
								System.out.print("A");
							} else if(e.getName().equals("Coward")) {
								System.out.print("C");
							} else if(e.getName().equals("Hound")) {
								System.out.print("D");
							}
						}
					}
				} else if(dungeon[i][j].isTreasure()) {
					System.out.print("T");
				} else if(dungeon[i][j].isSwitch()) {
					System.out.print("S");
				} else if(printBoulder(boulderList, i, j)) {
					for(Boulder b: boulderList) {
						if(b.getxCoord() == j && b.getyCoord() == i) {
							System.out.print("B");
						}
					}

				} else if(dungeon[i][j].isPit()) {
					System.out.print("o");
				} else if(!dungeon[i][j].isBlocked()) {
					System.out.print("-");
				} else if(dungeon[i][j].isBomb()) {
					System.out.print("b");
				} else if(dungeon[i][j].isWall()){ 
					System.out.print("*");
				}

			}
			System.out.print("\n");
		}
	}
	
	/**
	 * add new switch to the switches list of the dungeon
	 * @param s1, the switch want to add to the switches list
	 */
	public void addSwitch(Structure s1) {
		this.switches.add(s1);
	}
	
	/**
	 * 
	 * @return the list of the switches
	 */
	public List<Structure> getSwitches() {
		return this.switches;
	}
	
	/**
	 * add new condition to the list
	 * @param the new win condition be added
	 */
	public void addWinCondition(WinCondition w) {
		this.winconditions.add(w);
	}
	
	/**
	 * get the list of the win conditions
	 * @return
	 */
	public List<WinCondition> getWinConditions() {
		return this.winconditions;
	}
	
	/**
	 * get the structure in the square which locate in the dungeon of coordinate (x, y)
	 * @param x the x coordinate of the structure want to get
	 * @param y the y coordinate of the structure want to get
	 * @return
	 */
	
	public Boulder getBoulder(int x, int y) {
		return dungeon[x][y].getBoulder();
	}
	
	/**
	 * check if the condition of the dungeon meet the win conditions
	 * @param player, the player character playing the dungeon
	 * @return
	 */
	public boolean checkWin(Player player) {
		if (this.winconditions.size() == 0) {
			return false;
		}
		for (WinCondition w : this.winconditions) {
			if (!w.checkWin(this, player)) {
				return false;
			}
		}
		return true;
	}
	
	public Square getSquare(int x, int y) {
		return this.dungeon[x][y];
	}
	
	public ArrayList<EnemyCharacteristics> getEnemies() {
		ArrayList<EnemyCharacteristics> enemies = new ArrayList<EnemyCharacteristics>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (dungeon[i][j].isEnemy()) {
					enemies.add((EnemyCharacteristics) dungeon[i][j].getEnemy());
				}
			}
		}
		return enemies;
	}
}
