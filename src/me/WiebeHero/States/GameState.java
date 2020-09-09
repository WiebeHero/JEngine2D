package me.WiebeHero.States;

import java.awt.Graphics;

import me.WiebeHero.Entities.Player;
import me.WiebeHero.Entities.StaticEntities.Tree;
import me.WiebeHero.Main.Handler;
import me.WiebeHero.Worlds.World;

public class GameState extends State{
	
	private World world;

	public GameState(Handler handler) {
		super(handler);
		this.world = new World(this.handler, "res/worlds/MainWorld.txt");
		this.handler.setWorld(this.world);
	}
	
	@Override
	public void tick() {
		this.world.tick();
	}

	@Override
	public void render(Graphics g) {
		this.world.render(g);
	}

}
