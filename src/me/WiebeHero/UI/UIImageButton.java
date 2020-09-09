package me.WiebeHero.UI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject{

	private BufferedImage[] images;
	private ClickListener clicker;
	
	public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
	}

	@Override
	public void tick() {}

	@Override
	public void render(Graphics g) {
		if(this.hovering) {
			g.drawImage(this.images[1], (int)this.x, (int)this.y, this.width, this.height, null);
		}
		else {
			
		}
	}

	@Override
	public void onClick() {
		this.clicker.onClick();
	}
	
	 
	
}
