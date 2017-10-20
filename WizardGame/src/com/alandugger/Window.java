package com.alandugger;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window 
{
	// Window constructor creates the jframe with established parameters & sets it visible
	public Window(int width, int height, String title, GameEngine game)
	{
		JFrame frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.add(game);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
}
