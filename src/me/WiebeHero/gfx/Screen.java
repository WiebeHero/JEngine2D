package me.WiebeHero.gfx;

public class Screen {

	private int width, height;
	/**
	 * Constructor for the Screen class
	 * @param width
	 * @param height
	 */
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
	}
	/**
	 * A getter that returns the width of the Screen.
	 * @return width | Width of the screen.
	 */
	public int getWidth() {
		return this.width;
	}
	/**
	 * A getter that returns the height of the Screen.
	 * @return height | Height of the screen.
	 */
	public int getHeight() {
		return this.height;
	}
	/**
	 * A method that Resizes the Canvas and Screen.
	 * @param width | Width of the Screen.
	 * @param height | Height of the Screen.
	 */
	public void resize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
}
