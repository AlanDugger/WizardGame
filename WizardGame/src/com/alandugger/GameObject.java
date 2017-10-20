package com.alandugger;

import java.awt.Graphics;
import java.awt.Rectangle;

/* Abstract class for the objects to be used within the game */
public abstract class GameObject 
{
	protected int xPosition, yPosition;
	protected float xVelocity, yVelocity;
	protected ObjectID id;
	
	public GameObject(int x, int y, ObjectID id)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.id = id;
	}


	public abstract void tick();
	public abstract void render(Graphics graphics);
	public abstract Rectangle getBounds();

	
	// Setters & Getters for x/y current positions & x/y velocity	
	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public float getxVelocity() {
		return xVelocity;
	}

	public void setxVelocity(float xVelocity) {
		this.xVelocity = xVelocity;
	}

	public float getyVelocity() {
		return yVelocity;
	}

	public void setyVelocity(float yVelocity) {
		this.yVelocity = yVelocity;
	}
	
	
	public ObjectID getId() {
		return id;
	}

	public void setId(ObjectID id) {
		this.id = id;
	}

	
}
