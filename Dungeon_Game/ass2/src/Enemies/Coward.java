package Enemies;

import ass2.EnemyCharacteristics;
import ass2.Player;
import ass2.Square;

public class Coward extends EnemyCharacteristics{
	
	public Coward(int y, int x) {
		this.name = "Coward";
		this.xCoord = x;
		this.yCoord = y;
	}

	@Override
	public void move(int x, int y, Square s) {
		if(!s.isBlocked()) {
			this.xCoord = x;
			this.yCoord = y;
		}
	}

	@Override
	public void movement(Player p, Square[][] s) {
		int xDist, yDist, distFromP;
		xDist = this.xCoord - p.getX();
		yDist = this.yCoord - p.getY();
		distFromP = xDist*xDist + yDist*yDist;
		distFromP = (int) Math.sqrt(distFromP);
		if (distFromP <= 3) {
			if(yDist > xDist) {
				if(yDist >= 0) {
					move(xCoord, yCoord +1, s[yCoord +1][xCoord]);
				} else if(yDist < 0) {
					move(xCoord, yCoord -1, s[yCoord -1][xCoord]);
				} 
			} else if (xDist > yDist) {
				if(xDist > 0) {
					move(xCoord + 1, yCoord, s[yCoord][xCoord + 1]);
				} else if(xDist < 0) {
					move(xCoord - 1, yCoord, s[yCoord][xCoord -1]);
				}
			} else if (xDist == 0 && yDist != 0) {
				int randomNumber = (int)(Math.random() % 2);
				if(randomNumber == 0) {
					if(xDist > 0) {
						move(xCoord + 1, yCoord, s[yCoord][xCoord + 1]);
					} else {
						move(xCoord - 1, yCoord, s[yCoord][xCoord - 1]);
					}
				} else {
					if(yDist > 0) {
						move(xCoord, yCoord + 1, s[yCoord + 1][xCoord]);
					} else {
						move(xCoord, yCoord - 1, s[yCoord - 1][xCoord]);
					}
				}
			} else if (yDist == 0 && xDist != 0) {
				int randomNumber = (int)(Math.random() % 2);
				if(randomNumber == 0) {
					if(yDist > 0) {
						move(xCoord, yCoord + 1, s[yCoord + 1][xCoord]);
					} else {
						move(xCoord, yCoord - 1, s[yCoord - 1][xCoord]);
					}
				} else {
					if(xDist > 0) {
						move(xCoord + 1, yCoord, s[yCoord][xCoord + 1]);
					} else {
						move(xCoord - 1, yCoord, s[yCoord][xCoord - 1]);
					}
				}
			} else {
				int randomNumber = (int)(Math.random() % 2);
				if(randomNumber == 0) {
					if(xDist > 0) {
						move(xCoord + 1, yCoord, s[yCoord][xCoord + 1]);
					} else {
						move(xCoord - 1, yCoord, s[yCoord][xCoord -1]);
					}
				} else {
					if(yDist > 0) {
						move(xCoord, yCoord +1, s[yCoord +1][xCoord]);
					} else {
						move(xCoord, yCoord -1, s[yCoord -1][xCoord]);
					}
				}
			}
		} else if(yDist > xDist && (yDist != 0 && xDist != 0)) {
			if(yDist > 0) {
				move(xCoord, yCoord - 1, s[yCoord - 1][xCoord]);
			} else {
				move(xCoord, yCoord + 1, s[yCoord + 1][xCoord]);
			}
		} else if (xDist > yDist && (yDist != 0 && xDist != 0)){
			if(xDist > 0) {
				move(xCoord - 1, yCoord, s[yCoord][xCoord - 1]);
			} else {
				move(xCoord + 1, yCoord, s[yCoord][xCoord + 1]);
			}
		} else if(yDist == 0 && xDist != 0) {
			if(xDist > 0) {
				move(xCoord - 1, yCoord, s[yCoord][xCoord -1]);
			} else {
				move(xCoord + 1, yCoord, s[yCoord][xCoord + 1]);
			}
		} else if(xDist == 0 && yDist != 0) {
			if(yDist > 0) {
				move(xCoord, yCoord - 1, s[yCoord - 1][xCoord]);
			} else {
				move(xCoord, yCoord + 1, s[yCoord + 1][xCoord]);
			}
		} else if(xDist == yDist && (xDist != 0 && yDist != 0)) {
			int randomNumber = (int)(Math.random() % 2);
			if(randomNumber == 0) {
				if(xDist > 0) {
					move(xCoord - 1, yCoord, s[yCoord][xCoord - 1]);
				} else {
					move(xCoord + 1, yCoord, s[yCoord][xCoord + 1]);
				}
			} else if (randomNumber == 1) {
				if(yDist > 0) {
					move(xCoord, yCoord - 1, s[yCoord - 1][xCoord]);
				} else {
					move(xCoord, yCoord + 1, s[yCoord + 1][xCoord]);
				}
			}
		}
		checkCollision(p);
	}

	@Override
	public boolean checkCollision(Player p) {
		if(p.getX() == this.xCoord && p.getY() == this.yCoord) {
			return true;
		}
		return false;
	}

}
