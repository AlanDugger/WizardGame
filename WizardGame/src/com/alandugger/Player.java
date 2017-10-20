package com.alandugger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/* Special handling for the player to allow movement */
public class Player extends GameObject {

	ObjectHandler objectHandler;
	
	public Player(int x, int y, ObjectID id, ObjectHandler objectHandler) 
	{
		super(x, y, id);
		this.objectHandler = objectHandler;
	}

	@Override
	public void tick() 
	{
		xPosition += xVelocity;
		yPosition += yVelocity;
		
		if (objectHandler.isMovingUp())
			yVelocity = -5;
		else if (!objectHandler.isMovingDown())
			yVelocity = 0;
		
		if (objectHandler.isMovingDown())
			yVelocity = 5;
		else if (!objectHandler.isMovingUp())
			yVelocity = 0;
		
		if (objectHandler.isMovingRight())
			xVelocity = 5;
		else if (!objectHandler.isMovingLeft())
			xVelocity = 0;
		
		if (objectHandler.isMovingLeft())
			xVelocity = -5;
		else if (!objectHandler.isMovingRight())
			xVelocity = 0;
		
	}

	@Override
	public void render(Graphics graphics) 
	{
		graphics.setColor(Color.BLUE);
		graphics.fillRect(xPosition, yPosition, 32, 32);
	}

	@Override
	public Rectangle getBounds() 
	{
		return new Rectangle(xPosition, yPosition, 32, 32);
	}

}
