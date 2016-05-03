package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.imageio.ImageReader;

import entity.Item;
import entity.RandomUtility;
import render.IRenderable;
import render.Resource;

public class Barrier extends Item {

	protected int radius = 50;
	protected int speed = RandomUtility.random(2, 7);
	protected boolean destroyed = false;

	public Barrier(int x) {
		super(x);
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		try {
			g2d.drawImage(Resource.barrierSprite, null, x, y);
		} catch (MyException e) {
			g2d.setColor(Color.YELLOW);
			g2d.fillOval(x, y, radius, radius);
		}
	}
}
