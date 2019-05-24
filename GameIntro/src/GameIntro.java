import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class GameIntro extends Applet implements Runnable, KeyListener
{
	Image    offscreen_img;
	Graphics offscreen_g;
	
		
	Soldier[] soldier = new Soldier [84];
	
	boolean up_pressed = false;
	boolean dn_pressed = false;
	boolean lt_pressed = false;
	boolean rt_pressed = false;
	boolean  A_pressed = false;
	boolean  S_pressed = false;
	boolean  W_pressed = false;
	
	
	Thread t;
	
	

	
	public void init()
	{
		offscreen_img = this.createImage(1024, 768);
		offscreen_g   = offscreen_img.getGraphics();
		
		int columns = 12;
	
		for(int i = 0; i < soldier.length; i++)
		{
			int x = 50 * (i % columns);
			int y = 55;
			int z = 50 * (i / columns) + 500;
			
			int w = 25;
			int h = 50;
			
			soldier[i] = new Soldier(x, y, z, w, h);
			
		}
		
		requestFocus();
		
		addKeyListener(this);
		
		
		t = new Thread(this);
		
		t.start();
		
	
		
	}
	
	public void run()
	{		
	
		while(true)
		{
			
//*
			if(up_pressed)   Camera.moveUp(1);
			if(dn_pressed)   Camera.moveDown(1);
			if(lt_pressed)   Camera.moveLeft(1);
			if(rt_pressed)   Camera.moveRight(1);
//*/
			
//*			
			for(int i = 0; i < soldier.length; i++)
			{
		   	if(up_pressed)   soldier[i].moveIn(1);
			   if(dn_pressed)   soldier[i].moveOut(1);
			   if(lt_pressed)   soldier[i].moveLeft(1);
			   if(rt_pressed)   soldier[i].moveRight(1);
			}
//*/			
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
	
	public void update(Graphics g)
	{
		offscreen_g.clearRect(0, 0, 1024, 768);
		
		paint(offscreen_g);
		
		g.drawImage(offscreen_img, 0, 0, 1024, 768, null);
	}
	
	public void paint(Graphics g)
	{

		for(int i =soldier.length-1; i >= 0; i--)
         soldier[i].draw3D(g);
   }

}
