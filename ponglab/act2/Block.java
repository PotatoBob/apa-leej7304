//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
  private int xPos;
  private int yPos;
  private int width;
  private int height;

  private Color color;

  public Block()
  {
    this(100, 100, 50, 50);
    setColor(Color.BLUE);
  }
  public Block(int x, int y) {
    setX(x);
    setY(y);
    setWidth(50);
    setHeight(50);
    setColor(Color.BLUE);
  }

  //add other Block constructors - x , y , width, height, color
  public Block(int x, int y, int w, int h)
  {
  	setX(x);
  	setY(y);
  	setWidth(w);
  	setHeight(h);
  	setColor(Color.BLUE);
  }
  public Block(int x, int y, int w, int h, Color c)
  {
  	setX(x);
  	setY(y);
  	setWidth(w);
  	setHeight(h);
  	setColor(c);
  }
  //add the other set methods
   
  public void setX(int x)
  {
  	xPos = x;
  }
  public void setY(int y )
  {
  	yPos = y;
  }
  public void setPos(int x, int y)
  {
  	xPos = x;
  	yPos = y;
  }
  public void setWidth(int w)
  {
  	width = w;
  }
  public void setHeight(int h)
  {
  	height = h;
  }
  public void setColor(Color col)
  {
  	color = col;
  }

  public void draw(Graphics window)
  {
    window.setColor(color);
    window.fillRect(getX(), getY(), getWidth(), getHeight());
  }

  public void draw(Graphics window, Color col)
  {
  	setColor(col);
    window.setColor(color);
    window.fillRect(getX(), getY(), getWidth(), getHeight());
  }
   
  public boolean equals(Object obj)
  {
  	Block b = (Block)obj;
    return (xPos == b.getX() && yPos == b.getY() && width == b.getWidth() && height == b.getHeight() && color == b.getColor());
  }   

  //add the other get methods
  public int getX()
  {
  	return xPos;
  }
  public int getY()
  {
  	return yPos;
  }
  public int getWidth()
  {
  	return width;
  }
  public int getHeight()
  {
  	return width;
  }
  public Color getColor()
  {
  	return color;
  }

  //add a toString() method  - x , y , width, height, color
  public String toString()
  {
  	return ("("+xPos+","+yPos+") " + width+" by "+height+" "+color);
  }
}