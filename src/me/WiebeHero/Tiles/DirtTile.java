package me.WiebeHero.Tiles;

import me.WiebeHero.gfx.Assets;

public class DirtTile extends Tile{
	
	public DirtTile(int id) {
		super(Assets.DIRT, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
	
}
