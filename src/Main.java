import entity.GameLogic;
import ui.GameManager;

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
