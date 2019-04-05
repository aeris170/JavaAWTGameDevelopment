package main;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Window extends JFrame {

	private Engine engine;

	public Window() {
		setTitle("Java AWT Platformer Game!");
		addKeyListener(Keyboard.INPUT);
		setBounds(2000, 100, 600, 600);
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
