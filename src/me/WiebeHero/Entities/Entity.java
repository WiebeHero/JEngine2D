package me.WiebeHero.Entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import me.WiebeHero.Main.Game;

public abstract class Entity {

	public static final int DEFAULT_SOUL_HEALTH = 3;
	public static final int DEFAULT_SOUL_SHIELD = 0;
	
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;
	protected int soulHealth;
	protected int soulShield;
	protected boolean active = true;

	public Entity(float x, float y, int width, int height) {
		this.soulHealth = DEFAULT_SOUL_HEALTH;
		this.soulShield = DEFAULT_SOUL_SHIELD;
		this.x = x;
		this.y = x;
		this.width = width;
		this.height = height;
		
		this.bounds = new Rectangle(0, 0, width, height);
	}

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract void die();
	
	public void hurt(int amount) {
		this.soulHealth -= amount;
		if(this.soulHealth <= 0)
			this.active = false;
			this.die();
	}
	
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for(Entity e : Game.handler.getWorld().getEntityManager().getEntities()) {
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
	
	public int getSoulHealth() {
		return soulHealth;
	}

	public void setSoulHealth(int soulHealth) {
		this.soulHealth = soulHealth;
	}

	public int getSoulShield() {
		return soulShield;
	}

	public void setSoulShield(int soulShield) {
		this.soulShield = soulShield;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
