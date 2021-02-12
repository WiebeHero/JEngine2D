package me.WiebeHero.Entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import me.WiebeHero.Entities.Creatures.Player;

public class EntityManager {
	
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
	
	public EntityManager(Player player) {
		this.player = player;
		this.entities = new ArrayList<Entity>();
		this.entities.add(this.player);
	}
	
	public void tick() {
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()) {
			Entity e = it.next();
			e.tick();
			if(!e.isActive())
				it.remove();
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
