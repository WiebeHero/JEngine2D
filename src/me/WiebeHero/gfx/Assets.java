package me.WiebeHero.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage PLAYER, DIRT, GRASS;
	
	public static void init() {
		SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("/textures/TileSheet.png"));
		SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/sprites/CharacterSprite.png"));
		
		PLAYER = playerSheet.crop(0, 0, width, height);
		GRASS = tileSheet.crop(0, 0, width, height);
		DIRT = tileSheet.crop(0, height, width, height);
	}
	
}
