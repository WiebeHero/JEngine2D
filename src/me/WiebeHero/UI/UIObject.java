package me.WiebeHero.UI;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import me.WiebeHero.Input.Listeners.Listener;
import me.WiebeHero.Input.Listeners.KeyListeners.KeyPressListener;
import me.WiebeHero.Input.Listeners.KeyListeners.KeyReleaseListener;
import me.WiebeHero.Input.Listeners.MouseListeners.MouseClickListener;
import me.WiebeHero.Input.Listeners.MouseListeners.MouseDragListener;
import me.WiebeHero.Input.Listeners.MouseListeners.MouseEnterListener;
import me.WiebeHero.Input.Listeners.MouseListeners.MouseExitListener;
import me.WiebeHero.Input.Listeners.MouseListeners.MousePressListener;
import me.WiebeHero.Input.Listeners.MouseListeners.MouseReleaseListener;
import me.WiebeHero.gfx.Screen;

public abstract class UIObject{
	
	protected UIObject parent;
	protected Screen screen;
	protected ArrayList<UIObject> children;
	protected ArrayList<Listener> listeners;
	protected float x, y;
	protected double marginX, marginY;
	protected int width, height;
	protected float widthR, heightR;
	protected Rectangle bounds;
	protected boolean hovering = false, hovered = false, active = true;
	
