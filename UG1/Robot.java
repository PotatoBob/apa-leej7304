//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

class Robot extends Canvas
{
  public Robot()    //constructor method - sets up the class
  {
    setSize(800,600);
    setBackground(Color.WHITE);   	
    setVisible(true);
  }
  
  public void paint( Graphics window )
  {
    window.setColor(Color.BLUE);
    
    window.drawString("Robot LAB ", 35, 35 );
    
    //call head method
    head(window);
    //call other methods
    upperBody(window);
    lowerBody(window);
  }
  
  public void head( Graphics window )
  {
    window.setColor(Color.YELLOW);
    
    window.fillOval(300, 100, 200, 100);

    //add more code here
    window.setColor(Color.BLACK);
    window.fillOval(350, 120, 30, 60);
    window.fillOval(420, 120, 30, 60);

    window.setColor(Color.GREEN);
    window.fillArc(330, 80, 30, 60, 150, -120);
    window.fillArc(440, 80, 30, 60, 150, -120);
  }

  public void upperBody( Graphics window )
  {
    window.setColor(Color.BLUE);
    window.fillRect(250, 200, 300, 200);

    window.setColor(Color.GREEN);
    window.fillRect(200, 200, 50, 200);
    window.setColor(Color.BLACK);
    window.drawRect(200, 200, 50, 200);


    window.setColor(Color.GREEN);
    window.fillRect(550, 200, 50, 200);
    window.setColor(Color.BLACK);
    window.drawRect(550, 200, 50, 200);
  }

  public void lowerBody( Graphics window )
  {
    window.setColor(Color.GREEN);
    window.fillRect(250, 400, 50, 200);
    window.fillRect(500, 400, 50, 200);
    window.setColor(Color.BLACK);
    window.drawRect(250, 400, 50, 200);
    window.drawRect(500, 400, 50, 200);
  }
}
