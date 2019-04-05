package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;

public class Player extends GameObject {

	public static final Color PLAYER_COLOR = new Color(31, 58, 147);
	private static final float GRAVITY = 0.02f;
	private static final float JUMP_POWER = 0.2f;
	private static final int HITBOX_MARGIN = 3;

	private boolean lastTickJump = false;

	private Rectangle line = new Rectangle(0, 0, 1, 1);

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
		if(yVel < -1) {
			yVel = -1;
		}
		if(yVel > 1) {
			yVel = 1;
		}
		Handler.gameObjects.stream().filter(object -> object instanceof Block).forEach(object -> {
			Block block = (Block) object;
			Rectangle blockBounds = block.getBounds();
			if (blockBounds.intersects(getLeftBounds())) {
				x++;
				return;
			}
			if (blockBounds.intersects(getRightBounds())) {
				x--;
				return;
			}
			if (blockBounds.intersects(getBottomBounds())) {
				y = block.y - height;
				yVel = 0;
			}
		});
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.setColor(PLAYER_COLOR);
		g2d.fillRect((int) x, (int) y, width, height);
		g2d.setColor(Color.GREEN);
		g2d.fill(getTopBounds());
		g2d.fill(getBottomBounds());
		g2d.fill(getLeftBounds());
		g2d.fill(getRightBounds());
		g2d.setColor(Color.RED);
		g2d.fill(line);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, width, height);
	}

	public Rectangle getTopBounds() {
		return new Rectangle((int) x + HITBOX_MARGIN, (int) y, width - 2 * HITBOX_MARGIN, HITBOX_MARGIN);
	}

	public Rectangle getBottomBounds() {
		return new Rectangle((int) x + HITBOX_MARGIN, (int) y + height - HITBOX_MARGIN, width - 2 * HITBOX_MARGIN,
				HITBOX_MARGIN);
	}

	public Rectangle getLeftBounds() {
		return new Rectangle((int) x, (int) y + HITBOX_MARGIN, HITBOX_MARGIN, height - 2 * HITBOX_MARGIN);
	}

	public Rectangle getRightBounds() {
		return new Rectangle((int) x + width - HITBOX_MARGIN, (int) y + HITBOX_MARGIN, HITBOX_MARGIN,
				height - 2 * HITBOX_MARGIN);
	}
}