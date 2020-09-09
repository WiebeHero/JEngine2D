package me.WiebeHero.Entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import me.WiebeHero.Main.Handler;

public abstract class Entity {

	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;
	
	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = x;
		this.width = width;
		this.height = height;
		
		this.bounds = new Rectangle(0, 0, width, height);
	}

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for(Entity e : this.handler.getWorld().getEntityManager().getEntities()) {
			if(!e.equals(this)) {
				if(e.getCollisionBounds(0F, 0F).intersects(this.getCollisionBounds(xOffset, yOffset))) {
					return true;
				}
			}
		}
		return false;
	}
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int)(this.x + this.bounds.x + xOffset), (int)(this.y + this.bounds.y + yOffset), this.bounds.width, this.bounds.height);
	}
	
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
}
