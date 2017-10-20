package com.alandugger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BlockObject extends GameObject 
{
	public BlockObject(int x, int y, ObjectID id)
	{
		super(x, y, id);
	}

	@Override
	public void tick() 
	{
		
		
	}

	@Override
	public void render(Graphics graphics) 
	{
		graphics.setColor(Color.BLACK);
		graphics.fillRect(xPosition, yPosition, 32, 32);
	}

	@Override
	public Rectangle getBounds() 
	{		
		return new Rectangle(xPosition, yPosition, 32, 32);
	}
	
	
}
