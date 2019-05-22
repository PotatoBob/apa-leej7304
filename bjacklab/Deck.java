// A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
  public static final int NUMFACES = 13;
  public static final int NUMSUITS = 4;
  public static final int NUMCARDS = 52;

  public static final String SUITS[] = {"CLUBS","SPADES","DIAMONDS","HEARTS"};

  private int topCardIndex;
  private ArrayList<Card> stackOfCards;

  public Deck ()
  {
    //initialize data - stackOfCards - topCardIndex
    stackOfCards = new ArrayList<Card>();
    topCardIndex = NUMCARDS - 1;
    for(int suit = 0; suit < NUMSUITS; suit++)
    {
    	for(int face = 1; face <= NUMFACES; face++)
    	{
    		stackOfCards.add(new BlackJackCard(face, SUITS[suit]));
    	}
    }
                
    //loop through suits
    //loop through faces
    //add in a new card
                
  }

  //modifiers
  public void shuffle ()
  {
    //shuffle the deck
    //reset variables as needed
    Collections.shuffle(stackOfCards);
    for(Card c : stackOfCards) {
      ((BlackJackCard)c).setAceHigh(true);
    }
    topCardIndex = size()-1;
  }

  //accessors
  public int size ()
  {
    return stackOfCards.size();
  }

  public int numCardsLeft()
  {
    return topCardIndex+1;
  }

  public Card nextCard()
  {
    try {
      return stackOfCards.get(topCardIndex--);
    } catch (NullPointerException e) {
      return null;  
    }
  }

  public String toString()
  {
    return stackOfCards + "   topCardIndex = " + topCardIndex;
  } 
}
