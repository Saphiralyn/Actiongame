package com.realtustsgml.neon.window;

import java.awt.Graphics;
import java.util.LinkedList;

import com.realtustsgml.neon.framework.GameObject;
import com.realtustsgml.neon.framework.ObjectId;
import com.realtutsgml.neon.objects.Block;

public class Handler {
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	private GameObject tempObject;

	public void tick() {
		for (int i = 0; i < object.size(); i++) {
			tempObject = object.get(i);
			tempObject.tick(object);
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			tempObject = object.get(i);
			tempObject.render(g);
		}
	}

	public void addObject(GameObject object) {
		this.object.add(object);
	}

	public void removeObject(GameObject object) {
		this.object.remove(object);
	}

	public void createLevel() {
		for (int xx = 0; xx < Game.WIDTH*2; xx = xx + 32)
			addObject(new Block(xx, Game.HEIGHT - 32, 0,ObjectId.Block));

	
		
		for (int xx = 400,yy=400; xx < Game.HEIGHT-32; xx += 32) 
			addObject(new Block(xx,yy,0,ObjectId.Block));
		
		
		
	}
}