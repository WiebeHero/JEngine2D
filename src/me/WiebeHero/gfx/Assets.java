package me.WiebeHero.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage dirt, grass, tree;
	public static BufferedImage[] player_up, player_down, player_left, player_right;
	public static BufferedImage player_up_still, player_down_still, player_left_still, player_right_still;
	public static BufferedImage[] title_icon, play_icon, new_icon, load_icon, settings_icon;
	
	public static void init() {
		SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("/textures/TileSheet.png"));
		SpriteSheet staticEntitySheet = new SpriteSheet(ImageLoader.loadImage("/sprites/StaticEntitySprite.png"));
		SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/sprites/CharacterSprite.png"));
		SpriteSheet titleIconSheet = new SpriteSheet(ImageLoader.loadImage("/icons/TitleIcon.png"));
		SpriteSheet playIconSheet = new SpriteSheet(ImageLoader.loadImage("/icons/PlayIcon.png"));
		SpriteSheet newIconSheet = new SpriteSheet(ImageLoader.loadImage("/icons/NewIcon.png"));
		SpriteSheet loadIconSheet = new SpriteSheet(ImageLoader.loadImage("/icons/LoadIcon.png"));
		SpriteSheet settingsIconSheet = new SpriteSheet(ImageLoader.loadImage("/icons/SettingsIcon.png"));
		
		player_up = new BufferedImage[4];
		player_down = new BufferedImage[4];
		player_left = new BufferedImage[4];
		player_right = new BufferedImage[4];
		play_icon = new BufferedImage[9];
		load_icon = new BufferedImage[1];
		new_icon = new BufferedImage[1];
		settings_icon = new BufferedImage[1];
		title_icon = new BufferedImage[1];
		
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
		
		for(int i = 0; i < 1; i++) {
			title_icon[i] = titleIconSheet.crop(0, 0, width * 2, height * 2);
		}
		for(int i = 0; i < 1; i++) {
			new_icon[i] = newIconSheet.crop(0, 0, width * 2, height + 1);
		}
		for(int i = 0; i < 1; i++) {
			load_icon[i] = loadIconSheet.crop(0, 0, width * 2, height + 1);
		}
		for(int i = 0; i < 1; i++) {
			settings_icon[i] = settingsIconSheet.crop(0, 0, width * 2 + 5, height + 1);
		}
		for(int i = 0; i < 9; i++) {
			play_icon[i] = playIconSheet.crop(width * 2 * i, 0, width * 2, height + 1);
		}
	}
	
}
