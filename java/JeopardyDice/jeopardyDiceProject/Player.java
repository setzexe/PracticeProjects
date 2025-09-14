package jeopardyDiceProject; // We keep these in the same package so they link to one another. Modular development 

public class Player { // A class that can be used by any file in the package, called Player
	private int score; // private int for score. We do not want main() to change this so only our public functions can 
	
	public Player() { // Constructor, default
		score = 0;
	}
	
	public int getScore() { // How we access score, since score is private
		return score;
	}
	
	public void addScore(int points) { // How we add points to score. Points is a parameter passed by a point value from main()
		score += points;
	}
	
}
