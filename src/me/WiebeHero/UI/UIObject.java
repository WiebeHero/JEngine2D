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
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract void onClick();
	
	public void onMouseMove(MouseEvent event) {
		if(this.bounds.contains(event.getX(), event.getY())) {
			this.hovering = true;
		}
		else {
			this.hovering = false;
		}
	}
	
	public void onMouseRelease(MouseEvent event) {
		if(this.hovering && this.bounds.contains(event.getX(), event.getY())) {
			this.onClick();
		}
	}
	
	//Getters and Setters
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public double getMarginX() {
		return marginX;
	}

	public void setMarginX(double marginX) {
		this.marginX = marginX;
	}

	public double getMarginY() {
		return marginY;
	}

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
