/**
 * @author Sorachach Panomchaisawang (5730611421) 
 * @version 3 Apr 2015
 * Lab5 part2 (2/2014) in 2110215 Prog Meth
 */
package ui;

import javax.swing.JPanel;

import entity.GameLogic;
import entity.PlayerStatus;


public class GameManager {
	
	private static GameTitle titleScene;
	private static GameScreen gameScreen;
	private static GameWindow gameWindow;
	private static GameOverScreen gameOver;
	private static JPanel nextScene = null;
	private static GameLogic gameLogic;
	
	public static void runGame(GameLogic game){
		titleScene = new GameTitle();	
		gameWindow = new GameWindow(titleScene);
		gameLogic = game;
		while(true){
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			gameWindow.getCurrentScene().repaint();
			if(gameWindow.getCurrentScene() instanceof GameScreen){
				gameLogic.logicUpdate();
			}
			if(nextScene != null){
				if(gameWindow.getCurrentScene() instanceof GameScreen)
					gameLogic.onExit();
				gameWindow.switchScene(nextScene);
				if(nextScene instanceof GameScreen)
					gameLogic.onStart();
			}
		}
	}
	
	public static void goToTitle(){
		nextScene = titleScene;
	}
	
	public static void newGame(){
		PlayerStatus.resetScore();
		gameScreen = new GameScreen();
		gameLogic = new GameLogic();
		nextScene = gameScreen;
	}
	
	public static void GameOver(){
		gameOver = new GameOverScreen();
		nextScene = gameOver;
	}
	
}
