package me.WiebeHero.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.util.ArrayList;
import java.util.Arrays;

import me.WiebeHero.Input.MouseManager;
import me.WiebeHero.InputListeners.HoverListener;
import me.WiebeHero.InputListeners.Listener;
import me.WiebeHero.InputListeners.PressListener;
import me.WiebeHero.InputListeners.ReleaseListener;
import me.WiebeHero.Main.Game;

public class UISlider extends UIObject{
	
	private UIPivot pivot;
	private int max;
	private int value;
	private boolean[] options;
	private ArrayList<Listener> listeners;
	
	//**OPTIONS**
	//There are different options you can choose for the animation to perform
	//Arguments: 0 : FALSE = PIVOT FOLLOWS MOUSE, TRUE = PIVOT FOLLOWS POINTS
	//**OPTIONS**
	
	public UISlider(UIPivot pivotG, double marginX, double marginY, int width, int height, int max, boolean... options) {
		super(marginX, marginY, width, height);
		this.listeners = new ArrayList<Listener>();
		this.max = max;
		this.pivot = pivotG;
		this.pivot.setInheritance(this);
		int[] points = new int[max + 1];
		int distance = width / max;
//		Game.handler.getDisplay().getFrame().getRootPane().addComponentListener(new ComponentAdapter() {
//		    public void componentResized(ComponentEvent componentEvent) {
//		    	Thread t = new Thread() {
//					public void run() {
//						try {
//							sleep(100);
//						} 
//						catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//						for(int i = 0; i < points.length; i++) {
//							points[i] = (int)x + (distance * i);
//						}
//						pivot.setX(points[value] - pivot.getWidth() / 2);
//						pivot.setY(y + height / 2 - pivot.getHeight() / 2);
//					}
//				};
//				t.start();
//		    }
//		});
		for(int i = 0; i < points.length; i++) {
			points[i] = (int)x + (distance * i);
		}
		double diff = 100.00 / (double)points.length;
		this.pivot.setMarginX(diff * this.value);
		this.pivot.setMarginY(50.0);
//		pivot.setX(points[value] - pivot.getWidth() / 2);
//		pivot.setY(y + height / 2 - pivot.getHeight() / 2);
		this.options = new boolean[1];
		for(int i = 0; i < options.length; i++) {
			this.options[i] = options[i];
		}
		
	}
	
	public UISlider(UIPivot pivotG, double marginX, double marginY, int width, int height, int max, int value1, boolean... options) {
		super(marginX, marginY, width, height);
		this.listeners = new ArrayList<Listener>();
		this.max = max;
		this.pivot = pivotG;
		this.pivot.setInheritance(this);
		this.value = value1;
		int[] points = new int[max + 1];
		int distance = width / max;
//		Game.handler.getDisplay().getFrame().getRootPane().addComponentListener(new ComponentAdapter() {
//		    public void componentResized(ComponentEvent componentEvent) {
//		    	Thread t = new Thread() {
//					public void run() {
//						try {
//							sleep(100);
//						} 
//						catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//						for(int i = 0; i < points.length; i++) {
//							points[i] = (int)x + (distance * i);
//						}
//						pivot.setX(points[value] - pivot.getWidth() / 2);
//						pivot.setY(y + height / 2 - pivot.getHeight() / 2);
//					}
//				};
//				t.start();
//		    }
//		});
		for(int i = 0; i < points.length; i++) {
			points[i] = (int)x + (distance * i);
		}
		double diff = 100.00 / (double)points.length;
		this.pivot.setMarginX(diff * this.value);
		this.pivot.setMarginY(50.0);
//		pivot.setX(points[value] - pivot.getWidth() / 2);
//		pivot.setY(y + this.height / 2 - pivot.getHeight() / 2);
		this.options = new boolean[1];
		for(int i = 0; i < options.length; i++) {
			this.options[i] = options[i];
		}
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int)x, (int)y, width, height);
		int[] points = new int[max + 1];
		for(int i = 0; i < points.length; i++) {
			points[i] = (int)x + (width / max * i);
		}
		g.setColor(Color.BLUE);
		Font font = g.getFont();
		FontRenderContext frc = g.getFontMetrics().getFontRenderContext();
		TextLayout layout = new TextLayout(value + "", font, frc);
		layout.draw((Graphics2D) g, (int)(x - layout.getBounds().getWidth() / 2 - 18), (int)(y + (height / 2) + (layout.getBounds().getHeight() / 2)));
		this.pivot.render(g);
	}

	@Override
	public void onHover() {
		for(Listener listener : this.listeners) {
			if(listener instanceof HoverListener) {
				listener.listen();
			}
		}
	}

	@Override
	public void onPress() {
		this.update();
		for(Listener listener : this.listeners) {
			if(listener instanceof PressListener) {
				listener.listen();
			}
		}
	}
	
	@Override
	public void onRelease() {
		int mouseX = MouseManager.mouseX;
		int[] points = new int[max + 1];
		int distance = width / max;
		for(int i = 0; i < points.length; i++) {
			points[i] = (int)x + (distance * i);
		}
		for(int i = 0; i < points.length; i++) {
			if(mouseX - points[i]  < distance / 2 || points[i] - mouseX > -distance / 2) {
				value = i;
				double diff = (double)(points[i] - x) / (double)width * 100.00;
				pivot.setMarginX(diff);
				break;
			}
		}
		for(Listener listener : this.listeners) {
			if(listener instanceof ReleaseListener) {
				listener.listen();
			}
		}
	}

	@Override
	public void onDrag() {
		this.update();
	}
	
	private void update() {
		int mouseX = MouseManager.mouseX;
		int[] points = new int[max + 1];
		int distance = width / max;
		for(int i = 0; i < points.length; i++) {
			points[i] = (int)x + (distance * i);
		}
		for(int i = 0; i < points.length; i++) {
			if(mouseX - points[i]  < distance / 2 || points[i] - mouseX > -distance / 2) {
				if(options[0]) {
					double diff = (double)(points[i] - x) / (double)width * 100.00;
					pivot.setMarginX(diff);
				}
				value = i;
				break;
			}
		}
	}
	
	public void addListeners(Listener... listeners) {
		this.listeners.addAll(Arrays.asList(listeners));
	}
	
	public int getValue() {
		return this.value;
	}
	
	@Override
	public void updateMargin() {
		this.updateM();
		if(this.pivot != null) {
			this.pivot.updateM();
		}
	}
}
