//� A+ Computer Science  -  www.apluscompsci.com
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

		return getFace();
	}
        
}