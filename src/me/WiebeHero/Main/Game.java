package me.WiebeHero.Main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import me.WiebeHero.Display.Display;
import me.WiebeHero.Input.KeyManager;
import me.WiebeHero.States.GameState;
import me.WiebeHero.States.MenuState;
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
	private State gameState;
	private State menuState;
	
	//Input
	private KeyManager keyManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		this.keyManager = new KeyManager();
	}
	
	private void init() {
		this.display = new Display(this.title, this.width, this.height);
		this.display.getFrame().addKeyListener(this.keyManager);
		Assets.init();
		this.handler = new Handler(this);
		this.gameCamera = new GameCamera(this.handler, 0, 0);
		this.gameState = new GameState(this.handler);
		this.menuState = new MenuState(this.handler);
		State.setState(this.gameState);
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
	
	public GameCamera getGameCamera() {
		return this.gameCamera;
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
