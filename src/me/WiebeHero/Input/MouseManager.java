package me.WiebeHero.Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import me.WiebeHero.UI.UIManager;

public class MouseManager implements MouseListener, MouseMotionListener{

	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY;
	private UIManager uiManager;
	
	public MouseManager() {
		
	}
	
	public void setUIManager(UIManager uiManager) {
		this.uiManager = uiManager;
	}
	
	// Getters
	
	public boolean isLeftPressed() {
		return this.leftPressed;
	}
	
	public boolean isRightPressed() {
		return this.rightPressed;
	}
	
	public int getMouseX() {
		return this.mouseX;
	}
	
	public int getMouseY() {
		return this.mouseY;
	}
	
	// Implemented methods
	
	@Override
	public void mouseDragged(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		this.mouseX = event.getX();
		this.mouseY = event.getY();
		if(this.uiManager != null) {
			this.uiManager.onMouseMove(event);
		}
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent event) {
		if(event.getButton() == MouseEvent.BUTTON1) {
			this.leftPressed = true;
		}
		else if(event.getButton() == MouseEvent.BUTTON3) {
			this.rightPressed = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		if(event.getButton() == MouseEvent.BUTTON1) {
			this.leftPressed = false;
		}
		else if(event.getButton() == MouseEvent.BUTTON3) {
			this.rightPressed = false;
		}
		if(this.uiManager != null) {
			this.uiManager.onMouseRelease(event);
		}
	}

}
