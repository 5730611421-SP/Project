package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import render.IRenderable;
import render.Resource;

public class PlayerStatus implements IRenderable {
	
	private static int score = 0;
	private boolean pause = false;

	public static int getScore() {
		return score;
	}
	
	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public PlayerStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void addScore(int score){
		PlayerStatus.score += score;
	}
	
	public void subtractionScore(int score){
		PlayerStatus.score -= score;
		if(PlayerStatus.score<0) PlayerStatus.score = 0;
	}
	
	public static void resetScore() {
		score = 0;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setBackground(Color.BLACK);
		g2d.clearRect(0, 420, 640, 60);
		g2d.setColor(Color.WHITE);
		g2d.setFont(Resource.standardFont);
		g2d.drawString("SCORE: "+score, 10, 460);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
