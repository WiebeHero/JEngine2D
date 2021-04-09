package me.WiebeHero.Tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Tile {
	
	//CLASS
	
	protected BufferedImage texture;
	protected final int id;
	/**
	 * The constructor for the Tile class, can normally not be called since it
	 * is an abstract class.
	 * @param texture | Image for the Tile.
	 * @param id | Id for the Tile.
	 */
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
	}
	/**
	 * A method that is called every frame.
	 */
	public abstract void tick();
	/**
	 * A method that manages rendering the tile to the screen.
	 * @param g | Graphics.
	 * @param x | X Position of the tile.
	 * @param y | Y Position of the tile.
	 */
	public abstract void render(Graphics g, int x, int y);
	/**
	 * A getter to get the ID of the Tile.
	 * @return
	 */
	public int getId() {
		return this.id;
	}
	
}
