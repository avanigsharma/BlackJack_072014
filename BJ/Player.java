package BJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Player.java
 * author: Avani Sharma
 * Inherits from Hand.java
 * Has money, bet, and the ability to read from stdin (for hit or stand)
 * Methods are Bets, Hits , Wins, Loses, showHand
 */

// Player Class inherits from Hand
public class Player extends  Hand{	
		int money;
		int bet;
		InputStreamReader stdin;
        BufferedReader console;
	
		public Player(int m){ 
			this.money = m;
			stdin = new InputStreamReader(System.in);
			console = new BufferedReader(stdin);
		}

		// place bet 1-money, 0 to quit
		boolean Bets()  {
			if (money == 0) return false;
			try{	
				do{
	
				   System.out.print("You have " + money + " chips. Enter bet (0: to quit, 1-" + money +"):");
				   //System.out.flush();
				   bet = Integer.parseInt(console.readLine()); 
				   
				
				} while(bet<0 || bet>money);
			} catch (IOException ex){
             System.out.println(ex.toString());
			}
			
			return bet !=0; // if 0, then no more betting
		}
	
		// show player's hands
		public void showHand(){
			System.out.println("*** Player's cards:");
			super.showHand(); // call parent function
		}
		
		// increment bet money, if wins
		 public void Wins() {
		    System.out.println( "Player wins " + bet + " chips.");
		    money += bet;
		 }
		 
		 // decrement bet money, if loses
		 public void Loses() {
			 System.out.println( "Player loses " + bet + " chips.");
			 money -= bet;
		 }
		 
		 // Implement Player hits or stays
		 public boolean Hits() {
			 char hit;
		     while (true) {
		    	 try{
		        	System.out.println("Hit? (y/n): ");
		        	hit = console.readLine().charAt(0);
		            
		            if (hit == 'y' || hit == 'Y') {
		                System.out.println("Player hits.");
		                return true;
		            }
		            if (hit == 'n' || hit == 'N') {
		            	System.out.println("Player stays.");
		                return false;
		            }
		    	 } catch (IOException ex)
		         {
		             System.out.println(ex.toString());
		         }
		        } // end while
		 } // Hits()
		    
}
