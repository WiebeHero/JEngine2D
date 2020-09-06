package me.WiebeHero.Entities;

import java.awt.Color;
import java.awt.Graphics;

import me.WiebeHero.Main.Handler;
import me.WiebeHero.gfx.Assets;

public class Player extends Creature{
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		this.bounds.x = 16;
		this.bounds.y = 32;
		this.bounds.width = 32;
		this.bounds.height = 32;
		
	}

	@Override
	public void tick() {
		this.getInput();
		this.move();
		this.handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput() {
		this.xMove = 0.0F;
		this.yMove = 0.0F;
		
		if(this.handler.getKeyManager().up) {
			this.yMove = -this.speed;
		}
		if(this.handler.getKeyManager().down) {
			this.yMove = this.speed;
		}
		if(this.handler.getKeyManager().left) {
			this.xMove = -this.speed;
		}
		if(this.handler.getKeyManager().right) {
			this.xMove = this.speed;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.PLAYER, (int)(this.x - this.handler.getGameCamera().getxOffset()), (int)(this.y - this.handler.getGameCamera().getyOffset()), this.width, this.height, null);
//		g.setColor(Color.RED);
//		g.fillRect((int)(this.x + this.bounds.x - this.handler.getGameCamera().getxOffset()), 
//				(int)(this.y + this.bounds.y - this.handler.getGameCamera().getyOffset()),
//				this.bounds.width, this.bounds.height);
	}

}
