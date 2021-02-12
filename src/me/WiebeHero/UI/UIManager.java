package me.WiebeHero.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import me.WiebeHero.Main.Game;

public class UIManager {
	
	private ArrayList<UIObject> objects;
	
	public UIManager() {
		this.objects = new ArrayList<UIObject>();
		Game.handler.getDisplay().getFrame().getRootPane().addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent componentEvent) {
		    	for(UIObject object : objects) {
		    		if(object instanceof Marginable) {
		    			object.updateMargin();
		    		}
		    	}
		    }
		});
	}
	
	public void tick() {
		for(UIObject o : this.objects) {
			o.tick();
			o.updateMargin();
			if(o instanceof UIBox) {
				UIBox box = (UIBox) o;
    			for(UIObject item : box.getObjects()) {
    				item.updateMargin();
    			}
			}
		}
	}
	
	public void render(Graphics g) {
		for(UIObject o : this.objects) {
			o.render(g);
			if(o instanceof UIBox) {
				UIBox box = (UIBox) o;
				g.setColor(Color.RED);
				g.drawRect((int)box.getX(), (int)box.getY(), box.getWidth(), box.getHeight());
			}
		}
	}
	
	public void onMouseMove(MouseEvent event) {
		for(UIObject o : this.objects) {
			o.onMouseMove(event);
		}
	}
	
	public void onMousePress(MouseEvent event) {
		for(UIObject o : this.objects) {
			o.onMousePress(event);
		}
	}
	
	public void onMouseRelease(MouseEvent event) {
		for(UIObject o : this.objects) {
			o.onMouseRelease(event);
		}
	}
	
	public void onMouseDrag(MouseEvent event) {
		for(UIObject o : this.objects) {
			o.onMouseDrag(event);
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

