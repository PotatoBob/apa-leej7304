//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
  //instance variables
  private int speed;

  public Paddle()
  {
    super(10,10);
    speed =5;
  }
  public Paddle(int x, int y)
  {
  	super(x,y);
  	speed = 5;
  }
  public Paddle(int x, int y, int sp)
  {
    super(x,y);
    speed = sp;
  }
  public Paddle(int x, int y, int w, int h)
  {
  	super(x,y,w,h);
  	speed = 5;
  }
  public Paddle(int x, int y, int w, int h, int sp)
  {
  	super(x,y,w,h);
  	speed = sp;
  }
  public Paddle(int x, int y, int w, int h, Color color)
  {
  	super(x,y,w,h,color);
  	speed = 5;
  }
  public Paddle(int x, int y, int w, int h, Color color, int sp)
  {
  	super(x,y,w,h,color);
  	speed = sp;
  }
  //add the other Paddle constructors

  public void moveUpAndDraw(Graphics window)
  {
  	draw(window, Color.WHITE);
  	setY(getY() - speed);
  	draw(window, getColor());

  }
  public void moveUpAndDraw(Graphics window, Color color)
  {
  	draw(window, Color.WHITE);
  	setY(getY() - speed);
  	draw(window, color);

  }

  public void moveDownAndDraw(Graphics window)
  {
  	draw(window, Color.WHITE);
  	setY(getY() + speed);
  	draw(window, getColor());

  }
  public void moveDownAndDraw(Graphics window, Color color)
  {
  	draw(window, Color.WHITE);
  	setY(getY() + speed);
  	draw(window, color);

  }

  //add get methods
  public int getSpeed()
  {
  	return speed;
  }
   
  //add a toString() method
  public String toString()
  {
  	return super.toString() + " " + speed;
  }
  public boolean equals(Object obj)
  {
  	Paddle p = (Paddle)obj;
  	return getX() == p.getX() && getY() == p.getY() && getWidth() == p.getWidth() && getHeight() == p.getHeight() && getColor() == p.getColor() && getSpeed() == p.getSpeed();
  }
}