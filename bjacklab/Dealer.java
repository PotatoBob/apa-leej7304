// A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 


//define Dealer class here
public class Dealer extends AbstractPlayer
{
	//instance variable - Deck 
	private Deck deck;

	private boolean dealerTurn = false;
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
	public void setDealerTurn(boolean turn)
	{
		dealerTurn = turn;
	}
	@Override
	public String toString()
	{
		if(dealerTurn) {
		    return super.toString();
		} else {
			// return "hand = [" + hand.get(0).toString() + "] = " + getHandValue();
			return super.toString().substring(0, super.toString().indexOf("\n", super.toString().indexOf("\n") + 1)) + "\n\t?? of ???? | value = ?\n]";
		}
	}
}
