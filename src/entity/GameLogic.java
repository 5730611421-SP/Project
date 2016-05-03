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
import ui.GameManager;

public class GameLogic {

	protected Player player = new Player();
	protected PlayerStatus playerStatus = new PlayerStatus();
	protected ArrayList<Item> items = new ArrayList<Item>();

	private static final int SPAWN_DELAY = 50;
	private int spawnDelayCounter = 0;

	private static int ITEM_SPAWN_DELAY = 3*SPAWN_DELAY;
	private int itemSpawnDelayCounter = 0;

	protected boolean speedUp = false;
	protected boolean speedDown = false;

	public GameLogic() {
		super();
		// TODO Auto-generated constructor stub
		RenderableHolder.getInstance().removeAll();
		RenderableHolder.getInstance().add(player);
		RenderableHolder.getInstance().add(playerStatus);
		for (Item item : items) {
			RenderableHolder.getInstance().add(item);
		}
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
		int ran = RandomUtility.random(5, 11);

		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			if (item instanceof Bomb) {
				if (item.collideWith(player)) {
					Resource.bombSound.play();
					item.destroyed = true;
					RenderableHolder.getInstance().getRenderableList().remove(item);
					items.remove(item);
					if (!player.isBarrier()) {
						// die;
						GameManager.GameOver();
					}
				} else if (!item.isDestroyed()) {
					item.update();
				} else if (item.isDestroyed()) {
					playerStatus.addScore(1);
					RenderableHolder.getInstance().getRenderableList().remove(item);
					items.remove(item);
				}
			}
			if (item instanceof Barrier) {
				if (item.collideWith(player)) {
					item.destroyed = true;
					Resource.coinSound.play();
					RenderableHolder.getInstance().getRenderableList().remove(item);
					items.remove(item);
					if (!player.isBarrier()) {
						player.setBarrier(true);
						itemSpawnDelayCounter = 0;
					}
				} else if (!item.isDestroyed()) {
					item.update();
				} else if (item.isDestroyed()) {
					RenderableHolder.getInstance().getRenderableList().remove(item);
					items.remove(item);
				}
			}
			if (item instanceof BombDevastator) {
				if (item.collideWith(player)) {
					item.destroyed = true;
					Resource.coinSound.play();
					RenderableHolder.getInstance().getRenderableList().remove(item);
					items.remove(item);
					if (!player.isBarrier()) {
						player.setBarrier(true);
					}
				} else if (!item.isDestroyed()) {
					item.update();
				} else if (item.isDestroyed()) {
					RenderableHolder.getInstance().getRenderableList().remove(item);
					items.remove(item);
				}
			}
			if (item instanceof BombReducer) {
				if (item.collideWith(player)) {
					item.destroyed = true;
					Resource.coinSound.play();
					RenderableHolder.getInstance().getRenderableList().remove(item);
					items.remove(item);
					if (!player.isReduce()) {
						RandomUtility.random(5, 11);
						player.setReduce(true);
					}
				} else if (!item.isDestroyed()) {
					item.update();
				} else if (item.isDestroyed()) {
					RenderableHolder.getInstance().getRenderableList().remove(item);
					items.remove(item);
				}
			}
			if (item instanceof SpeedUpItem) {
				if (item.collideWith(player)) {
					item.destroyed = true;
					Resource.coinSound.play();
					RenderableHolder.getInstance().getRenderableList().remove(item);
					items.remove(item);
					speedUp = true;
				} else if (!item.isDestroyed()) {
					item.update();
				} else if (item.isDestroyed()) {
					RenderableHolder.getInstance().getRenderableList().remove(item);
					items.remove(item);
				}
			}
			if (item instanceof SpeedDownItem) {
				if (item.collideWith(player)) {
					item.destroyed = true;
					Resource.coinSound.play();
					RenderableHolder.getInstance().getRenderableList().remove(item);
					items.remove(item);
					speedDown = true;
				} else if (!item.isDestroyed()) {
					item.update();
				} else if (item.isDestroyed()) {
					RenderableHolder.getInstance().getRenderableList().remove(item);
					items.remove(item);
				}
			}

		}

		spawnDelayCounter++;
		itemSpawnDelayCounter++;
		if (spawnDelayCounter == SPAWN_DELAY) {
			spawnDelayCounter = 0;
			for (int i = 0; i < ran; i++) {
				Bomb a1 = new Bomb(RandomUtility.random(0, 600));
				if (speedUp)
					a1.setSpeedUp(3);
				else if (speedDown)
					a1.setSpeedDown(3);
				else {
					a1.setSpeedDown(0);
					a1.setSpeedUp(0);
				}
				items.add(a1);
				RenderableHolder.getInstance().add(a1);
			}
		}
		if (itemSpawnDelayCounter == 5*SPAWN_DELAY) {
			player.setBarrier(false);
			player.setReduce(false);
			speedUp = false;
			speedDown = false;
		}
		if (itemSpawnDelayCounter == ITEM_SPAWN_DELAY) {
			itemSpawnDelayCounter = 0;
			ITEM_SPAWN_DELAY = RandomUtility.random(5, 10)*SPAWN_DELAY;
			int i = RandomUtility.random(0, 4);
//			int i =0;
			if (i == 0) {
				Barrier b1 = new Barrier(RandomUtility.random(0, 600));
				items.add(b1);
				RenderableHolder.getInstance().add(b1);
			} else if (i == 1) {
				BombDevastator b2 = new BombDevastator(RandomUtility.random(0, 600));
				items.add(b2);
				RenderableHolder.getInstance().add(b2);
			} else if (i == 2) {
				BombReducer b3 = new BombReducer(RandomUtility.random(0, 600));
				items.add(b3);
				RenderableHolder.getInstance().add(b3);
			} else if (i == 3) {
				SpeedDownItem b4 = new SpeedDownItem(RandomUtility.random(0, 600));
				items.add(b4);
				RenderableHolder.getInstance().add(b4);
			} else {
				SpeedUpItem b5 = new SpeedUpItem(RandomUtility.random(0, 600));
				items.add(b5);
				RenderableHolder.getInstance().add(b5);
			}
		}

	}

	public synchronized void onStart() {
		playerStatus = new PlayerStatus();
	}

	public synchronized void onExit() {
		
	}

}
