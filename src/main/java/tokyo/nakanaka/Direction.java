package tokyo.nakanaka;

public enum Direction {
	NORTH("north", 0, 0, - 1),
	SOUTH("south", 0, 0, 1),
	EAST("east", 1, 0, 0),
	WEST("west", -1, 0, 0),
	UP("up", 0, 1, 0),
	DOWN("down", 0, -1, 0);
	
	private String name;
	private int dx;
	private int dy;
	private int dz;
	
	private Direction(String name, int dx, int dy, int dz) {
		this.name = name;
		this.dx = dx;
		this.dy = dy;
		this.dz = dz;
	}
	
	public int getX() {
		return this.dx;
	}
	
	public int getY() {
		return this.dy;
	}
	
	public int getZ() {
		return this.dz;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
