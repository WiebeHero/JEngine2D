package me.WiebeHero.Assets;

import java.awt.image.BufferedImage;

public abstract class Asset {
	
	protected String identifier;
	protected BufferedImage[] images;
	
	public Asset(String identifier, BufferedImage[] images) {
		this.identifier = identifier;
		this.images = images;
	}
	
	public String getIdentifier() {
		return this.identifier;
	}
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	public BufferedImage getImage() {
		if(this.images.length > 0) {
			return this.images[0];
		}
		return null;
	}
	
	public BufferedImage getSpecificImage(int specific) {
		if(specific >= 0 && specific < this.images.length) {
			return this.images[specific];
		}
		return null;
	}
	
	public BufferedImage[] getImageRange(int start, int end) {
		if(start >= 0 && end < this.images.length) {
			BufferedImage[] images = new BufferedImage[Math.abs(start - end) + 1];
			for(int i = 0; i < images.length; i++) {
				images[i] = this.images[start + i];
			}
			return images;
		}
		return null;
	}
	
	public BufferedImage[] getImages() {
		return this.images;
	}
	
	public void setImage(BufferedImage image) {
		this.images = new BufferedImage[] {image};
	}
	
	public void setImages(BufferedImage[] images) {
		this.images = images;
	}
	
}
