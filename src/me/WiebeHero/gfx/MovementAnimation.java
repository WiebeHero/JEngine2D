package me.WiebeHero.gfx;

public class MovementAnimation {
	
	private int speed, index, max, xOffset, yOffset;
	private long lastTime, timer;
	private boolean paused;
	private boolean reversed;
	
	public MovementAnimation(int speed, int max, int xOffset, int yOffset) {
		this.speed = speed;
		this.max = max;
		this.index = 0;
		this.timer = 0;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.lastTime = System.currentTimeMillis();
	}
	
	public MovementAnimation(int speed, int max, boolean reversed, int xOffset, int yOffset) {
		this.speed = speed;
		this.max = max;
		this.timer = 0;
		this.reversed = reversed;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.lastTime = System.currentTimeMillis();
		if(this.reversed) {
			this.index = this.max - 1;
		}
		else {
			this.index = 0;
		}
	}
	
	public MovementAnimation(int speed, int max, boolean paused, boolean reversed, int xOffset, int yOffset) {
		this.speed = speed;
		this.max = max;
		this.timer = 0;
		this.reversed = reversed;
		this.paused = paused;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.lastTime = System.currentTimeMillis();
		if(this.reversed) {
			this.index = this.max - 1;
		}
		else {
			this.index = 0;
		}
	}
	
	public void tick() {
		this.timer += System.currentTimeMillis() - this.lastTime;
		this.lastTime = System.currentTimeMillis();
		
		if(!this.paused) {
			if(!this.reversed) {
				if(this.timer > this.speed) {
					this.index++;
					this.timer = 0;
					if(this.index >= this.max) {
						this.index = 0;
					}
				}
			}
			else {
				if(this.timer > this.speed) {
					this.index--;
					this.timer = 0;
					if(this.index < 0) {
						this.index = this.max - 1;
					}
				}
			}
		}
	}
	
	public boolean isOnLastIndex() {
		return this.max - 1 == this.index;
	}
	
	public boolean isOnFirstIndex() {
		return this.index == 0;
	}
	
	public int getCurrentIndex() {
		return this.index;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public boolean isPaused() {
		return this.paused;
	}
	
	public void setPaused(boolean paused) {
		this.paused = paused;
	}
	
	public boolean isReversed() {
		return this.reversed;
	}
	
	public void setReversed(boolean reversed) {
		this.reversed = reversed;
	}
	
	public int getXOffset() {
		return this.xOffset;
	}
	
	public int getYOffset() {
		return this.yOffset;
	}
}
