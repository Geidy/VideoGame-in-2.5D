import java.awt.*;

public class Tank extends PolygonModel{
int gunAngle;
	
	public Tank(int x, int y, int angle)
	{
		super(x, y, angle);
		
		color[0] = new Color(50, 100, 70);
		color[1] = Color.GRAY;
		
		color[2] = Color.black;
		color[3] = Color.black;
		
		color[4] = new Color(60, 130, 100);		
	}
	
	public void rotateGunBy(int degrees)
	{		
	   theta[1] += degrees; 	
	   theta[4] += degrees; 	

	   if(theta[1] > 359)  theta[1] -= 360;
		if(theta[1] < 0)    theta[1] += 360;

	   if(theta[4] > 359)  theta[4] -= 360;
		if(theta[4] < 0)    theta[4] += 360;
	}
	

	public int numberOfPolygons()
	{
	   return 5;	
	}
	
	public int[][] generate_y_struct()
	{
	   int[][] y_struct =
   	{
		   {-25, 25, 25, -25},
		   {-10, 10, 10, -10},
		   {25, 30, 30, 25},
		   {-25, -30, -30, -25},
		   {-3, 3, 3, -3}
	   };
	   
	   return y_struct;
	}
	
	public int[][] generate_x_struct()
	{
   	int[][] x_struct =
   	{
   		{40, 40, -40, -40},
   		{10, 10, -10, -10},
   		{35, 35, -35, -35},
   		{35, 35, -35, -35},
   		{37, 37, 10, 10}
   	};
   	
   	return x_struct;
	}

}
