package me.WiebeHero.States;

import java.awt.Graphics;

import me.WiebeHero.Main.Game;
import me.WiebeHero.Worlds.World;

public class GameState extends State{
	
	private World world;

	public GameState() {
		this.world = new World("worlds/MainWorld.txt");
		Game.handler.setWorld(this.world);
	}
	
	@Override
	public void tick() {
		this.world.tick();
	}

	@Override
	public void render(Graphics g) {
		this.world.render(g);
	}

	@Override
	public void initMouseManager() {
		
	}

}
