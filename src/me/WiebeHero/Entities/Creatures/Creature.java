package me.WiebeHero.Entities.Creatures;

import me.WiebeHero.Entities.Direction;
import me.WiebeHero.Entities.Entity;
import me.WiebeHero.Main.Game;
import me.WiebeHero.Tiles.Tile;

public abstract class Creature extends Entity{
	
	public static final float DEFAULT_SPEED = 2.4F;
	public static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CREATURE_HEIGHT = 64;
	
	protected Direction dir;
	protected float speed;
	protected float xMove, yMove;

	public Creature(float x, float y, int width, int height) {
		super(x, y, width, height);
		this.speed = DEFAULT_SPEED;
		this.xMove = 0.0F;
		this.yMove = 0.0F;
		this.dir = Direction.DOWN;
	}
	
	public void move() {
		if(!this.checkEntityCollisions(xMove, 0F)) {
			this.moveX();
		}
		if(!this.checkEntityCollisions(0F, yMove)) {
			this.moveY();
		}
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
			this.dir = Direction.RIGHT;
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
			this.dir = Direction.LEFT;
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
			this.dir = Direction.UP;
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
			this.dir = Direction.DOWN;
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return Game.handler.getWorld().getTile(x, y).isSolid();
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

	public float getSpeed() {
		return this.speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public Direction getDirection() {
		return this.dir;
	}
	
}
