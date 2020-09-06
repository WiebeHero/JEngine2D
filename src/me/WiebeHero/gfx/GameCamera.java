package me.WiebeHero.gfx;

import me.WiebeHero.Entities.Entity;
import me.WiebeHero.Main.Handler;
import me.WiebeHero.Tiles.Tile;

public class GameCamera {
	
	private Handler handler;
	private float xOffset, yOffset;
	
	public GameCamera(Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void checkBlankSpace() {
		if(this.xOffset < 0) {
			this.xOffset = 0;
		}
		else if(this.xOffset > this.handler.getWorld().getWidth() * Tile.TILEWIDTH - this.handler.getWidth()) {
			this.xOffset = this.handler.getWorld().getWidth() * Tile.TILEWIDTH - this.handler.getWidth();
		}
		if(this.yOffset < 0) {
			this.yOffset = 0;
		}
		else if(this.yOffset > this.handler.getWorld().getHeight() * Tile.TILEHEIGHT - this.handler.getHeight()) {
			this.yOffset = this.handler.getWorld().getHeight() * Tile.TILEHEIGHT - this.handler.getHeight();
		}
	}
	
	public void centerOnEntity(Entity entity) {
		this.xOffset = entity.getX() - this.handler.getWidth() / 2 + entity.getWidth() / 2;
		this.yOffset = entity.getY() - this.handler.getHeight() / 2 + entity.getHeight() / 2;
		this.checkBlankSpace();
		
	}
	
	public void move(float xAmount, float yAmount) {
		this.xOffset += xAmount;
		this.yOffset += yAmount;
		this.checkBlankSpace();
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
}
