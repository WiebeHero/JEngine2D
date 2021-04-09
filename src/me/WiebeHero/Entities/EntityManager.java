package me.WiebeHero.Entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class EntityManager {
	
	// CLASS
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {

		@Override
		public int compare(Entity a, Entity b) {
			if (a.getY() + a.getHeight() < b.getY() + b.getHeight()) {
				return -1;
			} else {
				return 1;
			}
		}

	};
	/**
	 * The EntityManager Constructor, used to render entities to the screen. This class
	 * is also used to define if the entity has render priority or not.
	 * @param player
	 */
	public EntityManager() {
		this.entities = new ArrayList<Entity>();
	}
	/**
	 * A method that gets called every frame.
	 */
	public void tick() {
		Iterator<Entity> it = entities.iterator();
		while (it.hasNext()) {
			Entity e = it.next();
			e.tick();
			if (!e.isActive())
				it.remove();
		}
		this.entities.sort(this.renderSorter);
	}
	/**
	 * A method that gets called every frame, but also draws objects to the screen.
	 * @param g | A Graphics object.
	 */
	public void render(Graphics g) {
		for (Entity e : this.entities) {
			e.render(g);
		}
	}
	/**
	 * A method to add Entitities to the EntityManager.
	 * @param e | The Entity to be added to the EntityManager.
	 */
	public void addEntity(Entity e) {
		this.entities.add(e);
	}
	
	// GETTERS AND SETTERS
	
	/**
	 * A getter to get all the Entities in the EntityManager.
	 * @return entities | All the Entities in the EntityManager.
	 */
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	/**
	 * A setter to set all the Entities in the EntityManager.
	 * @param entities | All the Entities in the EntityManager.
	 */
	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
}
