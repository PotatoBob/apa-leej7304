//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
{
  private int xSpeed;
  private int ySpeed;

  public Ball()
  {
    super(200,200);
    xSpeed = 3;
    ySpeed = 1;
  }

  //add the other Ball constructors
  public Ball(int x, int y)
  {
  	super(x,y);
  	xSpeed = 3;
  	ySpeed = 1;
  }
  public Ball(int x, int y, int width, int height)
  {
  	super(x,y,width,height);
  	xSpeed = 3;
  	ySpeed = 1;
  }
  public Ball(int x, int y, int width, int height, Color color)
  {
  	super(x,y,width,height,color);
  	xSpeed = 3;
  	ySpeed = 1;
  }
  public Ball(int x, int y, int width, int height, Color color, int xSpd, int ySpd)
  {
  	super(x,y,width,height,color);
  	xSpeed = xSpd;
  	ySpeed = ySpd;
  }
  //add the set methods
  public void setXSpeed(int x)
  {
  	xSpeed = x;
  }
  public void setYSpeed(int y)
  {
  	ySpeed = y;
  }
  public void setAll(int x, int y, int width, int height, Color color, int xSpd, int ySpd)
  {
   super.setPos(x, y);
   super.setDimensions(width, height);
   super.setColor(color);
   xSpeed = xSpd;
   ySpeed = ySpd;
  }

  public void moveAndDraw(Graphics window)
  {
    //draw a white ball at old ball location
  	draw(window, Color.WHITE);

    setX(getX()+xSpeed);
    //setY
    setY(getY()+ySpeed);
    //draw the ball at its new location
    draw(window, getColor());
  }
   
  public boolean equals(Object obj)
  {
  	Ball b = (Ball)obj;
  	return getX() == b.getX() && getY() == b.getY() && getWidth() == b.getWidth() && getHeight() == b.getHeight() && getColor() == b.getColor() && getXSpeed() == b.getXSpeed() && getYSpeed() == b.getYSpeed();
  }

  //add the get methods
  public int getXSpeed()
  {
  	return xSpeed;
  }
  public int getYSpeed()
  {
  	return ySpeed;
  }

  //add a toString() method
  public String toString()
  {
  	return super.toString() + " " + xSpeed + " " + ySpeed;
  }
}