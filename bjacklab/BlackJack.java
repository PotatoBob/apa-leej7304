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

    System.out.println("Player:\n" + player);
    System.out.println("Dealer:\n" + dealer);
  }
        
  public static void main(String[] args)
  {
    BlackJack game = new BlackJack();
    game.playGame();
  }
}