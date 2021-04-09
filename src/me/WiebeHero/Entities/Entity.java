package me.WiebeHero.Entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import me.WiebeHero.Worlds.World;

public abstract class Entity {
	
	// CLASS

	public static final int DEFAULT_SOUL_HEALTH = 3;
	public static final int DEFAULT_SOUL_SHIELD = 0;
	
	protected World world;
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;
	protected int soulHealth;
	protected int soulShield;
	protected boolean active = true;
	
	/**
	 * The entity constructor, cannot be called by itself due to it being
	 * an abstract class.
	 * @param x			| The X position of the Entity.
	 * @param y			| The Y position of the Entity.
	 * @param width		| The Width of the Entity.
	 * @param height	| The Height of the Entity.
	 */
	public Entity(float x, float y, int width, int height, World world) {
		this.world = world;
		this.soulHealth = DEFAULT_SOUL_HEALTH;
		this.soulShield = DEFAULT_SOUL_SHIELD;
		this.x = x;
		this.y = x;
		this.width = width;
		this.height = height;
		
		this.bounds = new Rectangle(0, 0, width, height);
	}
	
	/**
	 * A method that is called every frame.
	 */
	public abstract void tick();
	/**
	 * A method that is also called every frame, but draws stuff on the canvas during
	 * that.
	 * @param g	| Graphics object, the object you use to draw stuff on the Canvas.
	 */
	public abstract void render(Graphics g);
	/**
	 * A method that is called when the SoulHealth of an Entity reaches bellow 0.
	 */
	public abstract void die();
	/**
	 * A method that removes SoulHealth by a certain amount.
	 * @param amount | The amount of that needs to be removed from SoulHealth.
	 */
	public void hurt(int amount) {
		this.soulHealth -= amount;
		if(this.soulHealth > 0)
			return;
		this.active = false;
		this.die();
	}
	/**
	 * A method that is called to see if this Entity is colliding with
	 * any other entity.
	 * @param xOffset  | X Offset of the collision bounds.
	 * @param yOffset  | Y Offset of the collision bounds.
	 * @return boolean | To see if the Entity is or is not colliding with another Entity.
	 */
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for(Entity e : this.world.getEntityManager().getEntities()) {
			if(!e.equals(this)) {
				if(e.getCollisionBounds(0F, 0F).intersects(this.getCollisionBounds(xOffset, yOffset))) {
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * A method that creates a quick Rectangle, or basically 'CollisionBounds'
	 * @param xOffset    | X Offset of the collision bounds.
	 * @param yOffset    | Y Offset of the collision bounds.
	 * @return Rectangle | The Collision Bounds that were created.
	 */
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int)(this.x + this.bounds.x + xOffset), (int)(this.y + this.bounds.y + yOffset), this.bounds.width, this.bounds.height);
	}
	
	// GETTERS AND SETTERS
	
	/**
	 * A getter that returns the X position of the Entity.
	 * @return x | X position of the Entity.
	 */
	public float getX() {
		return x;
	}
	/**
	 * A setter that sets the X position of the Entity.
	 * @param x | The desired X position of the Entity.
	 */
	public void setX(float x) {
		this.x = x;
	}
	/**
	 * A getter that returns the Y position of the Entity.
	 * @return y | Y position of the Entity.
	 */
	public float getY() {
		return y;
	}
	/**
	 * A setter that sets the Y position of the Entity.
	 * @param y | The desired Y position of the Entity.
	 */
	public void setY(float y) {
		this.y = y;
	}
	/**
	 * A getter that returns the Width of the Entity.
	 * @return width | Width of the Entity.
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * A setter that sets the Width of the Entity.
	 * @param width | The desired Width of the Entity.
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * A getter that returns the Height of the Entity.
	 * @return height | Height of the Entity.
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * A setter that sets the Height of the Entity.
	 * @param height | The desired Height of the Entity.
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * A getter that returns the Soul Health of the Entity.
	 * @return soulHealth | The Soul Health of the Entity.
	 */
	public int getSoulHealth() {
		return soulHealth;
	}
	/**
	 * A setter that sets the Soul Health of the Entity.
	 * @param soulHealth | The desired Soul Health of the Entity.
	 */
	public void setSoulHealth(int soulHealth) {
		this.soulHealth = soulHealth;
	}
	/**
	 * A getter that returns the Soul Shield of the Entity.
	 * @return soulShield | The Soul Shield of the Entity.
	 */
	public int getSoulShield() {
		return soulShield;
	}
	/**
	 * A setter that sets the Soul Shield of the Entity.
	 * @param soulShield | The desired Soul Shield of the Entity.
	 */
	public void setSoulShield(int soulShield) {
		this.soulShield = soulShield;
	}
	/**
	 * A getter that returns the Active state of the Entity.
	 * @return active | The active state of the Entity.
	 */
	public boolean isActive() {
		return active;
	}
	/**
	 * A setter that sets the Active state of the Entity.
	 * @param active | The desired active state of the Entity.
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
}
