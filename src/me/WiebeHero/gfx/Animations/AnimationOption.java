package me.WiebeHero.gfx.Animations;

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
	
	/**
	 * This class is a class for animation options.
	 * This is used in the Abstract Animation class to
	 * set different options for the according animation.
	 * 
	 * @param option | Type of option
	 * @param state | Enable the option or not
	 * 
	 */
	
	public AnimationOption(int option, boolean state) {
		this.option = AnimOption.values()[option];
		this.state = state;
	}
	
	/**
	 * A getter that returns the Option that this class manages.
	 * @return option | Option that this class manages.
	 */
	public AnimOption getOptionType() {
		return this.option;
	}
	/**
	 * A getter that returns the state of the option that this class manages.
	 * @return state | State of the option that this class manages.
	 */
	public boolean getState() {
		return this.state;
	}
	/**
	 * A setter that sets the state of the option that this class manages.
	 * @param state | State of the option that this class manages.
	 */
	public void setState(boolean state) {
		this.state = state;
	}
	
}