	/**
	 * This constructor can not be called. Because it is an abstract class.
	 *
	 * @param x | Horizontal position on the screen.
	 * @param y | Vertical position on the screen.
	 * @param width | Width that it is taking on the screen.
	 * @param height | Height that it is taking on the screen.
	 * @param screen | Screen of the Game.
	 */
	public UIObject(float x, float y, int width, int height, Screen screen) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.screen = screen;
		this.marginX = -1F;
		this.marginY = -1F;
		this.bounds = new Rectangle((int)x, (int)y, width, height);
		this.children = new ArrayList<UIObject>();
		this.listeners = new ArrayList<Listener>();
	}
	/**
	 * This constructor can not be called. Because it is an abstract class.
	 *
	 * @param marginX | Horizontal position on the screen. (Proportional to the screens size, given a %)
	 * @param marginY | Vertical position on the screen. (Proportional to the screens size, given a %)
	 * @param width | Width that it is taking on the screen.
	 * @param height | Height that it is taking on the screen.
	 * @param screen | Screen of the Game.
	 */
	public UIObject(double marginX, double marginY, int width, int height, Screen screen) {
		this.x = 0.00F;
		this.y = 0.00F;
		this.screen = screen;
		this.marginX = marginX;
		this.marginY = marginY;
		this.width = width;
		this.height = height;
		this.bounds = new Rectangle((int)x, (int)y, width, height);
		this.children = new ArrayList<UIObject>();
		this.listeners = new ArrayList<Listener>();
		this.updateMargin();
	}
	/**
	 * This constructor can not be called. Because it is an abstract class.
	 *
	 * @param marginX | Horizontal position on the screen. (Proportional to the screens size, given a %)
	 * @param marginY | Vertical position on the screen. (Proportional to the screens size, given a %)
	 * @param width | Width that it is taking on the screen.
	 * @param height | Height that it is taking on the screen.
	 * @param screen | Screen of the Game.
	 * @param parent | The parent to which the object should apply their margin with
	 */
	public UIObject(double marginX, double marginY, int width, int height, Screen screen, UIObject parent) {
		this.x = 0.00F;
		this.y = 0.00F;
		this.screen = screen;
		this.marginX = marginX;
		this.marginY = marginY;
		this.width = width;
		this.height = height;
		this.parent = parent;
		this.bounds = new Rectangle((int)x, (int)y, width, height);
		this.children = new ArrayList<UIObject>();
		this.listeners = new ArrayList<Listener>();
		this.updateMargin();
	}
	/**
	 * This constructor can not be called. Because it is an abstract class.
	 *
	 * @param marginX | Horizontal position on the screen. (Proportional to the screens size, given a %)
	 * @param marginY | Vertical position on the screen. (Proportional to the screens size, given a %)
	 * @param width | Width that it is taking on the screen.
	 * @param height | Height that it is taking on the screen.
	 * @param screen | Screen of the Game.
	 * @param childen | The objects that have to base their margin of this object.
	 */
	public UIObject(double marginX, double marginY, int width, int height, Screen screen, UIObject... children) {
		this.x = 0.00F;
		this.y = 0.00F;
		this.screen = screen;
		this.marginX = marginX;
		this.marginY = marginY;
		this.width = width;
		this.height = height;
		this.bounds = new Rectangle((int)x, (int)y, width, height);
		this.children = new ArrayList<UIObject>();
		this.listeners = new ArrayList<Listener>();
		if(children != null) {
			for(int i = 0; i < children.length; i++) {
				UIObject child = children[i];
				child.setParent(this);
				this.children.add(child);
			}
		}
		this.updateMargin();
	}
	/**
	 * This constructor can not be called. Because it is an abstract class.
	 *
	 * @param marginX | Horizontal position on the screen. (Proportional to the screens size, given a %)
	 * @param marginY | Vertical position on the screen. (Proportional to the screens size, given a %)
	 * @param width | Width that it is taking on the screen.
	 * @param height | Height that it is taking on the screen.
	 * @param screen | Screen of the Game.
	 * @param parent | The object that this object should base their margin on.
	 * @param childen | The objects that have to base their margin of this object.
	 */
	public UIObject(double marginX, double marginY, int width, int height, Screen screen, UIObject parent, UIObject... children) {
		this.x = 0.00F;
		this.y = 0.00F;
		this.screen = screen;
		this.marginX = marginX;
		this.marginY = marginY;
		this.width = width;
		this.height = height;
		this.parent = parent;
		this.bounds = new Rectangle((int)x, (int)y, width, height);
		this.children = new ArrayList<UIObject>();
		if(children != null) {
			for(int i = 0; i < children.length; i++) {
				UIObject child = children[i];
				child.setParent(this);
				this.children.add(child);
			}
		}
		this.updateMargin();
	}
	/**
	 * Method that is being called every frame.
	 */
	public abstract void tick();
	/**
	 * Method that draws things to the screen.
	 * 
	 * @param g | Main graphics object that draws to the screen.
	 */
	public abstract void render(Graphics g);
	/**
	 * Method that is being called when a key is pressed.
	 */
	public abstract void onKeyPress(int key);
	/**
	 * Method that is being called when a key is released.
	 */
	public abstract void onKeyRelease(int key);
	/**
	 * Method that is being called when a key is typed.
	 */
	public abstract void onKeyType(int key);
	/**
	 * Method that is being called when the button is hovered on.
	 */
	public abstract void onMouseHover();
	/**
	 * Method that is being called when a mouse button is released.
	 */
	public abstract void onMouseRelease();
	/**
	 * Method that is being called when a mouse button is pressed.
	 */
	public abstract void onMousePress();
	/**
	 * Method that is being called when you drag with your mouse.
	 */
	public abstract void onMouseDrag();
	/**
	 * Method that is being called when a mouse button is pressed and released.
	 */
	public abstract void onMouseClicked();
	/**
	 * Method that is being called when the cursor enters the window.
	 */
	public abstract void onMouseEntered();
	/**
	 * Method that is being called when the cursor exits the window.
	 */
	public abstract void onMouseExited();
	/**
	 * Sets the hovering state dependent on the position of the mouse and calls the onMouseHover() method, also all
	 * the appropiate listeners will be called related to Hovering.
	 * 
	 * @param event | Mouse Move Event.
	 */
	public void onMouseMoved(MouseEvent event) {
		if(this.bounds.contains(event.getX(), event.getY())) {
			this.hovering = true;
			if(!this.hovered) {
				this.hovered = true;
				this.onMouseHover();
			}
		}
		else {
			this.hovering = false;
			this.hovered = false;
		}
		for(UIObject child : this.children) {
			child.onMouseMoved(event);
		}
	}
	/**
	 * Calls the onMousePress() method that can be overriden, also all the appriopiate
	 * listeners will be called related to Pressing.
	 * 
	 * @param event | Mouse Release Event.
	 */
	public void onMousePressed(MouseEvent event) {
		if(this.hovering && this.bounds.contains(event.getX(), event.getY())) {
			this.onMousePress();
			for(Listener listener : this.listeners) {
				if(listener instanceof MousePressListener) {
					listener.listen();
				}
			}
		}
		for(UIObject child : this.children) {
			child.onMousePressed(event);
		}
		
	}
	/**
	 * Calls the onMouseRelease() method that can be overriden, also all the appropiate
	 * listeners will be called related to Releasing.
	 * 
	 * @param event | Mouse Release Event.
	 */
	public void onMouseReleased(MouseEvent event) {
		if(this.hovering && this.bounds.contains(event.getX(), event.getY())) {
			this.onMouseRelease();
			for(Listener listener : this.listeners) {
				if(listener instanceof MouseReleaseListener) {
					listener.listen();
				}
			}
		}
		for(UIObject child : this.children) {
			child.onMouseReleased(event);
		}
	}
	/**
	 * Calls the onMouseDrag() method that can be overriden, also all the appropiate
	 * listeners will be called related to Dragging.
	 * 
	 * @param event | Mouse Release Event.
	 */
	public void onMouseDragged(MouseEvent event) {
		if(this.hovering && this.bounds.contains(event.getX(), event.getY())) {
			this.onMouseDrag();
			for(Listener listener : this.listeners) {
				if(listener instanceof MouseDragListener) {
					listener.listen();
				}
			}
		}
		for(UIObject child : this.children) {
			child.onMouseDragged(event);
		}
	}
	/**
	 * Calls the onMouseClick() method that can be overriden, also all the appropiate
	 * listeners will be called related to Clicking.
	 * 
	 * @param event | Mouse Release Event.
	 */
	public void onMouseClicked(MouseEvent event) {
		if(this.hovering && this.bounds.contains(event.getX(), event.getY())) {
			this.onMouseClicked();
			for(Listener listener : this.listeners) {
				if(listener instanceof MouseClickListener) {
					listener.listen();
				}
			}
		}
		for(UIObject child : this.children) {
			child.onMouseClicked(event);
		}
	}
	/**
	 * Calls the onMouseEntered() method that can be overriden, also all the appropiate
	 * listeners will be called related to Entering.
	 * 
	 * @param event | Mouse Enter Event.
	 */
	public void onMouseEntered(MouseEvent event) {
		this.onMouseEntered();
		for(Listener listener : this.listeners) {
			if(listener instanceof MouseEnterListener) {
				listener.listen();
			}
		}
		for(UIObject child : this.children) {
			child.onMouseEntered(event);
		}
	}
	/**
	 * Calls the onMouseExited() method that can be overriden, also all the appropiate
	 * listeners will be called related to Exiting.
	 * 
	 * @param event | Mouse Exit Event.
	 */
	public void onMouseExited(MouseEvent event) {
		this.onMouseExited();
		for(Listener listener : this.listeners) {
			if(listener instanceof MouseExitListener) {
				listener.listen();
			}
		}
		for(UIObject child : this.children) {
			child.onMouseExited(event);
		}
	}
	/**
	 * Calls the onKeyPress() method that can be overriden, also all the appropiate
	 * listeners will be called related to Key Pressing.
	 * 
	 * @param event | Key Press Event.
	 */
	public void onKeyPressed(KeyEvent event) {
		this.onKeyPress(event.getKeyCode());
		for(Listener listener : this.listeners) {
			if(listener instanceof KeyPressListener) {
				listener.listen();
			}
		}
		for(UIObject child : this.children) {
			child.onKeyPressed(event);
		}
	}
	
	/**
	 * Calls the onKeyRelease() method that can be overriden, also all the appropiate
	 * listeners will be called related to Key Releasing.
	 * 
	 * @param event | Key Release Event.
	 */
	public void onKeyReleased(KeyEvent event) {
		this.onKeyRelease(event.getKeyCode());
		for(Listener listener : this.listeners) {
			if(listener instanceof KeyReleaseListener) {
				listener.listen();
			}
		}
		for(UIObject child : this.children) {
			child.onKeyReleased(event);
		}
	}
	
	/**
	 * Calls the onKeyType() method that can be overriden, also all the appropiate
	 * listeners will be called related to Exiting.
	 * 
	 * @param event | Key Type Event.
	 */
	public void onKeyTyped(KeyEvent event) {
		this.onKeyType(event.getKeyCode());
		for(Listener listener : this.listeners) {
			if(listener instanceof KeyReleaseListener) {
				listener.listen();
			}
		}
		for(UIObject child : this.children) {
			child.onKeyTyped(event);
		}
	}
	
	//GETTERS AND SETTERS
	
	/**
	 * Returns the horizontal position of the object.
	 */
	public float getX() {
		return x;
	}
	/**
	 * Sets the horizontal position of the object.
	 * 
	 * @param x | Horizontal position in floats.
	 */
	public void setX(float x) {
		this.x = x;
	}
	/**
	 * Returns the vertical position of the object.
	 */
	public float getY() {
		return y;
	}
	/**
	 * Sets the vertical position of the object.
	 * 
	 * @param y | Vertical position in floats.
	 */
	public void setY(float y) {
		this.y = y;
	}
	/**
	 * Returns the horizontal margin of the object.
	 */
	public double getMarginX() {
		return marginX;
	}
	/**
	 * Sets the horizontal margin of the object.
	 * 
	 * @param marginX | Horizontal margin in doubles.
	 */
	public void setMarginX(double marginX) {
		this.marginX = marginX;
		this.updateMargin();
		for(UIObject children : this.children) {
			children.updateMargin();
		}
	}
	/**
	 * Returns the vertical margin of the object.
	 */
	public double getMarginY() {
		return marginY;
	}
	/**
	 * Sets the vertical margin of the object.
	 * 
	 * @param marginY | Vertical margin in doubles.
	 */
	public void setMarginY(double marginY) {
		this.marginY = marginY;
		this.updateMargin();
		for(UIObject children : this.children) {
			children.updateMargin();
		}
	}
	/**
	 * Get the width of the object.
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * Sets the width of the object.
	 * 
	 * @param width | Width in integer.
	 */
	public void setWidth(int width) {
		this.width = width;
		this.bounds.width = width;
	}
	/**
	 * Get the height of the object.
	 * 
	 * @return int | height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * Set the height of the object.
	 * 
	 * @param height | Height in integer
	 */
	public void setHeight(int height) {
		this.height = height;
		this.bounds.height = height;
	}
	/**
	 * Check if the object is being hovered on.
	 * @return boolean | hovering
	 */
	public boolean isHovering() {
		return hovering;
	}
	/**
	 * Set if the object is being hovered on.
	 * @param hovering | Hovered or not
	 */
	public void setHovering(boolean hovering) {
		this.hovering = hovering;
	}
	/**
	 * Check if the object is active (Rendered on screen and processing events)
	 * @return active | Active or not.
	 */
	public boolean isActive() {
		return this.active;
	}
	/**
	 * Set if the object is active (Rendered on screen and processing events)
	 * @param active | Active or not.
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	/**
	 * A getter that returns the Bounding Box of the object.
	 * @return bounds | Rectangle, bounding box.
	 */
	public Rectangle getBounds() {
		return this.bounds;
	}
	/**
	 * A setter to set the parrent of this object (Margin related)
	 * @param object | UIObject
	 */
	public void setParent(UIObject object) {
		this.parent = object;
		if(marginX != -1F && marginY != -1F) {
			this.updateMargin();
			for(UIObject children : this.children) {
				children.updateMargin();
			}
		}
	}
	/**
	 * A getter to get the parent of this object (If it has one)
	 * @return parent | UIObject
	 */
	public UIObject getParent() {
		return this.parent;
	}
	/**
	 * A method to add children to the object.
	 * @param child | UIObject
	 */
	public void addChild(UIObject child) {
		child.setParent(this);
		this.children.add(child);
	}
	/**
	 * A method to add multiple children to the object
	 * @param children | UIObject
	 */
	public void addChildren(UIObject... children) {
		for(int i = 0; i < children.length; i++) {
			UIObject child = children[i];
			child.setParent(this);
			this.children.add(child);
		}
	}
	/**
	 * Get a child if it's present.
	 * @param index
	 * @return child | UIObject
	 */
	public UIObject getChild(int index) {
		return this.children.get(index);
	}
	/**
	 * A getter that returns all of the children present in this object.
	 * @return children | ArrayList
	 */
	public ArrayList<UIObject> getChildren(){
		return this.children;
	}
	/**
	 * A method to add a Listener to this object (If needed, not required.)
	 * @param listener | Listener
	 */
	public void addListener(Listener listener){
		this.listeners.add(listener);
	}
	/**
	 * A method to add listeners to this object (If needed, not required.)
	 * @param listeners
	 */
	public void addListeners(Listener... listeners) {
		for(int i = 0; i < listeners.length; i++) {
			this.listeners.add(listeners[i]);
		}
	}
	/**
	 * A method the returns a boolean and checks if another hitbox is overlapping another.
	 * @param r | Rectangle of the other bounding box.
	 * @return
	 */
	public boolean overlaps(Rectangle r) {
	    return x < r.x + r.width && x + width > r.x && y < r.y + r.height && y + height > r.y;
	}
	/**
	 * A method to update the Margin of the object if it is set.
	 */
	protected void updateMargin() {
		if(this.parent != null) {
			float inX = parent.getX(), inY = parent.getY();
			int inWidth = parent.getWidth(), inHeight = parent.getHeight();
			int finalX = (int)inX + (int)(inWidth / 100.00 * marginX) - width / 2, finalY = (int)inY + (int)(inHeight / 100.00 * marginY) - height / 2;
			x = finalX;
			y = finalY;
			bounds.x = finalX;
			bounds.y = finalY;
		}
		else {
			int canvasX = this.screen.getWidth(), canvasY = this.screen.getHeight();
			int finalX = (int)(canvasX / 100.00 * marginX) - width / 2, finalY = (int)(canvasY / 100.00 * marginY) - height / 2;
			x = finalX;
			y = finalY;
			bounds.x = finalX;
			bounds.y = finalY;
		}
		for(UIObject children : this.children) {
			children.updateMargin();
		}
	}
}
