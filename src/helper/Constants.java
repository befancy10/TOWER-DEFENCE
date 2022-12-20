package helper;

import java.lang.System.Logger.Level;

import scenes.Difficulty;
import scenes.GameScene;

public class Constants {

	public static class Projectiles {
		public static final int ARROW = 0;
		public static final int ICEBALL = 3;
		public static final int BOMB = 1;
		public static final int FIREBALL = 2;

		public static float GetSpeed(int type) {
			switch (type) {
			case ARROW:
				return 8f;
			case BOMB:
				return 4f;
			case ICEBALL:
				return 6f;
			case FIREBALL:
				return 6f;
			}
			return 0f;
		}
	}

	public static class Towers {
		public static final int CANNON = 1;
		public static final int ARCHER = 0;
		public static final int FIREFIZARD = 2;
		public static final int ICEWIZ = 3;

		public static int GetTowerCost(int towerType) {
			switch (towerType) {
			case CANNON:
				return 65;
			case ARCHER:
				return 35;
			case FIREFIZARD:
				return 50;
			case ICEWIZ:
				return 50;
			}
			return 0;
		}

		public static String GetName(int towerType) {
			switch (towerType) {
			case CANNON:
				return "Snorlax";
			case ARCHER:
				return "Mimikyu";
			case FIREFIZARD:
				return "Moltres";
			case ICEWIZ:
				return "Lugia";
			}
			return "";
		}

		public static int GetStartDmg(int towerType) {
			switch (towerType) {
			case CANNON:
				return 17;
			case ARCHER:
				return 13;
			case FIREFIZARD:
				return 3;
			case ICEWIZ:
				return 3;
			}

			return 0;
		}

		public static float GetDefaultRange(int towerType) {
			switch (towerType) {
			case CANNON:
				return 75;
			case ARCHER:
				return 120;
			case FIREFIZARD:
				return 100;
			case ICEWIZ:
				return 100;
			}

			return 0;
		}

		public static float GetDefaultCooldown(int towerType) {
			switch (towerType) {
			case CANNON:
				return 120;
			case ARCHER:
				return 35;
			case FIREFIZARD:
				return 50;
			case ICEWIZ:
				return 50;
			}

			return 0;
		}
	}

	public static class Direction {
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;
	}

	public static class Enemies {

		public static int level = 1;
		
		public static final int BATBAT = 0;
		public static final int JELLYFISH = 1;
		public static final int GHOST = 2;
		public static final int GENGAR = 3;
		public static final int BOSS = 4;
		
		public Enemies() {
			
		}
		
		public void setLevel(int level) {
			this.level = level;
		}

		public static int GetReward(int enemyType) {
			switch (enemyType) {
			case BATBAT:
				return 5;
			case JELLYFISH:
				return 10;
			case GHOST:
				return 15;
			case GENGAR:
				return 25;
			case BOSS:
				return 30;
			}
			return 0;
		}

		public static float GetSpeed(int enemyType) {
			if (level == 1) {
				switch (enemyType) {
				case BATBAT:
					return 0.5f;
				case JELLYFISH:
					return 0.7f;
				case GHOST:
					return 0.45f;
				case GENGAR:
					return 0.85f;
				case BOSS:
					return 1f;
				}
			}
			else if (level == 2) {
				switch (enemyType) {
				case BATBAT:
					return 0.60f;
				case JELLYFISH:
					return 0.80f;
				case GHOST:
					return 0.55f;
				case GENGAR:
					return 0.95f;
				case BOSS:
					return 1.1f;
				}
			}
			else if (level == 3) {
				switch (enemyType) {
				case BATBAT:
					return 0.70f;
				case JELLYFISH:
					return 0.9f;
				case GHOST:
					return 0.65f;
				case GENGAR:
					return 1.05f;
				case BOSS:
					return 1.2f;
				}
			}
			return 0;
		}

		public static int GetStartHealth(int enemyType) {
			if (level == 1) {
				switch (enemyType) {
				case BATBAT:
					return 85;
				case JELLYFISH:
					return 100;
				case GHOST:
					return 125;
				case GENGAR:
					return 400;
				case BOSS:
					return 700;
				}
			}
			else if (level == 2) {
				switch (enemyType) {
				case BATBAT:
					return 110;
				case JELLYFISH:
					return 125;
				case GHOST:
					return 150;
				case GENGAR:
					return 425;
				case BOSS:
					return 725;
				}
			}
			else if (level == 3) {
				switch (enemyType) {
				case BATBAT:
					return 135;
				case JELLYFISH:
					return 150;
				case GHOST:
					return 175;
				case GENGAR:
					return 450;
				case BOSS:
					return 750;
				}
			}
			return 0;
		}
	}

	public static class Tiles {
		public static final int WATER_TILE = 0;
		public static final int GRASS_TILE = 1;
		public static final int ROAD_TILE = 2;
	}

}