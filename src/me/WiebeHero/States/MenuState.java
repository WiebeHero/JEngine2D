package me.WiebeHero.States;

import java.awt.Color;
import java.awt.Graphics;

import me.WiebeHero.Main.Handler;
import me.WiebeHero.UI.ClickListener;
import me.WiebeHero.UI.UIBox;
import me.WiebeHero.UI.UIImageButton;
import me.WiebeHero.UI.UIManager;
import me.WiebeHero.gfx.Assets;
import me.WiebeHero.gfx.MovementAnimation;
import me.WiebeHero.gfx.SizeAnimation;
import me.WiebeHero.gfx.SpriteAnimation;

public class MenuState extends State{

	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		this.uiManager = new UIManager(this.handler);
		this.handler.getMouseManager().setUIManager(this.uiManager);
		UIBox menuBox = new UIBox(50.0D, 50.0D, 250, 350);
		menuBox.addButton(new UIImageButton(50.0D, 17.5D, 200, 200, Assets.title_icon, new ClickListener() {

			@Override
			public void onClick() {
				
			}
			
		}));
		menuBox.addButton(new UIImageButton(50.0D, 41.0D, 35, 0, 64, 33, Assets.new_icon, new ClickListener() {

			@Override
			public void onClick() {
				UIImageButton playButton = (UIImageButton) menuBox.getButton(3);
				UIImageButton newButton = (UIImageButton) menuBox.getButton(1);
				if(!playButton.overlaps(newButton.getBounds())) {
					handler.getMouseManager().setUIManager(null);
					State.setState(handler.getGame().gameState);
				}
			}
			
		}, new MovementAnimation(20, 20, 4F, 0F, true, false, false, false), new SizeAnimation(30, 5, 2, 1, true, false, false, true)));
		menuBox.addButton(new UIImageButton(50.0D, 53.0D, 35, 0, 64, 33, Assets.load_icon, new ClickListener() {
			
			@Override
			public void onClick() {
				UIImageButton playButton = (UIImageButton) menuBox.getButton(3);
				UIImageButton loadButton = (UIImageButton) menuBox.getButton(2);
				if(!playButton.overlaps(loadButton.getBounds())) {
					handler.getMouseManager().setUIManager(null);
					State.setState(handler.getGame().gameState);
				}
			}
			
		}, new MovementAnimation(20, 20, 4F, 0F, true, false, false, false), new SizeAnimation(30, 5, 2, 1, true, false, false, true)));
		
		menuBox.addButton(new UIImageButton(50.0D, 47.0D, 150, 80, Assets.play_icon, new ClickListener() {
			
			@Override
			public void onClick() {
				UIImageButton newButton = (UIImageButton) menuBox.getButton(1);
				UIImageButton loadButton = (UIImageButton) menuBox.getButton(2);
				newButton.getAnimation(0).setPaused(false);
				loadButton.getAnimation(0).setPaused(false);
			}
			
		}, new SpriteAnimation(100, Assets.play_icon, true, false, false, true)));
		
		menuBox.addButton(new UIImageButton(50.0D, 72D, 150, 71, Assets.settings_icon, new ClickListener() {
			
			@Override
			public void onClick() {
				
			}
			
		}, new SizeAnimation(30, 5, 2, 1, true, false, false, true)));
		this.uiManager.addObject(menuBox);
	}
	
	//First Button: X = X + 150 Y = 150
	//Second Button: X = X + 150 Y = 191
	
	@Override
	public void tick() {
		this.uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1930, 1080);
		g.setColor(Color.RED);
		this.uiManager.updateXY();
		this.uiManager.render(g);
	}

}
