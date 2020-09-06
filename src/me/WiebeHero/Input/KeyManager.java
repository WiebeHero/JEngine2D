package me.WiebeHero.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	
	private boolean[] keys;
	public boolean up, down, left, right;
	
	public KeyManager() {
		this.keys = new boolean[256];
	}
	
	public void tick() {
		this.up = this.keys[KeyEvent.VK_W];
		this.left = this.keys[KeyEvent.VK_A];
		this.right = this.keys[KeyEvent.VK_D];
		this.down = this.keys[KeyEvent.VK_S];
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
	
	
	
}
