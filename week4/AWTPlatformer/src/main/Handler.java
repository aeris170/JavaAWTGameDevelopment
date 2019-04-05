package main;

import java.awt.Graphics2D;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Handler {

	public static List<GameObject> gameObjects = new CopyOnWriteArrayList<>();
	
	public static void add(GameObject o) {
		gameObjects.add(o);
	}
	
	public static void remove(Object o) {
		gameObjects.remove(o);
	}
	
	public static boolean contains(Object o) {
		return gameObjects.contains(o);
	}
	
	public static Object get(int index) {
		return gameObjects.get(index);
	}
	
	public static void clear() {
		gameObjects.clear();
	}
	
	public static void tick() {
		gameObjects.forEach(gameObject -> gameObject.tick());
	}
	
	public static void render(Graphics2D g2d) {
		gameObjects.forEach(gameObject -> gameObject.render(g2d));
	}
}
