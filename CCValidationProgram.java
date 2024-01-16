/**
 * This program successfully (1) reads numbers from an input file, (2) evaluates each number to
 * see if it represents a possible credit card number, (3) validates each credit card number to
 * see if it is a valid number, (4) stores the valid numbers and invalid numbers in separate
 * arrays, (5) writes the contents of the validated credit card number array into 
 * "valid_cards.txt", and (6) writes the invalid credit card number array to 
 * "invalid_numbers.txt". The user must provide the input and output file names as command line
 * arguments in the following order: (1) input file name, (2) valid cards output file name, 
 * (3) invalid numbers file name.
 * Class: Fall - COSC 1437.81301
 * Assignment: Final Project
 * Date: 12/5/2023
 * @author Avalon Matthew
 * @version 0.0.0
 */
public class CCValidationProgram
{
    /**
    * @param String as args
    * @return Termination code as int, 0 for normal, anything else is error condition
    * @throws Nothing is implemented
    */
    public static void main(String[] args)
    {
        /*
         * Notes for providing command line arguments (to meet assignment requirements):
         * - inputFileName MUST be "numbers_to_test.txt"
         * - validCardsFileName MUST be "valid_cards.txt"
         * - invalidNumbersFileName MUST be "invalid_numbers.txt"
         */
        
        /* Validate command line args */
        if (args.length != 3) // If there are not exactly 3 command line args provided
        {
            // Print series of messages explaining the problem and how the user can fix it
            System.out.println(
                "This program requires 3 command line arguments in the following order:");
            System.out.println(
                "(1) input file name, (2) valid cards output file name, (3) invalid # " +
                "file name");
            System.out.println("\nRequired command line arguments: ");
            System.out.println("numbers_to_test.txt valid_cards.txt invalid_numbers.txt");
            System.out.println(
                "\nPlease try again and provide the correct command line arguments.");
                
            System.exit(0); // Exit the program
        }
        // If there are 3 command line args provided, but the args are incorrect
        else if (args.length == 3 && (!args[0].equals("numbers_to_test.txt")
                    || !args[1].equals("valid_cards.txt") 
                    || !args[2].equals("invalid_numbers.txt")))
        {
            // Print series of messages explaining the problem and how the user can fix it
            System.out.println(
                "The correct number of command line arguments have been provided,");
            System.out.println("but the argument list is invalid.");
            System.out.println("For this version of the program, the argument list must " +
                                "be the following:\n");
            
            System.out.println("numbers_to_test.txt valid_cards.txt invalid_numbers.txt");
            
            System.out.println(
                "\nPlease try again and provide the correct command line arguments.");
            
            System.exit(0); // Exit the program
        }
        /* Finished validating command line args */
        
        // Will hold ArrayList of valid credit cards as CreditCard objects
        java.util.ArrayList<CreditCard> validCreditCards = new java.util.ArrayList<>();
        
        // Will hold ArrayList of invalid numbers as Strings
        java.util.ArrayList<String> invalidNumbers = new java.util.ArrayList<>();
        
        String inputFileName = args[0]; // Set inputFileName equal to 1st cmd line arg
        String validCardsFileName = args[1]; // Set validCardsFileName equal to 2nd cmd line arg
        String invalidNumbersFileName = args[2]; // Set invalidNumbersFileName equal to 3rd cmd line arg
        
        // Initialize Scanner for user input
        java.util.Scanner scnr = new java.util.Scanner(System.in);
        
        char userResponse; // Will hold the 1st character of user input
        
        // Print welcome message and prompt for user input
        System.out.println("Welcome to the Credit Card Validation Program!");
        System.out.print(
            "Would you like to start the Credit Card Validation process? (y or n): ");
        
        // Set userResponse equal to the 1st character of the user's next input
        userResponse = scnr.nextLine().charAt(0);
        
        // While userResponse is not equal to 'y', 'Y', 'n', or 'N' (input validation)
        while (userResponse != 'y' && userResponse != 'Y' && userResponse != 'n' && 
                        userResponse != 'N')
        {
            // Print error message and prompt user to try again
            System.out.println("Invalid entry. Please enter either y or n only.");
            System.out.print(
                "Would you like to start the Credit Card Validation process? (y or n):");
            
            // Set userResponse equal to the 1st character of the user's next input 
            userResponse = scnr.nextLine().charAt(0);
        }
        
        // If userResponse is 'n' or 'N'...
        if (userResponse == 'n' || userResponse == 'N')
        {
            // Print program exit message
            System.out.println(
                "Credit Card Validation process not started. Exiting program.");
            
            System.exit(0); // Exit the program
        }
        
        /* Initialize CC Issuer Profiles */
        // Print status message
        System.out.println("\nBuilding CC Issuer Profiles...");
        
        // Create new CreditCardIssuerProfiles object
        // (This will initialize issuerProfiles's issuerArray)
        CreditCardIssuerProfiles issuerProfiles = new CreditCardIssuerProfiles();
        
        // Get a copy of issuerProfiles's issuerArray
        // Set issuerProfilesArray equal to that copy
        CreditCardIssuer[] issuerProfilesArray = issuerProfiles.getIssuerProfiles();
        
        // Print status message
        System.out.println("CC Issuer Profiles Built Successfully!");
        /* Finished Initializing CC Issuer Profiles */
        
        /* Read data from input file */
        // Print status message
        System.out.println("Reading from " + inputFileName + " and processing contents...");

        // Try to read from the input file, process the contents of the input file, organize
        // data for output, create output files, and write the output data to the output files
        try 
        {
            // Create a File object for the input file using inputFileName as the argument
            java.io.File inputFile = new java.io.File(inputFileName);
            
            // Initialize Scanner for reading input file
            java.util.Scanner inputFileScnr = new java.util.Scanner(inputFile);
        
            while (inputFileScnr.hasNext()) // While input file still has more lines...
            {
                // Set testNumber equal to the input file's next line, trimming any whitespace
                String testNumber = inputFileScnr.nextLine().trim();
                boolean matchFound = false; // Set matchFound to false
                String issuerName = ""; // Initialize issuerName to an empty String
                boolean correctLength = false; // Set correctLength to false
                int iterator = 0; // Initialize iterator to 0
            
                // While iterator has not reached the end of issuerProfilesArray
                // and a match has not been found
                while (iterator < issuerProfilesArray.length && !matchFound)
                {
                    // Use currentIssuer to hold current item in issuerProfilesArray
                    CreditCardIssuer currentIssuer = issuerProfilesArray[iterator];
                
                    // If testNumber's length is between the min and max length variables of 
                    // the currentIssuer (inclusive)
                    if (testNumber.length() >= currentIssuer.getMinLength() && 
                            testNumber.length() <= currentIssuer.getMaxLength())
                    {
                        correctLength = true; // Set correctLength to true
                    }
                
                    // Use validIINs to hold currentIssuer's 2D validIINs
                    String[][] validIINs = currentIssuer.getValidIINs();
                    
                    int i = 0; // Initialize i to 0
                
                    // While i has not reached the end of validIINs 2D array for currentIssuer
                    // AND testNumber is the correct length
                    // AND a match has not been found
                    while (i < validIINs.length && correctLength && !matchFound)
                    {
                        // Create a substring of the beginning of testNumber that is the 
                        // same length as the 1st element in the array at the current index
                        String keyDigitsToTest = 
                                    testNumber.substring(0, validIINs[i][0].length());
                    
                        // If the array's length at the current index is exactly 1
                        if (validIINs[i].length == 1)
                        {
                            // Compare validIINs[i][0] to first digits of testNumber
                            // If they are equal
                            if (keyDigitsToTest.equals(validIINs[i][0]))
                            {
                                // Get currentIssuer's name and set issuerName equal to it
                                issuerName = currentIssuer.getName();
                                
                                matchFound = true; // Set matchFound to true
                            }
                        }
                        // If the array's length at the current index is exactly 2
                        else if (validIINs[i].length == 2)
                        {
                            // Convert keyDigitsToTest to an int
                            // Set keyDigits equal to that int
                            int keyDigits = Integer.parseInt(keyDigitsToTest);
                            
                            // Convert the 1st element in the array at the current index to
                            // an int. Set currentIssuerDigitsMin equal to that int.
                            int currentIssuerDigitsMin = Integer.parseInt(validIINs[i][0]);
                            
                            // Convert the 2nd element in the array at the current indext to
                            // an int. Set currentIssuerDigitsMax equal to that int.
                            int currentIssuerDigitsMax = Integer.parseInt(validIINs[i][1]);
                        
                            // If keyDigits value is between currentIssuerDigitsMin and
                            // currentIssuerDigitsMax (inclusive)
                            if (keyDigits >= currentIssuerDigitsMin 
                                    && keyDigits <= currentIssuerDigitsMax)
                            {
                                // Get currentIssuer's name and set issuerName equal to it
                                issuerName = currentIssuer.getName();
                                
                                matchFound = true; // Set matchFound to true
                            }
                        }
                    
                        i++; // Add 1 to i to continue loop
                    }
                
                    iterator++; // Add 1 to iterator to continue loop
                }
            
                if (!matchFound) // If matchFound still equals false
                {
                    // Add testNumber to invalidNumbers ArrayList
                    invalidNumbers.add(testNumber);
                }
                else // If matchFound equals true
                {
                    // Create a new LuhnValidator object, passing testNumber as the argument
                    // (This will perform luhn check on testNumber and record the true/false
                    // result)
                    LuhnValidator luhnValidator = new LuhnValidator(testNumber);
                
                    // If testNumber passed the luhn check
                    if(luhnValidator.getLuhnCheckPassed())
                    {
                        // Create a new CreditCard object, passing testNumber and 
                        // issuerName as the arguments
                        CreditCard currentCC = new CreditCard(testNumber, issuerName);
                        
                        // Add the new CreditCard object to validCreditCards ArrayList
                        validCreditCards.add(currentCC);
                    }
                    else // If testNumber failed the luhn check
                    {
                        // Add testNumber to invalidNumbers ArrayList
                        invalidNumbers.add(testNumber);
                    }
                }
            }
        
            inputFileScnr.close(); // Close the input file
            
            // Print status message
            System.out.println(
                "Finished reading from " + inputFileName + " and processing contents!");
            /* Finished reading from input file */
        
            // Create arrays from validCreditCards and invalidNumbers (to meet assignment 
            // requirements related to working with arrays)
            String[] invalidNumbersArray =
                invalidNumbers.toArray(new String[invalidNumbers.size()]);
            CreditCard[] validCreditCardsArray = 
                validCreditCards.toArray(new CreditCard[validCreditCards.size()]);
        
            // Sort validCreditCardsArray (uses CreditCard class's compareTo method)
            java.util.Arrays.sort(validCreditCardsArray);
        
            // Print status message
            System.out.println("Creating output files...");
            
            // Initialize output print writers
            java.io.PrintWriter invalidFileWriter = 
                            new java.io.PrintWriter(invalidNumbersFileName);
            java.io.PrintWriter validFileWriter = 
                            new java.io.PrintWriter(validCardsFileName);
        
            // Write header to invalid numbers file
            invalidFileWriter.println("Invalid Numbers from " + inputFileName);
            invalidFileWriter.println("---------------------------------------------");
        
            // Write header to valid cards file
            validFileWriter.println("Valid CC Numbers from " + inputFileName);
            validFileWriter.println("----------------------------------------------------" +
                "---------------");
            
            // For each item in the invalidNumbersArray
            for (String invalidNumber : invalidNumbersArray)
            {
                // Write the item to the invalid numbers file
                invalidFileWriter.println(invalidNumber);
            }
        
            // For each item in the validCreditCardsArray
            for (CreditCard cc : validCreditCardsArray)
            {
                // Write the String representation of the item to the valid cards file
                validFileWriter.println(cc.toString());
            }
        
            invalidFileWriter.close(); // Close the invalid numbers file
            validFileWriter.close(); // Close the valid cards file
        
            // Print status message
            System.out.println("Output files created successfully!\n\nPlease open " + 
                invalidNumbersFileName + " and " + validCardsFileName + " to view " +
                "program output. ");
        }
        catch (java.io.FileNotFoundException e) // Catch FileNotFoundException by...
        {
            // Printing an error message
            System.out.println("FileNotFoundException was thrown with message: " +
                e.getMessage());
        }
    }
}
