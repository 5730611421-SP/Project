package entity;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import entity.Item;
import entity.Player;
import entity.PlayerStatus;
import entity.RandomUtility;
import input.InputUtility;
import render.RenderableHolder;
import render.Resource;

public class GameLogic {

	private static GameLogic instance = new GameLogic();

	protected Player player = new Player();
	protected PlayerStatus playerStatus = new PlayerStatus();
	protected ArrayList<Item> items = new ArrayList<Item>();

	private static final int SPAWN_DELAY = 50;
	private int spawnDelayCounter = 0;
	
	private boolean readyToRender = false;

	public GameLogic() {
		super();
		// TODO Auto-generated constructor stub
		RenderableHolder.getInstance().add(player);
		RenderableHolder.getInstance().add(playerStatus);
		for (Item item : items) {
			RenderableHolder.getInstance().add(item);
		}
	}

	public static GameLogic getInstance() {
		return instance;
	}

	public void logicUpdate() {
		if (InputUtility.getKeyPressed(KeyEvent.VK_ENTER)) {
			if (playerStatus.isPause())
				playerStatus.setPause(false);
			else
				playerStatus.setPause(true);
		}

		if (playerStatus.isPause()) {
			return;
		}
		
		player.update();

		for (int i = 0; i < items.size();i++) {
			Item item = items.get(i);
			if(item instanceof Bomb){
				if (item.collideWith(player)) {
					item.destroyed = true;
//					Resource.bombSound.play();
					RenderableHolder.getInstance().getRenderableList().remove(item);
					items.remove(item);
//					if(!player.isBarrier){
//						//die;
//						ConfigurableOption.gameWindow.switchScene(ConfigurableOption.gameOver);
//					} 
				} else if (!item.isDestroyed()) {
					item.update();
				} else if (item.isDestroyed()) {
					playerStatus.addScore(1);
					RenderableHolder.getInstance().getRenderableList().remove(item);
					items.remove(item);
				}
			}
			
			
		}

		spawnDelayCounter++;
		if (spawnDelayCounter == SPAWN_DELAY) {
			spawnDelayCounter = 0;
			int ran = (int)(Math.random()*10);
			for(int i=0;i<ran;i++){
				Bomb a1 = new Bomb(RandomUtility.random(0, 600));
				items.add(a1);
				RenderableHolder.getInstance().add(a1);
			}
		}

	}
	
	public synchronized void onStart() {
		playerStatus = new PlayerStatus();
		readyToRender = true;
	}
	
	public synchronized void onExit() {
		readyToRender = false;
	}

}
