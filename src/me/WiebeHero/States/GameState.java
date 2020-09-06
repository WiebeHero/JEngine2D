package me.WiebeHero.States;

import java.awt.Graphics;

import me.WiebeHero.gfx.Assets;

public class GameState extends State{

	public GameState() {
		
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.DIRT, 0, 0, null);
	}

}
