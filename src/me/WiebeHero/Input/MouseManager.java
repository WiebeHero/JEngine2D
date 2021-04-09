package me.WiebeHero.Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import me.WiebeHero.UI.UIManager;

public abstract class MouseManager implements MouseListener, MouseMotionListener{

	protected UIManager uiManager;
	/**
	 * A constructor for the MouseManager. Cannot be called normally due to it
	 * being an abstract class. Empty constructor.
	 */
	public MouseManager() {
		
	}
	/**
	 * A setter that couples the UIManager to this class.
	 * @param uiManager | UIManager.
	 */
	public void setUIManager(UIManager uiManager) {
		this.uiManager = uiManager;
	}
	/**
	 * A getter that returns the UIManager coupled to this class.
	 * @return uiManager | UIManager.
	 */
	public UIManager getUIManager() {
		return this.uiManager;
	}
	/**
	 * An abstract void that is called when the mouse is holding a button and moving
	 * at the same time. Mouse Dragging!
	 * @param event | MouseEvent.
	 */
	@Override
	public abstract void mouseDragged(MouseEvent event);
	/**
	 * An abstract void that is called when the mouse is moved. Mouse Moving!
	 * @param event | MouseEvent
	 */
	@Override
	public abstract void mouseMoved(MouseEvent event);
	/**
	 * An abstract void that is called when the mouse presses and releases a button.
	 * Mouse Clicking!
	 * @param event | MouseEvent
	 */
	@Override
	public abstract void mouseClicked(MouseEvent event);
	/**
	 * An abstract void that is called when the mouse enters the window. Mouse Entering!
	 * @param event | MouseEvent
	 */
	@Override
	public abstract void mouseEntered(MouseEvent event);
	/**
	 * An abstract void that is called when the mouse exits the window. Mouse Exiting!
	 * @param event | MouseEvent
	 */
	@Override
	public abstract void mouseExited(MouseEvent event);
	/**
	 * An abstract void that is called when a mouse button is pressed! Mouse Pressing!
	 * @param event | MouseEvent
	 */
	@Override
	public abstract void mousePressed(MouseEvent event);
	/**
	 * An abstract void that is called when a mouse button is released! Mouse Releasing!
	 */
	@Override
	public abstract void mouseReleased(MouseEvent event);

}
