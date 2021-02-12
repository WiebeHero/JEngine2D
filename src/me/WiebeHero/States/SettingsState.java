package me.WiebeHero.States;

import java.awt.Color;
import java.awt.Graphics;

import me.WiebeHero.InputListeners.ReleaseListener;
import me.WiebeHero.Main.Game;
import me.WiebeHero.Settings.Settings;
import me.WiebeHero.UI.UIBox;
import me.WiebeHero.UI.UIInputRecorder;
import me.WiebeHero.UI.UIManager;
import me.WiebeHero.UI.UIPivot;
import me.WiebeHero.UI.UISlider;
import me.WiebeHero.UI.UIText;

public class SettingsState extends State{
	
	private UIManager uiManager;
	
	public SettingsState() {
		this.uiManager = new UIManager();
		UIBox menuBox = new UIBox(50.0D, 50.0D, 350, 450, null);
		UIPivot pivot = new UIPivot(20, 30, Color.BLUE);
		UISlider slider = new UISlider(pivot, 40.0D, 30.0D, 200, 18, 100, (int)Settings.volume, true);
		slider.addListeners(new ReleaseListener() {

			@Override
			public void listen() {
				Settings.volume = slider.getValue();
			}
			
		});
		menuBox.addObject(slider);
		UIText textVolume = new UIText(90.0D, 31.75D, 0, 0, "Volume");
		menuBox.addObject(textVolume);
		UIInputRecorder recorder = new UIInputRecorder(50.0, 60.0, 25, 25, Color.BLUE) {
			@Override
			public void recorded(int key) {
				Settings.up = key;
			}
		};
		menuBox.addObject(recorder);
		this.uiManager.addObject(menuBox);
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

	@Override
	public void initMouseManager() {
		Game.handler.getGame().getMouseManager().setUIManager(this.uiManager);
	}
	
}
