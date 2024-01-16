/**
 * This class holds an array of CC issuer names provided in the Assignment Instructions and the
 * count of those CC issuer names. Initialization: If a CC issuer name is provided to the
 * constructor, the CreditCardIssuer object will hold the information provided in the 
 * Assignment Instructions for that specific CC issuer. If a CreditCardIssuer object is
 * provided to the constructor, the CreditCardIssuer object will copy the fields of the given
 * CreditCardIssuer object. Also, this class provides getter methods for all fields.
 * Class: Fall - COSC 1437.81301
 * Assignment: Final Project
 * Date: 12/5/2023
 * @author Avalon Matthew
 * @version 0.0.0
 */
public class CreditCardIssuer
{
    // Holds an array of the CC issuer names provided in the Assignment Instructions
    public static final String[] ISSUER_NAME_ARRAY = 
            {
                "American Express",
                "Diners Club - Carte Blanche",
                "Diners Club - International",
                "Diners Club - USA & Canada",
                "Discover",
                "InstaPayment",
                "JCB",
                "Laser",
                "Maestro",
                "MasterCard",
                "Visa Electron",
                "Visa"
            };
    
    // Holds the count of CC issuer names provided in the Assignment Instructions
    public static final int NUMBER_OF_ISSUER_NAMES = ISSUER_NAME_ARRAY.length;
    
    private String name; // Will hold the name of the CC issuer
    private String[][] validIINs; // Will hold the valid IIN ranges for the specific CC issuer
    private int minLength; // Will hold the min # of digits for CCs from the specific issuer
    private int maxLength; // Will hold the max # of digits for CCs from the specific issuer
    
