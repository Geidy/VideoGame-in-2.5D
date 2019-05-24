import java.awt.*;

public class Sprite {
	int x;
	int y;
	int z;
	
	int w;
	int h;
	
	protected static final int x_origin = 500;
	protected static final int y_origin = 300;
	
	Animation[] anim;
	
	int pose = 0;
	
	boolean moving = false;
	
	
	public Sprite(int x, int y, int z, int w, int h, String name, String[] poses, int count, int duration)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		
		this.w = w;
		this.h = h;
		
		anim = new Animation[poses.length];
		
		for(int i = 0; i < poses.length; i++)
			
			anim[i] = new Animation(name + "_" + poses[i], count, duration);
	}
	
	public void moveBy(int dx, int dy)
	{
		x += dx;
		y += dy;
	}
	
	
	public void moveUp(int dist)
	{
		y -= dist;
		
		pose = 0;
		
      moving = true;		
	}
	
	public void moveDown(int dist)
	{
		y += dist;
		
		pose = 1;

      moving = true;		
}

	public void moveLeft(int dist)
	{
		x -= dist;
		
		pose = 2;

      moving = true;		
   }
	
	public void moveRight(int dist)
	{
		x += dist;
		
		pose = 3;
	
      moving = true;		
   }
	
	public void moveIn(int dist)
	{
		z += dist;
		
		pose = 0;
		
		moving = true;
	}
	
	public void moveOut(int dist)
	{
		z -= dist;
		
		pose = 1;
		
		moving = true;
	}
	
	public void draw2D(Graphics g)
	{
      if(moving)  
      	
      	g.drawImage(anim[pose].getCurrentImage(), x - (int)Camera.x, y, null);
      
      else
      	
      	g.drawImage(anim[pose].getStillImage(), x - (int)Camera.x, y, null);
      
      moving = false;
      	
	}
	
	public void draw3D(Graphics g)
	{
		int d = 1024;
		
		int x3D = d * x / z;
		int y3D = d * y / z;
		
		int w3D = d * w / z;
		int h3D = d * h / z;
		
		
      if(moving)  
      	
      	g.drawImage(anim[pose].getCurrentImage(), x3D - w3D/2 + x_origin, y3D - h3D + y_origin, w3D, h3D, null);
      
      else
      	
      	g.drawImage(anim[pose].getStillImage(), x3D - w3D/2 + x_origin, y3D - h3D + y_origin, w3D, h3D, null);
      
      moving = false;
      	
		
	}

}
