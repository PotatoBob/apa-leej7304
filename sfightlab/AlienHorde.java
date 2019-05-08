//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
  private List<Alien> aliens;
  private final int ALIEN_SIZE = 30;
  private final int ALIEN_SPEED = 1;

  public AlienHorde(int size)
  {
    aliens = new ArrayList<>();
    for(int i = 0; i < size; i++) {
		// add(new Alien(2*ALIEN_SIZE*i, -2*ALIEN_SIZE, ALIEN_SIZE, ALIEN_SIZE, ALIEN_SPEED));
    	add(new Alien(2*ALIEN_SIZE*i, 0));
    }
  }

  public void add(Alien al)
  {
    aliens.add(al);
  }

  public void drawEmAll( Graphics window ) throws NullPointerException
  {
    int count = 0;
    for(Alien al : aliens) {
    	try {
			//al.setX(++count*100);
			al.draw(window);
		} catch(NullPointerException e) {
			count++;
		}
    }
    /*for(Alien al : aliens) {
    	try {
	    	al.draw(window);
    	} catch(NullPointerException e) {
    		e.printStackTrace();
    	}
    }*/
  }

  public void moveEmAll()
  {
    //depends on if they all move left/right or one goes down then changes at a time
    /*for(Alien al : aliens) {
    	try {
	    	al.move();
    	} catch(NullPointerException e) {
    		e.printStackTrace();
    	}
    }*/
  }

  public void removeDeadOnes(List<Ammo> shots)
  {
    for(int i = getSize()-1; i >= 0; i--) {
      for(Ammo a : shots) {
      	try {
	        if(a.alienCollision(aliens.get(i))) {
	          aliens.set(i,null);
	          break;
	        }
	    } catch(NullPointerException e) {
	    	continue;
	    }
      }
    }
  }

  public int getSize()
  {
    return aliens.size();
  }

  public String toString()
  {
    return "";
  }
}
