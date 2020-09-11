package me.WiebeHero.UI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import me.WiebeHero.gfx.Animation;

public class UIImageButton extends UIObject{

	private BufferedImage[] images;
	private ClickListener clicker;
	private Animation anim;
	
	public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
	}
	
	public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, Animation anim, ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
		this.anim = anim;
	}

	@Override
	public void tick() {
		if(this.anim != null) {
			this.anim.tick();
		}
	}

	@Override
	public void render(Graphics g) {
		if(this.anim != null) {
			g.drawImage(this.getCurrentFrame(), (int)this.x, (int)this.y, this.width, this.height, null);
		}
		else {
			g.drawImage(this.images[0], (int)this.x, (int)this.y, this.width, this.height, null);
		}
	}
	
	private BufferedImage getCurrentFrame() {
		if(this.hovering) {
			this.anim.setReversed(false);
			if(!this.anim.isOnLastFrame()) {
				this.anim.setPaused(false);
			}
			else {
				this.anim.setPaused(true);
			}
			return this.anim.getCurrentFrame();
		}
		else {
			this.anim.setReversed(true);
			if(!this.anim.isOnFirstFrame()) {
				this.anim.setPaused(false);
			}
			else {
				this.anim.setPaused(true);
			}
			return this.anim.getCurrentFrame();
		}
	}

	@Override
	public void onClick() {
		this.clicker.onClick();
	}
	
	 
	
}
