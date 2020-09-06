package me.WiebeHero.Entities;

import me.WiebeHero.Main.Handler;
import me.WiebeHero.Tiles.Tile;

public abstract class Creature extends Entity{
	
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0F;
	public static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CREATURE_HEIGHT = 64;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		this.health = DEFAULT_HEALTH;
		this.speed = DEFAULT_SPEED;
		this.xMove = 0.0F;
		this.yMove = 0.0F;
	}
	
	public void move() {
		this.moveX();
		this.moveY();
	}
	
	public void moveX() {
		if(this.xMove > 0) {//Moving Right
			int tx = (int) (this.x + this.xMove + this.bounds.x + this.bounds.width) / Tile.TILEWIDTH;
			
			if(!this.collisionWithTile(tx, (int)(this.y + this.bounds.y) / Tile.TILEHEIGHT) && 
					!this.collisionWithTile(tx, (int) (this.y + this.bounds.y + this.bounds.height) / Tile.TILEHEIGHT)) {
				this.x += this.xMove;
			}
			else {
				this.x = tx * Tile.TILEWIDTH - this.bounds.x - this.bounds.width - 1;
			}
			
		}
		else if(this.xMove < 0) {//Moving Left
			int tx = (int) (this.x + this.xMove + this.bounds.x) / Tile.TILEWIDTH;
			
			if(!this.collisionWithTile(tx, (int)(this.y + this.bounds.y) / Tile.TILEHEIGHT) && 
					!this.collisionWithTile(tx, (int) (this.y + this.bounds.y + this.bounds.height) / Tile.TILEHEIGHT)) {
				this.x += this.xMove;
			}
			else {
				this.x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - this.bounds.x;
			}
		}
	}
	
	public void moveY() {
		if(this.yMove < 0) {//Moving Up
			int ty = (int)(this.y + this.yMove + this.bounds.y) / Tile.TILEHEIGHT;
			
			if(!this.collisionWithTile((int) (this.x + this.bounds.x) / Tile.TILEWIDTH, ty) &&
					!this.collisionWithTile((int) (this.x + this.bounds.x + this.bounds.width) / Tile.TILEWIDTH, ty)) {
				this.y += this.yMove;
			}
			else {
				this.y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - this.bounds.y;
			}
		}
		else if(this.yMove > 0) {//Moving Down
			int ty = (int)(this.y + this.yMove + this.bounds.y + this.bounds.height) / Tile.TILEHEIGHT;
			
			if(!this.collisionWithTile((int) (this.x + this.bounds.x) / Tile.TILEWIDTH, ty) &&
					!this.collisionWithTile((int) (this.x + this.bounds.x + this.bounds.width) / Tile.TILEWIDTH, ty)) {
				this.y += this.yMove;
			}
			else {
				this.y = ty * Tile.TILEHEIGHT - this.bounds.y - this.bounds.height - 1;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return this.handler.getWorld().getTile(x, y).isSolid();
	}
	
	//GETTERS AND SETTERS

	public float getxMove() {
		return this.xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}
	public float getyMove() {
		return this.yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return this.health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return this.speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
}
