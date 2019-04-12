package main;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Window extends JFrame {

	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 600;
	
	private Engine engine;

	public Window() {
		setTitle("Java AWT Platformer Game!");
		addKeyListener(Keyboard.INPUT);
		setBounds(2000, 100, WINDOW_WIDTH, WINDOW_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void setEngine(Engine e) {
		if (engine != null) {
			engine.stop();
			remove(engine);
		}
		add(e);
		e.setClearRect(getWidth(), getHeight());
		engine = e;
		e.start();
	}
}
