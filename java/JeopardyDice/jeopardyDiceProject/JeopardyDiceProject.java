package jeopardyDiceProject;
import java.util.Scanner; // for scanner (input)
import java.util.Random; // This is how we utilize psuedo-randomness. Psuedo because it's generated from a seed (which is technically algorithmic)

public class JeopardyDiceProject { 
	public static void main(String[] args) { 
		Scanner input = new Scanner(System.in);
		
		System.out.print("How many points are required to win? "); 
		int winningPoints  = input.nextInt(); // How many points to win
				
		System.out.print("Enter a value to use to 'seed' the random number (negative number will seed currect Unix Epoch time):  ");
		System.out.println(); // These are mostly for formatting for the executable whenever you see this
		int seed  = input.nextInt(); // seed. If negative, it will do Unix Epoch Time. Which is how many seconds it has been since 1/1/1970
		Random rand; // Creates a variable of type Random. rand will allow the chosing of a random number based on a seed
		if (seed < 0) {
			rand = new Random(); // Unix Epoch if seed < 0
		} else {
			rand = new Random(seed); // Custom seed
		}
		
		Player user = new Player(); // new object from Player class. This is us
		Player computer = new Player(); // The computer. Same object type 
		
		while (user.getScore() < winningPoints && computer.getScore() < winningPoints) { // While either user's or computer's score (use function to retrieve
			int pointsEarned = 0; // This purely exists in this loop. We send this as a parameter to addScore()
			boolean loop = true; // This is our version of while (True) like in python
			
			System.out.print("Your turn ");
			System.out.println();
			int randPick = rand.nextInt(6) + 1; // rand chooses from 1-6 from its seed
			System.out.println();
			
			while (loop) { // Until something breaks loop, which is true
				System.out.println("You rolled: " + randPick); // Rand displays number
				if (randPick == 1) { // If 1, turn is over and no points are scored
					pointsEarned = 0;
					System.out.println("1 rolled! No points!");
					System.out.println("Your total score is: " + user.getScore());
					break; // We exit this while loop
				} else { // 2-6 rolled
					pointsEarned += randPick; // Current points rolled has randPick added to it
					System.out.println("Your turn score is " + randPick + " and your total score is " + user.getScore()); // Call getScore()
					System.out.println("If you hold, you will have " + (pointsEarned + user.getScore()) + " points.");
					System.out.print("Enter 'r' to roll again, any other letter to stop: "); 
					char playChoice = input.next().charAt(0); // player choice
					if (playChoice == 'r') {
						randPick = rand.nextInt(6) + 1; // process continues, randomizes randPick again before continuing
						continue;
						} else {
						user.addScore(pointsEarned); // Total points are sent as a parameter to addScore
						System.out.println("Your score is " + user.getScore());
						pointsEarned = 0;
						break; 
					}
				}
			}
			
			if (user.getScore() >= winningPoints) { // If user has more than points needed to win (it does not automatically do it since score is based on the Player class
				break; // break this loop, go to win condition below
			}
			
			System.out.println();
			System.out.println("It is the computer's turn. "); // computers turn
			randPick = rand.nextInt(6) + 1;
			
			while (loop) { // This one does the same except computer does not stop rolling unless he gets a 1 or accumulates 20 points in a turn. It technically could win in 4 goes
				System.out.println("The computer rolled: " + randPick);
				if (randPick == 1) {
					pointsEarned = 0;
					System.out.println("1 rolled! No points!");
					System.out.println("Computer's total score is: " + computer.getScore());
					break;
				} else {
					pointsEarned += randPick;
					if (pointsEarned >= 20) { // Break out of this loop when the points earned this turn is 20 or more
						computer.addScore(pointsEarned);
						System.out.println("Computer's total score is: " + computer.getScore());
						break;
					} else {
						randPick = rand.nextInt(6) + 1;
						continue;
					}
				}
			}
			System.out.println();
		}
		
		// We only exit the full loop above if either player's points meet the winning criteria
		
		System.out.println();
		if (user.getScore() >= winningPoints) { // If user's score is more than our points needed to win
			System.out.print("YOU WIN!"); // user wins
		} else { // If not
			System.out.println("THE COMPUTER WINS!"); // computer wins
		}
		
		input.close();
	}

}
