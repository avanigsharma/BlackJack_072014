package BJ;

/*
 * Card.java
 * author: Avani Sharma
 * Abstraction for  1 playing card. It has suit and value of the card
 */
public class Card {
	public final static int HEARTS = 1;
	public final static int DIAMONDS = 2;
	public final static int SPADES = 3;
	public final static int CLUBS = 4;
	
	private int suit;
	private int value;

	
	public Card(int s, int v){
		// check for valid values
		if (s != SPADES && s != HEARTS && s != DIAMONDS && s != CLUBS )
	         throw new IllegalArgumentException("Illegal playing card suit");
	    if ( v < 1 || v > 13)
	         throw new IllegalArgumentException("Illegal playing card value");
	    
		suit =s;
		value = v;
		
	}
	
	 public int getValue() {
		 
		 return value>10?10:value;
	 }
	
	// get value of Card as a string
	 public String toString() {
	      
         return getValueAsString() + " of " + getSuitAsString();
	 }
	

	  public String getSuitAsString() {
		      switch ( suit ) {
		      case SPADES:   return "Spades";
		      case HEARTS:   return "Hearts";
		      case DIAMONDS: return "Diamonds";
		      default:       return "Clubs";
		      }// end switch
		   }
	   

	    public String getValueAsString() {
	          switch ( value ) {  
		          case 11:  return "Jack";
		          case 12:  return "Queen";
		          case 13:  return "King";
		          case 1:   return "Ace"; // value of 1
		          // for 2-10
		          default:   return (Integer.toString(value % 13));
	          } // end switch

	    }

		   
} // end Class 
