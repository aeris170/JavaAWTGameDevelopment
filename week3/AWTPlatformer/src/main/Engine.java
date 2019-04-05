package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;

public class Engine extends Canvas implements Runnable {

	public static final int TICK_RATE = 240;
	
	private Thread gameThread;
	private Rectangle clearRect;
	private Window w;

	public Engine(Window w) {
		gameThread = new Thread(this);
		this.w = w;
	}

	public void start() {
		gameThread.start();
	}

	public void stop() {
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			gameThread.interrupt();
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		long timer = System.currentTimeMillis();
		int ticks = 0;
		int frames = 0;
		long lastTime = System.nanoTime();
		long thisTime;
		double nanoseconds = 1000000000.0 / TICK_RATE;
		double deltaTime = 0;
		while (true) {
			thisTime = System.nanoTime();
			deltaTime += (thisTime - lastTime) / nanoseconds;
			lastTime = thisTime;
			while (deltaTime >= 1) {
				tick();
				deltaTime--;
				ticks++;
			}
			render();
			w.requestFocus();
		}
	}

	private void tick() {
		Keyboard.tick();
		Handler.tick();
	}

	private void render() {
		if (getBufferStrategy() == null) {
			createBufferStrategy(3);
		}
		BufferStrategy bs = getBufferStrategy();
		Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();
		g2d.setColor(Color.WHITE);
		g2d.fill(clearRect);
		
		Handler.render(g2d);
		
		bs.show();
		g2d.dispose();
	}

	public void setClearRect(int width, int height) {
		clearRect = new Rectangle(width, height);
	}
}