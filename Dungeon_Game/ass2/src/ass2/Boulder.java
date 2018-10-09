package ass2;

import ass2.Player;

public class Boulder {
	
	private String name;
	private int xCoord;
	private int yCoord;
	
	public Boulder(int x, int y) {
		this.name = "Boulder";
		this.xCoord = x;
		this.yCoord = y;
	}

	public String getName() {
		return name;
	}

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	
	public boolean move(int x, int y,Square s) {
		if(!s.isBlocked()) {
			this.xCoord = x;
			this.yCoord = y;
			return true;
		}
		return false;
	}
	
	public void printBoulder() {
		System.out.println("BOULDER AT: " + " y: " + this.yCoord + " x: " + this.xCoord);
	}
	
//	public void movement(Player p, Square[][] next) {
//		int x, y;
//		x = this.xCoord; y = this.yCoord;
//		
//
//		if (checkCoord(p)) {
//			if (p.getDirection().equals(Direction.RIGHT)) {
//				if (checkBlock(next)) {
//					p.move(x-1, y, next[x-1][y]);
//				}
//				move(x+1, y, next[x+1][y]);
//			} else if (p.getDirection().equals(Direction.LEFT)) {
//				if (checkBlock(next)) {
//					p.move(x+1, y, next[x+1][y]);
//				}
//				move(x-1, y, next[x-1][y]);
//			} else if (p.getDirection().equals(Direction.UP)) {
//				if (checkBlock(next)) {
//					p.move(x, y+1, next[x][y+1]);
//				}
//				move(x, y-1, next[x][y-1]);
//			} else if (p.getDirection().equals(Direction.DOWN)) {
//				if (checkBlock(next)) {
//					p.move(x, y-1, next[x][y-1]);
//				}
//				move(x, y+1, next[x][y+1]);
//			}
//		}
//	}
	
	public void movement(Player p, Square[][] next) {
		int x, y;
		x = this.xCoord; y = this.yCoord;
		if (checkCoord(p)) {
			if (p.getDirection().equals(Direction.RIGHT)) {
				if (checkBlock(next)) {
					p.move(x-1, y, next[x-1][y]);
				}
				if (move(x+1, y, next[x+1][y])) {
					next[x][y].removeBoulder();
					next[x+1][y].addBoulder(this);
				}
			} else if (p.getDirection().equals(Direction.LEFT)) {
				if (checkBlock(next)) {
					p.move(x+1, y, next[x+1][y]);
				}
				if (move(x-1, y, next[x-1][y])) {
					next[x][y].removeBoulder();
					next[x-1][y].addBoulder(this);
				}
				
			} else if (p.getDirection().equals(Direction.UP)) {
				if (checkBlock(next)) {
					p.move(x, y+1, next[x][y+1]);
				}
				if (move(x, y-1, next[x][y-1])) {
					next[x][y].removeBoulder();
					next[x][y-1].addBoulder(this);
				}
			} else if (p.getDirection().equals(Direction.DOWN)) {
				if (checkBlock(next)) {
					p.move(x, y-1, next[x][y-1]);
				}
				if (move(x, y+1, next[x][y+1])) {
					next[x][y].removeBoulder();
					next[x][y+1].addBoulder(this);
				}
			}
		}
	}
	
	
	
	public boolean checkBlock(Square[][] s) {
		int x, y;
		x = this.xCoord; y = this.yCoord;
		Square right = s[x+1][y];
		Square left = s[x-1][y];
		Square up = s[x][y-1];
		Square down = s[x][y+1];
		
		if (right.isBlocked()) {
			return true;
		} 
		else if (left.isBlocked()) {
			return true;
		}
		else if (up.isBlocked()) {
			return true;
		}
		else if (down.isBlocked()) {
			return true;
		}
		
		return false;
	}
	
	
	public boolean checkCoord(Player p) {
		if (p.getX() == this.xCoord && p.getY() == this.yCoord) {
			return true;
		}
		return false;
	}
	
}
