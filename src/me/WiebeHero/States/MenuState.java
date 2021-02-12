package me.WiebeHero.States;

import java.awt.Color;
import java.awt.Graphics;

import me.WiebeHero.InputListeners.HoverListener;
import me.WiebeHero.InputListeners.PressListener;
import me.WiebeHero.Main.Game;
import me.WiebeHero.Main.Handler;
import me.WiebeHero.Sounds.Sounds;
import me.WiebeHero.UI.UIBox;
import me.WiebeHero.UI.UIImageButton;
import me.WiebeHero.UI.UIManager;
import me.WiebeHero.gfx.AnimOption;
import me.WiebeHero.gfx.Assets;
import me.WiebeHero.gfx.MovementAnimation;
import me.WiebeHero.gfx.SizeAnimation;
import me.WiebeHero.gfx.SpriteAnimation;

public class MenuState extends State{

	private UIManager uiManager;
	
	public MenuState() {
		Handler handler = Game.handler;
		this.uiManager = new UIManager();
		UIBox menuBox = new UIBox(47.5D, 50.0D, 512, 480, null);
		
		UIImageButton title = new UIImageButton(50.0D, 16.5D, 320, 160, Assets.title_icon);
		menuBox.addObject(title);
		
		UIImageButton newButton = new UIImageButton(64.5D, 43.75D, 100, 50, Assets.new_icon);
		newButton.addAnimations(new MovementAnimation(16, 38, 3F, 0F, AnimOption.PAUSED), new SizeAnimation(30, 5, 2, 1, AnimOption.PAUSED, AnimOption.HOVER_TRIGGER));
		newButton.addListeners(
		new PressListener() {

			@Override
			public void listen() {
				UIImageButton playButton = (UIImageButton) menuBox.getObject(3);
				UIImageButton newButton = (UIImageButton) menuBox.getObject(1);
				if(!playButton.overlaps(newButton.getBounds())) {
					handler.getMouseManager().setUIManager(null);
					State.setState(handler.getGame().gameState);
				}
			}
			
		}, new HoverListener() {
			
			@Override
			public void listen() {
				UIImageButton playButton = (UIImageButton) menuBox.getObject(3);
				UIImageButton newButton = (UIImageButton) menuBox.getObject(1);
				if(!playButton.overlaps(newButton.getBounds())) {
					Sounds.hover_button.start();
				}
			}
			
		});
		menuBox.addObject(newButton);
		
		UIImageButton loadButton = new UIImageButton(64.5D, 55.5D, 100, 50, Assets.load_icon);
		loadButton.addAnimations(new MovementAnimation(16, 38, 3F, 0F, AnimOption.PAUSED), new SizeAnimation(30, 5, 2, 1, AnimOption.PAUSED, AnimOption.HOVER_TRIGGER));
		loadButton.addListeners(
		new PressListener() {
			
			@Override
			public void listen() {
				UIImageButton playButton = (UIImageButton) menuBox.getObject(3);
				UIImageButton loadButton = (UIImageButton) menuBox.getObject(2);
				if(!playButton.overlaps(loadButton.getBounds())) {
					handler.getMouseManager().setUIManager(null);
					State.setState(handler.getGame().gameState);
				}
			}
			
		}, 
		new HoverListener() {
			
			@Override
			public void listen() {
				UIImageButton playButton = (UIImageButton) menuBox.getObject(3);
				UIImageButton loadButton = (UIImageButton) menuBox.getObject(2);
				if(!playButton.overlaps(loadButton.getBounds())) {
					Sounds.hover_button.start();
				}
			}
		});
		menuBox.addObject(loadButton);
		
		UIImageButton playButton = new UIImageButton(50.0D, 49.5D, 256, 128, Assets.play_icon);
		playButton.addAnimations(new SpriteAnimation(25, Assets.play_icon, AnimOption.PAUSED, AnimOption.HOVER_TRIGGER));
		playButton.addListeners(new PressListener() {
			
			@Override
			public void listen() {
				UIImageButton newButton = (UIImageButton) menuBox.getObject(1);
				UIImageButton loadButton = (UIImageButton) menuBox.getObject(2);
				newButton.getAnimation(0).setOptionState(AnimOption.PAUSED, false);
				loadButton.getAnimation(0).setOptionState(AnimOption.PAUSED, false);
			}
			
		});
		menuBox.addObject(playButton);
		
		UIImageButton settingsButton = new UIImageButton(50.0D, 79.5D, 256, 128, Assets.settings_icon);
		settingsButton.addAnimations(new SpriteAnimation(25, Assets.settings_icon, AnimOption.PAUSED, AnimOption.HOVER_TRIGGER));
		settingsButton.addListeners(
		new PressListener() {
			
			@Override
			public void listen() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().settingsState);
				handler.getGame().settingsState.initMouseManager();
			}
			
		});
		menuBox.addObject(settingsButton);
		this.uiManager.addObject(menuBox);
	}
	
	//First Button: X = X + 150 Y = 150
	//Second Button: X = X + 150 Y = 191
	
	@Override
	public void initMouseManager() {
		Game.handler.getMouseManager().setUIManager(this.uiManager);
	}
	
	@Override
	public void tick() {
		this.uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1930, 1080);
		this.uiManager.render(g);
	}

}
