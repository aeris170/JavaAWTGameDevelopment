package main;

public class Camera {

	private float x = 0;
	private float y = 0;
	private float zoom = 1;

	private GameObject objectToFollow;

	public Camera(GameObject objectToFollow) {
		this.objectToFollow = objectToFollow;
	}

	public void tick() {
		if (objectToFollow != null) {
			x += (objectToFollow.x - x - Window.WINDOW_WIDTH / 2f) * 0.03f;
			y += (objectToFollow.y - y - Window.WINDOW_HEIGHT / 2f) * 0.03f;
		}
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZoom() {
		return zoom;
	}

	public void setZoom(float zoom) {
		this.zoom = zoom;
	}

	public GameObject getObjectToFollow() {
		return objectToFollow;
	}

	public void setObjectToFollow(GameObject objectToFollow) {
		this.objectToFollow = objectToFollow;
	}
}
