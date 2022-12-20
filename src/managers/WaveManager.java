package managers;

import java.util.ArrayList;
import java.util.Arrays;

import scenes.Playing;
import wave.Wave;

public class WaveManager {

	private Playing playing;
	private ArrayList<Wave> waves = new ArrayList<>();
	private int enemySpawnTickLimit = 60 * 1;
	private int enemySpawnTick = enemySpawnTickLimit;
	private int enemyIndex, waveIndex;
	private int waveTickLimit = 60 * 5;
	private int waveTick = 0;
	private boolean waveStartTimer, waveTickTimerOver;
	
	public static int level = 1;

	public WaveManager(Playing playing) {
		this.playing = playing;
		createWaves();
	}
	
	public void setLevel(int level) {
		this.level = level;
	}

	public void update() {
		if (enemySpawnTick < enemySpawnTickLimit)
			enemySpawnTick++;

		if (waveStartTimer) {
			waveTick++;
			if (waveTick >= waveTickLimit) {
				waveTickTimerOver = true;
			}
		}

	}

	public void increaseWaveIndex() {
		waveIndex++;
		waveTick = 0;
		waveTickTimerOver = false;
		waveStartTimer = false;
	}

	public boolean isWaveTimerOver() {

		return waveTickTimerOver;
	}

	public void startWaveTimer() {
		waveStartTimer = true;
	}

	public int getNextEnemy() {
		enemySpawnTick = 0;
		return waves.get(waveIndex).getEnemyList().get(enemyIndex++);
	}

	private void createWaves() {
		if(level == 1) {
			waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0))));
			waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 0, 1))));
			waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0, 0, 1, 1, 1, 2))));
		}
		else if(level == 2) {
			waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1,0))));
			waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(1, 1, 0, 0, 2, 2))));
			waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 2, 2))));
			waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(2, 2, 2, 1, 1, 3))));
			waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(2, 1, 1, 2, 3, 3, 1, 2))));
			waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3))));
		}
		else if(level == 3) {
			waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 0,0))));
			waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0, 1, 1, 0, 2, 2))));
			waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0, 1, 1, 2, 2, 2))));
			waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 2, 2, 2))));
			waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(1, 2, 2, 2, 2, 2, 2, 3))));
			waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(1, 0, 0, 2, 0, 0, 3, 1, 1, 3, 3))));
			waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(2, 2, 2, 0, 2, 2, 2, 2, 3, 3, 3))));
			waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(2, 2, 2, 0, 0, 0, 1, 1, 1, 3, 3, 3, 3, 3, 4))));
			waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(3, 2, 3, 2, 3, 2, 3, 4, 4))));
		}
			
	}

	public ArrayList<Wave> getWaves() {
		return waves;
	}

	public boolean isTimeForNewEnemy() {
		return enemySpawnTick >= enemySpawnTickLimit;
	}

	public boolean isThereMoreEnemiesInWave() {
		return enemyIndex < waves.get(waveIndex).getEnemyList().size();
	}

	public boolean isThereMoreWaves() {
		return waveIndex + 1 < waves.size();
	}
	
	

	public void resetEnemyIndex() {
		enemyIndex = 0;
	}

	public int getWaveIndex() {
		return waveIndex;
	}

	public float getTimeLeft() {
		float ticksLeft = waveTickLimit - waveTick;
		return ticksLeft / 60.0f;
	}

	public boolean isWaveTimerStarted() {
		return waveStartTimer;
	}

	public void reset() {
		waves.clear();
		createWaves();
		enemyIndex = 0;
		waveIndex = 0;
		waveStartTimer = false;
		waveTickTimerOver = false;
		waveTick = 0;
		enemySpawnTick = enemySpawnTickLimit;
	}

}