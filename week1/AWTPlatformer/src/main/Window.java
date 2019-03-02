package main;

import javax.swing.JFrame;

public class Window extends JFrame {

	private Engine engine;
	
	public Window(Engine e) {
		setTitle("Java AWT Platformer Game!");
		setBounds(2000, 100, 300, 300);
		setResizable(false);
		setVisible(true);
		engine = e;
		add(e);
		e.start();
	}
}
