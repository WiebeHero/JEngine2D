package me.WiebeHero.States;

import java.awt.Color;
import java.awt.Graphics;

import me.WiebeHero.Main.Handler;
import me.WiebeHero.UI.ClickListener;
import me.WiebeHero.UI.UIImageButton;
import me.WiebeHero.UI.UIManager;
import me.WiebeHero.gfx.Assets;

public class MenuState extends State{

	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		this.uiManager = new UIManager(this.handler);
		this.handler.getMouseManager().setUIManager(this.uiManager);
		int x = (this.handler.getGame().getWidth() - 150) / 2;
		this.uiManager.addObject(new UIImageButton(x, 100, 150, 150, Assets.icons, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));
	}
	
	@Override
	public void tick() {
		this.uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.handler.getGame().getWidth(), this.handler.getGame().getHeight());
		int x = (this.handler.getGame().getWidth() - 200) / 2;
		g.drawImage(Assets.icons[0], x, -35, 200, 200, null);
		this.uiManager.render(g);
	}

}
