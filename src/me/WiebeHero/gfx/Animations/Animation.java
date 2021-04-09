package me.WiebeHero.gfx.Animations;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public abstract class Animation {
	
	private int speed, index, max;
	private long lastTime, timer;
	private BufferedImage[] frames;
	private AnimType type;
	
	//**OPTIONS**
	//There are different options you can choose for the animation to perform
	//Arguments: 0 = PAUSED | 1 = REVERSED | 2 = LOOP | 3 = HOVER TRIGGER | 4 = PAUSE WHEN REACHING END OF LOOP
	//**OPTIONS**
	
	private AnimationOption[] animOptions;
	private boolean hovering;
	
	/**
	 * This constructor can not be called. Because it is an abstract class.
	 *
	 * @param speed | speed the animation needs to play in nano seconds
	 * @param frames | frames for the animation to play
	 * @param options | options for the animation.
	 */
	public Animation(int speed, BufferedImage[] frames, AnimOption... options) {
		this.speed = speed;
		this.frames = frames;
		this.animOptions = this.getBasicOptions(options);
		this.max = this.frames.length;
		if(this.getOptionState(AnimOption.REVERSED)) {
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
	public Animation(int speed, int max, AnimOption... options) {
		this.speed = speed;
		this.max = max;
		this.index = 0;
		this.timer = 0;
		this.animOptions = this.getBasicOptions(options);
		if(this.getOptionState(AnimOption.REVERSED)) {
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
		boolean reversed = this.getOptionState(AnimOption.REVERSED);
		boolean paused = this.getOptionState(AnimOption.PAUSED);
		boolean triggerOnHover = this.getOptionState(AnimOption.HOVER_TRIGGER);
		boolean looping = this.getOptionState(AnimOption.LOOP);
		boolean pauseEndLoop = this.getOptionState(AnimOption.PAUSE_END_LOOP);
		if(this.timer <= this.speed) 
			return;
		if(!paused) {
			if(triggerOnHover) {
				this.setOptionState(AnimOption.REVERSED, this.hovering ? false : true);
			}
			this.timer = 0;
			this.index += reversed ? -1 : 1;
			if(reversed ? this.index < 0 : this.index >= this.max) {
				if(!looping) {
					this.index = reversed ? 0 : this.max - 1;
					this.setOptionState(AnimOption.PAUSED, true);
					this.setOptionState(AnimOption.REVERSED, reversed ? false : true);
				}
				else {
					if(pauseEndLoop) {
						this.index = 0;
						this.setOptionState(AnimOption.PAUSED, true);
					}
					else {
						this.index = 0;
					}
				}
			}
		}
		else if(triggerOnHover) {
			if(this.hovering ? this.isOnLastIndex() : this.isOnFirstIndex()) {
				this.setOptionState(AnimOption.PAUSED, true);
			}
			else {
				this.setOptionState(AnimOption.PAUSED, false);
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
	 * Turn an animation option on or off.
	 * 
	 * @param option | AnimOption: Which option should be turned on or off.
	 * @param state | boolean: Turn on or off.
	 */
	public void setOptionState(AnimOption option, boolean state) {
		for(int i = 0; i < this.animOptions.length; i++) {
			AnimationOption animOption = this.animOptions[i];
			if(animOption.getOptionType() == option)
				animOption.setState(state);
		}
	}
	/**
	 * Get an Animations option state
	 * 
	 * @param option | AnimOption: Which options state you want to see.
	 */
	public boolean getOptionState(AnimOption option) {
		for(int i = 0; i < this.animOptions.length; i++) {
			AnimationOption animOption = this.animOptions[i];
			if(animOption.getOptionType() == option)
				return animOption.getState();
		}
		return false;
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
	public AnimType getAnimationType() {
		return this.type;
	}
	/**
	 * Sets the type of the animation.
	 * 
	 * @param type | Animation type.
	 */
	public void setAnimationType(AnimType type) {
		this.type = type;
	}
	/**
	 * Get a basic setup for the AnimationOptions. The paramater in this getter
	 * is the Animation is the list of Animation Options you want to be enabled
	 * 
	 * @param enabled | Animation Options you want to be enabled upon instantiation
	 */
	private AnimationOption[] getBasicOptions(AnimOption enabled[]) {
		Set<AnimOption> setEnabled = new HashSet<>(Arrays.asList(enabled));
		AnimOption options[] = AnimOption.values();
		AnimationOption[] animOptions = new AnimationOption[options.length];
		for(int i = 0; i < options.length; i++) {
			AnimOption option = options[i];
			if(setEnabled.contains(option)) {
				animOptions[i] = new AnimationOption(option, true);
			}
			else {
				animOptions[i] = new AnimationOption(option, false);
			}
		}
		return animOptions;
	}
}
