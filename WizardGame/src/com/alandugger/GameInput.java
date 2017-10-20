package com.alandugger;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/* Basic movement game input */
public class GameInput extends KeyAdapter 
{
	ObjectHandler objectHandler;	
	public GameInput(ObjectHandler objectHandler)
	{
		this.objectHandler = objectHandler;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		for (int i = 0; i < objectHandler.object.size(); i++)
		{
			GameObject tmp = objectHandler.object.get(i);
			
			if (tmp.getId() == ObjectID.Player)
			{
				if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP)
					objectHandler.setMovingUp(true);
				if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN)
					objectHandler.setMovingDown(true);
				if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT)
					objectHandler.setMovingLeft(true);
				if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT)
					objectHandler.setMovingRight(true);
			}
		}
	}
	
	public void keyReleased(KeyEvent e)
	{
	int key = e.getKeyCode();
		
		for (int i = 0; i < objectHandler.object.size(); i++)
		{
			GameObject tmp = objectHandler.object.get(i);
			
			if (tmp.getId() == ObjectID.Player)
			{
				if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP)
					objectHandler.setMovingUp(false);
				if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN)
					objectHandler.setMovingDown(false);
				if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT)
					objectHandler.setMovingLeft(false);
				if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT)
					objectHandler.setMovingRight(false);
			}
		}	
	}
}
