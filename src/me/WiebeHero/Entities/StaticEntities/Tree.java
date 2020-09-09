package me.WiebeHero.Entities.StaticEntities;

import java.awt.Graphics;

import me.WiebeHero.Main.Handler;
import me.WiebeHero.Tiles.Tile;
import me.WiebeHero.gfx.Assets;

public class Tree extends StaticEntity{
	
	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
		
		this.bounds.x = 10;
		this.bounds.y = (int) (height / 1.5F);
		this.bounds.width = this.width - 20;
		this.bounds.height = (int) (this.height - this.height / 1.10F); 
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int)(this.x - this.handler.getGameCamera().getxOffset()), (int)(this.y - this.handler.getGameCamera().getyOffset()), this.width, this.height, null);
	}
	
}
