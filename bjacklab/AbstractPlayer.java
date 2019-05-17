//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import java.util.ArrayList;

public abstract class AbstractPlayer implements Playerable
{
  private ArrayList<Card> hand;
  private int winCount;

  //constructors
  public AbstractPlayer() 
  {
  	hand = new ArrayList<Card>();
  	winCount = 0;
  }
  public AbstractPlayer(ArrayList<Card> newHand) 
  {
  	hand = newHand;
  	winCount = 0;
  }
  public AbstractPlayer(int numwins) 
  {
  	hand = new ArrayList<Card>();
  	winCount = numwins;
  }
  public AbstractPlayer(ArrayList<Card> newHand, int numwins)
  {
  	hand = newHand;
  	winCount = numwins;
  }

  public  void addCardToHand( Card temp )
  {
  	hand.add(temp);

  }

  public  void resetHand()
  {
  	hand = new ArrayList<Card>();

  }

  public  void setWinCount( int numwins )
  {
  	winCount = numwins;

  }

  public int getWinCount() { return winCount; }

  public int getHandSize() { return hand.size(); }

  public int getHandValue()
  {
    //great example of polymorphism
    int total=0;
    for(Card c : hand) {
    	total += c.getValue();
    }
    return total;
  }

  public void setAceLow()
  {
    for(Card c : hand) {
      if(((BlackJackCard)c).getValue() == 11) {
        ((BlackJackCard)c).setAceHigh(false);
        break;
      }
    }
  }

  public String toString()
  {
    String out = "[";
    for(int i = 0; i < getHandSize(); i++) {
      out += "\n\t";
      out += hand.get(i).toString();
    }
    out += "\n] value = " + getHandValue();
    return out;
    //return "hand = " + hand.toString() + " \n-  # wins " + winCount;
  }
}