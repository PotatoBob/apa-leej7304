//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

public class BlackJackCard extends Card
{
	private boolean aceHigh = true;
	//constructors
	public BlackJackCard(){};
	public BlackJackCard(int face, String suit)
	{
		super(face, suit);
	}

	public void setAceHigh(boolean aceHigh) {
		this.aceHigh = aceHigh;
	}
	public int getValue()
	{
		//enables you to build the value for the game into the card
		//this makes writing the whole program a little easier
		if(getFace() == 1)
			if(aceHigh)
				return 11;
			else
				return 1;
		else if(getFace() >= 10)
			return 10;
		else
			return getFace();
	}
        
}