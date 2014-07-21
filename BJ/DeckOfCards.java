package BJ;

/*
 * DeckOfCards.java
 * author: Avani Sharma
 * this is a deck of 52 cards and allows to deal a card, shuffle deck
 * if when dealing the card, a deck is exhausted, it reinitializes the deck
 */

public class DeckOfCards {
	public static final int NCARDS = 52; // 52 max cards
    
    private Card[] deck; // array of all cards makes a deck
    private int topCard;
    
    public DeckOfCards(){
    	
    	deck =  new Card[NCARDS];
    	
    	int totalCards=0;
    	for ( int suit = Card.HEARTS; suit <= Card.CLUBS; suit++ ) 
            for ( int value = 1; value <= 13; value++ ) {
               deck[totalCards] = new Card(suit,value);
               totalCards++;
            }// end inner for

    	this.topCard = 0;
    }
    
    public void  shuffle(){
    	int N = deck.length ;
    	for ( int i = 0 ; i < N; i++ ) {
            int rand = i + (int) (Math.random() * (N-i)); // swap with a random card
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
         }
    	
    }
    
    // deal from deck and get new deck, if current one is exhausted
    public Card dealCard(){	
    	if (topCard == deck.length){
    		System.out.println("No cards are left in current deck. Getting a new deck...");
    		this.topCard=0;
    		this.shuffle();
    	}
        return deck[topCard++];
    }

    
} //end Class


