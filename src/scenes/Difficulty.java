package scenes;

public class Difficulty {
	
	public static int difficultyINT;
	public static String difficultyString;
	
	public Difficulty() {
		super();
		this.difficultyINT = 1;
		this.difficultyString = "Easy";
	}
	
	public void setObjectDifficulty(int DifficultyINT, String DifficultyString) {
		setDifficultyINT(DifficultyINT);
		setDifficultyString(DifficultyString);
	}

	public static int getDifficultyINT() {
		return difficultyINT;
	}

	public void setDifficultyINT(int difficultyINT) {
		this.difficultyINT = difficultyINT;
	}

	public String getDifficultyString() {
		return difficultyString;
	}

	public void setDifficultyString(String difficultyString) {
		this.difficultyString = difficultyString;
	}

	@Override
	public String toString() {
		return difficultyString + "\n";
	}
	
	
}
