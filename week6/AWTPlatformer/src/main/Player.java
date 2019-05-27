package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

public class Player extends GameObject {

	public static final Color PLAYER_COLOR = new Color(31, 58, 147);
	private static final float GRAVITY = 0.02f;
	private static final float JUMP_POWER = 1.5f;
	private static final int HITBOX_MARGIN = 3;
	private static final int TERMINAL_VELOCITY = 10;

	private boolean isAirborne = true;
	private boolean isVisible = true;

	public Player(float x, float y) {
		super(x, y);
		width = 11;
		height = 25;
	}

	@Override
	public void tick() {
		if (Keyboard.isKeyPressed(KeyEvent.VK_SPACE) && !isAirborne) {
			yVel -= JUMP_POWER;
			isAirborne = true;
		}
		if (Keyboard.isKeyPressed(KeyEvent.VK_A)) {
			x--;
		}
		if (Keyboard.isKeyPressed(KeyEvent.VK_D)) {
			x++;
		}
		y += yVel;
		yVel += GRAVITY;
		if (yVel > TERMINAL_VELOCITY) {
			yVel = TERMINAL_VELOCITY;
		}
		isAirborne = true;
		Handler.gameObjects.stream().filter(object -> object instanceof SolidBlock).forEach(object -> {
			SolidBlock block = (SolidBlock) object;
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
				isAirborne = false;
			}
			if (blockBounds.intersects(getTopBounds())) {
				y = block.y + block.height;
				yVel *= -0.5f;
			}
		});
		Handler.gameObjects.stream().filter(object -> object instanceof Trampoline).forEach(object -> {
			Trampoline trampoline = (Trampoline) object;
			Rectangle trampolineBounds = trampoline.getBounds();
			if (trampolineBounds.intersects(getBounds()) && isAirborne) {
				yVel *= -0.3;
				yVel -= Trampoline.Y_VEL_MODIFIER;
			}
		});
	}

	@Override
	public void render(Graphics2D g2d) {
		if (isVisible) {
			g2d.setColor(PLAYER_COLOR);
			g2d.fillRect((int) x, (int) y, width, height);
			g2d.setColor(Color.GREEN);
			g2d.fill(getTopBounds());
			g2d.fill(getBottomBounds());
			g2d.fill(getLeftBounds());
			g2d.fill(getRightBounds());
			g2d.drawImage(AssetLoader.PLAYER_IDLE,(int)x, (int)y, width, height, null);
		}
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

	public void getHurt() {
		new Thread(() -> {
			int invulnerabilityTime = 0;
			while (invulnerabilityTime < 3000) {
				isVisible = !isVisible;
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}
				invulnerabilityTime += 200;
			}
			isVisible = true;
		}).start();
	}
}