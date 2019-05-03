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
    this.size = size;
  }

  public void add(Alien al)
  {
    aliens.add(al);
  }

  public void drawEmAll( Graphics window )
  {
    int count = 0;
    for(Alien al : aliens) {
      al.setX(++count*50);
      al.draw(window)
    }
  }

  public void moveEmAll()
  {
    //depends on if they all move left/right or one goes down then changes at a time
  }

  public void removeDeadOnes(List<Ammo> shots)
  {
    
  }

  public String toString()
  {
    return "";
  }
}
