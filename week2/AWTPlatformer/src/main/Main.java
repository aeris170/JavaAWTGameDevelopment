package main;

public class Main {

	public static void main(String[] args) {
		Engine e = new Engine();
		Window w = new Window(e);
		Player p = new Player(20, 200);
		Handler.add(p);
		
	}
}