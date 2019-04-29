//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

public class BlackJackCard extends Card
{
	//constructors
	public BlackJackCard(){};
	public BlackJackCard(int face, String suit)
	{
		super(face, suit);
	}


	public int getValue()
	{
		//enables you to build the value for the game into the card
		//this makes writing the whole program a little easier
		int suitValue;
		if(getSuit().equals("CLUBS")) suitValue = 0;
		else if(getSuit().equals("SPADES")) suitValue = 1;
		else if(getSuit().equals("DIAMONDS")) suitValue = 2;
		else if(getSuit().equals("HEARTS")) suitValue = 3;
		else suitValue = 4;

		return 13*suitValue + getFace();
	}
        
}