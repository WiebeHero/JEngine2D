package me.WiebeHero.gfx;

import java.awt.image.BufferedImage;

import me.WiebeHero.gfx.AnimationTypes.AnimationType;

public class SpriteAnimation extends Animation{
	
	private BufferedImage frames[];
	
	/**
	 * A constructor to create a new SpriteAnimation. With this animation, you
	 * will be able to display different images from a spritesheet.
	 *
	 * @param speed | Speed the animation needs to play in nano seconds.
	 * @param frames | Spritesheet frames for the animation to play.
	 * @param options | Options for the animation. 0 = PAUSED | 1 = REVERSED | 2 = LOOP | 3 = HOVER TRIGGER
	 */
	public SpriteAnimation(int speed, BufferedImage[] frames, boolean... options) {
		super(speed, frames, options);
		this.frames = frames;
		this.setAnimationType(AnimationType.SPRITE);
	}
	
	/**
	 * Returns an image of the current displayed frame.
	 */
	public BufferedImage getCurrentFrame() {
		return this.frames[this.getCurrentIndex()];
	}
	
}
