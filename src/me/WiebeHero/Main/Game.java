package me.WiebeHero.Main;

import me.WiebeHero.Display.Display;
import me.WiebeHero.Input.KeyManager;
import me.WiebeHero.Input.MouseManager;
import me.WiebeHero.Internal.FPSManager;
import me.WiebeHero.States.StateManager;
import me.WiebeHero.gfx.Screen;

public abstract class Game implements Runnable{
	
	protected Display display;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
//	private BufferStrategy bs;
//	private Graphics g;
	
	//Screen
	protected Screen screen;
	
	//States
	protected StateManager stateManager;
	
	//Input
	protected KeyManager keyManager;
	protected MouseManager mouseManager;
	/**
	 * A constructor for the Game class, cannot be instantiated on it's own due to it
	 * being an abstract class. Initializes the Title, Width, Height, KeyManager and MouseManager.
	 * @param title
	 * @param width
	 * @param height
	 * @param keyManager
	 * @param mouseManager
	 */
	public Game(String title, int width, int height, KeyManager keyManager, MouseManager mouseManager) {
		this.screen = new Screen(width, height);
		this.keyManager = keyManager;
		this.mouseManager = mouseManager;
		this.title = title;
	}
	/**
	 * A method that is called when the game runs. (Game.run())
	 */
	protected abstract void init();
//		this.display = new Display(this.title, screen.getWidth(), screen.getHeight());
//		this.display.getFrame().addMouseListener(this.mouseManager);
//		this.display.getFrame().addMouseMotionListener(this.mouseManager);
//		this.display.getFrame().getRootPane().addComponentListener(new ComponentAdapter() {
//			
//		    public void componentResized(ComponentEvent componentEvent) {
//		    	screen.resize(display.getFrame().getWidth() - 16, display.getFrame().getHeight() - 39);
//		    }
//		    
//		});
//		this.display.getCanvas().addMouseListener(this.mouseManager);
//		this.display.getCanvas().addMouseMotionListener(this.mouseManager);
//		this.stateManager = StateManager.getInstance();
//		this.endInit();
	/**
	 * A method that is called every frame. Used to tick other objects.
	 */
	protected abstract void tick();
//		this.keyManager.tick();
//		
//		if(this.stateManager.getState() != null) {
//			this.stateManager.getState().tick();
//		}
		
	/**
	 * A method that is called every frame. Used to render other objects.
	 */
	protected abstract void render();
//		this.bs = this.display.getCanvas().getBufferStrategy();
//		if(bs == null) {
//			this.display.getCanvas().createBufferStrategy(3);
//			return;
//		}
//		this.g = this.bs.getDrawGraphics();
//		//Clear Screen
//		this.g.clearRect(0, 0, screen.getWidth(), screen.getHeight());
//		//Draw Here!
//		
//		if(this.stateManager.getState() != null) {
//			this.stateManager.getState().render(this.g);
//		}
//		
//		//End Drawing!
//		
//		this.bs.show();
//		this.g.dispose();
	
	/**
	 * A method called when the game starts. (Game.run())
	 */
	public void run() {
		
		this.init();
		
		double timePerTick = 1000000000 / FPSManager.getFPS();
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
	/**
	 * A getter that returns the KeyManager of this class.
	 * @return keyManager | KeyManager
	 */
	public KeyManager getKeyManager() {
		return this.keyManager;
	}
	/**
	 * A getter that returns the MouseManager of this class.
	 * @return mouseManager | MouseManager
	 */
	public MouseManager getMouseManager() {
		return this.mouseManager;
	}
	/**
	 * A getter that returns the Display of this class.
	 * @return display | Display
	 */
	public Display getDisplay() {
		return this.display;
	}
	/**
	 * A getter that returns the Screen of this class.
	 * @return screen | Screen
	 */
	public Screen getScreen() {
		return this.screen;
	}
	/**
	 * A getter that returns the StateManager of this class.
	 * @return stateManager | StateManager
	 */
	public StateManager getStateManager() {
		return this.stateManager;
	}
	/**
	 * A method that starts the game.
	 */
	public synchronized void start() {
		if(!this.running) {
			this.running = true;
			this.thread = new Thread(this);
			this.thread.start();
		}
	}
	/**
	 * A method that stops the game.
	 */
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
