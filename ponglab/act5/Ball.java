//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
  private int xSpeed;
  private int ySpeed;

  public Ball()
  {
    //super(200,200);
    
    super ((int)(Math.random() * 450) + 20, (int)(Math.random() * 450) + 20);
    
    xSpeed = 3;
    ySpeed = 3;
    
    if ((int)(Math.random() * 2) == 1) {
      xSpeed = -1 * xSpeed;
    }
    
    if ((int)(Math.random() * 2) == 1) {
      ySpeed = -1 * ySpeed;
    }
    
  setWidth(20);
  setHeight(20);
       
       setColor(Color.GREEN);
  }


   public Ball(int i, int j, int k, int l, Color blue) {
    // TODO Auto-generated constructor stub
     super(i, j);
     xSpeed = k;
     ySpeed = l;
     setColor(blue);
     setWidth(20);
     setHeight(20);
  }

   public Ball(int i, int j, int w, int h) {
  // TODO Auto-generated constructor stub
     
     super(i, j);
     xSpeed = w;
     ySpeed = h;

     setColor(Color.GREEN);
     setWidth(20);
     setHeight(20);
}

public Ball(int i, int j) {
  // TODO Auto-generated constructor stub
  
  super(i, j);
  setColor(Color.GREEN);
  setWidth(20);
  setHeight(20);
}

public Ball(int i, int j, int k, int l, Color blue, int m, int n) {
  // TODO Auto-generated constructor stub
  
   super(i, j);
     xSpeed = m;
     ySpeed = n;
     setColor(blue);

  setWidth(k);
  setHeight(l);
}

public Ball(int x, int y, int wid, int ht, int xSpd, int ySpd) {
  super(x, y);
     xSpeed = xSpd;
     ySpeed = ySpd;
     setColor(Color.GREEN);

  setWidth(wid);
  setHeight(ht);
}

public void moveAndDraw(Graphics window)
   {
    draw(window, Color.WHITE);
    setX(getX()+xSpeed);
    setY(getY()+ySpeed);
    
    draw(window, getColor());
   }
   
  public boolean equals(Object obj)
  {
    return this == obj;
  }

  @Override
  public String toString() {
    return "Ball [xSpeed=" + xSpeed + ", ySpeed=" + ySpeed + "]";
  }

  public int getXSpeed() {
    // TODO Auto-generated method stub
    return xSpeed;
  }

  public void setXSpeed(int i) {
    xSpeed = i;
    
  }

  public int getYSpeed() {
    // TODO Auto-generated method stub
    return ySpeed;
  }

  public void setYSpeed(int i) {
    // TODO Auto-generated method stub
    ySpeed = i;
  }

  @Override
  public boolean didCollideLeft(Object obj) {
    Block temp = (Block)obj;
    return (getX()<=temp.getX()+temp.getWidth()) && didCollideTop(obj) && didCollideBottom(obj);
  }

  @Override
  public boolean didCollideRight(Object obj) {
    Block temp = (Block)obj;
    return (getX()>=temp.getX()) && didCollideTop(obj) && didCollideBottom(obj);
  }

  @Override
  public boolean didCollideTop(Object obj) {
    Block temp = (Block)obj;
    return getY()<=temp.getY()+temp.getHeight();
  }

  @Override
  public boolean didCollideBottom(Object obj) {
    Block temp = (Block)obj;
    return getY()>=temp.getY();
  }   

}