    /**
     * Constructor for CreditCardIssuer class. Initializes name with the provided parameter. 
     * Then, validIINs, minLength, and maxLength are all initialized with predetermined values
     * (given in the Assignment Instructions) based on the value of name.
     * @param Name of the CC issuer as String
     * @return None
     * @throws Nothing is implemented
     */
    public CreditCardIssuer(String issuerName)
    {
        name = issuerName; // Initializes name with value of issuerName
        
        if (name.equals(ISSUER_NAME_ARRAY[0])) // If name is "American Express"
        {
            // Initialize validIINs, minLength, and maxLength with the information given
            // in the Assignment Instructions for American Express
            validIINs = new String[][] { { "34" }, { "37" } }; 
            minLength = 15;
            maxLength = 15;
        }
        else if (name.equals(ISSUER_NAME_ARRAY[1])) // If name is "Diners Club - Carte Blanche"
        {
            // Initialize validIINs, minLength, and maxLength with the information given
            // in the Assignment Instructions for Diners Club - Carte Blanche
            validIINs = new String[][] { { "300" }, { "301" }, { "302" }, { "303" }, 
                                            { "304" }, { "305" } };
            minLength = 14;
            maxLength = 14;
        }
        else if (name.equals(ISSUER_NAME_ARRAY[2])) // If name is "Diners Club - International"
        {
            // Initialize validIINs, minLength, and maxLength with the information given
            // in the Assignment Instructions for Diners Club - International
            validIINs = new String[][] { { "36" } };
            minLength = 14;
            maxLength = 14;
        }
        else if (name.equals(ISSUER_NAME_ARRAY[3])) // If name is "Diners Club - USA & Canada"
        {
            // Initialize validIINs, minLength, and maxLength with the information given
            // in the Assignment Instructions for Diners Club - USA & Canada
            validIINs = new String[][] { { "54" } };
            minLength = 16;
            maxLength = 16;
        }
        else if (name.equals(ISSUER_NAME_ARRAY[4])) // If name is "Discover"
        {
            // Initialize validIINs, minLength, and maxLength with the information given
            // in the Assignment Instructions for Discover
            validIINs = new String[][] { { "6011" }, { "622126", "622925" }, { "644" },
                                            { "645" }, { "646" }, { "647" }, { "648" },
                                            { "649" }, { "65" } };
            minLength = 16;
            maxLength = 16;
        }
        else if (name.equals(ISSUER_NAME_ARRAY[5])) // If name is "InstaPayment"
        {
            // Initialize validIINs, minLength, and maxLength with the information given
            // in the Assignment Instructions for InstaPayment
            validIINs = new String[][] { { "637" }, { "638" }, { "639" } };
            minLength = 16;
            maxLength = 16;
        }
        else if (name.equals(ISSUER_NAME_ARRAY[6])) // If name is "JCB"
        {
            // Initialize validIINs, minLength, and maxLength with the information given
            // in the Assignment Instructions for JCB
            validIINs = new String[][] { { "3528", "3589" } };
            minLength = 16;
            maxLength = 16;
        }
        else if (name.equals(ISSUER_NAME_ARRAY[7])) // If name is "Laser"
        {
            // Initialize validIINs, minLength, and maxLength with the information given
            // in the Assignment Instructions for Laser
            validIINs = new String[][] { { "6304" }, { "6706" }, { "6771" }, { "6709" } };
            minLength = 16;
            maxLength = 19;
        }
        else if (name.equals(ISSUER_NAME_ARRAY[8])) // If name is "Maestro"
        {
            // Initialize validIINs, minLength, and maxLength with the information given
            // in the Assignment Instructions for Maestro
            validIINs = new String[][] { { "5018" }, { "5020" }, { "5038" }, { "5893" }, 
                                        { "6304" }, { "6759" }, { "6761" }, { "6762" }, 
                                        { "6763" } };
            minLength = 16;
            maxLength = 19;
        }
        else if (name.equals(ISSUER_NAME_ARRAY[9])) // If name is "MasterCard"
        {
            // Initialize validIINs, minLength, and maxLength with the information given
            // in the Assignment Instructions for MasterCard
            validIINs = new String[][] { { "51" }, { "52" }, { "53" }, { "54" }, { "55" } };
            minLength = 16;
            maxLength = 19;
        }
        else if (name.equals(ISSUER_NAME_ARRAY[10])) // If name is "Visa Electron"
        {
            // Initialize validIINs, minLength, and maxLength with the information given
            // in the Assignment Instructions for Visa Electron
            validIINs = new String[][] { { "4026" }, { "417500" }, { "4508" }, { "4844" }, 
                                        { "4913" }, { "4917" } };
            minLength = 16;
            maxLength = 16;
        }
        else if (name.equals(ISSUER_NAME_ARRAY[11])) // If name is "Visa"
        {
            // Initialize validIINs, minLength, and maxLength with the information given
            // in the Assignment Instructions for Visa
            validIINs = new String[][] { { "4" } };
            minLength = 13;
            maxLength = 16;
        }
    }
    
    /**
    * Copy constructor for CreditCardIssuer class. Initializes name, validIINs, minLength, and
    * maxLength with the associated fields of the provided CreditCardIssuer.
    * @param CC issuer to be copied as CreditCardIssuer
    * @return None
    * @throws Nothing is implemented
    */
    public CreditCardIssuer(CreditCardIssuer issuer)
    {
        name = issuer.getName();
        validIINs = issuer.getValidIINs();
        minLength = issuer.getMinLength();
        maxLength = issuer.getMaxLength();
    }
    
    /**
    * Getter for name
    * @param None
    * @return CC issuer name as String
    * @throws Nothing is implemented
    */
    public String getName()
    {
        return name;
    }
    
    /**
    * Getter for validIINs
    * @param None
    * @return Two-dimensional array of valid IIN ranges as String[][]
    * @throws Nothing is implemented
    */
    public String[][] getValidIINs()
    {
        return validIINs;
    }
    
    /**
    * Getter for minLength
    * @param None
    * @return Min # of digits for CCs from the specific issuer as int
    * @throws Nothing is implemented
    */
    public int getMinLength()
    {
        return minLength;
    }
    
    /**
    * Getter for maxLength
    * @param None
    * @return Max # of digits for CCs from the specific issuer as int
    * @throws Nothing is implemented
    */
    public int getMaxLength()
    {
        return maxLength;
    }
}
