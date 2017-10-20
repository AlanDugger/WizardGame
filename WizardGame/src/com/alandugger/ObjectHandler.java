package com.alandugger;

import java.awt.Graphics;
import java.util.LinkedList;

public class ObjectHandler 
{
	LinkedList<GameObject> object = new LinkedList<GameObject>();

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
}
