import javax.swing.JComponent;
import javax.swing.JFrame;

import input.InputUtility;
import entity.ConfigurableOption;
import entity.GameLogic;
import render.*;
import ui.GameManager;
import ui.GameScreen;
import ui.GameWindow;

public class Main {

	public Main() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameLogic logic = new GameLogic();
		GameManager.runGame(logic);
	}

}
