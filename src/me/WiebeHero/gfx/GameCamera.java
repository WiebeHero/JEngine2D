package me.WiebeHero.gfx;

import me.WiebeHero.Entities.Entity;
import me.WiebeHero.Main.Game;
import me.WiebeHero.Main.Handler;
import me.WiebeHero.Tiles.Tile;

public class GameCamera {
	
	private float xOffset, yOffset;
	
	public GameCamera(float xOffset, float yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void checkBlankSpace() {
		Handler handler = Game.handler;
		if(this.xOffset < 0) {
			this.xOffset = 0;
		}
		else if(this.xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()) {
			this.xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		}
		if(this.yOffset < 0) {
			this.yOffset = 0;
		}
		else if(this.yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()) {
			this.yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
		}
	}
	
	public void centerOnEntity(Entity entity) {
		Handler handler = Game.handler;
		this.xOffset = entity.getX() - handler.getWidth() / 2 + entity.getWidth() / 2;
		this.yOffset = entity.getY() - handler.getHeight() / 2 + entity.getHeight() / 2;
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
