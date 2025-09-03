package cheatSheet;
import java.util.Scanner;

// Hello

// This cheat sheet will uncover and explain the basics with Java
// You will write this down on your notes too, but this reinforces it better
// As you can tell, // for comments

public class cheatSheet { // Every program must have a class, public (accessible by JVM) and must be the same name as the file

	public static void main(String[] args) { // Public static (does not create an object, but runs) void (no return) main(An array of strings that holds Command line codes. A.K.A I/O.
		System.out.println("Hello. Accessing this code will give you all the essentials for JAVA!"); // System outputs printed text (followed by a new line if println. Just print for normal), in parenthesis is the text.
		Scanner input = new Scanner(System.in); // This is how we handle input. We import java.util.Scanner at line two. We create a scanner type variable named input, who scans a new location at System.in (keyboard, default input)
		boolean run = true; // Boolean type. True/False. Other variable types are initialized similarly.
		
		while (run) { // We can not just put true, so we must activate a boolean to do this. But for the most part. It is very similar to C++. This is a menu
			System.out.println("Please select an option: ");
			System.out.println("1: Hello World");
			System.out.println("2: Arithmetics example");
			System.out.println("3: Exit");
			
			String choiceString = input.next(); // Input reads next, up until the first space (String)
			int choice; 
			try { // Do this. Catch and do that if this does not work
				choice = Integer.parseInt(choiceString); // parses choiceString into an integer
			} catch (NumberFormatException e) { // Wrong variable format
				System.out.println("Invalid input. Please enter a number.");
			    continue; // Back to start. 
			}
			
			
			switch(choice) { // Switch case
				case 1: 
					helloWorld();
					break; // Break gets out of loop / menu
				case 2:
					cheatSheetSolver();
					break;
				case 3:
					run = false; // We turn run false so while (run) becomes false, ending our program
					System.out.println("Bye");
					break;
				default:
					System.out.println("Invalid choice! Please enter 1-3. ");
					continue;
			}
			
			if (run) { // If run is still true
				System.out.println("Continue? Insert 'n' to exit. Any other input to continue.");
				char loopAgain = input.next().charAt(0); // reads user input up to string, and just returns the first character
				if (loopAgain == 'n' || loopAgain == 'N') { // Not sure any better ways to authenticate caps.... yet
					run = false;
					System.out.println("Bye");
				}
				
			}
					
		}
	
		input.close(); // Notice input was initialized with new. This can cause memory leaks similar to C++ heap memory. It is recommended to close the scanner.
	}
	
	public static void cheatSheetSolver() { 
		System.out.println("View the inside of the code to view arithimics.");
		System.out.println("Our demonstration: X = 5, Y = 13.");
		int x = 5, y = 13; // You can initialize multiple variables granted they are the same type.
		System.out.println("Arithmetic:");
        System.out.println("x + y = " + (x + y)); // Addition
        System.out.println("x - y = " + (x - y)); // Subtraction
        System.out.println("x * y = " + (x * y)); // Multiplication
        System.out.println("x / y = " + (x / y)); // Division
        System.out.println("(double)x / y = " + ((double)x / y)); // Float division. Although if either is already a double, that works too
        System.out.println("x % y = " + (x % y)); // Modulo

        System.out.println("\nComparison:"); // New line
        System.out.println("x > y: " + (x > y)); // >= and <= exists too
        System.out.println("x == y: " + (x == y)); // != exists too

        System.out.println("\nLogical:");
        boolean a = true, b = false;
        System.out.println("a && b: " + (a && b)); // AND
        System.out.println("a || b: " + (a || b)); // OR
        System.out.println("!a: " + (!a)); // NOT

		
		
	}
	
	public static void helloWorld() { // Note this does not need String[] args. As long as main has it, it unlocks a door that allows I/O for other functions.
		System.out.println("Hello, World!");
	}
}


	
	
	
	
	
	


