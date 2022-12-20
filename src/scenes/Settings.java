package scenes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import main.Game;
import objects.PathPoint;
import ui.MyButton;
import helper.LoadSave;
import static main.GameStates.*;


public class Settings extends Playing implements SceneMethods {

	private MyButton bMenu, bEasy, bMedium, bHard;
	private BufferedImage atlas;
	private String difficultiesText;
	private boolean mouseover;

	public Settings(Game game) {
		super(game);
		loadAtalas();
		initButtons();
		
	}

	private void initButtons() {
		
		int w = 150;
		int h = w / 3;
		int x = 640 / 2 - w / 2;
		int y = 250;
		int yOffset = 60;
		
		bEasy = new MyButton("Easy", x, y + yOffset, w, h, 97);
		bMedium = new MyButton("Medium", x, y + yOffset * 2, w, h, 98);
		bHard = new MyButton("Hard", x, y + yOffset * 3, w, h, 99);
		bMenu = new MyButton("Menu", x, y+yOffset*4+100,w, h,100);
	
	}

	@Override
	public void render(Graphics g) {
		
		drawcover(g);
		drawButtons(g);
	//	drawChooseDifficulty(g);
		
	//	drawDifficultyText(g);
		
	}
	
	private void drawcover(Graphics g)
	{
		g.drawImage(getsettingscreen(0, 0), 0, 0, 640, 800, null);
	}

	private void drawButtons(Graphics g) {
		bMenu.draw(g);
		
		g.setFont(new Font("LucidaSans", Font.BOLD, 20));
		bEasy.draw(g);
		bMedium.draw(g);
		bHard.draw(g);
	}
	
	/*private void drawChooseDifficulty(Graphics g) {
		g.setColor(Color.RED);
		g.setFont(new Font("LucidaSans", Font.BOLD, 33));
		g.drawString("CHOOSE THE DIFFICULTY", 110, 150);
	}*/
	
	public boolean checkCurrentDifficulty(int diffINT, int currentDiffINT) {
		if (diffINT == currentDiffINT) {
			return true;
		}
		else return false;
	}

	
	
	@Override
	public void mouseClicked(int x, int y) {
		if (bMenu.getBounds().contains(x, y))
			SetGameState(MENU);
		else if (bEasy.getBounds().contains(x, y)) {
			int choose = JOptionPane.showConfirmDialog(null,
					"Do you really want to change the difficulty of the game?\n                  (the game will be restarted)",
					"Confirm", JOptionPane.YES_NO_OPTION,
					 JOptionPane.INFORMATION_MESSAGE);
					 if (choose == JOptionPane.YES_OPTION) 
					 {
						 difficulty.setObjectDifficulty(1, "Easy");
						 enemies.setLevel(1);
						 waveManager.setLevel(1);
//							lvl = LoadSave.GetLevelData("Hard");
						 setCondition("Easy");
						 loadDefaultLevel();
						 //game.getPlaying().resetEverything();
						 replayGame();
						 System.out.println("Diff Changed Easy");
					 } 
					 else 
					 {
						 
					 }
				
				
			}
		
		else if (bMedium.getBounds().contains(x, y)) {
			int choose = JOptionPane.showConfirmDialog(null,
					"Do you really want to change the difficulty of the game?\n                  (the game will be restarted)",
					"Confirm", JOptionPane.YES_NO_OPTION,
					 JOptionPane.INFORMATION_MESSAGE);
					 if (choose == JOptionPane.YES_OPTION) 
					 {
						 difficulty.setObjectDifficulty(2, "Medium");
						 enemies.setLevel(2);
						 waveManager.setLevel(2);
//							lvl = LoadSave.GetLevelData("Hard");
						 setCondition("Medium");
						 loadDefaultLevel();
						 replayGame();
						 System.out.println("Diff Changed Medium");
					 } 
					 else 
					 {
						 
					 }
				
				
			
		}
		else if (bHard.getBounds().contains(x, y)) {
			int choose = JOptionPane.showConfirmDialog(null,
					"Do you really want to change the difficulty of the game?\n                  (the game will be restarted)",
					"Confirm", JOptionPane.YES_NO_OPTION,
					 JOptionPane.INFORMATION_MESSAGE);
					 if (choose == JOptionPane.YES_OPTION) 
					 {
						 difficulty.setObjectDifficulty(3, "Hard");
						 enemies.setLevel(3);
						 waveManager.setLevel(3);
//							lvl = LoadSave.GetLevelData("Hard");
						 setCondition("Hard");
						 loadDefaultLevel();
						 //game.getPlaying().resetEverything();
						 replayGame();
						 System.out.println("Diff Changed Hard");
					 } 
					 else 
					 {
						 
					 }
				
		}

	
	}

	@Override
	public void mouseMoved(int x, int y) {
		bMenu.setMouseOver(false);
		bEasy.setMouseOver(false);
		bMedium.setMouseOver(false);
		bHard.setMouseOver(false);
		
		if (bMenu.getBounds().contains(x, y))
			bMenu.setMouseOver(true);
		else if (bEasy.getBounds().contains(x, y))
			bEasy.setMouseOver(true);
		else if (bMedium.getBounds().contains(x, y))
			bMedium.setMouseOver(true);
		else if (bHard.getBounds().contains(x, y))
			bHard.setMouseOver(true);

	}

	@Override
	public void mousePressed(int x, int y) {
		if (bMenu.getBounds().contains(x, y))
			bMenu.setMousePressed(true);
		else if (bEasy.getBounds().contains(x, y))
			bEasy.setMousePressed(true);
		else if (bMedium.getBounds().contains(x, y))
			bMedium.setMousePressed(true);
		else if (bHard.getBounds().contains(x, y))
			bHard.setMousePressed(true);
	}

	@Override
	public void mouseReleased(int x, int y) {
		resetButtons();
	}

	private void resetButtons() {
		bMenu.resetBooleans();
		bEasy.resetBooleans();
		bMedium.resetBooleans();
		bHard.resetBooleans();

	}

	@Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
	private BufferedImage getsettingscreen(int xCord, int yCord) {
		return atlas.getSubimage(xCord * 0, yCord * 0, 640, 800);
	}
	private void loadAtalas() {
		atlas = LoadSave.getsettingscreen();
	}


}
