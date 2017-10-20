package com.alandugger;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class GameEngine extends Canvas implements Runnable
{
	static final long serialVersionUID = 1L;
	private Thread thread;
	private boolean running = false;
	private ObjectHandler objectHandler;
	
	// GameEngine constructor called by main(), creates the window object
	public GameEngine()
	{		
		objectHandler = new ObjectHandler();
		new Window(1000, 563, "Wizard Game", this);
		start();	
	}
	
	public static void main(String[] args) 
	{
		new GameEngine();
	}

	// Using tick algorithm developed by Notch (credit: Minecraft)
	@Override
	public void run() 
	{
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while (running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1)
			{				
					tick();
					delta--;
			}
			
			// 
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				frames = 0;
			}
		}
		
		stop();
	}
	
	public void tick()
	{
		objectHandler.tick();
	}
	
	public void render()
	{
		BufferStrategy bufferStrat = this.getBufferStrategy();
		if (bufferStrat == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics graphics = bufferStrat.getDrawGraphics();
		
		
		objectHandler.render(graphics);
		graphics.dispose();
		bufferStrat.show();
	}
	
	// Set the running value to false and wait for the thread to die
	private void stop()
	{
		running = false;
		try
		{
			thread.join();
		}	
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	// Set the running value to true and create/start new thread for the game engine
	private void start()
	{
		running = true;
		thread = new Thread(this);
		thread.start();
	}

}
