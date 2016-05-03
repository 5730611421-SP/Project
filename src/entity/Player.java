package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import input.InputUtility;
import render.IRenderable;

public class Player implements IRenderable {

	protected int radius = 40;
	protected int x;
	protected int y = 420 - radius;
	protected boolean barrier = false;
	protected boolean reduce = false;
	protected int shoot=0;
	
	public boolean isReduce() {
		return reduce;
	}

	public void setReduce(boolean reduce) {
		this.reduce = reduce;
	}

	protected int explodedRadius = radius;

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void update() {
		if (InputUtility.getKeyPressed(KeyEvent.VK_LEFT)) {
			x -= 5;
			if (x <= 0)
				x = 0;
		} else if (InputUtility.getKeyPressed(KeyEvent.VK_RIGHT)) {
			x += 5;
			if (x >= 640 - radius)
				x = 640 - radius;
		} else if (InputUtility.getMouseX() >= 0 && InputUtility.getMouseX() <= ConfigurableOption.SCREEN_WIDTH-radius) {
			x = InputUtility.getMouseX();
		}
		if (barrier){
			explodedRadius = radius+radius/2;
		} else 
			explodedRadius = radius;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setColor(Color.BLUE);
		g2d.fillRect(x, y, radius, radius);
		if(isBarrier())
			g2d.drawRect(x+radius/2-explodedRadius/2, y+radius/2-explodedRadius/2, explodedRadius, explodedRadius);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isBarrier() {
		return barrier;
	}

	public void setBarrier(boolean barrier) {
		this.barrier = barrier;
	}

	
}
