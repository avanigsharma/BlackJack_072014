package BJ;

/*
 * BlackJack.java
 * author: Avani Sharma
 * Methods are Hits, showHand
 */

public class BlackJack {
	
	private Player mPlayer;
	private Dealer mDealer;
	private DeckOfCards mDeck;
		
	public BlackJack() { // Constructor
		  this.mPlayer = new Player( 100); // initialize with 100 chips
		  this.mDealer = new Dealer();
		  this.mDeck   = new DeckOfCards();  
	}
	
	private void  InitialDeal() {
        mPlayer.ClearCards();
        mDealer.ClearCards();
        mDeck.shuffle();
        mPlayer.AddCard(mDeck.dealCard());
        mDealer.AddCard(mDeck.dealCard());
        mDealer.showHand();
        mPlayer.AddCard(mDeck.dealCard());
        mPlayer.showHand();
        mDealer.AddCard(mDeck.dealCard());  // this card is not shown
    }
	
	private  void ShowResults() {
		System.out.println("****** Results ********");
		if (mPlayer.HasBlackJack())
			System.out.println("Player has BLACKJACK !");
		if (mDealer.HasBlackJack())
			System.out.println("Dealer has BLACKJACK !");
		System.out.println("Player's hand: " + mPlayer.handTotal() + " Dealer's hand: " + mDealer.handTotal());
        if (mPlayer.Busted() && mDealer.Busted()) {
            System.out.println( "Dealer and player both busted. It's a tie!");
        } else if (mPlayer.Busted()) {
        	System.out.println("Player Busted");
            mPlayer.Loses();
        } else if (mDealer.Busted()) {
        	System.out.println("Dealer Busted");
            mPlayer.Wins();
        } else if (mPlayer.handTotal() > mDealer.handTotal()) {
            mPlayer.Wins();
        } else if (mPlayer.handTotal() < mDealer.handTotal()) {
            mPlayer.Loses();
        } else {
        	System.out.println("It's a tie!");
        }
    }

	
	void Play() {
		
		System.out.println("Welcome to Blackjack!" );
		
		while (mPlayer.Bets()) {
			
			InitialDeal();
			
            if (!mPlayer.HasBlackJack()) {
            	
            	// player hits or stands
                while (!mPlayer.Busted() && mPlayer.Hits()) {
                    mPlayer.AddCard(mDeck.dealCard()); 
                    mPlayer.showHand(); 
                }
                // Dealer's turn
                mDealer.showHand();
                while (!mDealer.Busted() && mDealer.Hits()) {
                    mDealer.AddCard(mDeck.dealCard()); 
                    mDealer.showHand();
                }
            }
	        ShowResults();
	    } // end while
		System.out.println( "Thank you for playing.");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlackJack BJGame = new BlackJack();
		BJGame.Play();

	}

}
