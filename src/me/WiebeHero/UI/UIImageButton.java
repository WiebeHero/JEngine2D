package me.WiebeHero.UI;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javafx.util.Pair;
import me.WiebeHero.gfx.MovementAnimation;
import me.WiebeHero.gfx.SpriteAnimation;

public class UIImageButton extends UIObject{

	private BufferedImage[] images;
	private ClickListener clicker;
	private SpriteAnimation spriteAnim;
	private MovementAnimation moveAnim;
	
	public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
	}
	
	public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, SpriteAnimation anim, ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
		this.spriteAnim = anim;
	}
	
	public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, MovementAnimation anim, ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
		this.moveAnim = anim;
	}
	
	public UIImageButton(double marginX, double marginY, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(marginX, marginY, width, height);
		this.images = images;
		this.clicker = clicker;
	}
	
	public UIImageButton(double marginX, double marginY, int width, int height, BufferedImage[] images, SpriteAnimation anim, ClickListener clicker) {
		super(marginX, marginY, width, height);
		this.images = images;
		this.clicker = clicker;
		this.spriteAnim = anim;
	}
	
	public UIImageButton(double marginX, double marginY, int width, int height, BufferedImage[] images, MovementAnimation anim, ClickListener clicker) {
		super(marginX, marginY, width, height);
		this.images = images;
		this.clicker = clicker;
		this.moveAnim = anim;
	}
	
	public UIImageButton(double marginX, double marginY, float extraX, float extraY, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(marginX, marginY, extraX, extraY, width, height);
		this.images = images;
		this.clicker = clicker;
	}
	
	public UIImageButton(double marginX, double marginY, float extraX, float extraY, int width, int height, BufferedImage[] images, SpriteAnimation anim, ClickListener clicker) {
		super(marginX, marginY, extraX, extraY, width, height);
		this.images = images;
		this.clicker = clicker;
		this.spriteAnim = anim;
	}
	
	public UIImageButton(double marginX, double marginY, float extraX, float extraY, int width, int height, BufferedImage[] images, MovementAnimation anim, ClickListener clicker) {
		super(marginX, marginY, extraX, extraY, width, height);
		this.images = images;
		this.clicker = clicker;
		this.moveAnim = anim;
	}

	@Override
	public void tick() {
		if(this.spriteAnim != null) {
			this.spriteAnim.tick();
		}
		if(this.moveAnim != null) {
			this.moveAnim.tick();
		}
	}
	
	@Override
	public void render(Graphics g) {
		if(this.spriteAnim != null && this.moveAnim != null) {
			Pair<Integer, Integer> pair = this.getCurrentOffsets();
			Rectangle rect = this.getBounds();
			rect.x = (int)(this.x + pair.getKey());
			rect.y = (int)(this.y + pair.getValue());
			g.drawImage(this.getCurrentFrame(), (int)(this.x + pair.getKey()), (int)(this.y + pair.getValue()), this.width, this.height, null);
		}
		else if(this.moveAnim != null) {
			Pair<Integer, Integer> pair = this.getCurrentOffsets();
			Rectangle rect = this.getBounds();
			rect.x = (int)(this.x + pair.getKey());
			rect.y = (int)(this.y + pair.getValue());
			g.drawImage(this.images[0], (int)(this.x + pair.getKey()), (int)(this.y + pair.getValue()), this.width, this.height, null);
		}
		else if(this.spriteAnim != null) {
			g.drawImage(this.getCurrentFrame(), (int)this.x, (int)this.y, this.width, this.height, null);
		}
		else {
			g.drawImage(this.images[0], (int)this.x, (int)this.y, this.width, this.height, null);
		}
	}
	
	public BufferedImage getCurrentFrame() {
		if(this.hovering) {
			this.spriteAnim.setReversed(false);
			if(!this.spriteAnim.isOnLastFrame()) {
				this.spriteAnim.setPaused(false);
			}
			else {
				this.spriteAnim.setPaused(true);
			}
			return this.spriteAnim.getCurrentFrame();
		}
		else {
			this.spriteAnim.setReversed(true);
			if(!this.spriteAnim.isOnFirstFrame()) {
				this.spriteAnim.setPaused(false);
			}
			else {
				this.spriteAnim.setPaused(true);
			}
			return this.spriteAnim.getCurrentFrame();
		}
	}
	
	public Pair<Integer, Integer> getCurrentOffsets() {
		if(this.moveAnim.isOnLastIndex()) {
			this.moveAnim.setPaused(true);
			this.moveAnim.setReversed(true);
		}
		if(this.moveAnim.isOnFirstIndex()) {
			this.moveAnim.setPaused(true);
			this.moveAnim.setReversed(false);
		}
		return new Pair<Integer, Integer>(this.moveAnim.getXOffset() * this.moveAnim.getCurrentIndex(), this.moveAnim.getYOffset() * this.moveAnim.getCurrentIndex());
	}

	@Override
	public void onClick() {
		this.clicker.onClick();
	}
	
	public SpriteAnimation getSpriteAnimation() {
		return this.spriteAnim;
	}
	
	public MovementAnimation getMovementAnimation() {
		return this.moveAnim;
	}
	
}
