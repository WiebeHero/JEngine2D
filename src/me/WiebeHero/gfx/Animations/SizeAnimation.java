package me.WiebeHero.gfx.Animations;

public class SizeAnimation extends Animation{
	
	private int widthOffset, heightOffset;
	
	/**
	 * A constructor to create a new SizeAnimation. With this animation, you
	 * will be able to change the size of any UIObject if it accepts an animation object.
	 *
	 * @param speed | Speed the animation needs to play in nano seconds.
	 * @param frames | Spritesheet frames for the animation to play.
	 * @param widthOffset | The offset of the width, it can be positive or negative.
	 * @param heightOffset | The offset of the height, it can be positive or negative.
	 * @param options | Options for the animation. 0 = PAUSED | 1 = REVERSED | 2 = LOOP | 3 = HOVER TRIGGER
	 */
	public SizeAnimation(int speed, int max, int widthOffset, int heightOffset, AnimOption... options) {
		super(speed, max, options);
		this.widthOffset = widthOffset;
		this.heightOffset = heightOffset;
		this.setAnimationType(AnimType.SIZE);
	}
	
	/**
	 * Get the current width offset of the animation.
	 */
	public int getWidthOffset() {
		return this.widthOffset;
	}
	/**
	 * Set the current width offset of the animation.
	 * 
	 * @param widthOffset | The value to set as the width offset.
	 */
	public void setWidthOffset(int widthOffset) {
		this.widthOffset = widthOffset;
	}
	/**
	 * Get the current height offset of the animation.
	 */
	public int getHeightOffset() {
		return this.heightOffset;
	}
	/**
	 * Set the current height offset of the animation.
	 * 
	 * @param heightOffset | The value to set as the height offset.
	 */
	public void setHeightOffset(int heightOffset) {
		this.heightOffset = heightOffset;
	}
	
}
