package me.WiebeHero.gfx;

public class AnimationOption {
	
	private AnimOption option;
	private boolean state;
	
	/**
	 * This class is a class for animation options.
	 * This is used in the Abstract Animation class to
	 * set different options for the according animation.
	 * 
	 * @param option | Type of option
	 * @param state | Enable the option or not
	 * 
	 */
	
	public AnimationOption(AnimOption option, boolean state) {
		this.option = option;
		this.state = state;
	}
	
	public AnimationOption(int option, boolean state) {
		this.option = AnimOption.values()[option];
		this.state = state;
	}
	
	public AnimOption getOptionType() {
		return this.option;
	}
	
	public boolean getState() {
		return this.state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
	
}
