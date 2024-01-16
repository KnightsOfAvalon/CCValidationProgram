/**
 * This class holds the number and issuer name for any verified CreditCards. This class
 * provides methods to access the number and the issuer name and a method to return a String
 * representation of the CreditCard. This class also implements Comparable<Object> and
 * overrides the compareTo method to properly compare CreditCard objects.
 * Class: Fall - COSC 1437.81301
 * Assignment: Final Project
 * Date: 12/5/2023
 * @author Avalon Matthew
 * @version 0.0.0
 */
public class CreditCard implements Comparable<Object>
{
    private String cardNumber; // Will hold the CC Number
    private String cardIssuer; // Will hold the name of the CC issuer

    /**
     * Constructor for CreditCard class. Initializes cardNumber and cardIssuer with associated
     * parameters.
     * @param CC number as String and CC issuer name as String
     * @return None
     * @throws Nothing is implemented
     */
    public CreditCard(String number, String issuer)
    {
        cardNumber = number; // Initializes cardNumber with value of number
        cardIssuer = issuer; // Initializes cardIssuer with value of issuer
    }
    
    /**
    * Getter for cardNumber
    * @param None
    * @return CC number of CreditCard as String
    * @throws Nothing is implemented
    */
    public String getCardNumber()
    {
        return cardNumber;
    }
    
    /**
    * Getter for cardIssuer
    * @param None
    * @return Name of issuer for CreditCard as String
    * @throws Nothing is implemented
    */
    public String getCardIssuer()
    {
        return cardIssuer;
    }
    
    /**
    * Returns String representation of CreditCard. Overrides toString() method of superclass.
    * @param None
    * @return String representation of CreditCard as String
    * @throws Nothing is implemented
    */
    @Override
    public String toString()
    {
        return "CC Number: " + cardNumber + ", CC Issuer: " + cardIssuer;
    }
    
    /**
    * Compares 2 objects, first ensuring that the paramater is of the CreditCard type. This
    * method overrides the interface's compareTo method.
    * @param Any object as Object
    * @return Result of comparison of the Objects as int
    * @throws Nothing is implemented
    */
    @Override
    public int compareTo(Object cc)
    {
        if (cc instanceof CreditCard cc2) // If cc is of the CreditCard type
        {
            // If the cardIssuers of the two Objects are not equal to each other...
            if (!this.getCardIssuer().equals(cc2.getCardIssuer()))
            {
                // Return the result of the comparison of the cardIssuers of the two Objects
                return this.getCardIssuer().compareTo(cc2.getCardIssuer());
            }
            else // If the cardIssuers of the two Objects are equal
            {
                // Return the result of the comparison of the cardNumbers of the two Objects
                return this.getCardNumber().compareTo(cc2.getCardNumber());
            }
        }
        else // If cc is not of the CreditCard type
        {
            // Throw a new IllegalArgumentException
            throw new IllegalArgumentException(
                "Object given must be an instance of CreditCard");
        }
    
    }
}
