package scenes;

import java.awt.image.BufferedImage;

import helper.Constants;
import helper.Constants.Enemies;
import main.Game;
import managers.WaveManager;
import scenes.Difficulty;

public class GameScene{

	protected Game game;
	protected Difficulty difficulty;
	protected Enemies enemies;
	protected int animationIndex;
	protected int ANIMATION_SPEED = 25;
	protected int tick;
	protected boolean gamePlayed;

	public GameScene(Game game) {
		this.game = game;
		difficulty = new Difficulty();
		enemies = new Enemies();
		
	}

	public Game getGame() {
		return game;
	}

	protected boolean isAnimation(int spriteID) {
		return game.getTileManager().isSpriteAnimation(spriteID);
	}
	
	public boolean isGampePlayed() {
		return gamePlayed;
	}

	protected void updateTick() {
		tick++;
		if (tick >= ANIMATION_SPEED) {
			tick = 0;
			animationIndex++;
			if (animationIndex >= 4)
				animationIndex = 0;
		}
	}

	
	protected BufferedImage getSprite(int spriteID) {
		return game.getTileManager().getSprite(spriteID);
	}

	protected BufferedImage getSprite(int spriteID, int animationIndex) {
		return game.getTileManager().getAniSprite(spriteID, animationIndex);
	}

}
