package me.WiebeHero.Main;

import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

import me.WiebeHero.Display.Display;
import me.WiebeHero.Input.KeyManager;
import me.WiebeHero.Input.MouseManager;
import me.WiebeHero.Settings.Settings;
import me.WiebeHero.Sounds.Sounds;
import me.WiebeHero.States.FightState;
import me.WiebeHero.States.GameState;
import me.WiebeHero.States.MenuState;
import me.WiebeHero.States.SettingsState;
import me.WiebeHero.States.State;
import me.WiebeHero.gfx.Assets;
import me.WiebeHero.gfx.GameCamera;

public class Game implements Runnable{
	
	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	public State gameState;
	public State menuState;
	public State settingsState;
	public State fightState;
	
	//Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	public static Handler handler;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		this.keyManager = new KeyManager();
		this.mouseManager = new MouseManager();
	}
	
	private void init() {
		this.display = new Display(this.title, this.width, this.height);
		this.display.getFrame().addKeyListener(this.keyManager);
		this.display.getFrame().addMouseListener(this.mouseManager);
		this.display.getFrame().addMouseMotionListener(this.mouseManager);
		this.display.getFrame().getRootPane().addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent componentEvent) {
		    	width = display.getFrame().getWidth() - 16;
		    	height = display.getFrame().getHeight() - 39;
		    }
		});
		this.display.getFrame().addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent windowEvent) {
		    	Settings.saveSettings();
		    }
		});
		this.display.getCanvas().addMouseListener(this.mouseManager);
		this.display.getCanvas().addMouseMotionListener(this.mouseManager);
		Assets.init();
		Sounds.init();
		Settings.loadSettings();
		Game.handler = new Handler(this);
		this.gameCamera = new GameCamera(0, 0);
		this.gameState = new GameState();
		this.menuState = new MenuState();
		this.menuState.initMouseManager();
		this.fightState = new FightState();
		this.settingsState = new SettingsState();
		State.setState(this.menuState);
	}
	
	private void tick() {
		this.keyManager.tick();
		
		if(State.getState() != null) {
			State.getState().tick();
		}
		
	}
	
	private void render() {
		this.bs = this.display.getCanvas().getBufferStrategy();
		if(bs == null) {
			this.display.getCanvas().createBufferStrategy(3);
			return;
		}
		this.g = this.bs.getDrawGraphics();
		//Clear Screen
		this.g.clearRect(0, 0, this.width, this.height);
		//Draw Here!
		
		if(State.getState() != null) {
			State.getState().render(this.g);
		}
		
		//End Drawing!
		
		this.bs.show();
		this.g.dispose();
	}
	
	public void run() {
		
		this.init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		while(this.running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;
			
			if(delta >= 1) {
				this.tick();
				this.render();
				delta--;
			}
		}
		
		this.stop();
		
	}
	
	public KeyManager getKeyManager() {
		return this.keyManager;
	}
	
	public MouseManager getMouseManager() {
		return this.mouseManager;
	}
	
	public GameCamera getGameCamera() {
		return this.gameCamera;
	}
	
	public Display getDisplay() {
		return this.display;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public synchronized void start() {
		if(!this.running) {
			this.running = true;
			this.thread = new Thread(this);
			this.thread.start();
		}
	}
	
	public synchronized void stop() {
		if(this.running) {
			this.running = false;
			try {
				this.thread.join();
			} 
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
