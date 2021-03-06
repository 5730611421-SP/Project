package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JPanel;

import entity.Player;
import entity.PlayerStatus;
import entity.ConfigurableOption;
import entity.GameLogic;
import input.InputUtility;
import render.IRenderable;
import render.RenderableHolder;
import render.Resource;

public class GameScreen extends JPanel {
	
	public GameScreen() {
		super();
		// TODO Auto-generated constructor stub
		setPreferredSize(new Dimension(ConfigurableOption.SCREEN_WIDTH,ConfigurableOption.SCREEN_HEIGHT));
		setVisible(true);
		requestFocus();
		
		addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				InputUtility.setKeyPressed(e.getKeyCode(), false);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				InputUtility.setKeyPressed(e.getKeyCode(), true);
				InputUtility.setKeyTriggered(e.getKeyCode(), true);
			}
		});
		
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				InputUtility.setMouseX(e.getX());
				InputUtility.setMouseY(e.getY());
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				InputUtility.setMouseX(e.getX());
				InputUtility.setMouseY(e.getY());
			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setBackground(Color.WHITE);
		g2d.clearRect(0, 0, ConfigurableOption.SCREEN_WIDTH, ConfigurableOption.SCREEN_HEIGHT);
		
		for(IRenderable entity : RenderableHolder.getInstance().getRenderableList()){
			if(entity.isVisible() && !entity.isDestroyed()){
				entity.draw(g2d);
			}
		}
		
//		if (PlayerStatus.isPause()) {
//			g2d.setFont(Resource.standardFont);
//			FontMetrics metrics = g2d.getFontMetrics(Resource.standardFont);
//			Rectangle2D rectPause = metrics.getStringBounds("PAUSE", g2d);
//			int pauseHeight = (int) rectPause.getHeight();
//			int xMid = (int)((ConfigurableOption.SCREEN_WIDTH - rectPause.getWidth()) / 2);
//			int yMid = (int)((ConfigurableOption.SCREEN_HEIGHT - pauseHeight) / 2 + pauseHeight
//					- metrics.getDescent());
//			g2d.drawString("PAUSE", xMid, yMid);
//		}
	}
}
