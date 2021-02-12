package me.WiebeHero.Worlds;

import java.awt.Graphics;

import me.WiebeHero.Entities.EntityManager;
import me.WiebeHero.Entities.Creatures.Player;
import me.WiebeHero.Entities.StaticEntities.Tree;
import me.WiebeHero.Main.Game;
import me.WiebeHero.Main.Handler;
import me.WiebeHero.Tiles.Tile;
import me.WiebeHero.Utils.Utils;

public class World {
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	//ENTITIES
	private EntityManager entityManager;
	
	public World(String path) {
		this.entityManager = new EntityManager(new Player(100, 100));
		this.entityManager.addEntity(new Tree(250, 250));
		
		this.loadWorld(path);
		
		this.entityManager.getPlayer().setX(this.spawnX);
		this.entityManager.getPlayer().setY(this.spawnY);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void tick() {
		this.entityManager.tick();
	}
	
	public void render(Graphics g) {
		Handler handler = Game.handler;
		int xStart = (int)Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int)Math.min(this.width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int)Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int)Math.min(this.height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart; y < yEnd; y++) {
			for(int x = xStart; x < xEnd; x++) {
				this.getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		//Entities
		this.entityManager.render(g);
	}
	
	public Tile getTile(int x, int y) {
		if(x > 0 || y > 0 || x <= this.width || y <= this.height) {
			Tile t = Tile.tiles[tiles[x][y]];
			if(t != null) {
				return t;
			}
			else {
				return Tile.grassTile;
			}
		}
		else {
			return Tile.grassTile;
		}
	}
	
	private void loadWorld(String path) {
		System.out.println(path);
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		this.width = Utils.parseInt(tokens[0]);
		this.height = Utils.parseInt(tokens[1]);
		this.spawnX = Utils.parseInt(tokens[2]);
		this.spawnY = Utils.parseInt(tokens[3]);
		
		this.tiles = new int[width][height];
		for(int y = 0; y < this.height; y++) {
			for(int x = 0; x < this.width; x++) {
				this.tiles[x][y] = Utils.parseInt(tokens[(x + y * this.width + 4)]);
			}
		}
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
}
