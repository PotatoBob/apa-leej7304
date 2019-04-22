//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;
import java.awt.Color;

class BallTestOne
{
  public static void main( String args[] )
  {
    Ball one = new Ball();
    System.out.println(one);
		
    Ball two = new Ball(100,90);
    System.out.println(two);
		
    Ball three = new Ball(100,100,30,50);
    System.out.println(three);
		
    Ball four = new Ball(100,100,30,50,Color.BLUE);
    System.out.println(four);
		
    Ball five = new Ball(100,100,30,50,Color.BLUE,5,6);
    System.out.println(five);
		
    //x, y, wid, ht, color, xSpd, ySpd
    Ball six = new Ball(100,100,30,50,Color.blue,5,6);
    System.out.println(six);		
		
    System.out.println(five.equals(four));		
		
    System.out.println(five.equals(five));										
  }
}