//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 


public abstract class Card
{
  public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
                                        "FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

  private String suit; // "CLUBS" "DIAMONDS" "HEARTS" "SPADES"
  private int face; // 0-13, 0 is a dummy card? hopefully never appears

  //constructors
  public Card()
  {
  	suit = "CLUBS";
  	face = 0;
  }
  public Card(int face, String suit)
  {
  	this.face = face;
  	this.suit = suit;
  }

  // modifiers
  public void setFace(int face)
  {
  	this.face = face;
  }
  public void setSuit(String suit)
  {
  	this.suit = suit;
  }

 

  //accessors
  public int getFace()
  {
  	return face;
  }
  public String getSuit()
  {
  	return suit;
  }




  public abstract int getValue(); // depending on suit and face number

  public boolean equals(Object obj)
  {
  	Card temp = (Card)obj;
  	return (temp.getFace()==getFace() && temp.getSuit().equals(getSuit()));
  }

  //toString
  public String toString()
  {
  	return FACES[face] + " of " + getSuit() + " | value = " + getValue();
  }
}