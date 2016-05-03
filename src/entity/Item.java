package entity;

import java.awt.Graphics2D;

import entity.Player;
import entity.RandomUtility;
import render.IRenderable;

public abstract class Item implements IRenderable {

	protected int radius = 40;
	protected int x;
	protected int y = -radius;
	protected int speed = RandomUtility.random(2, 7);
	protected boolean destroyed = false;
	protected int speedUp = 0;
	protected int speedDown = 0;

	public Item(int x) {
		super();
		this.x = x;
		update();
	}

	protected void update() {
		y += speed +speedUp +speedDown;
	}

	public int getSpeedUp() {
		return speedUp;
	}

	public int getSpeedDown() {
		return speedDown;
	}

	public void setSpeedUp(int speedUp) {
		this.speedUp = speedUp;
	}

	public void setSpeedDown(int speedDown) {
		this.speedDown = speedDown;
	}

	public boolean isDestroyed() {
		if (y > 420) {
			destroyed = true;
		}
		return destroyed;
	}

	public boolean collideWith(Player player) {
		if (player.x + player.explodedRadius >= x -5 && player.x - player.explodedRadius <= x+5
				&& y+5 >= 420 - player.explodedRadius && y <= 420) {
			return true;
		} else
			return false;
	}

	@Override
	public abstract void draw(Graphics2D g2d);

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		if (isDestroyed())
			return false;
		return true;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 1;
	}
	
}
