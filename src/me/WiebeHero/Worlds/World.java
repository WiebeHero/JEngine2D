package me.WiebeHero.Worlds;

import java.awt.Graphics;

import me.WiebeHero.Entities.EntityManager;

public abstract class World {
	
	protected int width, height;
	
	protected EntityManager entityManager;
	/**
	 * A constructor that cannot be called, since this is an abstract class.
	 * Initializes the EntityManager of the world
	 */
	public World() {
		this.entityManager = new EntityManager();
	}
	/**
	 * A constructor that cannot be called, since this is an abstract class.
	 * Initializes the Width, Height and EntityManager of the world.
	 * @param width | Width of the World.
	 * @param height | Height of the World.
	 */
	public World(int width, int height) {
		this.width = width;
		this.height = height;
		this.entityManager = new EntityManager();
	}
	/**
	 * A method that is called every frame to tick other objects.
	 */
	public abstract void tick();
	/**
	 * A method that is called every frame to render other objects.
	 * @param g | Graphics
	 */
	public abstract void render(Graphics g);
	/**
	 * A getter that returns the EntityManager of the world.
	 * @return entityManager | EntityManager
	 */
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	/**
	 * A getter that returns the width of the world.
	 * @return width | Width of World.
	 */
	public int getWidth() {
		return this.width;
	}
	/**
	 * A getter that returns the height of the world.
	 * @return height | Height of World.
	 */
	public int getHeight() {
		return this.height;
	}
}
