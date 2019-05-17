//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack
{
	//add in Player instance variable
	//add in Dealer instance variable
	private Player player;
	private Dealer dealer;

	private boolean hit;
	private boolean continueGame;

	private int playerWins;
	private int dealerWins;

	public BlackJack()
	{
		player = new Player();
		dealer = new Dealer();
		hit = true;
		continueGame = true;

		playerWins = 0;
		dealerWins = 0;
	}

	public void playGame()
	{
		//TODO: add BLACKJACKS what are you doing???!
		//TODO: add separate win condition for blackjack (combines with gambling later)
		//TODO: add BLACKJACK check for dealer, not just player
		//TODO: having BLACKJACK skips the player hit/stand loop
		//TODO: make dealer hit on soft 17, otherwise hit on 16
		//TODO: expose one of dealer's cards in beginning, but not both???
		//TODO: add gambling???
		//TODO: add option to split hand on doubles???
	    Scanner keyboard = new Scanner(System.in);

	    while(continueGame) {
		    dealer.shuffle();
		    player.resetHand();
		    dealer.resetHand();

		    hit = true;

		    player.addCardToHand(dealer.deal());
		    player.addCardToHand(dealer.deal());

		    dealer.addCardToHand(dealer.deal());
		    dealer.addCardToHand(dealer.deal());
		    //we don't know dealer's hand until after player finishes

		    System.out.println("Player Hand:\n" + player);

		    if(player.getHandValue() == 21) {
		    	System.out.println("BLACKJACK!");
			    System.out.println("\nDealer's Hand:\n" + dealer);
			    if(dealer.getHandValue() == 21)
			    	System.out.println("It's a tie! You both got BLACKJACK!");
			    else {
			    	System.out.println("You win! You got BLACKJACK and the dealer didn't!");
			    	playerWins++;
			    }
		    } else {
			    while(player.getHandValue() < 21 && hit) {
			    	System.out.print("\nhit? y/n :: ");
			    	if(hit = (keyboard.next().charAt(0) == 'y')) {
			    		player.addCardToHand(dealer.deal());
			    	} else {
			    		hit = false;
			    	}
			    	if(player.getHandValue() > 21) {
			    		player.setAceLow();
			    	}
			    	System.out.println("\n\nPlayer Hand:\n" + player);
			    }
			    if(player.getHandValue() > 21) {
			    	System.out.println("Shucks! You busted! Dealer wins!");
			    	dealerWins++;
			    } else {
				    System.out.println("\nDealer's Hand:\n" + dealer);
				    Card temp = null;
				    while(dealer.getHandValue() < 17) { // later implement dealer hit on "soft" 17 (A + 6)
				    	dealer.addCardToHand(temp = dealer.deal());
				    	System.out.println("\ndealer hits: " + temp+"\n");
				    	if(dealer.getHandValue() > 21) {
				    		dealer.setAceLow();
				    	}
				    	System.out.println("Dealer Hand Value: " + dealer.getHandValue());
				    }
				    if(dealer.getHandValue() > 21) {
				    	System.out.println("\nDealer busted! You win!");
			    		playerWins++;
				    } else {
				    	if(player.getHandValue() > dealer.getHandValue()) {
				    		System.out.println("\nYou win! Your hand (" + player.getHandValue() + ") is larger than the dealer's hand (" + dealer.getHandValue() + ")!");
				    		playerWins++;
				    	} else if(player.getHandValue() == dealer.getHandValue()) {
				    		System.out.println("\nIt's a tie! Your hand (" + player.getHandValue() + ") is the same as the dealer's hand (" + dealer.getHandValue() + ")!");
				    	} else {
				    		System.out.println("\nDealer wins! Your hand (" + player.getHandValue() + ") is smaller than the dealer's hand (" + dealer.getHandValue() + ")!");
				    		dealerWins++;
				    	}
				    }
				}
		    }

		    System.out.println("\nPlayer wins: " + playerWins);
		    System.out.println("Dealer wins: " + dealerWins);
		    System.out.print("\nContinue playing? y/n :: ");
		    continueGame = ('y' == keyboard.next().charAt(0));
		    System.out.println("---------------------\n\n");
		}
	}
        
	public static void main(String[] args)
	{
	    BlackJack game = new BlackJack();
	    game.playGame();
	}
}