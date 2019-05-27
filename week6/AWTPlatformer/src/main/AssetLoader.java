package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class AssetLoader {


	private AssetLoader() {
	}

	public static BufferedImage PLAYER_IDLE;
	public static BufferedImage MAP_BACKGROUND;
	
	public static void initializeAssets() {
		try {
			PLAYER_IDLE = ImageIO.read(AssetLoader.class.getResourceAsStream("/player.png"));
			MAP_BACKGROUND = ImageIO.read(AssetLoader.class.getResourceAsStream("/castle.png"));
		} catch (IOException | IllegalArgumentException ex) {
			System.err.println("f'ed up during asset loading");
		}
	}
}