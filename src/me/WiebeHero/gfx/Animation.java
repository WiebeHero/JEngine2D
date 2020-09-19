package me.WiebeHero.gfx;

import java.awt.image.BufferedImage;

import me.WiebeHero.gfx.AnimationTypes.AnimationType;

public abstract class Animation {
	
	private int speed, index, max;
	private long lastTime, timer;
	private BufferedImage[] frames;
	private AnimationType type;
	
	//**OPTIONS**
	//There are different options you can choose for the animation to perform
	//Arguments: 0 = PAUSED | 1 = REVERSED | 2 = LOOP | 3 = HOVER TRIGGER
	//**OPTIONS**
	
	private boolean[] options;
	private boolean hovering;
	
	/**
	 * This constructor can not be called. Because it is an abstract class.
	 *
	 * @param speed | speed the animation needs to play in nano seconds
	 * @param frames | frames for the animation to play
	 * @param options | options for the animation.
	 */
	public Animation(int speed, BufferedImage[] frames, boolean... options) {
		this.speed = speed;
		this.frames = frames;
		this.options = new boolean[4];
		for(int i = 0; i < options.length; i++) {
			this.options[i] = options[i];
		}
		this.max = this.frames.length;
		if(this.isReversed()) {
			this.index = this.max - 1;
		}
		else {
			this.index = 0;
		}
		this.timer = 0;
		this.lastTime = System.currentTimeMillis();
	}
	
	/**
	 * This constructor can not be called. Because it is an abstract class.
	 *
	 * @param speed | speed the animation needs to play in nano seconds
	 * @param frames | frames for the animation to play
	 * @param options | options for the animation.
	 */
	public Animation(int speed, int max, boolean... options) {
		this.speed = speed;
		this.max = max;
		this.index = 0;
		this.timer = 0;
		this.options = new boolean[4];
		for(int i = 0; i < options.length; i++) {
			this.options[i] = options[i];
		}
		if(this.isReversed()) {
			this.index = this.max - 1;
		}
		else {
			this.index = 0;
		}
		this.lastTime = System.currentTimeMillis();
	}
	/**
	 * This method handles the index increment for animations.
	 */
	public void tick() {
		this.timer += System.currentTimeMillis() - this.lastTime;
		this.lastTime = System.currentTimeMillis();
		if(this.timer > this.speed) {
			if(!this.isPaused()) {
				this.index += this.isReversed() ? -1 : 1;
				this.timer = 0;
				if(this.triggerOnHover()) {
					this.setReversed(this.hovering ? false : true);
				}
				if(this.isReversed() ? this.index < 0 : this.index >= this.max) {
					if(!this.isLooping()) {
						this.index = this.isReversed() ? 0 : this.max - 1;
						this.setPaused(true);
						this.setReversed(this.isReversed() ? false : true);
					}
					else {
						this.index = 0;
					}
				}
			}
			else if(this.triggerOnHover()) {
				if(this.hovering ? this.isOnLastIndex() : this.isOnFirstIndex()) {
					this.setPaused(true);
				}
				else {
					this.setPaused(false);
				}
			}
		}
	}
	/**
	 * This method returns a boolean if the index is the same as the max.
	 */
	public boolean isOnLastIndex() {
		return this.index >= this.max - 1;
	}
	/**
	 * This method returns a boolean if the index is on 0.
	 */
	public boolean isOnFirstIndex() {
		return this.index == 0;
	}
	/**
	 * This method returns the current index of the animation.
	 */
	public int getCurrentIndex() {
		return this.index;
	}
	/**
	 * Returns the speed that the animation runs at in nanoseconds.
	 */
	public int getSpeed() {
		return this.speed;
	}
	/**
	 * Sets the speed of the animation runs at in nanoseconds.
	 * 
	 * @param speed | Speed of the index to increment in nanoseconds.
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	/**
	 * Returns a boolean saying if the animation is paused. (If it's playing or not)
	 */
	public boolean isPaused() {
		return this.options[0];
	}
	/**
	 * Sets the animation on a paused state. (Stops playing)
	 * 
	 * @param paused | If the animation should be paused or not.
	 */
	public void setPaused(boolean paused) {
		this.options[0] = paused;
	}
	/**
	 * Returns a boolean saying if the animation is reversed. (If it's playing backwards or not)
	 */
	public boolean isReversed() {
		return this.options[1];
	}
	/**
	 * Sets the animation on a reversed state. (Stars playing in reverse)
	 * 
	 * @param reversed | If the animation should be reversed or not.
	 */
	public void setReversed(boolean reversed) {
		this.options[1] = reversed;
	}
	/**
	 * Returns a boolean saying if the animation is looping. (If it starts over at the end of the animation)
	 */
	public boolean isLooping() {
		return this.options[2];
	}
	/**
	 * Sets the animation on a loop state. (Starts looping the animation)
	 * 
	 * @param loop | If the animation should loop or not.
	 */
	public void setLooping(boolean loop) {
		this.options[2] = loop;
	}
	/**
	 * Returns a boolean saying if the animation is triggers on hover. (Animation starts when hovering over something)
	 */
	public boolean triggerOnHover() {
		return this.options[3];
	}
	/**
	 * Sets the animation on a hover trigger state. (Play animation on hover)
	 * 
	 * @param loop | If the animation should activate on trigger or not.
	 */
	public void setHoverTrigger(boolean hoverTrigger) {
		this.options[3] = hoverTrigger;
	}
	/**
	 * Sets the animation on a hover trigger state. (Play animation on hover)
	 * 
	 * @param loop | If the animation should activate on trigger or not.
	 */
	public void setHovering(boolean hovering) {
		this.hovering = hovering;
	}
	/**
	 * Returns an enum of the animations type.
	 */
	public AnimationType getAnimationType() {
		return this.type;
	}
	/**
	 * Sets the type of the animation.
	 * 
	 * @param type | Animation type.
	 */
	public void setAnimationType(AnimationType type) {
		this.type = type;
	}
}
