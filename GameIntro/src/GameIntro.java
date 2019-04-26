// Introduction to Game Programming

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class GameIntro extends Applet implements Runnable, KeyListener
{
//	Image image = Toolkit.getDefaultToolkit().getImage("g_rt_0.gif");
	
	
//	Animation anim = new Animation("g_dn", 5, 10);
	
	Soldier soldier = new Soldier(100, 100);
	BattleLord bl = new BattleLord(130, 80);
	boolean up_pressed = false;
	boolean dn_pressed = false;
	boolean lt_pressed = false;
	boolean rt_pressed = false;
	boolean  A_pressed = false;
	boolean  S_pressed = false;
	boolean  W_pressed = false;
	
	
	Thread t;
	
	Tank tank1 = new Tank(100, 100, 0);
	Tank tank2 = new Tank(500, 300, 0);
	
	Rect r1 = new Rect(50, 100, 10, 50);
	Rect r2 = new Rect(900, 400, 10, 50);
	
	Rect ball = new Rect(100, 100, 10, 10);
	

	
	public void init()
	{
		requestFocus();
		
		addKeyListener(this);
		
		
		t = new Thread(this);
		
		t.start();
		
	
		
	}
	
	public void run()
	{
		ball.setVelocity(4, 15);
		while(true)
		{
			if(up_pressed)   soldier.moveUp(1);
			if(dn_pressed)   soldier.moveDown(1);
			if(lt_pressed)   soldier.moveLeft(1);
			if(rt_pressed)   soldier.moveRight(1);
			
			if(up_pressed)   bl.moveUp(1);
			if(dn_pressed)   bl.moveDown(1);
			if(lt_pressed)   bl.moveLeft(1);
			if(rt_pressed)   bl.moveRight(1);
			
			
/*			if(up_pressed)   r1.moveUpBy(4);
			if(dn_pressed)   r1.moveDownBy(4);
						
			if(W_pressed)    r2.moveUpBy(4);
			if(S_pressed)    r2.moveDownBy(4);
			
			ball.moveForward();
			
			
			if(ball.overlaps(r1))  ball.bounceX();

			if(ball.overlaps(r2))  ball.bounceX();
*/				
				

/*			
			if(lt_pressed)   r1.moveBy(-4, 0);
			if(rt_pressed)   r1.moveBy( 4, 0);

			
			if(up_pressed)   tank1.moveForwardBy(4);
			if(dn_pressed)   tank1.moveBy(0, 2);
			
			if(A_pressed)    tank1.rotateGunBy(-6);
			if(S_pressed)    tank1.rotateGunBy(6);
			
			if(lt_pressed)   tank1.rotateBy(-2);
			if(rt_pressed)   tank1.rotateBy(2);
*/			
			repaint();
			
			try
			{
			   t.sleep(16);
			}
			catch(Exception x) {};
		}
	}
	
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)     up_pressed = true;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)   dn_pressed = true;
		if (e.getKeyCode() == KeyEvent.VK_LEFT)   lt_pressed = true;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)  rt_pressed = true;
		if (e.getKeyCode() == KeyEvent.VK_A)      A_pressed  = true;
		if (e.getKeyCode() == KeyEvent.VK_S)      S_pressed  = true;
		if (e.getKeyCode() == KeyEvent.VK_W)      W_pressed  = true;
		
	}
	
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)     up_pressed = false;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)   dn_pressed = false;
		if (e.getKeyCode() == KeyEvent.VK_LEFT)   lt_pressed = false;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)  rt_pressed = false;
		if (e.getKeyCode() == KeyEvent.VK_A)      A_pressed  = false;
		if (e.getKeyCode() == KeyEvent.VK_S)      S_pressed  = false;
		if (e.getKeyCode() == KeyEvent.VK_W)      W_pressed  = false;
		
	}

	public void keyTyped(KeyEvent e)
	{
		
	}
	
	public void paint(Graphics g)
	{
		soldier.draw(g);
		
		bl.draw(g);
		
		
		
		//g.drawImage(anim.getStillImage(), 100, 100, null);
		//g.drawImage(anim.getCurrentImage(), 100, 100, null);
		
		
		
		
		
		//g.drawImage(image, 100, 100, null);
	//	tank1.draw(g);
	//	tank2.draw(g);
		
		r1.draw(g);
		r2.draw(g);
		
		ball.draw(g);
		
		if (r1.overlaps(r2))   g.drawString("overlaps", 10, 20);
		
		else                   g.drawString("", 10, 20);
		
	}
	
	
	
	
	
	
	
	
	
	
	public void drawPoly(int[] x, int[]y, Graphics g)
	{
		int last = x.length-1;
		
		for(int i = 0; i < last; i++)
			
			g.drawLine(x[i], y[i], x[i+1], y[i+1]);
		
		g.drawLine(x[last], y[last], x[0], y[0]);
		
	}
	
	
	
	public void drawLine(int x1, int y1, int x2, int y2, Graphics g)
	{
		double m = (y2 - y1) / (double)(x2 - x1);
		
		double y = y1;
		
		for(int x = x1; x < x2; x++)
		{
			drawPoint(x, (int)y, g);
			
			y += m;
		}
	}
	
	public void drawRect(int x, int y, int w, int h, Graphics g)
	{
		drawVLine(x, y, y+h, g);
		drawHLine(x, x+w, y, g);
		drawVLine(x+w, y, y+h, g);
		drawHLine(x, x+w, y+h, g);
	}
	
	
	public void drawPoint(int x, int y, Graphics g)
	{
		g.drawLine(x, y, x, y);
	}
	
	public void drawVLine(int x, int y1, int y2, Graphics g)
	{
		for(int y = y1; y <= y2; y++)
			drawPoint(x, y, g);
	}
	
	public void drawHLine(int x1, int x2, int y, Graphics g)
	{
		for(int x = x1; x <= x2; x++)
			drawPoint(x, y, g);
	}
	
	
	
	/*	
	
	int[] x = {100, 120, 50};
	int[] y = {600-100, 600-40, 600-60};
	
	drawPoly(x, y, g);
	
	
/*
	g.drawLine(10, 500, 500, 400);
	g.drawLine(10, 500, 500, 300);
	g.drawLine(10, 500, 500,  10);
	g.drawLine(10, 500, 300,  10);
	g.drawLine(10, 500, 100,  10);
	
	
 /*
	drawHLine(10, 500, 10, g);
    
    drawHLine(300, 700, 500, g);
    
    drawVLine(500, 0, 600, g);
    
    drawRect(100, 100, 50, 50, g);
    drawRect(150, 150, 50, 50, g);
    drawRect(-100, 200, 350, 80, g);
    drawRect(   0, 300, 350, 80, g);
*/    


}
