package com.realtutsgml.neon.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.realtustsgml.neon.framework.GameObject;
import com.realtustsgml.neon.framework.ObjectId;
import com.realtustsgml.neon.framework.Texture;
import com.realtustsgml.neon.window.Game;
import com.realtustsgml.neon.window.Handler;

public class Player extends GameObject {
	private float width = 64, height = 64;
	private float gravity = 0.5f;
	private boolean falling = true;
	private final float MAX_SPEED = 10;

	private Handler handler;
	Texture tex = Game.getInstance();

	public Player(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick(LinkedList<GameObject> object) {
		x += velX;
		y += velY;

		if (falling || jumping) {
			velY += gravity;

			if (velY > MAX_SPEED)
				velY = MAX_SPEED;
		}
		Collision(object);
	}

	private void Collision(LinkedList<GameObject> object) {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ObjectId.Block) {
				/* top判定 */
				if (getBoundsTop().intersects(tempObject.getBounds())) {
					velY = 0;
					y = tempObject.getY() + 33;

				}
				/* bottom判定 */
				if (getBounds().intersects(tempObject.getBounds())) {
					y = tempObject.getY() - height;
					velY = 0;
					falling = false;
					jumping = false;
				} else
					falling = true;
				/* right */
				if (getBoundsRight().intersects(tempObject.getBounds())) {
					x = tempObject.getX() - width;
				}
				if (getBoundsLeft().intersects(tempObject.getBounds())) {
					x = tempObject.getX() + width-32;
				}

			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.drawImage(tex.player[0], (int) x - 32, (int) y - 48, 128, 128, null);
		/*
		 * g.fillRect((int) x, (int) y, (int) width, (int)
		 * height));　　　藍色の長方形キャラ！
		 */

		Graphics g2d = (Graphics2D) g;
		g.setColor(Color.red);

		((Graphics2D) g2d).draw(getBounds());
		((Graphics2D) g2d).draw(getBoundsRight());
		((Graphics2D) g2d).draw(getBoundsLeft());
		((Graphics2D) g2d).draw(getBoundsTop());
	}

	public Rectangle getBounds() {
		return new Rectangle((int) ((int) x + (width / 2) - ((width / 2) / 2)),
				(int) ((int) y + (height / 2)), (int) width / 2,
				(int) height / 2);
	}

	public Rectangle getBoundsTop() {
		return new Rectangle((int) ((int) x + (width / 2) - ((width / 2) / 2)),
				(int) y, (int) width / 2, (int) height / 2);
	}

	// 右のあたり判定
	public Rectangle getBoundsRight() {
		return new Rectangle((int) ((int) x + width -5), (int) y + 5, (int) 5,
				(int) height - 10);
		
	}

	// 左のあたり判定
	public Rectangle getBoundsLeft() {
		return new Rectangle((int) (int) x, (int) y + 5, (int) 5,
				(int) height - 10);
		
	}
}
