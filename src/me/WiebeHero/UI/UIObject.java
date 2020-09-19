package me.WiebeHero.UI;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public abstract class UIObject {
	
	protected float x, y;
	protected double marginX, marginY;
	protected float extraX, extraY;
	protected int width, height;
	protected Rectangle bounds;
	protected boolean hovering = false;
	
	/**
	 * This constructor can not be called. Because it is an abstract class.
	 *
	 * @param x | Horizontal position on the screen.
	 * @param y | Vertical position on the screen.
	 * @param width | Width that it is taking on the screen.
	 * @param height | Height that it is taking on the screen.
	 */
	public UIObject(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.extraX = 0;
		this.extraY = 0;
		this.width = width;
		this.height = height;
		this.marginX = -1F;
		this.marginY = -1F;
		this.bounds = new Rectangle((int)x, (int)y, width, height);
	}
	/**
	 * This constructor can not be called. Because it is an abstract class.
	 *
	 * @param marginX | Horizontal position on the screen. (Proportional to the screens size, given a %)
	 * @param marginY | Vertical position on the screen. (Proportional to the screens size, given a %)
	 * @param width | Width that it is taking on the screen.
	 * @param height | Height that it is taking on the screen.
	 */
	public UIObject(double marginX, double marginY, int width, int height) {
		this.x = 0.00F;
		this.y = 0.00F;
		this.extraX = 0;
		this.extraY = 0;
		this.marginX = marginX;
		this.marginY = marginY;
		this.width = width;
		this.height = height;
		this.bounds = new Rectangle((int)x, (int)y, width, height);
	}
	/**
	 * This constructor can not be called. Because it is an abstract class.
	 *
	 * @param marginX | Horizontal position on the screen. (Proportional to the screens size, given a %)
	 * @param marginY | Vertical position on the screen. (Proportional to the screens size, given a %)
	 * @param extraX | Horizontal position on the screen. (Raw offset in pixels apart from margin (Horizontal))
	 * @param extraY | Vertical position on the screen. (Raw offset in pixels apart from margin (Vertical))
	 * @param width | Width that it is taking on the screen.
	 * @param height | Height that it is taking on the screen.
	 */
	public UIObject(double marginX, double marginY, float extraX, float extraY, int width, int height) {
		this.x = 0.00F;
		this.y = 0.00F;
		this.marginX = marginX;
		this.marginY = marginY;
		this.width = width;
		this.height = height;
		this.extraX = extraX;
		this.extraY = extraY;
		this.bounds = new Rectangle((int)x, (int)y, width, height);
	}
	/**
	 * Method that is being called every frame.
	 */
	public abstract void tick();
	/**
	 * Method that draws things to the screen.
	 * 
	 * @param g | Main graphics object that draws to the screen.
	 */
	public abstract void render(Graphics g);
	/**
	 * Method that is being called when the button is clicked on.
	 */
	public abstract void onClick();
	/**
	 * Sets the hovering state dependent on the position of the mouse.
	 * 
	 * @param event | Mouse Move Event.
	 */
	public void onMouseMove(MouseEvent event) {
		if(this.bounds.contains(event.getX(), event.getY())) {
			this.hovering = true;
		}
		else {
			this.hovering = false;
		}
	}
	/**
	 * Calls the onClick() method that can be overridden when the mouse is released.
	 * 
	 * @param event | Mouse Release Event.
	 */
	public void onMouseRelease(MouseEvent event) {
		if(this.hovering && this.bounds.contains(event.getX(), event.getY())) {
			this.onClick();
		}
	}
	
	//Getters and Setters
	/**
	 * Returns the vertical position of the object.
	 */
	public float getX() {
		return x;
	}
	/**
	 * Sets the vertical position of the object.
	 * 
	 * @param x | Vertical position in floats.
	 */
	public void setX(float x) {
		this.x = x;
	}
	/**
	 * Returns the horizontal position of the object.
	 */
	public float getY() {
		return y;
	}
	/**
	 * Sets the horizonal position of the object.
	 * 
	 * @param y | Horizontal position in floats.
	 */
	public void setY(float y) {
		this.y = y;
	}
	/**
	 * Returns the vertical margin of the object.
	 */
	public double getMarginX() {
		return marginX;
	}
	/**
	 * Sets the vertical margin of the object.
	 * 
	 * @param marginX | Vertical margin in doubles.
	 */
	public void setMarginX(double marginX) {
		this.marginX = marginX;
	}
	/**
	 * Returns the horizontal margin of the object.
	 */
	public double getMarginY() {
		return marginY;
	}
	/**
	 * Sets the horizontal margin of the object.
	 * 
	 * @param marginY | Horizontal margin in doubles.
	 */
	public void setMarginY(double marginY) {
		this.marginY = marginY;
	}
	
	public float getExtraX() {
		return extraX;
	}

	public void setExtraX(float extraX) {
		this.extraX = extraX;
	}

	public float getExtraY() {
		return extraY;
	}

	public void setExtraY(float extraY) {
		this.extraY = extraY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isHovering() {
		return hovering;
	}

	public void setHovering(boolean hovering) {
		this.hovering = hovering;
	}
	
	public Rectangle getBounds() {
		return this.bounds;
	}

	public boolean overlaps(Rectangle r) {
	    return x < r.x + r.width && x + width > r.x && y < r.y + r.height && y + height > r.y;
	}
}
