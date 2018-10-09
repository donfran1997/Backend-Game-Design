package ass2;

import java.util.ArrayList;
import java.util.Scanner;

import Enemies.Coward;
import Enemies.Hound;
import Enemies.Hunter;
import Enemies.Strategist;
import WinCondition.EnemiesWin;
import WinCondition.ExitWin;
import WinCondition.SwitchWin;
import WinCondition.TreasureWin;
import collectables.Arrow;
import collectables.Bomb;
import collectables.Sword;
import collectables.Treasure;
import consumables.HoverPotion;
import exits.Pit;
import structures.NoStructure;
import structures.Structure;
import structures.Switch;
import structures.Wall;

/**
 * The main dungeon system orchestrates the game?
 * Should add start game function etc
 */
public class DungeonSystem {
	
	
	private Dungeon dungeon;
	private Player player;
	
	public DungeonSystem() {
		this.player = new Player();
	}
	
	public DungeonSystem(Square[][] dungeon, int size) {
		this.dungeon = new Dungeon(dungeon, size);
		this.player = new Player();
	}
	
	public void addDungeon(Square[][] dungeon, int size) {
		this.dungeon = new Dungeon(dungeon, size);
	}
	
	public Square[][] generateEmpty(int size) {
		 Square[][] map = new Square[size][size]; 
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				map[i][j] = new Square();
			}
		}
		
		Structure wall = new Wall();
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(i == 0 || i == size-1 || j == 0 || j == size-1) {
					map[i][j].addStructure(wall);
				}
			}
		}
		return map;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public void addSwitches(Structure s) {
		this.dungeon.addSwitch(s);
	}
	
	public void addWinCondition(WinCondition w) {
		this.dungeon.addWinCondition(w);
	}
	
	public boolean checkWin() {
		return this.dungeon.checkWin(this.player);
	}
	
	public static void main(String[] args) {
		/**
		 * this creates testing dungeon. It instnatiates each square and adds it to the dungeon
		 * m = vertical height 
		 * n = horizontal length
		 */
		int m = 7;
		boolean alive = true;
		Square[][] map = new Square[m][m];
		
		//instantiating objects to put on squares
		Structure wall = new Wall();
		Structure empty = new NoStructure();
		Entity treasure = new Treasure();
		Entity sword = new Sword();
		Entity arrow = new Arrow();
		Entity pit = new Pit();
		Entity hover = new HoverPotion();
		Entity bomb = new Bomb();
		ArrayList<EnemyCharacteristics> eList = new ArrayList<EnemyCharacteristics>();
		ArrayList<Boulder> bList = new ArrayList<Boulder>();
		EnemyCharacteristics e = new Coward(4, 5);

		//EnemyCharacteristics e = new Hound(4, 5);
		//EnemyCharacteristics e1 = new Strategist(3,3);
		//eList.add(e);
		//eList.add(e1);
		Structure s1 = new Switch(2, 2);
		Structure s2 = new Switch(4, 4);
		Structure s3 = new Switch(1, 4);
//		
		Boulder b1 = new Boulder(4, 2);
		Boulder b2 = new Boulder(4, 3);
		Boulder b3 = new Boulder(3, 4);
		bList.add(b1);
		bList.add(b2);
		bList.add(b3);
		//bList.add(b2);
		//bList.add(b3);

		//intialises
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = new Square();
				map[i][j].addStructure(empty);  //adds "empty structure" to every square
				//map[i][j].addEntity(treasure);  //adds treasure to every square
			}
		}
		map[2][1].removeEntity();
		map[3][1].removeEntity();
		//map[2][1].addEntity(arrow);
		//map[3][1].addEntity(pit);
		//map[1][2].addEntity(hover);

//		map[4][1].addEntity(sword);
//		map[4][2].addEntity(sword);
		//map[1][1].addEntity(treasure);
		//map[4][3].addEntity(treasure);
		
		
		map[2][2].addStructure(s1);
		map[4][4].addStructure(s2);
		map[1][4].addStructure(s3);
//		
//		map[1][2].addStructure(b);
//		map[2][3].addStructure(b);
//		map[3][4].addStructure(b);
		
		//map[4][5].addEnemy(e);
		//map[3][3].addEnemy(e1);

//		map[1][5].addEnemy(e);
//		map[4][3].addEnemy(e);
		map[1][2].addEntity(bomb);
		
		//map[1][4].addStructure(wall);
		//map[4][4].addEntity(treasure);
		
		//adds a border
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < m; j++) {
				if(i == 0 || i == m-1 || j == 0 || j == m-1) {
					map[i][j].addStructure(wall);
				}
			}
		}
		
		

		DungeonSystem sys = new DungeonSystem(map, m);
		sys.dungeon.printPath(sys.player, eList, bList);
		
		//addSwitches to dungeon
		sys.dungeon.addSwitch(s1);
		sys.dungeon.addSwitch(s2);
		sys.dungeon.addSwitch(s3);
		
		
		//add wincondition
		//WinCondition exitLocation = new ExitWin(m-2, m-2);
		//WinCondition switchWin = new SwitchWin();
		WinCondition enemiesWin = new EnemiesWin();
		//WinCondition treasureWin = new TreasureWin(2);
		//sys.dungeon.addWinCondition(treasureWin);
		//sys.dungeon.addWinCondition(switchWin);
		//sys.dungeon.addWinCondition(exitLocation);
		sys.dungeon.addWinCondition(enemiesWin);
		
		Scanner sc = new Scanner(System.in);
		
		/**
		 * takes players input (currently only directions to move)
		 * type "u" + enter to move up, "d"+ enter to move down, "l", "r" etc
		 */
		while(true) {
//			if(treasureWin.checkWin(sys.dungeon, sys.player) == true) {
//				System.out.println("WINNER WINNER CHICKEN DINNER");
//				break;
//			}
			
//			if(switchWin.checkWin(sys.dungeon, sys.player)) {
//				System.out.println("WINNER WINNER CHICKEN DINNER");
//				break;
//			}
			if (sys.dungeon.checkWin(sys.player)) {
				System.out.println("WINNER WINNER CHICKEN DINNER");
				break;
			}
			
			for(EnemyCharacteristics ec: eList) {
				if(ec.checkCollision(sys.player)) {
					System.out.println("YOU DIED");
					alive = false;
					break;
				}
			}
			
			if(!alive) {
				break;
			}
			
			String input = sc.nextLine();
			switch(input.charAt(0)) {
				case 'u':
					sys.player.moveUp(sys.dungeon.getDungeon());
					break;
				case 'd':
					sys.player.moveDown(sys.dungeon.getDungeon());
					break;
				case 'l':
					sys.player.moveLeft(sys.dungeon.getDungeon());
					break;
				case 'r':
					sys.player.moveRight(sys.dungeon.getDungeon());
					break;
				case 'a':
					sys.player.attackSword(sys.dungeon.getDungeon(), eList);
					break;
				case 's':
					sys.player.attackArrow(sys.dungeon.getDungeon(), sys.player, eList);
				case 'b':
					sys.player.placeBomb(sys.dungeon.getDungeon(), sys.player);
			}
			
			//e.movement(sys.player, sys.dungeon.getDungeon())
			//e1.movement(sys.player, sys.dungeon.getDungeon());
			//((Hunter) e).enemyPosition(sys.player);
			sys.dungeon.printPath(sys.player, eList, bList);
			sys.player.printInventory();
//			System.out.println(sys.dungeon.getDungeon()[sys.player.getY()][sys.player.getX()].isEnemy());
//			System.out.println("X: " + sys.player.getX() + " Y: " + sys.player.getY());
		}
		
	}
}
