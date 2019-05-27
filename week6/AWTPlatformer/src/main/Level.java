package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Level extends GameObject {

	public Level() {
		super(0f, 0f);
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics2D g2d) {
		BufferedImage mapBg = AssetLoader.MAP_BACKGROUND;
		g2d.drawImage(mapBg, 0, 0, mapBg.getWidth() * 4, mapBg.getHeight() * 4, null);
	}

}
