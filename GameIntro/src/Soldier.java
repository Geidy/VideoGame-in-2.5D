public class Soldier extends Sprite
{
	static String[] poses = { "up", "dn", "lt", "rt"};
	
	public Soldier(int x, int y)
	{
		super(x, y, "g", poses, 5, 10);
	}
	

}
