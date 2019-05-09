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

  public BlackJack()
  {
  	player = new Player();
  	dealer = new Dealer();
  	hit = true;
  }

  public void playGame()
  {
    Scanner keyboard = new Scanner(System.in);
    char choice = 0;

    dealer.shuffle();
    player.resetHand();
    dealer.resetHand();

    player.addCardToHand(dealer.deal());
    player.addCardToHand(dealer.deal());

    dealer.addCardToHand(dealer.deal());
    dealer.addCardToHand(dealer.deal());

    System.out.println("Player Hand:\n" + player);
    //we don't know dealer's hand until after player finishes

    while(player.getHandValue() <= 21 && hit) {
    	System.out.print("hit? y/n :: ");
    	if(hit = (keyboard.next().charAt(0) == 'y')) {
    		player.addCardToHand(dealer.deal());
    	} else {
    		hit = false;
    	}
    	System.out.println("Player Hand:\n" + player);
    }
    if(player.getHandValue() > 21) {
    	System.out.println("Shucks! You busted!");
    	return;
    }
    //else dealer's turn
  }
        
  public static void main(String[] args)
  {
    BlackJack game = new BlackJack();
    game.playGame();
  }
}