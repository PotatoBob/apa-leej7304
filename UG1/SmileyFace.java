//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;
import javax.swing.JFrame;

public class SmileyFace extends JFrame
{
   public SmileyFace()    //constructor - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      smileyFace(window);
   }

   public void smileyFace( Graphics window )
   {
      window.setColor(Color.BLUE);
      window.drawString("SMILEY FACE LAB ", 35, 35);

      window.setColor(Color.YELLOW);
      window.fillOval( 210, 100, 400, 400 );

		//add more code here
      
      //left eye
      window.setColor(Color.GREEN);
      window.fillOval(270, 200, 80, 80);

      //right eye
      window.fillOval(470, 200, 80, 80);

      //nose
      window.setColor(Color.BLACK);
      window.fillOval(370, 260, 80, 80);

      //smile
      window.setColor(Color.RED);
      window.drawArc(210, 200, 400, 200, -150, 120);

   }
}