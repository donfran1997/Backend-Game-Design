package ass2;

import java.util.ArrayList;
import structures.Structure;

public class Square {
	
	/*
	 * not sure if entities and structures shold be arraylist or just a single
	 * object. 
	 * there should only be 1 collectable/item or potion or pit or exit on a single square
	 * same as pit, boulder and wall
	 * 
	 * can change to arraylists if needed
	 */
	
	private Entity entity;
	private Structure structure; 
	private EnemyCharacteristics enemy;
	private Boulder boulder;
	
	public Square() {
		this.entity = null;
		this.structure = null;
		this.enemy = null;
		this.boulder = null;
	}
	
	public void addEntity(Entity e) {
		entity = e;
	}
	
	public void removeEntity() {
		entity = null;
	}
	
	public void addStructure(Structure s) {
		structure = s;
	}
	
	public void removeStructure() {
		structure = null;
	}
	
	public void addEnemy(EnemyCharacteristics e) {
		enemy = e;
	}
	
	public void killEnemy() {
		System.out.println("WORKS");
		enemy = null;
	}
	
	public void addBoulder(Boulder b) {
		boulder = b;
	}
	
	public void removeBoulder() {
		boulder = null;
	}
	
	public boolean isBlocked() {
		if(structure == null) return false;
		return structure.isBlocked();
	}
	
	public boolean doAction(Player player) {
		if(entity == null) return false;
		return entity.doAction(player);
	}
	
	public Entity getEntity() {
		return entity;
	}
	
	public Structure getStructure() {
		return structure;
	}
	
	public EnemyCharacteristics getEnemy() {
		return enemy;
	}
	
	public Boulder getBoulder() {
		return boulder;
	}
	
	public boolean isEnemy() {
		if (enemy != null) {
			return true;
		}
		return false;
	}
	
	
	//for testing
	/**
	 * show simple simple in the square represent for each entity
	 * @return
	 */
	public boolean isTreasure() {
		if (entity != null && entity.getName().equals("Treasure")) {
			return true;
		}
		return false;
	}
	
	public boolean isSwitch() {
		if (structure != null && structure.getName().equals("Switch")) {
			return true;
		}
		return false;
	}
	
	public boolean isBoulder() {
		if (boulder != null && boulder.getName().equals("Boulder")) {
			return true;
		}
		return false;
	}
	
	public boolean isWall() {
		if(structure != null && structure.getName().equals("Wall")) {
			return true;
		}
		return false;
	}
	
	public boolean isPit() {
		if(entity != null && entity.getName().equals("Pit")) {
			return true;
		}
		return false;
	}
	
	public boolean isBomb() {
		if(entity != null && entity.getName().equals("Bomb")) {
			return true;
		}
		return false;
	}
}
