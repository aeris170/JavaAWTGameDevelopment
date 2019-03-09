package main;

import java.awt.Graphics2D;

public abstract class GameObject {
	
	protected float x = 0;
	protected float y = 0;
	protected int width = 0;
	protected int height = 0;
	
	public GameObject(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public GameObject(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public abstract void tick();
	
	public abstract void render(Graphics2D g2d);
}
