package ui;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.HeadlessException;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import entity.ConfigurableOption;
import entity.GameLogic;

public class GameWindow extends JFrame {

	private JPanel currentScene;
	
	
	public GameWindow(JPanel scene) throws HeadlessException {
		super("BOMB EVADER!");
		// TODO Auto-generated constructor stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		this.currentScene = scene;
		getContentPane().add(currentScene);
		pack();
		setVisible(true);
		currentScene.requestFocus();
	}

	public void switchScene(JPanel scene){
		getContentPane().remove(currentScene);
		this.currentScene = scene;
		getContentPane().add(currentScene);
		getContentPane().validate();
		pack();
		currentScene.requestFocus();
	}

	public JPanel getCurrentScene() {
		return currentScene;
	}
	
}
