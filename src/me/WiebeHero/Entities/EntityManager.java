package me.WiebeHero.Entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import me.WiebeHero.Main.Handler;

public class EntityManager {
	
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {

		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight()) {
				return -1;
			}
			else {
				return 1;
			}
		}
		
	};
	
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		this.entities = new ArrayList<Entity>();
		this.entities.add(this.player);
	}
	
	public void tick() {
		for(int i = 0; i < this.entities.size(); i++) {
			Entity e = this.entities.get(i);
			e.tick();
		}
		this.entities.sort(this.renderSorter);
	}
	
	public void render(Graphics g) {
		for(Entity e : this.entities) {
			e.render(g);
		}
	}
	
	public void addEntity(Entity e) {
		this.entities.add(e);
	}
	
	//GETTERS AND SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
}
