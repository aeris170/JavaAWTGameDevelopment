package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Block extends GameObject {

	public Block(float x, float y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.setColor(Color.BLACK);
		g2d.drawRect((int)x, (int)y, width, height);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, width, height);
	}
}