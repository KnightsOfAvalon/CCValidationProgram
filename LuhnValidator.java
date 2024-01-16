/**
 * This class performs a Luhn check on the number provided to the constructor. The number
 * provided must be in the form of a String. This class holds a boolean variable that reports
 * whether the provided number passed (true) or failed (false) the Luhn check. This class also
 * provides a method that returns that boolean variable.
 * Class: Fall - COSC 1437.81301
 * Assignment: Final Project
 * Date: 12/5/2023
 * @author Avalon Matthew
 * @version 0.0.0
 */
public class LuhnValidator
{
    private boolean luhnCheckPassed; // Will hold whether the input number passes the Luhn check

    /**
     * Constructor for LuhnValidator class. Initializes luhnCheckPassed by calling luhnTest
     * method with the constructor parameter (inputNumber) as the argument.
     * @param Possible CC number as String
     * @return None
     * @throws Nothing is implemented
     */
    public LuhnValidator(String inputNumber)
    {
        // Call luhnTest with provided inputNumber as argument. Set luhnCheckPassed equal to
        // the return value of luhnTest
        luhnCheckPassed = luhnTest(inputNumber);
    }

    /**
    * Performs Luhn check on the provided testNumber. If the testNumber passes the Luhn check,
    * this method returns true. If the testNumber fails the Luhn check, this method returns
    * false.
    * @param The number to be tested as String
    * @return Whether the provided testNumber passes the Luhn check as boolean
    * @throws Nothing is implemented
    */
    private boolean luhnTest(String testNumber)
    {
        // Convert last index of testNumber to an int
        // Set actualCheckDigit equal to that int
        int actualCheckDigit = Integer.parseInt(testNumber.substring(testNumber.length() - 1));
        
        // Create a String that includes all except the last index of testNumber
        // Set remainingDigits equal to the created String
        String remainingDigits = testNumber.substring(0, testNumber.length() - 1);
        
        String remainingDigitsRev = ""; // Will hold a reversed copy of remainingDigits
        
        // Iterate backwards through remainingDigits
        for (int i = remainingDigits.length() - 1; i >= 0; i--)
        {
            // Add the character at each index of remainingDigits to remainingDigitsRev
            // (Since iteration is backwards, characters will be added to remainingDigitsRev
            // in reverse order)
            remainingDigitsRev += remainingDigits.charAt(i);
        }
        
        // Add all the digits from remainingDigitsRev
        int accumulator = 0; // Initialize a running total
        
        // Iterate through remainingDigitsRev
        for (int i = 0; i < remainingDigitsRev.length(); i++)
        {
            // Convert the character at the current index to a String
            // Convert that String to an int
            // Set charAsInt equal to that int
            int charAsInt = Integer.parseInt(Character.toString(remainingDigitsRev.charAt(i)));
            
            // If the current index is even (indicating an odd position due to zero-indexing)
            if (i % 2 == 0)
            {
                // Multiply charAsInt by 2 and set charTimesTwo equal to the product
                int charTimesTwo = Math.multiplyExact(charAsInt, 2);
                
                // If charTimesTwo is greater than 9
                if (charTimesTwo > 9)
                {
                    // Set charTimesTwo equal to itself, minus 9
                    charTimesTwo = charTimesTwo - 9;
                }
                
                accumulator += charTimesTwo; // Add charTimesTwo to the running total
            }
            // If the current index is odd (indicating an even position due to zero-indexing)
            else
            {
                accumulator += charAsInt; // Add charAsInt to the running total
            }
        }
        
        // Determine what the check digit SHOULD be based on the value of the accumulator
        // Set calculatedCheckDigit equal to the result of the calculation
        int calculatedCheckDigit = 10 - (accumulator % 10);
        
        // If the calculatedCheckDigit is equal to the last digit in the number being tested
        if (calculatedCheckDigit == actualCheckDigit)
            return true; // Return true
        // If the calculatedCheckDigit is not equal to the last digit in the number being
        // tested
        else
            return false; // Return false
    }
    
    /**
    * Getter for luhnCheckPassed
    * @param None
    * @return Whether the inputNumber passed the Luhn check as boolean
    * @throws Nothing is implemented
    */
    public boolean getLuhnCheckPassed()
    {
        return luhnCheckPassed;
    }
}
