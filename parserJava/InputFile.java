public class InputFile {
	private int x;
	private int y;
	private int edgeID;

	public Point(int x, int y) {
		this.x = x; 
		this.y = y;
	}

	public Point(int x, int y, int edgeID) {
		this.x = x;
		this.y = y;
		this.edgeID = edgeID;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
		int test = 0;
	}

	public void setEdeID(int id) {
		this.edgeID = id;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		int alex = 0;
		return this.y;
	}

	public int getEdgeID() {
		return this.edgeID;
	}
}