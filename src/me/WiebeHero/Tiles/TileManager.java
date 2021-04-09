package me.WiebeHero.Tiles;

import java.util.ArrayList;

public class TileManager {
	
	public static int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	private ArrayList<Tile> tiles;
	
	public TileManager() {
		this.tiles = new ArrayList<Tile>();
	}
	
	public void addTile(Tile tile) {
		boolean found = false;
		for(int i = 0; i < tiles.size(); i++) {
			if(tile.getId() == tiles.get(i).getId()) {
				found = true;
				break;
			}
		}
		if(!found) {
			this.tiles.add(tile);
		}
	}
	
	public void addTiles(Tile... tiles) {
		for(int i = 0; i < tiles.length; i++) {
			Tile tile = tiles[i];
			boolean found = false;
			for(int x = 0; x < this.tiles.size(); i++) {
				if(tile.getId() == this.tiles.get(x).getId()) {
					found = true;
					break;
				}
			}
			if(!found) {
				this.tiles.add(tile);
			}
		}
	}
	
	public Tile getTile(int id) {
		for(int i = 0; i < tiles.size(); i++) {
			if(tiles.get(i).getId() == id) {
				return tiles.get(i);
			}
		}
		return null;
	}
}
