/**
 * This class holds an array of CC issuer information called issuerArray. CC issuer information
 * is represented as CreditCardIssuer objects. Upon initialization, a new CreditCardIssuer 
 * object is created for each CC issuer provided in the CreditCardIssuer class's name array 
 * and then added to issuerArray. This class also provides a method to return a copy of 
 * issuerArray.
 * Class: Fall - COSC 1437.81301
 * Assignment: Final Project
 * Date: 12/5/2023
 * @author Avalon Matthew
 * @version 0.0.0
 */
public class CreditCardIssuerProfiles
{
    // Will hold an array of CreditCardIssuer objects
    private CreditCardIssuer[] issuerArray = 
                new CreditCardIssuer[CreditCardIssuer.NUMBER_OF_ISSUER_NAMES];

    /**
     * Constructor for CreditCardIssuerProfiles class. Creates a CreditCardIssuer object for
     * each item in the CreditCardIssuer class's name array, then add a copy of those objects 
     * to issuerArray.
     * @param None
     * @return None
     * @throws Nothing is implemented
     */
    public CreditCardIssuerProfiles()
    {
        // Count from 0 to CreditCardIssuer.NUMBER_OF_ISSUER_NAMES minus 1
        for (int i = 0; i < CreditCardIssuer.NUMBER_OF_ISSUER_NAMES; i++)
        {
            // Create a new CreditCardIssuer object by passing the name from index i of
            // the CreditCardIssuer name array to the constructor
            CreditCardIssuer ccIssuer = 
                new CreditCardIssuer(CreditCardIssuer.ISSUER_NAME_ARRAY[i]);
            
            // Put a copy of the created CreditCardIssuer object at the current index of
            // issuerArray
            issuerArray[i] = new CreditCardIssuer(ccIssuer);
        }
        
    }
    
    /**
    * Getter for issuerArray. 
    * @param None
    * @return Array of CC Issuer information as CreditCardIssuer[]
    * @throws Nothing is implemented
    */
    public CreditCardIssuer[] getIssuerProfiles()
    {
        return issuerArray;
    }

}
