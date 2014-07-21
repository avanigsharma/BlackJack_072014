package BJ;

/*
 * Dealer.java
 * author: Avani Sharma
 * Inherits from Hand.java
 * Methods are Hits, showHand
 */

// inherit from Hand Base
public class Dealer extends Hand{

    public Dealer() {
    }
    
    public void showHand()  {
        System.out.println("***Dealer's cards:");
        super.showHand();
    }
    
    public boolean Hits()  {
        boolean hits = super.handTotal() < 17;
        System.out.println("Dealer " + (hits ? "hits" : "stays") + "." );
        return hits;
    }


}
