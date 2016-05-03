package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import entity.Item;
import entity.RandomUtility;
import render.*;

public class Bomb extends Item{

	protected int radius = 50;
	protected int speed = RandomUtility.random(2, 7);
	protected boolean destroyed = false;

	public Bomb(int x) {
		super(x);
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		try{
			g2d.drawImage(Resource.bombSprite, null, x, y);
		} catch (MyException e){
			g2d.setColor(Color.BLACK);
			g2d.fillOval(x, y, radius, radius);
		}
	}
	
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 1;
	}
}
