package structures;

public class NoStructure extends Structure {

	public NoStructure () {
		name = "null";
	}
	@Override
	public boolean isBlocked() {
		return false;
	}


}
