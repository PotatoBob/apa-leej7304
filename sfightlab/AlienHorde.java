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
  private int size;

  public AlienHorde(int size)
  {
    aliens = new ArrayList<>();
    for(int i = 0; i < size; i++) {
      add(new Alien());
    }
  }

  public void add(Alien al)
  {
    aliens.add(al);
    size = aliens.size();
  }

  public void drawEmAll( Graphics window )
  {
    int count = 0;
    for(Alien al : aliens) {
      al.setX(++count*100);
      al.draw(window);
    }
  }

  public void moveEmAll()
  {
    //depends on if they all move left/right or one goes down then changes at a time
  }

  public void removeDeadOnes(List<Ammo> shots)
  {
    for(int i = getSize()-1; i >= 0; i--) {
      for(Ammo a : shots) {
        if(a.alienCollision(aliens.get(i))) {
          aliens.remove(i);
          break;
        }
      }
    }
  }

  public int getSize()
  {
    return size = aliens.size();
  }

  public String toString()
  {
    return "";
  }
}
