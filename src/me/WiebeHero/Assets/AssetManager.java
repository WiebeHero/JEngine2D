package me.WiebeHero.Assets;

public abstract class AssetManager {
	
	protected Asset[] assets;
	
	public AssetManager(int size) {
		this.assets = new Asset[size];
	}
	
	public abstract void loadAssets();
	
	public Asset getAsset(int index) {
		if(index >= 0 && index < this.assets.length) {
			return this.assets[index];
		}
		return null;
	}
	
	public Asset getAsset(String identifier) {
		for(int i = 0; i < this.assets.length; i++) {
			Asset asset = this.assets[i];
			if(asset.getIdentifier().equals(identifier)) {
				return asset;
			}
		}
		return null;
	}
	
	public Asset[] getAssets() {
		return this.assets;
	}
	
}
