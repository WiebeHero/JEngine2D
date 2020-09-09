package me.WiebeHero.States;

import java.awt.Color;
import java.awt.Graphics;

import me.WiebeHero.Main.Handler;

public class MenuState extends State{

	public MenuState(Handler handler) {
		super(handler);
	}
	
	@Override
	public void tick() {
		if(this.handler.getMouseManager().isLeftPressed() && this.handler.getMouseManager().isRightPressed()) {
			State.setState(this.handler.getGame().gameState);
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(this.handler.getMouseManager().getMouseX(), this.handler.getMouseManager().getMouseY(), 8, 8);
	}

}
