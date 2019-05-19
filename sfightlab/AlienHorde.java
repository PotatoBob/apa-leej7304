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
  private final int ALIEN_SPEED = 2;

  public AlienHorde(int size)
  {
    aliens = new ArrayList<>();
    int colMult = 1; int rowMult = 2;
    for(int i = 1; i <= size; i++) {
    	add(new Alien(2*ALIEN_SIZE*i, ALIEN_SIZE, ALIEN_SIZE, ALIEN_SIZE, ALIEN_SPEED));
    }
  }

  public void add(Alien al)
  {
    aliens.add(al);
  }

  public void drawEmAll( Graphics window )
  {
    int count = 0;
    for(Alien al : aliens) {
		//al.setX(++count*100);
		al.draw(window);
    }
  }

  public void moveEmAll()
  {
    for(Alien al : aliens) {
    	al.move();
    }
  }

  public void removeDeadOnes(List<Ammo> shots)
  {
    for(int i = getSize()-1; i >= 0; i--) {
      for(Ammo a : shots) {
      	try {
	        if(a.alienCollision(aliens.get(i))) {
	          aliens.remove(i);
	          break;
	        }
	    } catch(NullPointerException e) {
	    	continue;
	    }
      }
    }
  }

  public boolean gameOver()
  {
    if(aliens.get(0).getY() + aliens.get(0).getHeight() > 575)
      return true;
    return false;
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
