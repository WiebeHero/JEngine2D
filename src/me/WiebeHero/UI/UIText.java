package me.WiebeHero.UI;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;

public class UIText extends UIObject{
	
	private String text;
	
	public UIText(double marginX, double marginY, int width, int height, String text) {
		super(marginX, marginY, 0, 0);
		this.text = text;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		Font font = g.getFont();
		FontRenderContext frc = g.getFontMetrics().getFontRenderContext();
		TextLayout layout = new TextLayout(text, font, frc);
		layout.draw((Graphics2D) g, (int)x, (int)y);
		if(width != layout.getBounds().getWidth() && height != layout.getBounds().getHeight()) {
			width = (int) layout.getBounds().getWidth();
			height = (int) layout.getBounds().getHeight();
		}
	}

	@Override
	public void onHover() {
		
	}

	@Override
	public void onRelease() {
		
	}

	@Override
	public void onPress() {
		
	}

	@Override
	public void onDrag() {
		
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
}
