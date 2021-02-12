package me.WiebeHero.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;

import me.WiebeHero.Input.KeyManager;
import me.WiebeHero.Main.Game;
import me.WiebeHero.Main.Handler;
import me.WiebeHero.Settings.Settings;

public class UIInputRecorder extends UIObject{
	
	private Color color;
	private boolean recording;
	private BufferedImage[] images;

	public UIInputRecorder(double marginX, double marginY, int width, int height, Color color) {
		super(marginX, marginY, width, height);
		this.color = color;
	}
	
	public UIInputRecorder(double marginX, double marginY, int width, int height, BufferedImage images[]) {
		super(marginX, marginY, width, height);
		this.images = images;
	}

	@Override
	public void tick() {
		Handler handler = Game.handler;
		KeyManager keyManager = handler.getKeyManager();
		boolean[] keys = keyManager.getKeys();
		if(!this.recording) 
			return;
		for(int i = 0; i < keys.length; i++) {
			if(keys[i]) {
				this.recording = false;
				this.recorded(i);
				break;
			}
		}
	}

	@Override
	public void render(Graphics g) {
		if(this.color != null)
			g.setColor(color);
			g.fillRect((int)x, (int)y, width, height);
		if(this.images != null)
			g.drawImage(this.images[0], (int)x, (int)y, width, height, null);
		g.setColor(Color.RED);
		Font font = g.getFont();
		FontRenderContext frc = g.getFontMetrics().getFontRenderContext();
		TextLayout layout = new TextLayout(KeyEvent.getKeyText(Settings.up) + "", font, frc);
		layout.draw((Graphics2D) g, (int)(x + (width / 2) - layout.getBounds().getWidth() / 2 + 2), (int)(y + (height / 2) + (layout.getBounds().getHeight() / 2 + 1)));
	}

	@Override
	public void onHover() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRelease() {
		this.recording = true;
		Thread t = new Thread() {
			public void run() {
				try {
					sleep(1000);
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				recording = false;
			}
		};
		t.start();
	}

	@Override
	public void onPress() {
		
	}

	@Override
	public void onDrag() {
		// TODO Auto-generated method stub
		
	}

	public void recorded(int key) {}

}
