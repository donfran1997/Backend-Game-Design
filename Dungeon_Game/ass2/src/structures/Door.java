package structures;

import ass2.Player;
import collectables.Key;

public class Door extends Structure {
	
	private static int doorID = 0;
	private boolean state;
	
	public Door () {
		this.name = "Door";
		this.doorID++;
		this.state = false;
	}
	
	@Override
	public boolean isBlocked() {
		// TODO Auto-generated method stub
		if (this.state) {
			return false;
		}
		return true;
	}
	

	/**
	 * using key to open the door, if successfully open it, return true
	 * otherwise, return false
	 * @param key, the key be used to open the door
	 * @return
	 */
	public boolean openDoor(Key key) {
		if (this.doorID == key.getID()) {
			this.state = true;
			return true;
		}
		return false;
	}


}
