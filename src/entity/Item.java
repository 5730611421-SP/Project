package entity;

import java.awt.Graphics2D;

import entity.Player;
import entity.RandomUtility;
import render.IRenderable;

public abstract class Item implements IRenderable{

	protected int x;
	protected int y = -40;
	protected int radius = 40;
	protected int speed = RandomUtility.random(2, 7);
	protected boolean destroyed = false;

	public Item(int x) {
		super();
		this.x = x;
		update();
	}

	protected void update() {
		y += speed;
	}

	public boolean isDestroyed() {
		if (y > 420) {
			destroyed = true;
		}
		return destroyed;
	}

	public boolean collideWith(Player player) {
		if (player.x >= x - radius + 5 && player.x <= x + radius - 5 && y >= 345 && y <= 420) {
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
