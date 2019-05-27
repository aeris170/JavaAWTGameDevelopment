package main;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		Window w = new Window();
		Player p = new Player(20, 460);
		Camera c = new Camera(p);
		Engine e = new Engine(w, c);
		c.setZoom(1.2f);
		w.setEngine(e);
		try {
			MapLoader.readMap();
			AssetLoader.initializeAssets();
			Handler.add(new Level());
			Handler.add(p);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}