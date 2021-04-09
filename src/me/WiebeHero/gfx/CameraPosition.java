package me.WiebeHero.gfx;

public class CameraPosition {
	
	private float xOffset, yOffset;
	/**
	 * Constructor of the CameraPosition, use the parameters to set the starting
	 * position of the actual Camera.
	 * @param xOffset | X Position of the Camera.
	 * @param yOffset | Y Position of the Camera.
	 */
	public CameraPosition(float xOffset, float yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	/**
	 * A getter that returns the X position of the Camera.
	 * @return xOffset | X position of the Camera.
	 */
	public float getXOffset() {
		return this.xOffset;
	}
	/**
	 * A setter that sets the X position of the Camera.
	 * @param xOffset | X position of the Camera.
	 */
	public void setXOffset(float xOffset) {
		this.xOffset = xOffset;
	}
	/**
	 * A getter that returns the Y position of the Camera.
	 * @return yOffset | Y position of the Camera.
	 */
	public float getYOffset() {
		return this.yOffset;
	}
	/**
	 * A setter that sets the Y position of the Camera.
	 * @param yOffset | Y position of the Camera.
	 */
	public void setYOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}
