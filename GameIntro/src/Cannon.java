
public class Cannon extends Circle
{
	public Cannon(double x, double y, int r, int angle)
	{
		super(x, y, r, angle);
	}
	
	public void fire(Circle cannonbal)
	{
		cannonbal.x = x + r * Lookup.cos[angle];
		cannonbal.y = y + r * Lookup.sin[angle];
		
		cannonbal.vx = 12 * Lookup.cos[angle];
		cannonbal.vy = 12 * Lookup.sin[angle]; 
	}
	

}
