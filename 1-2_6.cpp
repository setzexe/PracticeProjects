#include <iostream> // cin , cout
#include <string> // strings
#include <vector> // vector
#include <cctype> // toupper, more on that later

int main() {
    using std::cout; // Instead of using namespace std or a lack of it like the previous projects
    using std::cin; // We can put this in replacement of it for each code that requires std::
    using std::string;
    using std::vector;
    using std::endl;
    using std::toupper;

    // ASCII Stages. First is empty, last is GAME OVER
    const std::vector<string> hangmanStages = {
        "   \n   \n   \n", // You do not have to just \n or seperate lines, but it makes it much easier
        "   O\n   \n   \n",
        "   O\n   |\n   \n",
        "   O\n  /|\n   \n",
        "   O\n  /|\\\n   \n",
        "   O\n  /|\\\n  / \n",
        "   O\n  /|\\\n  / \\\n"
    };

    const int maxWrong = static_cast<int>(hangmanStages.size()) - 1; // Allows for 6 wrong guesses. hangmanStages (a size_t, since size() returns that) becomes an int.
    // 7 - 1 because 7 guesses would access a non existent 8th element

    // Our word. You can edit this, it is hard coded for this project
    string wordOriginal = "Programming";

    // because we are using toupper later for consistency, we make the match word have all uppercase letters
    string word = wordOriginal; // word that the code will match via the code
    for (char &ch : word) { // Every character in word becomes uppercase via ch
        ch = static_cast<char>(toupper(static_cast<unsigned char>(ch))); // toupper turns every character into an uppercase
    }

    string displayWord(word.size(), '_');  // displays a line ('_' that spans across word.size() size, so 10);

    vector<char> guessedLetters; // Where we can store guessed letters
    int wrongGuesses = 0; // wrong guess count. Initialize here

    while (wrongGuesses < maxWrong && displayWord != word) { // While wrongGuesses hasnt gotten to maxWrong (lose) && the word has not been solved
        bool alreadyGuessed = false; // already guessed letter. Up here so it resets every turn
        bool correct = false; // Indicates if the inputted letter is correct. Resets every turn
        char guess; // inputted guess

        cout << hangmanStages[wrongGuesses] << endl;; // Display ASCII stage thats represented 0-6 by an array. This increases respective to a wrong guess
        cout << "Word: " << displayWord << endl;; // Progress bar
        cout << "Wrong guesses left: " << (maxWrong - wrongGuesses) << endl;; // 6 - whatever wrong guesses

        cout << "Guessed letters: "; 
        for (char c : guessedLetters) { // for every character in guessed letters
            cout << c << ' '; // display the characters
        }
        cout << endl;;

        cout << "Enter a letter: "; 
        if (!(cin >> guess)) { // If theres no way of getting input
            return 0; // exit
        }
        if (!std::isalpha(static_cast<unsigned char>(guess))) { // Turns guess into an unsigned_char. isalpha checks to see if the guess is alphabetic, or in range 0-255.
            // if signed, the range is different from this. If it wasnt either, the compiler would automatically set it to signed.
            cout << "Please enter a letter." << endl; 
            continue; // Try again
        }
        guess = static_cast<char>(toupper(static_cast<unsigned char>(guess))); // Turns the correct data of guess (explained above, the first inner loop) into a toupper,
        // which is an int. The leftmost static_cast turns that int back into a char

        for (char c : guessedLetters) { // Looks if we have any guessed letters
            if (c == guess) { // If any element of guessedLetters (c) == guess
                alreadyGuessed = true; // use this below
                break;  // go to if loop below
            }
        }
        if (alreadyGuessed) { // If above loop went to here
            cout << "You already guessed that letter! Try again." << endl;
            continue; // try again
        }
        guessedLetters.push_back(guess); // saves that guess

        for (size_t i = 0; i < word.size(); ++i) { // size_t, since size() returns size_t. Ideally start doing ++i instead of i++ for loops
            if (word[i] == guess) {  // if any char in word == guess
                displayWord[i] = word[i]; // the respective display space shows
                correct = true; // for the loop below
            }
        }

        if (!correct) { // wrong guess
            ++wrongGuesses; // Increment wrongGuess, vector moves to next element (next hangman line)
            cout << "Wrong guess!" << endl;
        } else {
            cout << "Good guess!" << endl;
        }
    } // while loop ends

    cout << hangmanStages[wrongGuesses] << endl; // Final hangman stage, the GAME OVER
    if (displayWord == word) { // if you won
        cout << "Congratulations! You guessed the word: " << wordOriginal << endl;
    } else { // if you lost
        cout << "Game Over! The word was: " << wordOriginal << endl;
    }
    return 0; // program done
}
