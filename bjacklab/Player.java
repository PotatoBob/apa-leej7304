//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.util.ArrayList;
import java.util.Scanner;



//define Player class here 
public class Player extends AbstractPlayer
{

	//constructors
	public Player()
	{
		super();
	}
	public Player(ArrayList<Card> hand)
	{
		super(hand);
	}
	public Player(int winCount)
	{
		super(winCount);
	}
	public Player(ArrayList<Card> hand, int winCount)
	{
		super(hand, winCount);
	}

	//hit method goes here
	public boolean hit()
	{
		addCardToHand(new BlackJackCard());
		return getHandValue() <= 21;
	}
}