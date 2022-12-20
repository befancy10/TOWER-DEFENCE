package scenes;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import helper.LoadSave;
import main.Game;
import ui.MyButton;
import static main.GameStates.*;

public class Win extends GameScene implements SceneMethods {

	private MyButton bReplay2, bMenu2;
	private BufferedImage atlas;
	
	public Win(Game game) {
		super(game);
		initButtons();
		loadAtalas();
	}

	private void initButtons() {

		int w = 150;
		int h = w / 3;
		int x = 640 / 2 - w / 2;
		int y = 300;
		int yOffset = 60;

		bMenu2 = new MyButton("Menu", x, y, w, h);
		bReplay2 = new MyButton("Replay", x, y + yOffset, w, h);

	}

	@Override
	public void render(Graphics g) {
		drawcover(g);
		// buttons
		g.setFont(new Font("LucidaSans", Font.BOLD, 20));
		bMenu2.draw(g);
		bReplay2.draw(g);
	}
	public void drawcover(Graphics g)
	{
		g.drawImage(getwinscreen(0, 0),0,0, 640, 800, null);
	}

	private void replayGame() {
		// reset everything
		resetAll();

		// change state to playing
		SetGameState(PLAYING);

	}

	private void resetAll() {
		game.getPlaying().resetEverything();
	}

	@Override
	public void mouseClicked(int x, int y) {
		if (bMenu2.getBounds().contains(x, y)) {
			SetGameState(MENU);
			resetAll();
		} else if (bReplay2.getBounds().contains(x, y))
			replayGame();
	}

	@Override
	public void mouseMoved(int x, int y) {
		bMenu2.setMouseOver(false);
		bReplay2.setMouseOver(false);

		if (bMenu2.getBounds().contains(x, y))
			bMenu2.setMouseOver(true);
		else if (bReplay2.getBounds().contains(x, y))
			bReplay2.setMouseOver(true);
	}

	@Override
	public void mousePressed(int x, int y) {
		if (bMenu2.getBounds().contains(x, y))
			bMenu2.setMousePressed(true);
		else if (bReplay2.getBounds().contains(x, y))
			bReplay2.setMousePressed(true);

	}

	@Override
	public void mouseReleased(int x, int y) {
		bMenu2.resetBooleans();
		bReplay2.resetBooleans();

	}

	@Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub

	}
	
	private BufferedImage getwinscreen(int xCord, int yCord) {
		return atlas.getSubimage(xCord * 0, yCord * 0, 640, 800);
	}
	private void loadAtalas() {
		atlas = LoadSave.getwinscreen();
	}

}