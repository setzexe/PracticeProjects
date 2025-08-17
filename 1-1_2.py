# First Python Assignment. This will be a simple calculator based on the seven operators.
# This and above is a single-line comment. C++ does //

"""
This will utilize essentials like comments, operators, prints, variables, etc
This text is contained in a multi line comment. # is honestly easier
    For readibility sake, four spaces for indenting. Will elaborate more with branches below
"""

num1 = float(input("Enter first number: ")) # Declaring a variable based on user input. num1 = The float version of whats inputted.
# The innermost parenthesis is what is shown to the user. Single quotes work too, and you can make that say anything else
num2 = float(input("Enter second number: "))

print("\nChoose an operation: ") # Print is the pyton equivalent to cout. \n still applies, no endl I believe. Single quotes work
print("1. Addition (+)") 
print("2. Subtraction (-)") 
print("3. Multiplication (*)") 
print("4. Division (/)") # always returns a float. Use // for integers
print("5. Division, Integer Result (//)") # Known as floor division. This returns an integer. 10 / 3 would be 3 and not 3.33333
print("6. Modulo (%)") 
print("7. Exponent (**)") 

choice = int(input("Enter Choice (1-7): ")) # User choice

if choice == 1: # No brackets. Same principle as C++. Addition
    result = num1 + num2 # No use of ;. No type declaration, result (and if you did result = 13) would automatically become an int
    print(f"{num1} + {num2} = {result}") # This allows us to print stuff with variables. Without the f, we cant do {variable}. Note the 4 spaces here
    # This in C++ would be cout << num1 << " + " << num2 << " = " << result;
elif choice == 2: # elif is pythons else if. Subtraction
    result = num1 - num2 
    print(f"{num1} - {num2} = {result}")
elif choice == 3: # Multiplication
    result = num1 * num2 
    print(f"{num1} * {num2} = {result}")
elif choice == 4: # Division, will always be float
    result = num1 / num2 
    print(f"{num1} / {num2} = {result}")
elif choice == 5: # Floor division, will return an int
    result = num1 // num2 
    print(f"{num1} // {num2} = {result}")
elif choice == 6: # Modulo
    result = num1 % num2 
    print(f"{num1} % {num2} = {result}")
elif choice == 7: # Exponent
    result = num1 ** num2 
    print(f"{num1} ** {num2} = {result}")
else: # default
    print("Invalid choice. Please enter a number 1-7.")
    
# Exits after first use, but for now that is ok
# Note this is not compiled or whatever. You can just run it directly here with that play button in the top right corner.
    