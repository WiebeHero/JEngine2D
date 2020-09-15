package me.WiebeHero.Main;

import java.awt.Toolkit;

public class Launcher {
	
	public static void main(String args[]) {
		Toolkit.getDefaultToolkit().getDesktopProperty("awt.dynamicLayoutSupported");
		Toolkit.getDefaultToolkit().setDynamicLayout(false);
		System.setProperty("sun.awt.noerasebackground", "true");
		Game game = new Game("Sinner", 640, 360);
		game.start();
		
	}
	
}
