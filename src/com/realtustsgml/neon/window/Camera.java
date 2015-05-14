package com.realtustsgml.neon.window;

import com.realtustsgml.neon.framework.GameObject;

public class Camera {

	private float x, y;

	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public void tick(GameObject player) {
		 //camera推進式
			/*x = x - 2;
		  	y = -player.getY() + Game.HEIGHT /2;*/
		  	
		x = -player.getX() + Game.WIDTH / 2;
		y = -player.getY() + Game.HEIGHT / 2;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
}
