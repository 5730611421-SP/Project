package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import entity.Item;
import entity.RandomUtility;
import render.Resource;

public class BombDevastator extends Item {

	protected int radius = 50;
	protected int speed = RandomUtility.random(2, 7);
	protected boolean destroyed = false;

	public BombDevastator(int x) {
		super(x);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		try {
			g2d.drawImage(Resource.devastatorSprite, null, x - 8, y - 6);
		} catch (MyException e) {
			g2d.setColor(Color.ORANGE);
			g2d.fillOval(x, y, radius, radius);
		}
	}
}
