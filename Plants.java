
public abstract class Plants {
	public int health = 100;
	public int y;
	public int x;
	public Panel gp;
	public Plants(GamePanel parent, int x, int y) {
		this.x = x;
		this.y = y;
		gp = parent;
		
	}
	public void Stop() {}

}
