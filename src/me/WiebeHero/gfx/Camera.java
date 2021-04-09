package me.WiebeHero.gfx;

public abstract class Camera {
	
	protected CameraPosition cameraPos;
	protected Screen screen;
	
	/**
	 * Constructor for the Camera class, cannot be instantiated normally
	 * due to it being an abstract class.
	 * @param cameraPos | Camera Position the Camera uses to dynamically manage it's position.
	 * @param screen | Screen, the class that manages the width and height of the screen.
	 */
	public Camera(CameraPosition cameraPos, Screen screen) {
		this.cameraPos = cameraPos;
		this.screen = screen;
	}
	/**
	 * A getter that returns the CameraPosition object of the Camera.
	 * @return CameraPosition
	 */
	public CameraPosition getCameraPosition() {
		return this.cameraPos;
	}
	/**
	 * A getter that returns the Screen object of the Camera.
	 * @return Screen
	 */
	public Screen getScreen() {
		return this.screen;
	}
	
}
