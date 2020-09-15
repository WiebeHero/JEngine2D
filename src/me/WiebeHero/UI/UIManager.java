package me.WiebeHero.UI;

import java.awt.Graphics;
import java.awt.Rectangle;
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
			if(o instanceof UIBox) {
				UIBox box = (UIBox) o;
				for(UIImageButton button : box.getButtons()) {
					button.tick();
				}
			}
			else {
				o.tick();
			}
		}
	}
	
	public void render(Graphics g) {
		for(UIObject o : this.objects) {
			if(o instanceof UIBox) {
				UIBox box = (UIBox) o;
				for(UIImageButton button : box.getButtons()) {
					button.render(g);
				}
			}
			else {
				o.render(g);
			}
		}
	}
	
	public void onMouseMove(MouseEvent event) {
		for(UIObject o : this.objects) {
			if(o instanceof UIBox) {
				UIBox box = (UIBox) o;
				for(UIImageButton button : box.getButtons()) {
					button.onMouseMove(event);
				}
			}
			else {
				o.onMouseMove(event);
			}
		}
	}
	
	public void onMouseRelease(MouseEvent event) {
		for(UIObject o : this.objects) {
			if(o instanceof UIBox) {
				UIBox box = (UIBox) o;
				for(UIImageButton button : box.getButtons()) {
					button.onMouseRelease(event);
				}
			}
			else {
				o.onMouseRelease(event);
			}
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
	
	public UIObject getObject(int index) {
		return this.objects.get(index);
	}
	
	public void updateXY() {
		for(int i = 0; i < this.objects.size(); i++) {
			UIObject object = this.objects.get(i);
			if(object instanceof UIBox) {
				UIBox box = (UIBox) object;
				double marginX = box.getMarginX(), marginY = box.getMarginY();
				if(marginX >= 0.00 && marginY >= 0.00) {
					int gameX = this.handler.getWidth(), gameY = this.handler.getHeight();
					Rectangle bounds = object.getBounds();
					int finalX = (int)(gameX / 100.00 * marginX) - box.getWidth() / 2 + (int)box.getExtraX(), finalY = (int)(gameY / 100.00 * marginY) - box.getHeight() / 2 + (int)object.getExtraY();
					box.setX(finalX);
					box.setY(finalY);
					bounds.x = finalX;
					bounds.y = finalY;
				}
				float boxX = box.getX();
				float boxY = box.getY();
				for(UIImageButton button : box.getButtons()) {
					marginX = button.getMarginX();
					marginY = button.getMarginY();
					if(marginX >= 0.00 && marginY >= 0.00) {
						int boxWidth = box.getWidth(), boxHeight = box.getHeight();
						Rectangle bounds = button.getBounds();
						int finalX = (int)boxX + (int)(boxWidth / 100.00 * marginX) - button.getWidth() / 2 + (int)button.getExtraX(), finalY = (int)boxY + (int)(boxHeight / 100.00 * marginY) - button.getHeight() / 2 + (int)button.getExtraY();
						button.setX(finalX);
						button.setY(finalY);
						bounds.x = finalX;
						bounds.y = finalY;
					}
				}
			}
			else {
				double marginX = object.getMarginX(), marginY = object.getMarginY();
				if(marginX >= 0.00 && marginY >= 0.00) {
					int canvasX = this.handler.getWidth(), canvasY = this.handler.getHeight();
					Rectangle bounds = object.getBounds();
					int finalX = (int)(canvasX / 100.00 * marginX) - object.getWidth() / 2 + (int)object.getExtraX(), finalY = (int)(canvasY / 100.00 * marginY) - object.getHeight() / 2 + (int)object.getExtraY();
					object.setX(finalX);
					object.setY(finalY);
					bounds.x = finalX;
					bounds.y = finalY;
				}
			}
		}
	}
}

