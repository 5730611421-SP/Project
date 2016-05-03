package entity;

import ui.GameOverScreen;
import ui.GameScreen;
import ui.GameTitle;
import ui.GameWindow;

public class ConfigurableOption {

	public static final int SCREEN_WIDTH = 640;
	public static final int SCREEN_HEIGHT = 480;

	public static GameScreen gameScreen = new GameScreen();
	public static GameTitle gameTitle = new GameTitle();
	public static GameOverScreen gameOver  = new GameOverScreen();
	public static GameWindow gameWindow = new GameWindow(gameTitle);
}
