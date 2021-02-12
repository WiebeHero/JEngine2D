package me.WiebeHero.Settings;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import me.WiebeHero.Utils.Utils;

public class Settings {
	
	public static float volume;
	public static int up, down, left, right, sprint;
	public static int aUp, aDown, aLeft, aRight;
	
	public static void saveSettings() {
		try {
			String path = (Settings.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
			if(path.contains(".jar")) {
				path = path.substring(0, path.indexOf("Sinner.jar"));
				System.out.println(path);
				File file = new File(path + "/Settings.txt");
				if(!file.exists()) {
					try {
						file.createNewFile();
						FileWriter writer = new FileWriter(file);
						writer.write("100.00," + KeyEvent.VK_W + "," + KeyEvent.VK_S + "," + KeyEvent.VK_A + "," + KeyEvent.VK_D + "," + KeyEvent.VK_SHIFT);
						writer.close();
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				}
				else {
					try {
						FileWriter writer = new FileWriter(file);
						writer.write(volume + "," + up + "," + down + "," + left + "," + right + "," + sprint);
						writer.close();
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void loadSettings() {
		try {
			String path = (Settings.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
			if(path.contains(".jar")) {
				path = path.substring(0, path.indexOf("Sinner.jar"));
				File file = new File(path + "Settings.txt");
				if(!file.exists()) {
					try {
						file.createNewFile();
						FileWriter writer = new FileWriter(file);
						writer.write("100.00," + KeyEvent.VK_W + "," + KeyEvent.VK_S + "," + KeyEvent.VK_A + "," + KeyEvent.VK_D + "," + KeyEvent.VK_SHIFT);
						writer.close();
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				}
				Scanner reader = new Scanner(file);
				StringBuilder builder = new StringBuilder();
				while(reader.hasNextLine()) {
					builder.append(reader.nextLine());
				}
				reader.close();
				System.out.println(builder.toString());
				String[] tokens = builder.toString().split(",");
				System.out.println(tokens[0]);
				System.out.println(tokens[1]);
				System.out.println(tokens[2]);
				System.out.println(tokens[3]);
				System.out.println(tokens[4]);
				System.out.println(tokens[5]);
				volume = Utils.parseFloat(tokens[0]);
				up = Utils.parseInt(tokens[1]);
				down = Utils.parseInt(tokens[2]);
				left = Utils.parseInt(tokens[3]);
				right = Utils.parseInt(tokens[4]);
				sprint = Utils.parseInt(tokens[5]);
				
				aUp = KeyEvent.VK_UP;
				aDown = KeyEvent.VK_DOWN;
				aLeft = KeyEvent.VK_LEFT;
				aRight = KeyEvent.VK_RIGHT;
			}
			else {
				volume = 100.0F;
				up = KeyEvent.VK_W;
				down = KeyEvent.VK_S;
				left = KeyEvent.VK_A;
				right = KeyEvent.VK_D;
				sprint = KeyEvent.VK_SHIFT;
				
				aUp = KeyEvent.VK_UP;
				aDown = KeyEvent.VK_DOWN;
				aLeft = KeyEvent.VK_LEFT;
				aRight = KeyEvent.VK_RIGHT;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
