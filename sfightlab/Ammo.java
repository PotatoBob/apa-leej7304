//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
  private int speed;
  private boolean draw;

  public Ammo()
  {
    this(0,0,0);
  }

  public Ammo(int x, int y)
  {
    this(x,y,0);
  }

  public Ammo(int x, int y, int s)
  {
    super(x,y,10,10);
    speed = s;
  }

  public void setSpeed(int s)
  {
    speed = s;
  }

  public int getSpeed()
  {
    return speed;
  }

  public void setDraw(boolean draw) {
    this.draw = draw;
  }

  public void draw( Graphics window )
  {
    if(draw)
      window.fillRect(getX(),getY(),getWidth(),getHeight());
  }
        
        
  public void move( String direction )
  {
    if(direction.equals("UP")) {
      setY(getY() - getSpeed());
    }
    if(direction.equals("DOWN")) {
      setY(getY() + getSpeed());
    }
  }

  public String toString()
  {
    return super.toString() + getSpeed();
  }
}
