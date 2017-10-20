package com.alandugger;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class GameEngine extends Canvas implements Runnable
{
	static final long serialVersionUID = 1L;
	private Thread thread;
	private boolean running = false;
	private ObjectHandler objectHandler;
	private BufferedImage gameLevel = null;
	
	// GameEngine constructor called by main(), creates the window object
	public GameEngine()
	{		
		objectHandler = new ObjectHandler();
		new Window(1000, 563, "Wizard Game", this);
		start();		
		this.addKeyListener(new GameInput(objectHandler));		
		BufferedImageLoader loader = new BufferedImageLoader();
		gameLevel = loader.loadImage("/gamelevel1.png");
		loadGameLevel(gameLevel);
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
	
	// Render the game space and objects
	public void render()
	{
		BufferStrategy bufferStrat = this.getBufferStrategy();
		if (bufferStrat == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics graphics = bufferStrat.getDrawGraphics();
		
		graphics.setColor(Color.GRAY);
		graphics.fillRect(0, 0, 1000, 563);
		
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
	
	private void loadGameLevel(BufferedImage image)
	{
		int imgWidth = image.getWidth();
		int imgHeight = image.getHeight();
		
			
		for (int y = 0; y < imgHeight; y++)
			for (int x = 0; x < imgWidth; x++)
			{
				int pixel = image.getRGB(x, y);
				int r_color = (pixel >> 16) & 0xff;
				int g_color = (pixel >> 8) & 0xff;
				int b_color = (pixel) & 0xff;
				
				
				// add the player position
				if (r_color == 0 && g_color == 0 && b_color == 255)
					objectHandler.addObject(new Player((32 * x), (32 * y), ObjectID.Player, objectHandler));
				
				// add a block or border image based on the loaded map
				if (r_color == 0 && g_color == 0 && b_color == 0)
					objectHandler.addObject(new BlockObject((32 * x), (32 * y), ObjectID.Block));
				
					
			}
	}

}
