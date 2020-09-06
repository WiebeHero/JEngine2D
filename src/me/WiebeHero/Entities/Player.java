package me.WiebeHero.Entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import me.WiebeHero.Main.Handler;
import me.WiebeHero.gfx.Animation;
import me.WiebeHero.gfx.Assets;

public class Player extends Creature{
	
	//Animations
	private Animation animDown, animUp, animLeft, animRight;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		this.bounds.x = 16;
		this.bounds.y = 32;
		this.bounds.width = 32;
		this.bounds.height = 32;
		
		//Animations
		this.animDown = new Animation(125, Assets.player_down);
		this.animUp = new Animation(125, Assets.player_up);
		this.animLeft = new Animation(125, Assets.player_left);
		this.animRight = new Animation(125, Assets.player_right);
	}

	@Override
	public void tick() {
		//Animations
		this.animDown.tick();
		this.animUp.tick();
		this.animLeft.tick();
		this.animRight.tick();
		//Movement
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
		g.drawImage(this.getCurrentAnimationFrame(), (int)(this.x - this.handler.getGameCamera().getxOffset()), (int)(this.y - this.handler.getGameCamera().getyOffset()), this.width, this.height, null);
//		g.setColor(Color.RED);
//		g.fillRect((int)(this.x + this.bounds.x - this.handler.getGameCamera().getxOffset()), 
//				(int)(this.y + this.bounds.y - this.handler.getGameCamera().getyOffset()),
//				this.bounds.width, this.bounds.height);
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		
		switch(this.getDirection()) {
			case LEFT:
				if(this.xMove < 0) {//Left Animation
					return this.animLeft.getCurrentFrame();
				}
				else {
					return Assets.player_left_still;
				}
			case RIGHT:
				if(this.xMove > 0) {//Right Animation
					return this.animRight.getCurrentFrame();
				}
				else {
					return Assets.player_right_still;
				}
			case UP:
				if(this.yMove < 0) {//Up Animation
					return this.animUp.getCurrentFrame();
				}
				else {
					return Assets.player_up_still;
				}
			case DOWN:
				if(this.yMove > 0) {//Down Animation
					return this.animDown.getCurrentFrame();
				}
				else {
					return Assets.player_down_still;
				}
			default:
				return Assets.player_down_still;
		}
	}
	
}
