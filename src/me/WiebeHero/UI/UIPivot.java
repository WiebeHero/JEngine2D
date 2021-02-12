package me.WiebeHero.UI;

import java.awt.Color;
import java.awt.Graphics;

public class UIPivot extends UIObject{
	
	private Color color;
	
	public UIPivot(int width, int height, Color color) {
		super(0.0, 0.0, width, height);
		this.color = color;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect((int)this.x, (int)this.y, this.width, this.height);
	}

	@Override
	public void onHover() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRelease() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPress() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDrag() {
		// TODO Auto-generated method stub
		
	}
}
