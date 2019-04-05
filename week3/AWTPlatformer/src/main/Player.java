package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Player extends GameObject {

	public static final Color PLAYER_COLOR = new Color(31, 58, 147);
	private static final float GRAVITY = 0.02f;
	private static final float JUMP_POWER = 0.2f;

	private boolean lastTickJump = false;

	public Player(float x, float y) {
		super(x, y);
		width = 10;
		height = 10;
	}

	@Override
	public void tick() {
		if (Keyboard.isKeyPressed(KeyEvent.VK_SPACE)) {
			yVel -= JUMP_POWER;
		}
		if (Keyboard.isKeyPressed(KeyEvent.VK_A)) {
			x--;
		}
		if (Keyboard.isKeyPressed(KeyEvent.VK_D)) {
			x++;
		}
		y += yVel;
		yVel += GRAVITY;
		if(y > 400 - height) {
			y = 400 - height;
			yVel = 0;
		}
		
		
		
		
		
		
		
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.setColor(PLAYER_COLOR);
		g2d.fillRect((int) x, (int) y, width, height);
	}
}