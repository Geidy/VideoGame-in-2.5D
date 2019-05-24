
public class BadCircle extends Circle {
	
	public BadCircle(double x, double y, int r, int angle)
	{
		super(x, y, r, angle);
	}
	
	public void chases(Circle c)
	{
      turnToward(c, 2); 
      moveForward(2);

	}
	
	public boolean notTooCloseTo(Circle c)
	{
   	double ux = c.x - x;
      double uy = c.y - y;

      return (ux*ux + uy*uy)  >  (r + c.r)*(r + c.r);
	}
	
	public void turnToward(Circle c, int rate)
	{
		double d = distanceTo(c);
		
		if (d < 0)  turnRight(rate);
		
		if (d > 0)  turnLeft(rate);
	}
	
   private double distanceTo(Circle c)
   {
   	double ux = c.x - x;
      double uy = c.y - y;
      
      double vx = Lookup.cos[angle];
      double vy = Lookup.sin[angle];
      
      return ux*vy - uy*vx;
   }

	public boolean isToTheLeft(Circle c)
	{
	   return distanceTo(c) > 0;
	}

	public boolean isToTheRight(Circle c)
	{
	   return distanceTo(c) < 0;
	}

}
