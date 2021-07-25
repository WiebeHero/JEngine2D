package me.WiebeHero.Display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Display {
	
	private JFrame frame;
	private Canvas canvas;
	
	private String title, iconPath;
	private int width, height;
	
	/**
	 * Constructor for the display class.
	 * @param title 	| Title of the window.
	 * @param width		| Width of the window.
	 * @param height	| Height of the window.
	 */
	public Display(String title, String iconPath, int width, int height) {
		this.title = title;
		this.iconPath = iconPath;
		this.width = width;
		this.height = height;
		
		this.createDisplay();
	}
	/**
	 * Runs when called in the constructor, basically the builder for the
	 * window.
	 */
	private void createDisplay() {
		this.frame = new JFrame(this.title);
		this.frame.setSize(this.width, this.height);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setResizable(true);
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
		this.frame.setMinimumSize(new Dimension(840, 520));
		Image img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(this.iconPath));
		this.frame.setIconImage(img);
		
		this.canvas = new Canvas();
		this.canvas.setPreferredSize(new Dimension(this.width, this.height));
		this.canvas.setMaximumSize(new Dimension(this.width, this.height));
		this.canvas.setMinimumSize(new Dimension(840, 520));
		this.canvas.setFocusable(false);
		
		this.frame.add(this.canvas);
		this.frame.pack();
	}
	
	/**
	 * A getter to get the Canvas.
	 * @return Returns the Canvas, basically the thing where you draw your stuff.
	 */
	public Canvas getCanvas() {
		return this.canvas;
	}
	/**
	 * A getter to get the JFrame.
	 * @return Returns the Window, basically the container of the canvas.
	 */
	public JFrame getFrame() {
		return this.frame;
	}
	
}
