package entity;

import java.awt.Graphics2D;

import entity.Item;
import entity.RandomUtility;
import render.IRenderable;

public class SpeedDownItem extends Item{
	
	protected int radius = 40;
	protected int speed = RandomUtility.random(2, 7);
	protected boolean destroyed = false;
	
	
	public SpeedDownItem(int x) {
		super(x);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
	}
}
