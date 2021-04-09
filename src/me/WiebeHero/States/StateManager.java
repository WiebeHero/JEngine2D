package me.WiebeHero.States;

public class StateManager {
	
	private static StateManager instance = new StateManager();
	
	private State[] states;
	
	private State currentState = null;
	
	/**
	 * A constructor of the StateManager class. Initializes nothing.
	 */
	private StateManager() {
		
	}
	/**
	 * Get an instance of the StateManager.
	 * @return instance | StateManager.
	 */
	public static StateManager getInstance() {
		return instance;
	}
	/**
	 * Set the current state with the class template (Class.class)
	 * @param clazz | State
	 */
	public void setState(Class<? extends State> clazz) {
		if(this.states.length != 0) {
			for(int i = 0; i < this.states.length; i++) {
				if(this.states[i].getClass().isAssignableFrom(clazz)) {
					this.currentState = this.states[i];
				}
			}
		}
	}
	/**
	 * A getter that gets the current state the game is running on.
	 * @return currentState | State
	 */
	public State getState() {
		return currentState;
	}
	/**
	 * A getter that gets the state based on the index if it is present.
	 * @param index | The state you want to retrieve.
	 * @return State | The state that you have chosen from this class.
	 */
	public State getState(int index) {
		if(index >= 0 && index < states.length) {
			return this.states[index];
		}
		return null;
	}
	/**
	 * A getter that gets the state based on the class if it is present.
	 * @param clazz | The state you want to retrieve.
	 * @return State | The state that you have chosen from this class.
	 */
	public State getState(Class<? extends State> clazz) {
		if(this.states.length != 0) {
			for(int i = 0; i < this.states.length; i++) {
				if(this.states[i].getClass().isAssignableFrom(clazz)) {
					return this.states[i];
				}
			}
		}
		return null;
	}
	/**
	 * A void that sets all of the states of the StateManager (RECOMMENDED TO ONLY DO THIS ONCE!)
	 */
	public void setStates(State... states) {
		this.states = states;
	}
}
