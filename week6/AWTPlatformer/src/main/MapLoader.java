package main;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MapLoader {

	private static final String MAP_FILE = "/map.png";

	public static void readMap() throws IOException {
		BufferedImage mapImage = ImageIO.read(MapLoader.class.getResourceAsStream(MAP_FILE));
		int mapWidth = mapImage.getWidth();
		int mapHeight = mapImage.getHeight();
		for (int i = 0; i < mapWidth; i++) {
			for (int j = 0; j < mapHeight; j++) {
				Color pixelColor = new Color(mapImage.getRGB(i, j));
				int alpha = pixelColor.getAlpha();
				int red = pixelColor.getRed();
				int green = pixelColor.getGreen();
				int blue = pixelColor.getBlue();
				if (alpha == 255) {
					if (pixelColor.equals(Color.BLACK)) {
						// black blocks
						Handler.add(new SolidBlock(i * 4, j *4, 4, 4));
					} else if (pixelColor.equals(Color.BLUE)) {
						Handler.add(new Trampoline(i * 16, j * 16 + 8, 16, 8));
					} else if (pixelColor.equals(Color.RED)) {
						Handler.add(new Lava(i * 16, j * 16, 16, 16));
					}
				}
			}
		}
	}
}
