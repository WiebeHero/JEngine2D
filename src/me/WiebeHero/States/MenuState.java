package me.WiebeHero.States;

import java.awt.Color;
import java.awt.Graphics;

import me.WiebeHero.Main.Handler;
import me.WiebeHero.UI.ClickListener;
import me.WiebeHero.UI.UIBox;
import me.WiebeHero.UI.UIImageButton;
import me.WiebeHero.UI.UIManager;
import me.WiebeHero.gfx.Assets;

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
//		this.uiManager.addObject(new UIImageButton(50.0D, 25.0D, 35, 80, 70, 38, Assets.new_icon, new MovementAnimation(20, 20, true, false, 4, 0), new ClickListener() {
//
//			@Override
//			public void onClick() {
//				UIImageButton playButton = (UIImageButton) uiManager.getObject(3);
//				UIImageButton newButton = (UIImageButton) uiManager.getObject(1);
//				if(!playButton.overlaps(newButton.getBounds())) {
//					handler.getMouseManager().setUIManager(null);
//					State.setState(handler.getGame().gameState);
//				}
//			}
//			
//		}));
//		this.uiManager.addObject(new UIImageButton(50.0D, 25.0D, 35, 120, 70, 38, Assets.load_icon, new MovementAnimation(20, 20, true, false, 4, 0), new ClickListener() {
//			
//			@Override
//			public void onClick() {
//				UIImageButton playButton = (UIImageButton) uiManager.getObject(3);
//				UIImageButton loadButton = (UIImageButton) uiManager.getObject(2);
//				if(!playButton.overlaps(loadButton.getBounds())) {
//					handler.getMouseManager().setUIManager(null);
//					State.setState(handler.getGame().gameState);
//				}
//			}
//			
//		}));
		
//		this.uiManager.addObject(new UIImageButton(50.0D, 25.0D, 0, 175, 150, 80, Assets.play_icon, new SpriteAnimation(100, Assets.play_icon), new ClickListener() {
//			
//			@Override
//			public void onClick() {
//				UIImageButton newButton = (UIImageButton) uiManager.getObject(1);
//				UIImageButton loadButton = (UIImageButton) uiManager.getObject(2);
//				newButton.getMovementAnimation().setPaused(false);
//				loadButton.getMovementAnimation().setPaused(false);
//			}
//			
//		}));
//		
//		this.uiManager.addObject(new UIImageButton(50.0D, 30.0D, 0, 185, 150, 71, Assets.settings_icon, new ClickListener() {
//			
//			@Override
//			public void onClick() {
//				
//			}
//			
//		}));
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
		UIBox box = (UIBox) this.uiManager.getObject(0);
		g.drawRect((int)box.getX(), (int)box.getY(), box.getWidth(), box.getHeight());
		this.uiManager.updateXY();
		this.uiManager.render(g);
	}

}
