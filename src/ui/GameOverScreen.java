package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entity.PlayerStatus;
import entity.ConfigurableOption;

public class GameOverScreen extends JPanel {

	public GameOverScreen() {
		super();
		// TODO Auto-generated constructor stub
		setPreferredSize(new Dimension(ConfigurableOption.SCREEN_WIDTH, ConfigurableOption.SCREEN_HEIGHT));
		this.setLayout(new BorderLayout());

		JPanel yn = new JPanel();
		
		yn.setBackground(Color.ORANGE);
		JButton y = new JButton("Yes");
		JButton n = new JButton("No");
		
		y.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GameManager.newGame();
			}
		});
		
		n.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GameManager.goToTitle();
			}
		});
		
		yn.setLayout(new FlowLayout(FlowLayout.CENTER));
		yn.add(y);
		yn.add(n);
		
		this.add(yn,BorderLayout.SOUTH);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setBackground(Color.ORANGE);
		g2.clearRect(0, 0, ConfigurableOption.SCREEN_WIDTH, ConfigurableOption.SCREEN_HEIGHT);
		g2.setFont(new Font("Tahoma",Font.BOLD,80));
		g2.setColor(Color.BLACK);
		
		Rectangle2D rect = g2.getFontMetrics().getStringBounds("GAME OVER", g2);
		g2.drawString("GAME OVER", ConfigurableOption.SCREEN_WIDTH/2-(int)rect.getWidth()/2, ConfigurableOption.SCREEN_HEIGHT/2-50+(int)rect.getHeight()/2-g2.getFontMetrics().getDescent());
		
		g2.setFont(new Font("Tahoma",Font.BOLD,30));
		
		Rectangle2D rect2 = g2.getFontMetrics().getStringBounds("SCORE = "+ PlayerStatus.getScore(), g2);
		g2.drawString("SCORE = "+ PlayerStatus.getScore(), ConfigurableOption.SCREEN_WIDTH/2-(int)rect2.getWidth()/2, ConfigurableOption.SCREEN_HEIGHT/2+(int)rect.getHeight()/2-g2.getFontMetrics().getDescent());
		
		Rectangle2D rect3 = g2.getFontMetrics().getStringBounds("Continue?", g2);
		g2.drawString("Continue?", ConfigurableOption.SCREEN_WIDTH/2-(int)rect3.getWidth()/2, ConfigurableOption.SCREEN_HEIGHT/2+(int)rect.getHeight()+(int)rect3.getHeight()/2-g2.getFontMetrics().getDescent());
		
	}

}
