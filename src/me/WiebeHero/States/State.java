package me.WiebeHero.States;

import java.awt.Graphics;

public abstract class State {
	
	//CLASS
	/**
	 * A method to initialize the mouse manager on this state.
	 */
	public abstract void initMouseManager();
	/**
	 * A method that is called every frame to tick other objects.
	 */
	public abstract void tick();
	/**
	 * A method that is called every frame to render other objects.
	 * @param g | Graphics
	 */
	public abstract void render(Graphics g);
	
}
