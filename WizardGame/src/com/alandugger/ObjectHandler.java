package com.alandugger;

import java.awt.Graphics;
import java.util.LinkedList;

public class ObjectHandler 
{
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	private boolean movingUp = false;
	private boolean movingDown = false;
	private boolean movingRight = false;
	private boolean movingLeft = false;
	
	//Go through the list of game objects in our game and perform their tick method
	public void tick()
	{
		for (int i = 0; i < object.size(); i++)
		{
			GameObject tmp = object.get(i);
			tmp.tick();
		}
	}
	
	//Go through the list of game objects in our game and perform their render method
	public void render(Graphics graphics)
	{
		for (int i = 0; i < object.size(); i++)
		{
			GameObject tmp = object.get(i);
			tmp.render(graphics);
		}
	}
	
	public void addObject(GameObject gameObject)
	{
		object.add(gameObject);
	}
	
	public void removeObject(GameObject gameObject)
	{
		object.remove(gameObject);
	}

	public boolean isMovingUp() {
		return movingUp;
	}

	public void setMovingUp(boolean movingUp) {
		this.movingUp = movingUp;
	}

	public boolean isMovingDown() {
		return movingDown;
	}

	public void setMovingDown(boolean movingDown) {
		this.movingDown = movingDown;
	}

	public boolean isMovingRight() {
		return movingRight;
	}

	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}

	public boolean isMovingLeft() {
		return movingLeft;
	}

	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}
	
	
}
