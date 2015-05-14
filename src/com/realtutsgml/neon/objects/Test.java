package com.realtutsgml.neon.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.realtustsgml.neon.framework.GameObject;
import com.realtustsgml.neon.framework.ObjectId;

public class Test extends GameObject {

	public Test(float x, float y, ObjectId id) {
		super(x, y, id);

	}

	public void tick(LinkedList<GameObject> object) {

	}

	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect((int) x, (int) y, 32, 32);
	}

	public Rectangle getBounds() {
 		return null;
	}
}
