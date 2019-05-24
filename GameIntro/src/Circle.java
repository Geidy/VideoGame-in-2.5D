import java.awt.*;

public class Circle {
	double x;
	double y;

	int r;  
	
	int angle;
	
	double vx = 0;
	double vy = 0;

	public Circle(double x, double y, int r, int angle)
	{
		this.x = x;
		this.y = y;
		
		this.r = r;
		
		this.angle = angle;
	}
	
	public boolean hasCollidedWith(Line line)
	{
		return line.distanceTo(x, y) < r;
	}
	
	public void backOffFrom(Line line)
	{
		double d = line.distanceTo(x, y);
		
		double dist = r - d + 1;
		
		x += dist * line.Nx;
		y += dist * line.Ny;
	}
	
	public void setVelocity(double vx, double vy)
	{
		this.vx = vx;
		this.vy = vy;
	}
	
	public void moveForward()
	{
		x += vx;
		y += vy;
	}
	
	public void applyGravity()
	{
	   vy += 0.2; 
	}
	
	public void moveForward(int dist)
	{
		x += dist * Lookup.cos[angle];
		y += dist * Lookup.sin[angle];
	}
	
	public void turnLeft(int dangle)
	{
		angle -= dangle;
		
		if(angle < 0)   angle += 360;
	}
	
	public void turnRight(int dangle)
	{
		angle += dangle;
		
		if(angle >= 360)   angle -= 360;
	}
	
	public void draw(Graphics g)
	{
	   g.drawOval((int)x-r, (int)y-r, 2*r, 2*r);
	   
	   g.drawLine
	   (
	   		(int)x, 
	   		(int)y, 
	   		(int)(x + r * Lookup.cos[angle]), 
	   		(int)(y + r * Lookup.sin[angle])
	   );
	}

}
