package me.WiebeHero.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import me.WiebeHero.UI.UIManager;

public abstract class KeyManager implements KeyListener{
	
	protected boolean[] keys;

	protected UIManager uiManager;
	/**
	 * A constructor that cannot be called regularly, since the KeyManager is an
	 * abstract class. It instantiates the keys array.
	 */
	public KeyManager() {
		this.keys = new boolean[256];
	}
	/**
	 * A setter that couples the UIManager to this class.
	 * @param uiManager | UIManager.
	 */
	public void setUIManager(UIManager uiManager) {
		this.uiManager = uiManager;
	}
	/**
	 * A getter that returns the UIManager coupled to this class.
	 * @return uiManager | UIManager.
	 */
	public UIManager getUIManager() {
		return this.uiManager;
	}
	/**
	 * This is a method that gets called every frame.
	 */
	public abstract void tick();
	/**
	 * A method that is called when a key is pressed.
	 * @param event | KeyEvent.
	 */
	@Override
	public abstract void keyPressed(KeyEvent event);
	/**
	 * A method that is called when a key is released.
	 * @param event | KeyEvent.
	 */
	@Override
	public abstract void keyReleased(KeyEvent event);
	/**
	 * A method that is called when a key is typed.
	 * @param event | KeyEvent.
	 */
	@Override
	public abstract void keyTyped(KeyEvent event);
	/**
	 * A getter that returns an array with keys. With the state of being pressed or not.
	 * @return keys
	 */
	public boolean[] getKeys() {
		return this.keys;
	}
	
}
