package main;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		Window w = new Window();
		Player p = new Player(20, 200);
		Camera c = new Camera(p);
		Engine e = new Engine(w, c);
		w.setEngine(e);
		
		try {
			MapLoader.readMap();
			Handler.add(p);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}