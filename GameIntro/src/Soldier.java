
public class Soldier extends Sprite {

	static String[] poses = { "up", "dn", "lt", "rt"};
	
	public Soldier(int x, int y, int z, int w, int h)
	{
		super(x, y, z, w, h, "g", poses, 5, 10);
	}

}
