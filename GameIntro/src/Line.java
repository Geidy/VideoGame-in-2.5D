import java.awt.*;

public class Line {
	int x1;
	int y1;

	int x2;
	int y2;
	
	double vx;
	double vy;
	
	double Nx;
	double Ny;
	
	
	public Line(int x1, int y1, int x2, int y2)
	{
		this.x1 = x1;
		this.y1 = y1;
		
		this.x2 = x2;
		this.y2 = y2;
		
		int dx = x2 - x1;
		int dy = y2 - y1;
		
		double magnitude = Math.sqrt(dx*dx + dy*dy);
			
		vx = dx / magnitude;
		vy = dy / magnitude;
		
		Nx =  vy;
		Ny = -vx;
	}
	
	public double distanceTo(double x, double y)
	{
	   return vy*(x - x1) - vx*(y - y1);	
	}
	
	public void draw(Graphics g)
	{
	  g.drawLine(x1, y1, x2, y2);	
		
	}

}
