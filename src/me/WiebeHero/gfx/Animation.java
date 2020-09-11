package me.WiebeHero.gfx;

import java.awt.image.BufferedImage;

public class Animation {
	
	private int speed, index;
	private long lastTime, timer;
	private BufferedImage[] frames;
	private boolean paused;
	private boolean reversed;
	
	public Animation(int speed, BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		this.index = 0;
		this.timer = 0;
		this.lastTime = System.currentTimeMillis();
	}
	
	public Animation(int speed, BufferedImage[] frames, boolean reversed) {
		this.speed = speed;
		this.frames = frames;
		this.timer = 0;
		this.reversed = reversed;
		this.lastTime = System.currentTimeMillis();
		if(this.reversed) {
			this.index = this.frames.length - 1;
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
					if(this.index >= this.frames.length) {
						this.index = 0;
					}
				}
			}
			else {
				if(this.timer > this.speed) {
					this.index--;
					this.timer = 0;
					if(this.index < 0) {
						this.index = this.frames.length - 1;
					}
				}
			}
		}
	}
	
	public boolean isOnLastFrame() {
		return this.frames.length - 1 == this.index;
	}
	
	public boolean isOnFirstFrame() {
		return this.index == 0;
	}
	
	public BufferedImage getCurrentFrame() {
		return this.frames[this.index];
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
}
