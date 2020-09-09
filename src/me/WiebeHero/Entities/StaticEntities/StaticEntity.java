package me.WiebeHero.Entities.StaticEntities;

import me.WiebeHero.Entities.Entity;
import me.WiebeHero.Main.Handler;

public abstract class StaticEntity extends Entity{
	
	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}
	
}
