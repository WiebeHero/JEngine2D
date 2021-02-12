package me.WiebeHero.Main;

import me.WiebeHero.Display.Display;
import me.WiebeHero.Input.KeyManager;
import me.WiebeHero.Input.MouseManager;
import me.WiebeHero.Worlds.World;
import me.WiebeHero.gfx.GameCamera;

public class Handler {
	
	private Game game;
	private World world;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public int getWidth() {
		return this.game.getWidth();
	}
	
	public int getHeight() {
		return this.game.getHeight();
	}
	
	public KeyManager getKeyManager() {
		return this.game.getKeyManager();
	}
	
	public MouseManager getMouseManager() {
		return this.game.getMouseManager();
	}
	
	public GameCamera getGameCamera() {
		return this.game.getGameCamera();
	}

	public Game getGame() {
		return game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
	public Display getDisplay() {
		return this.game.getDisplay();
	}
	
}
