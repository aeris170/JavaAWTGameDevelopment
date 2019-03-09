package main;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Window extends JFrame {

	private Engine engine;
	
	public Window(Engine e) {
		setTitle("Java AWT Platformer Game!");
		setBounds(2000, 100, 600, 600);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		engine = e;
		add(e);
		e.setClearRect(getWidth(), getHeight());
		e.start();
	}
}
