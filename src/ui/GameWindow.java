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

//	private static GameScreen gameScreen = new GameScreen();
//	private static GameTitle gameTitle = new GameTitle();
//	private static GameOverScreen gameOver  = new GameOverScreen();
	private JPanel currentScene;
	private GameLogic logic = GameLogic.getInstance();
	private boolean switching;
	
//	public GameWindow() throws HeadlessException {
//		super();
//		// TODO Auto-generated constructor stub
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setLayout(new CardLayout());
//		this.setResizable(false);
//		
//		this.add("Title",gameTitle);
//		this.add("GameScreen", gameScreen);
//		this.add("GameOver", gameOver);
//		
//
//		
//		this.pack();
//		this.setVisible(true);
//	}
	
	public GameWindow(JPanel scene) throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new CardLayout());
		this.setResizable(false);
		this.currentScene = scene;
		this.add(currentScene);
		this.pack();
		this.setVisible(true);
		
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
		this.getContentPane().remove(currentScene);
		this.currentScene = scene;
		this.getContentPane().add(currentScene);
		this.getContentPane().validate();
		pack();
		currentScene.requestFocus();	
	}

	public JPanel getCurrentScene() {
		return currentScene;
	}
	
}
