//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class BlackJack
{
	//add in Player instance variable
	//add in Dealer instance variable
	// private Player player;
	// private Dealer dealer;
	private ArrayList<Playerable> players;


	public BlackJack()
	{
		players = new ArrayList<>();
	}

	public void playGame()
	{
	    Scanner keyboard = new Scanner(System.in);
		// boolean hit = true;
		boolean continueGame = true;

		int playerWins = 0;
		int dealerWins = 0;

		System.out.print("How many players :: ");
		int numPlayers = keyboard.nextInt();

		boolean[] hit = new boolean[numPlayers+1]; //ignore index 0
		boolean[] blackjacks = new boolean[numPlayers + 1];
		boolean[] busted = new boolean[numPlayers+1]; //ignore index 0
		int[] wins = new int[numPlayers + 1];
		int bustedCount;

		players.add(new Dealer());
		for(int i = 0; i < numPlayers; i++) {
			players.add(new Player());
			hit[i] = true;
		}

	    while(continueGame) {
		    // dealer.shuffle();
		    // player.resetHand();
		    // dealer.resetHand();
		    // dealer.setDealerTurn(false);
	    	((Dealer)players.get(0)).shuffle();
	    	for(Playerable p : players) {
	    		p.resetHand();
	    	}
	    	((Dealer)players.get(0)).setDealerTurn(false);

	    	hit = new boolean[numPlayers+1]; //ignore index 0
			blackjacks = new boolean[numPlayers + 1];
			busted = new boolean[numPlayers+1]; //ignore index 0
	    	for(int i = 0; i <= numPlayers; i++) {
	    		hit[i] = true;
	    		blackjacks[i] = false;
	    		busted[i] = false;
	    	}

		    // player.addCardToHand(dealer.deal());
		    // player.addCardToHand(dealer.deal());

		    // dealer.addCardToHand(dealer.deal());
		    // dealer.addCardToHand(dealer.deal());
			for(int i = numPlayers; i >= 0; i--) {
				players.get(i).addCardToHand(((Dealer)players.get(0)).deal());
				players.get(i).addCardToHand(((Dealer)players.get(0)).deal());
			}

		    //we only know 1 card of the dealer's hand until the player's turn finishes

		    // System.out.println("Player Hand:\n" + player);
		    for(int i = 1; i <= numPlayers; i++) {
		    	System.out.println("Player " + i + " Hand:\n" + (Player)players.get(i));
		    }
		    // System.out.println("Dealer Hand:\n" + dealer);
		    System.out.println("Dealer Hand:\n" + (Dealer)players.get(0));

		    for(int i = numPlayers; i >= 0; i--) {
		    	if(players.get(i).getHandValue() == 21)
		    		blackjacks[i] = true;
		    }
		    if(Arrays.asList(blackjacks).contains(true)) {
		    	if(!blackjacks[0]) {//no dealer blackjack
		    		for(int i = 1; i <= numPlayers; i++) {
		    			if(blackjacks[i]) {
		    				System.out.println("Player "+i+" got BLACKJACK!");
		    				wins[i] = wins[i] + 1;
		    			}
		    		}
		    	} else {//dealer blackjack
		    		for(int i = 1; i <= numPlayers; i++) {
		    			if(blackjacks[i]) {
		    				System.out.println("Player "+i+" got BLACKJACK...\n...but so did the dealer!");
		    				wins[0] = wins[0] + 1;
				    		wins[i] = wins[i] + 1;
		    			}
		    		}
		    	}
		    } else {
		    	for(int i = 1; i <= numPlayers; i++) {
		    		while(players.get(i).getHandValue() < 21 && hit[i]) {
		    			System.out.println("\n\nPlayer "+i+" Hand:\n"+(Player)players.get(i));
		    			System.out.print("\nPlayer "+i+" hit? y/n :: ");
		    			if(hit[i] = (keyboard.next().charAt(0) == 'y'))
		    				players.get(i).addCardToHand(((Dealer)players.get(0)).deal());
		    			else
		    				hit[i] = false;
		    			if(players.get(i).getHandValue() > 21)
		    				((Player)players.get(i)).setAceLow();
		    			System.out.println("\n\nPlayer "+i+" Hand:\n"+(Player)players.get(i));
		    		}
		    		if(players.get(i).getHandValue() > 21) {
		    			System.out.println("Shucks! Player "+i+" busted! Dealer wins this one!");
		    			busted[i] = true;
		    			wins[0] = wins[0] + 1;
		    		}
				    System.out.println();
				    for(int j = 0; j <= numPlayers; j++) {
				    	System.out.println("Player "+j+" wins: "+wins[i]);
				    }
				    System.out.println("Dealer wins: "+wins[0]);
		    	}
		    	bustedCount = 0;
		    	for(int i = 1; i <= numPlayers; i++) {
		    		if(busted[i])
		    			bustedCount++;
		    	}
		    	if(bustedCount == numPlayers) {
		    		System.out.println("Wow, all players busted! Dealer won without doing anything!");
		    	} else {
			    	((Dealer)players.get(0)).setDealerTurn(true);
			    	System.out.println("\nDealer's Hand:\n" + (Dealer)players.get(0));
			    	Card temp = null;
			    	while(players.get(0).getHandValue() < 17) {
			    		players.get(0).addCardToHand(temp = ((Dealer)players.get(0)).deal());
			    		System.out.println("\nDealer hits: "+temp+"\n");
			    		if(players.get(0).getHandValue() > 21)
			    			((Dealer)players.get(0)).setAceLow();
			    		System.out.println("Dealer Hand Value: "+players.get(0).getHandValue());

			    	}
			    	if(players.get(0).getHandValue() > 21) {
			    		String playersWon = "";
			    		for(int i = 1; i <= numPlayers; i++) {
			    			if(!busted[i]) {
			    				playersWon += "Player "+i+", ";
			    				wins[i] = wins[i] + 1;
			    			}
			    		}
			    		playersWon = playersWon.substring(0,playersWon.length()-2) + " beat the dealer!";
			    		System.out.println("Dealer busted!\n" + playersWon);
			    	} else {
			    		for(int i = 1; i <= numPlayers; i++) {
			    			if(players.get(i).getHandValue() > players.get(0).getHandValue()) {
			    				System.out.println("\nPlayer "+i+" beat the dealer!");
			    				System.out.println("Their hand ("+players.get(i).getHandValue()+") is larger than the dealer's hand ("+players.get(0).getHandValue()+")!");
			    				wins[i] = wins[i] + 1;
			    			} else if(players.get(i).getHandValue() == players.get(0).getHandValue()) {
			    				System.out.println("\nPlayer "+i+" tied with the dealer!");
			    				System.out.println("Their hand ("+players.get(i).getHandValue()+") is the same as the dealer's hand ("+players.get(0).getHandValue()+")!");
			    			} else {
			    				System.out.println("\nPlayer "+i+" lost to the dealer!");
			    				System.out.println("Their hand (" + players.get(i).getHandValue() + ") is smaller than the dealer's hand (" + players.get(0).getHandValue() + ")!");
			    				wins[0] = wins[0] + 1;
			    			}
			    		}
			    	}
			    }
		    }
		    System.out.println();
		    for(int i = 1; i <= numPlayers; i++) {
		    	System.out.println("Player "+i+" wins: "+wins[i]);
		    }
		    System.out.println("Dealer wins: "+wins[0]);
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