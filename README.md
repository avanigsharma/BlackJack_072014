BlackJack_072014
================

Black Jack game for insight data engineering Coding Challenge

Classes :
-------
Card.java         - abstraction for  1 playing card. It has suit and value of the card

DeckOfCards.java  - this is a deck of 52 cards and allows to deal a card, shuffle deck 
                    if when dealing the card, a deck is exhausted, it reinitializes the deck
                    
Hand.java         - This contains a list of Cards currently in player's or dealer's hands  
                    This class offers: AddCard, HasBlackJack, handTotal,Busted, showHand methods

Player.java       - Inherits from Hand.java. 
                    Has money, bet, and the ability to read from stdin (for hit or stand)
                    Methods are Bets, Hits , Wins, Loses, showHand
                    
Dealer.java       - Inherits from Hand.java
                    Methods are Hits, showHand
                    
BlackJack.java    - The main class that plays the game
                    Has a dealer, player(with 100 chips) and a deck of 52 cards
                    Methods are InitialDeal, ShowResults, Play and main()
Features

1. Starts with a dealer, player(with 100 chips) and a deck of 52 cards
2. Loop until player bets: 1-100 chips or 0 to quit
3. InitialDeal : shuffle deck, deal 2 cards to player and 2 to dealer
    Player: shows both cards
    Dealer: shows first card, second card is hidden
3. Player: loop over until player wants to hit and is not busted 
4. Dealer: loop over until dealer is busted and keeps hitting
