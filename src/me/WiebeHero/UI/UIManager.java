package me.WiebeHero.UI;

import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import me.WiebeHero.Display.Display;

public class UIManager {
	
	private Display display;
	private ArrayList<UIObject> objects;
	
	public UIManager(Display display) {
		this.objects = new ArrayList<UIObject>();
		this.display = display;
		this.display.getFrame().getRootPane().addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent componentEvent) {
		    	for(UIObject object : objects) {
		    		object.updateMargin();
		    	}
		    }
		});
	}
	
	public void tick() {
		for(UIObject o : this.objects) {
			if(o.isActive()) {
				o.tick();
			}
		}
	}
	
	public void render(Graphics g) {
		for(UIObject o : this.objects) {
			if(o.isActive()) {
				o.render(g);
			}
		}
	}
	
	public void onMouseMoved(MouseEvent event) {
		for(UIObject o : this.objects) {
			if(!o.isActive())
				return;
			o.onMouseMoved(event);
		}
	}
	
	public void onMousePressed(MouseEvent event) {
		for(UIObject o : this.objects) {
			if(!o.isActive())
				return;
			o.onMousePressed(event);
		}
	}
	
	public void onMouseReleased(MouseEvent event) {
		for(UIObject o : this.objects) {
			if(!o.isActive())
				return;
			o.onMouseReleased(event);
		}
	}
	
	public void onMouseDragged(MouseEvent event) {
		for(UIObject o : this.objects) {
			if(!o.isActive())
				return;
			o.onMouseDragged(event);
		}
	}
	
	public void onMouseClicked(MouseEvent event) {
		for(UIObject o : this.objects) {
			if(!o.isActive())
				return;
			o.onMouseClicked(event);
		}
	}
	
	public void onMouseEntered(MouseEvent event) {
		for(UIObject o : this.objects) {
			if(!o.isActive())
				return;
			o.onMouseEntered(event);
		}
	}
	
	public void onMouseExited(MouseEvent event) {
		for(UIObject o : this.objects) {
			if(!o.isActive())
				return;
			o.onMouseExited(event);
		}
	}
	
	public void onKeyPressed(KeyEvent event) {
		for(UIObject o : this.objects) {
			if(!o.isActive())
				return;
			o.onKeyPressed(event);
		}
	}
	
	public void onKeyReleased(KeyEvent event) {
		for(UIObject o : this.objects) {
			if(!o.isActive())
				return;
			o.onKeyReleased(event);
		}
	}
	
	public ArrayList<UIObject> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<UIObject> objects) {
		this.objects = objects;
	}

	public void addObject(UIObject o) {
		this.objects.add(o);
	}
	
	public void removeObject(UIObject o) {
		this.objects.remove(o);
	}
	
	public UIObject getObject(int index) {
		return this.objects.get(index);
	}
}

