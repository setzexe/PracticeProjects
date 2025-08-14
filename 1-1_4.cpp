#include <iostream> // allows for cout / cin
#include <cstdlib> // Allows for algorithmic randomness 

// I usually use using namespace std, but I am told that is bad practice

int main() {
    srand(time(0)); // Generates a seed for rand thats based on the amount of seconds since 1/1/1970, meaning a new seed a second
    int randomNumber = rand() % 100 + 1; // random number, up to 100 but start at 1
    int guess; // input

    while (true) { // A loop to check to make sure our first input is valid. We put the code below in here as This works as our, condition_correct = continue.
        std::cout << "Guess the number: (1-100): "; // Guess number
        if (!(std::cin >> guess)) { // If cin isnt the correct type, so if guess isnt an int
            std::cin.clear(); // clear input in the buffer
            std::cin.ignore(1000, '\n'); // flush the buffer until next line
            std::cout << "Invalid input! Please enter a number." << std::endl; 
            continue; // Goes back to the start of this loop
        } // Go to the if loop if its the correct type, but out of range
        if (guess < 1 || guess > 100) { // out of range check
            std::cout << "Out of range! Please enter between 1 and 100." << std::endl;
            continue; // start of loop
        }
        break; // Valid input, break out of this condition_correct loop
    }

    while (guess != randomNumber) { // While guess isnt the randomNumber. Important to keep the guard condition_correct loop in this loop
        if (guess > randomNumber) { // if guess is more than the number
            std::cout << "Number is less than " << guess << std::endl;
        } else if (guess < randomNumber) { // if less
            std::cout << "Number is greater than " << guess << std::endl;
        } else { // if its a correct guess
            break;
        }
// Goes here since it wasnt correct, meaning it didnt go to the else branch
        while (true) { // condition for the next coming attempts
            std::cout << "Guess again: (1-100): "; // This will go into the If branches if its within constraints. It just goes to break if otherwise
                if (!(std::cin >> guess)) { // if not int
                    std::cin.clear();
                    std::cin.ignore(1000, '\n');
                    std::cout << "Invalid input! Please enter a number." << std::endl;
                    continue;
                }
                if (guess < 1 || guess > 100) {
                    std::cout << "Out of range! Please enter between 1 and 100." << std::endl;
                    continue;
                }
                break; // When it goes here, it goes through the while (guess...) loop to see if it matches. Its a continuous cycle
            }
    
        }
    std::cout << "Correct guess: " << guess; 

    return 0; // return 
}