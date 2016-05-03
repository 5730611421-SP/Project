/**
 * @author Sorachach Panomchaisawang (5730611421) 
 * @version 3 Apr 2015
 * Lab5 part2 (2/2014) in 2110215 Prog Meth
 */
package ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import entity.GameLogic;
import input.InputUtility;


public class GameManager {
	
	private static GameTitle titleScene;
	private static GameScreen gameScreen;
	private static GameWindow gameWindow;
	private static GameOverScreen gameOver;
	private static JPanel nextScene = null;
	
	public static void runGame(GameLogic gameLogic){
		titleScene = new GameTitle();	
		gameWindow = new GameWindow(titleScene);
		
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
		gameScreen = new GameScreen();
		nextScene = gameScreen;
	}
	
	public static void GameOver(){
		gameOver = new GameOverScreen();
		nextScene = gameOver;
	}
	
}
