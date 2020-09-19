package me.WiebeHero.UI;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javafx.util.Pair;
import me.WiebeHero.gfx.Animation;
import me.WiebeHero.gfx.AnimationTypes.AnimationType;
import me.WiebeHero.gfx.MovementAnimation;
import me.WiebeHero.gfx.SizeAnimation;
import me.WiebeHero.gfx.SpriteAnimation;

public class UIImageButton extends UIObject{

	private BufferedImage[] images;
	private ClickListener clicker;
	private Animation[] anims;
	
	public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
	}
	
	public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker, Animation... anims) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
		this.anims = anims;
	}
	
	public UIImageButton(double marginX, double marginY, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(marginX, marginY, width, height);
		this.images = images;
		this.clicker = clicker;
	}
	
	public UIImageButton(double marginX, double marginY, int width, int height, BufferedImage[] images, ClickListener clicker, Animation... anims) {
		super(marginX, marginY, width, height);
		this.images = images;
		this.clicker = clicker;
		this.anims = anims;
	}
	
	public UIImageButton(double marginX, double marginY, float extraX, float extraY, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(marginX, marginY, extraX, extraY, width, height);
		this.images = images;
		this.clicker = clicker;
	}
	
	public UIImageButton(double marginX, double marginY, float extraX, float extraY, int width, int height, BufferedImage[] images, ClickListener clicker, Animation... anims) {
		super(marginX, marginY, extraX, extraY, width, height);
		this.images = images;
		this.clicker = clicker;
		this.anims = anims;
	}

	@Override
	public void tick() {
		if(this.anims != null && this.anims.length != 0) {
			for(Animation anim : this.anims) {
				anim.setHovering(this.hovering);
				anim.tick();
			}
		}
	}
	
	@Override
	public void render(Graphics g) {
		if(this.anims != null && this.anims.length != 0) {
			BufferedImage img = this.images[0];
			Rectangle rect = this.getBounds();
			int tempX = (int)this.x;
			int tempY = (int)this.y;
			float xOffset = 0;
			float yOffset = 0;
			int widthOffset = 0;
			int heightOffset = 0;
			for(Animation anim : this.anims) {
				switch(anim.getAnimationType()) {
					case SPRITE:
						img = this.getCurrentFrame();
						break;
					case MOVEMENT:
						Pair<Integer, Integer> pair = this.getCurrentOffsets();
						xOffset = pair.getKey();
						yOffset = pair.getValue();
						break;
					case SIZE:
						pair = this.getCurrentSizes();
						widthOffset = pair.getKey();
						heightOffset = pair.getValue();
						break;
				}
			}
			tempX -= widthOffset / 2;
			tempY -= heightOffset / 2;
			rect.x = (int)(tempX + xOffset);
			rect.y = (int)(tempY + yOffset);
			rect.width = this.getWidth() + widthOffset;
			rect.height = this.getHeight() + heightOffset;
			g.drawImage(img, (int)(tempX + xOffset), (int)(tempY + yOffset), this.width + widthOffset, this.height + heightOffset, null);
		}
		else {
			g.drawImage(this.images[0], (int)(this.x), (int)(this.y), this.width, this.height, null);
		}
	}
	
	public BufferedImage getCurrentFrame() {
		if(this.anims != null && this.anims.length != 0) {
			for(Animation a : this.anims) {
				if(a.getAnimationType() == AnimationType.SPRITE) {
					SpriteAnimation anim = (SpriteAnimation) a;
					return anim.getCurrentFrame();
				}
			}
		}
		return null;
	}
	
	public Pair<Integer, Integer> getCurrentOffsets() {
		if(this.anims != null && this.anims.length != 0) {
			for(Animation a : this.anims) {
				if(a.getAnimationType() == AnimationType.MOVEMENT) {
					MovementAnimation anim = (MovementAnimation) a;
					return new Pair<Integer, Integer>((int)anim.getXOffset() * anim.getCurrentIndex(), (int)anim.getYOffset() * anim.getCurrentIndex());
				}
			}
		}
		return null;
	}
	
	public Pair<Integer, Integer> getCurrentSizes() {
		if(this.anims != null && this.anims.length != 0) {
			for(Animation a : this.anims) {
				if(a.getAnimationType() == AnimationType.SIZE) {
					SizeAnimation anim = (SizeAnimation) a;
					return new Pair<Integer, Integer>((int)anim.getWidthOffset() * anim.getCurrentIndex(), (int)anim.getHeightOffset() * anim.getCurrentIndex());
				}
			}
		}
		return null;
	}
	
//	private void animationSettings(Animation anim) {
//		if(!anim.isLooping()) {
//			if(anim.triggerOnHover()) {
//				if(this.hovering) {
//					anim.setReversed(false);
//					if(anim.isOnLastIndex()) {
//						anim.setPaused(true);
//					}
//					else {
//						anim.setPaused(false);
//					}
//				}
//				else {
//					anim.setReversed(true);
//					if(anim.isOnFirstIndex()) {
//						anim.setPaused(true);
//					}
//					else {
//						anim.setPaused(false);
//					}
//				}
//			}
//		}
//	}

	@Override
	public void onClick() {
		this.clicker.onClick();
	}
	
	public Animation getAnimation(int index) {
		return this.anims[index];
	}
	
}
