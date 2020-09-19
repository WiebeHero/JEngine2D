package me.WiebeHero.gfx;

import me.WiebeHero.gfx.AnimationTypes.AnimationType;

public class MovementAnimation extends Animation{
	
	private float xOffset, yOffset;
	
	/**
	 * A constructor to create a new MovementAnimation. With this animation, you
	 * will be able to change the x and y of any UIObject if it accepts an animation object.
	 *
	 * @param speed | Speed the animation needs to play in nano seconds.
	 * @param frames | Spritesheet frames for the animation to play.
	 * @param xOffset | The offset of the x, it can be positive or negative.
	 * @param yOffset | The offset of the y, it can be positive or negative.
	 * @param options | Options for the animation. 0 = PAUSED | 1 = REVERSED | 2 = LOOP | 3 = HOVER TRIGGER
	 */
	public MovementAnimation(int speed, int max, float xOffset, float yOffset, boolean... options) {
		super(speed, max, options);
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.setAnimationType(AnimationType.MOVEMENT);
	}
	/**
	 * Get the current x offset of the animation.
	 */
	public float getXOffset() {
		return this.xOffset;
	}
	/**
	 * Set the current x offset of the animation.
	 * 
	 * @param xOffset | The value to set as the x offset.
	 */
	public void setXOffset(float xOffset) {
		this.xOffset = xOffset;
	}
	/**
	 * Get the current y offset of the animation.
	 */
	public float getYOffset() {
		return this.yOffset;
	}
	/**
	 * Set the current y offset of the animation.
	 * 
	 * @param yOffset | The value to set as the y offset.
	 */
	public void setYOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}
