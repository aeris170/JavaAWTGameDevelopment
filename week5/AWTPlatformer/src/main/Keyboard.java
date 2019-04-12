package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public final class Keyboard {

	private static boolean[] KEYS = new boolean[525];
	
	
	private Keyboard() {
	}

	public static final KeyAdapter INPUT = new KeyAdapter() {
		
		@Override
		public void keyPressed(KeyEvent e) {
			KEYS[e.getKeyCode()] = true;
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			KEYS[e.getKeyCode()] = false;
		}
	};

	public static void tick() {
		
	}
	
	public static boolean isKeyPressed(int key) {
		return KEYS[key];
	}
}
