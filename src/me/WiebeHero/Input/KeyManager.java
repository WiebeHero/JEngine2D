package me.WiebeHero.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import me.WiebeHero.Settings.Settings;

public class KeyManager implements KeyListener{
	
	private boolean[] keys;
	public boolean up, down, left, right, sprint;
	public boolean aUp, aDown, aLeft, aRight;
	
	public KeyManager() {
		this.keys = new boolean[256];
	}
	
	public void tick() {
		this.up = this.keys[Settings.up];
		this.left = this.keys[Settings.left];
		this.right = this.keys[Settings.right];
		this.down = this.keys[Settings.down];
		this.sprint = this.keys[Settings.sprint];
		
		this.aUp = this.keys[Settings.aUp];
		this.aDown = this.keys[Settings.aDown];
		this.aLeft = this.keys[Settings.aLeft];
		this.aRight = this.keys[Settings.aRight];
	}

	@Override
	public void keyPressed(KeyEvent event) {
		this.keys[event.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent event) {
		this.keys[event.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent event) {
		
	}
	
	public boolean[] getKeys() {
		return this.keys;
	}
	
}
