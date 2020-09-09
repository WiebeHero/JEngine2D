package me.WiebeHero.UI;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import me.WiebeHero.Main.Handler;

public class UIManager {
	
	private Handler handler;
	private ArrayList<UIObject> objects;
	
	public UIManager(Handler handler) {
		this.handler = handler;
		this.objects = new ArrayList<UIObject>();
	}
	
	public void tick() {
		for(UIObject o : this.objects) {
			o.tick();
		}
	}
	
	public void render(Graphics g) {
		for(UIObject o : this.objects) {
			o.render(g);
		}
	}
	
	public void onMouseMove(MouseEvent event) {
		for(UIObject o : this.objects) {
			o.onMouseMove(event);
		}
	}
	
	public void onMouseRelease(MouseEvent event) {
		for(UIObject o : this.objects) {
			o.onMouseRelease(event);
		}
	}
	
	public ArrayList<UIObject> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<UIObject> objects) {
		this.objects = objects;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public void addObject(UIObject o) {
		this.objects.add(o);
	}
	
	public void removeObject(UIObject o) {
		this.objects.remove(o);
	}
}

