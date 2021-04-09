package me.WiebeHero.Internal;

public class FPSManager {
	
	private static int fps = 60;
	
	private FPSManager() {
		
	}
	/**
	 * A setter to set the current Frames Per Second.
	 * @param fps | Frames Per Second.
	 */
	public static void setFPS(int fps) {
		FPSManager.fps = fps;
	}
	/**
	 * A getter to return the current Frames Per Second.
	 * @param fps | Frames Per Second.
	 */
	public static int getFPS() {
		return FPSManager.fps;
	}
}
