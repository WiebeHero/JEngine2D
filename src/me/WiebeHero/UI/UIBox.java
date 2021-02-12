package me.WiebeHero.UI;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UIBox extends UIObject{
	
	private ArrayList<UIObject> objects;
	
	public UIBox(double marginX, double marginY, int width, int height, UIObject inheritance) {
		super(marginX, marginY, width, height, inheritance);
		this.objects = new ArrayList<UIObject>();
	}

	@Override
	public void tick() {
		for(UIObject object : this.objects) {
			object.tick();
		}
	}

	@Override
	public void render(Graphics g) {
		for(UIObject object : this.objects) {
			object.render(g);
		}
	}

	@Override
	public void onPress() {
		
	}
	
	@Override
	public void onHover() {
		
	}
	
	@Override
	public void onDrag() {
		
	}

	@Override
	public void onRelease() {
		
	}
	
	@Override
	public void onMouseMove(MouseEvent event) {
		for(UIObject object : this.objects) {
			object.onMouseMove(event);
		}
	}
	
	@Override
	public void onMouseRelease(MouseEvent event) {
		for(UIObject object : this.objects) {
			object.onMouseRelease(event);
		}
	}
	
	@Override
	public void onMouseDrag(MouseEvent event) {
		for(UIObject object : this.objects) {
			object.onMouseDrag(event);
		}
	}
	
	@Override
	public void onMousePress(MouseEvent event) {
		for(UIObject object : this.objects) {
			object.onMousePress(event);
		}
	}
	
	public void addObject(UIObject button) {
		button.setInheritance(this);
		this.objects.add(button);
	}
	
	public void removeObject(UIObject button) {
		button.setInheritance(null);
		this.objects.remove(button);
	}
	
	public boolean containsObject(UIObject button) {
		return this.objects.contains(button);
	}
	
	public ArrayList<UIObject> getObjects(){
		return this.objects;
	}
	
	public UIObject getObject(int index) {
		return this.objects.get(index);
	}
	
	@Override
	public void updateMargin() {
		this.updateM();
		for(UIObject object : this.objects) {
			object.updateM();
		}
	}
}
