package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Lava extends GameObject {

	public Lava(float x, float y) {
		super(x, y);
	}

	public Lava(float x, float y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void tick() {
		Handler.gameObjects.forEach(object -> {
			if (object instanceof Player) {
				Player player = (Player) object;
				if (player.getBounds().intersects(getBounds())) {
					player.getHurt();
				}
			}
		});
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.setColor(Color.RED);
		g2d.drawRect((int) x, (int) y, width, height);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, width, height);
	}
}