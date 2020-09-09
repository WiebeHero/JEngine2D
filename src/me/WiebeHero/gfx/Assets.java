package me.WiebeHero.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage dirt, grass, tree;
	public static BufferedImage[] player_up, player_down, player_left, player_right;
	public static BufferedImage player_up_still, player_down_still, player_left_still, player_right_still;
	
	public static void init() {
		SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("/textures/TileSheet.png"));
		SpriteSheet staticEntitySheet = new SpriteSheet(ImageLoader.loadImage("/sprites/StaticEntitySprite.png"));
		SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/sprites/CharacterSprite.png"));
		
		player_up = new BufferedImage[4];
		player_down = new BufferedImage[4];
		player_left = new BufferedImage[4];
		player_right = new BufferedImage[4];
		
		for(int i = 0; i < 4; i++) {
			player_down[i] = playerSheet.crop(width * i, 0, width, height);
		}
		for(int i = 0; i < 4; i++) {
			player_right[i] = playerSheet.crop(width * i, height, width, height);
		}
		for(int i = 0; i < 4; i++) {
			player_left[i] = playerSheet.crop(width * i, height * 2, width, height);
		}
		for(int i = 0; i < 4; i++) {
			player_up[i] = playerSheet.crop(width * i, height * 3, width, height);
		}
		
		player_down_still = playerSheet.crop(0, 0, width, height);
		player_right_still = playerSheet.crop(0, height, width, height);
		player_left_still = playerSheet.crop(0, height * 2, width, height);
		player_up_still = playerSheet.crop(0, height * 3, width, height);
		
		grass = tileSheet.crop(0, 0, width, height);
		dirt = tileSheet.crop(0, height, width, height);
		tree = staticEntitySheet.crop(0, 0, width, height * 2);
	}
	
}
