package main;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		Window w = new Window();
		Engine e = new Engine(w);
		w.setEngine(e);
		try {
			MapLoader.readMap();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Player p = new Player(20, 200);
		Handler.add(p);
	}
}