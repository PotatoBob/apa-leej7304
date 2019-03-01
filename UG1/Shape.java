//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Shape
{
   //instance variables
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color color;

   public Shape(int x, int y, int wid, int ht, Color col)
   {
		xPos = x;
		yPos = y;
		width = wid;
		height = ht;
		color = col;
   }


   public void draw(Graphics window)
   {
      window.setColor(color);
      window.fillRect(xPos, yPos, width, height);

      //draw whatever you want
      //    ^
      //  [ :: ]
      //    ()

   }

   //BONUS
   //add in set and get methods for all instance variables
   public int getX() {
   	return xPos;
   }
   public void setX(int x) {
   	xPos = x;
   }
   public int getY() {
   	return yPos;
   }
   public void setY(int y) {
   	yPos = y;
   }
   public int getWidth() {
   	return width;
   }
   public void setWidth(int w) {
   	width = w;
   }
   public int getHeight() {
   	return height;
   }
   public void setHeight(int h) {
   	height = h;
   }
   public Color getColor() {
   	return color;
   }
   public void setColor(Color col) {
   	color = col;
   }

   public String toString()
   {
   	return xPos+" "+yPos+" "+width+" "+height+" "+color;
   }
}