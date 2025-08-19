import random # Python has a built in library with tons of useful modules. We use import to import these. 
# Random here helps choose random characters from a list.

characters = list("abcdefghijklmnopqrstuvwxtyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890") # Characters becomes a list type through list(). Every individual character, from a-0, becomes a part of the list
password_list = [] # password list is an empty list for now

while True: # Creates a loop that allows us to keep code going until something, correct input, stops it
    try: # Tries a set of code. Does the code after it if it succeeds / Nothing causes it to crash. If an error pops up, it does whatever is in the 
        length = int(input("Enter ideal password length (4-20): ")) # converts input into an integer, granted its a number between 4-20
        if length < 4 or length > 20: # if outside the range of 4-20
            print("Length must be between 4 and 20. Try again.") 
            continue  # go back to start of loop

        break # The while True loop will never exit until it reaches this break.

    except ValueError:
        print("Input must be a number. Try again.") # Does this if an error (Specifically a value error, maybe inputting a letter instead of a number) occurs. Resets the loop


for i in range(length): # for index goes through a range thats represented by whatever length is:
    password_list.append(random.choice(characters)) # Each index apppends (adds) a random selection from our characters list
    
password = "".join(password_list) # Password becomes a string that is just all the items in the password_list joined together. The "" in front means Nothing in between each variable, no spaces

print(f"Your randomized password: {password}") # Password is outputted




