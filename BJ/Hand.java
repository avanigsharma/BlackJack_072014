package BJ;
import java.util.ArrayList;

/*
 * Hand.java
 * author: Avani Sharma
 * This contains a list of Cards currently in player's or dealer's hands  
 * This class offers: AddCard, HasBlackJack, handTotal,Busted, showHand methods
 */


public class Hand {

	private ArrayList<Card> hand;
	
	Hand(){
		hand = new ArrayList<Card>();
	}
	
	public void ClearCards(){
		hand.clear();
	}
	
	public void AddCard(Card c){
		if (c != null) hand.add(c);
	}

	public boolean HasBlackJack() {	
		return (hand.size() == 2 && this.handTotal() ==21);
	}
	
	// count ace as 1 or 11 
	public int handTotal(){
		int score =0;
		boolean ace = false;
		for (Card c : hand){
			if (c.getValue() ==1 ) ace = true; // soft hand, can not be Busted
			score += c.getValue();
		}
		if (ace && (score) < 12) score +=10; // ace is being treated as 11 here
		
		return score;
	}
	
	public boolean Busted(){
		return (this.handTotal()>21);
	}
	
	public void showHand(){
		StringBuffer sb = new StringBuffer();
		for (Card c : hand){
			sb.append(c.toString());
			sb.append(" ");
			
		}
		sb.append(" --> hand value:");
		sb.append(this.handTotal());
		System.out.println( sb);
		if (this.Busted()){
			System.out.println("Busted");
		}
	}
	
	
}
