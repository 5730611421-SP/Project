package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import entity.ConfigurableOption;

public class GameTitle extends JPanel {

	public GameTitle() {
		super();
		// TODO Auto-generated constructor stub
		this.setOpaque(true);
        this.setPreferredSize(new Dimension(ConfigurableOption.SCREEN_WIDTH, ConfigurableOption.SCREEN_HEIGHT));
        this.setLayout(new BorderLayout());
		
		JPanel center = new JPanel();
		center.setLayout(new GridBagLayout());
		center.setOpaque(true);
		center.setBackground(Color.ORANGE);
		
		JButton start = new JButton("BOMB EVADER START!");
		start.setSize(150, 50);
		start.setBackground(Color.ORANGE);
		start.setForeground(Color.BLACK);
		start.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));

		
		Font fontStart = new Font("Chiller", Font.BOLD, 50);
		start.setFont(fontStart);

		start.setBounds(ConfigurableOption.SCREEN_WIDTH/2-50, ConfigurableOption.SCREEN_HEIGHT/2-50, 100, 100);
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GameManager.newGame();
			}
		});
		
		center.add(start);
		this.add(center, BorderLayout.CENTER);

	}

//	@Override
//	public void paintComponent(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paint(g);
//		Graphics2D g2 = (Graphics2D) g;
//		
//		g2.setBackground(Color.ORANGE);
//		g2.setFont(new Font("Tahoma",Font.BOLD,30));
//	}

	
}
