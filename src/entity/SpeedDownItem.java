package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import entity.Item;
import entity.RandomUtility;
import render.IRenderable;
import render.Resource;

public class SpeedDownItem extends Item{
	
	protected int radius = 50;
	protected int speed = RandomUtility.random(2, 7);
	protected boolean destroyed = false;
	
	
	public SpeedDownItem(int x) {
		super(x);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		try{
			g2d.drawImage(Resource.speedDownSprite, null, x-8, y-6);
		}catch(MyException e){
			g2d.setColor(Color.GREEN);
			g2d.fillOval(x, y, radius, radius);
		}
	}
}
