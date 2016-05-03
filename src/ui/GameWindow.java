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
//	private GameLogic logic = GameLogic.getInstance();
//	private boolean switching;
	
	
	public GameWindow(JPanel scene) throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		this.currentScene = scene;
		getContentPane().add(currentScene);
		pack();
		setVisible(true);
		currentScene.requestFocus();
		
//		if(currentScene==ConfigurableOption.gameScreen){
////			System.out.println("ouch!");
//			while(true){
//				try {
//					Thread.sleep(20);
//				} catch (InterruptedException e) {
//				}
//				currentScene.repaint();
//				logic.logicUpdate();
//				
//			}
//		}
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
