package me.WiebeHero.Tiles;

import me.WiebeHero.gfx.Assets;

public class DirtTile extends Tile{
	
	public DirtTile(int id) {
		super(Assets.dirt, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
	
}
