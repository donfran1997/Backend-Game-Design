package Enemies;

import ass2.EnemyCharacteristics;
import ass2.Player;
import ass2.Square;

public abstract class Enemies extends EnemyCharacteristics{
	public abstract void move(int x, int y, Square s);

	public abstract void movement(Player p, Square[][] s);
	
	public abstract boolean checkCollision(Player p);
}
