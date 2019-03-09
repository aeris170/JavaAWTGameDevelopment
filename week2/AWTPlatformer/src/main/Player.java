package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player extends GameObject {

	public static final Color PLAYER_COLOR = new Color(31, 58, 147);
	public Player(float x, float y) {
		super(x, y);
		width = 20;
		height = 120;
	}

	@Override
	public void tick() {
		x += 0.45f;
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.setColor(PLAYER_COLOR);
		g2d.fillRect((int) x, (int) y, width, height);
	}
}