package structures;

public class Switch extends Structure{
	
	private int switchXCoord;
	private int switchYCoord;

	
	public Switch (int x, int y) {
		this.name = "Switch";
		this.switchXCoord = x;
		this.switchYCoord = y;
	}
	
	
	/**
	 * player can always go through the switch
	 */
	@Override
	public boolean isBlocked() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int getX() {
		return this.switchXCoord;
	}
	
	public int getY() {
		return this.switchYCoord;
	}
	
}
