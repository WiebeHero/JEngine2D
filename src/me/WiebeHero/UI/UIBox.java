package me.WiebeHero.UI;

import java.awt.Graphics;
import java.util.ArrayList;

public class UIBox extends UIObject{
	
	private ArrayList<UIImageButton> buttons;
	
	public UIBox(double marginX, double marginY, int width, int height) {
		super(marginX, marginY, width, height);
		this.buttons = new ArrayList<UIImageButton>();
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		
	}

	@Override
	public void onClick() {
		
	}
	
	public void addButton(UIImageButton button) {
		this.buttons.add(button);
	}
	
	public void removeButton(UIImageButton button) {
		this.buttons.remove(button);
	}
	
	public boolean containsButton(UIImageButton button) {
		return this.buttons.contains(button);
	}
	
	public ArrayList<UIImageButton> getButtons(){
		return this.buttons;
	}
	
	public UIImageButton getButton(int index) {
		return this.buttons.get(index);
	}

}
