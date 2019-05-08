//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 


//define Dealer class here
public class Dealer extends AbstractPlayer
{
	//instance variable - Deck 
	private Deck deck;

	//constructors
	public Dealer()
	{
		deck = new Deck();
	}

	//method to shuffle
	public void shuffle()
	{
		deck.shuffle();
	}

	//method to deal a card
	public Card deal()
	{
		return deck.nextCard();
	}

	//hit method goes here
	public boolean hit()
	{
		addCardToHand(new BlackJackCard());
		return getHandValue() < 17;
	}
}