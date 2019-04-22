//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable
{
  //private Ball ball;
  private Paddle leftPaddle;
  private Paddle rightPaddle;
  private boolean[] keys;
  private BufferedImage back;
  private Score score;
  private Wall top;
  private Wall bottom;
  private Wall right;
  private Wall left;
  private BlinkyBall ball;


  public Pong()
  {
    //set up all variables related to the game
    //ball = new Ball(200,200,4,4, Color.BLACK, 4, 3);
    ball = new BlinkyBall(200,200,4,4, Color.BLACK, 4, 3);
    leftPaddle = new Paddle(30, 300, 5, 100, Color.RED, 5);
    rightPaddle = new Paddle(750, 300, 5, 100, Color.RED, 5);

    keys = new boolean[4];

    top = new Wall(0, 50, 800, 1);

    bottom = new Wall(0, 550, 800, 1);

    left = new Wall(0, 0, 1, 600);

    right = new Wall(780, 0, 1, 600);

    score = new Score();

    
    setBackground(Color.WHITE);
    setVisible(true);
		
    new Thread(this).start();
    addKeyListener(this);		//starts the key thread to log key strokes
  }
	
  public void update(Graphics window){
    paint(window);
  }

  public void paint(Graphics window)
  {
    //set up the double buffering to make the game animation nice and smooth
    Graphics2D twoDGraph = (Graphics2D)window;

    //take a snap shop of the current screen and same it as an image
    //that is the exact same width and height as the current screen
    if(back==null)
      back = (BufferedImage)(createImage(getWidth(),getHeight()));

    //create a graphics reference to the back ground image
    //we will draw all changes on the background image
    Graphics graphToBack = back.createGraphics();


    ball.moveAndDraw(graphToBack);
    leftPaddle.draw(graphToBack);
    rightPaddle.draw(graphToBack);


    //see if the ball hits the paddle
    if(ball.didCollideLeft(leftPaddle) || ball.didCollideRight(rightPaddle))
    {
      ball.setXSpeed(-ball.getXSpeed());
    }


    //see if ball hits left wall or right wall
    if((ball.didCollideRight(right))) //hits right wall FROM left
    {
      ball.setXSpeed(0);
      
      ball.setYSpeed(0);

      score.leftPoint();
      System.out.println(score);
    ball.draw(graphToBack, Color.WHITE);
    ball = new BlinkyBall(200,200,4,4, Color.BLACK, 4, 3);

    }
    if ((ball.didCollideLeft(left))) //hits left wall FROM right
    {
      ball.setXSpeed(0);
      
      ball.setYSpeed(0);

      score.rightPoint();
      System.out.println(score);
    ball.draw(graphToBack, Color.WHITE);
    ball = new BlinkyBall(200,200,4,4, Color.BLACK, 4, 3);

    }

		
    //see if the ball hits the top or bottom wall 
    if((ball.didCollideBottom(bottom) || ball.didCollideTop(top)))
    {
      ball.setYSpeed(-ball.getYSpeed());
    }

		
    //see if the paddles need to be moved
    if (keys[0])
    {
      //move left paddle up and draw it on the window
      leftPaddle.moveUpAndDraw(graphToBack);
    }
    if (keys[1])
    {
      //move left paddle down and draw it on the window
      leftPaddle.moveDownAndDraw(graphToBack);

    }
    if (keys[2])
    {
      rightPaddle.moveUpAndDraw(graphToBack);
    }
    if (keys[3])
    {
      rightPaddle.moveDownAndDraw(graphToBack);
    }

    twoDGraph.drawImage(back, null, 0, 0);
  }

  public void keyPressed(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=true; break;
    case 'Z' : keys[1]=true; break;
    case 'I' : keys[2]=true; break;
    case 'M' : keys[3]=true; break;
    }
  }

  public void keyReleased(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=false; break;
    case 'Z' : keys[1]=false; break;
    case 'I' : keys[2]=false; break;
    case 'M' : keys[3]=false; break;
    }
  }

  public void keyTyped(KeyEvent e){}
	
  public void run()
  {
    try
    {
      while(true)
      {
	Thread.currentThread().sleep(8);
	repaint();
      }
    }catch(Exception e)
    {
    }
  }	
}