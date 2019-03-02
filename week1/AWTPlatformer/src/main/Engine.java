package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Engine extends Canvas implements Runnable {

	private Thread gameThread;

	public Engine() {
		gameThread = new Thread(this);
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
		double nanoseconds = 1000000000.0 / 1;
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
		}
	}

	private void tick() {
		// tick object
	}

	private void render() {
		if (getBufferStrategy() == null) {
			createBufferStrategy(3);
		}
		BufferStrategy bs = getBufferStrategy();
		Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, 10000, 10000);
		g2d.setColor(Color.RED);
		g2d.fillRect(100, 100, 50, 50);
		bs.show();
		g2d.dispose();
	}
}