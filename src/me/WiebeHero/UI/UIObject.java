package me.WiebeHero.UI;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import me.WiebeHero.Main.Game;

public abstract class UIObject implements Marginable{
	
	
	protected UIObject inheritance;
	protected float x, y;
	protected double marginX, marginY;
	protected int width, height;
	protected Rectangle bounds;
	protected boolean hovering = false;
	protected boolean hovered = false;
	
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
		this.marginX = marginX;
		this.marginY = marginY;
		this.width = width;
		this.height = height;
		this.bounds = new Rectangle((int)x, (int)y, width, height);
		this.updateM();
	}
	/**
	 * This constructor can not be called. Because it is an abstract class.
	 *
	 * @param marginX | Horizontal position on the screen. (Proportional to the screens size, given a %)
	 * @param marginY | Vertical position on the screen. (Proportional to the screens size, given a %)
	 * @param width | Width that it is taking on the screen.
	 * @param height | Height that it is taking on the screen.
	 */
	public UIObject(double marginX, double marginY, int width, int height, UIObject inheritance) {
		this.x = 0.00F;
		this.y = 0.00F;
		this.marginX = marginX;
		this.marginY = marginY;
		this.width = width;
		this.height = height;
		this.inheritance = inheritance;
		this.bounds = new Rectangle((int)x, (int)y, width, height);
		this.updateM();
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
	 * Method that is being called when the button is hovered on.
	 */
	public abstract void onHover();
	/**
	 * Method that is being called when the button is clicked on.
	 */
	public abstract void onRelease();
	/**
	 * Method that is being called when the button is clicked on.
	 */
	public abstract void onPress();
	/**
	 * Method that is being called something is being dragged.
	 */
	public abstract void onDrag();
	/**
	 * Sets the hovering state dependent on the position of the mouse.
	 * 
	 * @param event | Mouse Move Event.
	 */
	public void onMouseMove(MouseEvent event) {
		if(this.bounds.contains(event.getX(), event.getY())) {
			this.hovering = true;
			if(!this.hovered) {
				this.hovered = true;
				this.onHover();
			}
		}
		else {
			this.hovering = false;
			this.hovered = false;
		}
	}
	/**
	 * Calls the onClick() method that can be overridden when the mouse is released.
	 * 
	 * @param event | Mouse Release Event.
	 */
	public void onMousePress(MouseEvent event) {
		if(this.hovering && this.bounds.contains(event.getX(), event.getY())) {
			this.onPress();
		}
	}
	/**
	 * Calls the onClick() method that can be overridden when the mouse is released.
	 * 
	 * @param event | Mouse Release Event.
	 */
	public void onMouseRelease(MouseEvent event) {
		if(this.hovering && this.bounds.contains(event.getX(), event.getY())) {
			this.onRelease();
		}
	}
	/**
	 * Calls the onClick() method that can be overridden when the mouse is released.
	 * 
	 * @param event | Mouse Release Event.
	 */
	public void onMouseDrag(MouseEvent event) {
		if(this.hovering && this.bounds.contains(event.getX(), event.getY())) {
			this.onDrag();
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
		this.updateM();
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
		this.updateM();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
		this.bounds.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
		this.bounds.height = height;
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
	
	public void setInheritance(UIObject object) {
		this.inheritance = object;
		if(this.inheritance != null && marginX != -1F && marginY != -1F) {
			float inX = inheritance.getX(), inY = inheritance.getY();
			int inWidth = inheritance.getWidth(), inHeight = inheritance.getHeight();
			int finalX = (int)inX + (int)(inWidth / 100.00 * marginX) - width / 2, finalY = (int)inY + (int)(inHeight / 100.00 * marginY) - height / 2;
			x = finalX;
			bounds.x = finalX;
			y = finalY;
			bounds.y = finalY;
		}
		else {
			int canvasX = Game.handler.getWidth(), canvasY = Game.handler.getHeight();
			int finalX = (int)(canvasX / 100.00 * marginX) - width / 2, finalY = (int)(canvasY / 100.00 * marginY) - height / 2;
			x = finalX;
			bounds.x = finalX;
			y = finalY;
			bounds.y = finalY;
		}
	}
	
	public UIObject getInheritance() {
		return this.inheritance;
	}

	public boolean overlaps(Rectangle r) {
	    return x < r.x + r.width && x + width > r.x && y < r.y + r.height && y + height > r.y;
	}
	
	protected void updateM() {
		if(this.inheritance != null) {
			float inX = inheritance.getX(), inY = inheritance.getY();
			int inWidth = inheritance.getWidth(), inHeight = inheritance.getHeight();
			int finalX = (int)inX + (int)(inWidth / 100.00 * marginX) - width / 2, finalY = (int)inY + (int)(inHeight / 100.00 * marginY) - height / 2;
			x = finalX;
			y = finalY;
			bounds.x = finalX;
			bounds.y = finalY;
		}
		else {
			int canvasX = Game.handler.getWidth(), canvasY = Game.handler.getHeight();
			int finalX = (int)(canvasX / 100.00 * marginX) - width / 2, finalY = (int)(canvasY / 100.00 * marginY) - height / 2;
			x = finalX;
			y = finalY;
			bounds.x = finalX;
			bounds.y = finalY;
		}
	}
	
	@Override
	public void updateMargin() {
		this.updateM();
	}
}
