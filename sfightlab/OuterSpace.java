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
import java.awt.Font;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
  private Ship ship;
  private final int FONT_SIZE = 100;

  /* uncomment once you are ready for this part
   **/
   private AlienHorde horde;
   private Bullets shots;

   private int love; //determines endgame
  

  private boolean[] keys;
  private BufferedImage back;

  public OuterSpace()
  {
    setBackground(Color.black);

    keys = new boolean[5];

    //instantiate other instance variables
    //Ship, Alien

    ship = new Ship(400,300,30,30,5);
    horde = new AlienHorde(20);
    shots = new Bullets();

  	love = 0;

    this.addKeyListener(this);
    new Thread(this).start();

    setVisible(true);
  }

  public void update(Graphics window)
  {
    paint(window);
  }

  public void paint( Graphics window )
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

    graphToBack.setColor(Color.BLACK);
    graphToBack.fillRect(0,0,800,600);
    graphToBack.setColor(Color.BLUE);
    graphToBack.drawString("StarFighter ", 25, 50 );
    graphToBack.setColor(Color.YELLOW); // for ammo

    ship.draw(graphToBack);

    if(keys[0])
    {
      ship.move("LEFT");
    }
    if(keys[1])
    {
      ship.move("RIGHT");
    }
    if(keys[2])
    {
      ship.move("UP");
    }
    if(keys[3])
    {
      ship.move("DOWN");
    }
    if(keys[4])
    {
      shots.add(new Ammo((ship.getX() + ship.getWidth() / 2) - 5, ship.getY() - 5, 5));
    }
    shots.moveEmAll();
    shots.drawEmAll(graphToBack);
    // shots.cleanEmUp();
    horde.removeDeadOnes(shots.getList());
    horde.moveEmAll();
    horde.drawEmAll(graphToBack);

    if(horde.getSize() == 0) {
	    graphToBack.setColor(Color.BLACK);
	    graphToBack.fillRect(0,0,800,600);
	    graphToBack.setColor(Color.GREEN);
	    graphToBack.setFont(new Font("SansSerif", Font.BOLD, FONT_SIZE));
	    graphToBack.drawString("YOU WON!", 10, 300 );
	    ship = new Ship(550, 200, 120, 120, 0);
	    ship.draw(graphToBack);
	    love = 3000;
    } else if(horde.gameOver()) {
	    graphToBack.setColor(Color.BLACK);
	    graphToBack.fillRect(0,0,800,600);
	    graphToBack.setColor(Color.RED);
	    graphToBack.setFont(new Font("SansSerif", Font.BOLD, FONT_SIZE));
	    graphToBack.drawString("YOU LOST!", 10, 300 );
	    Alien alien = new Alien(550, 200, 120, 120, 0);
	    alien.draw(graphToBack);
	    love = 3000;
    }

    twoDGraph.drawImage(back, null, 0, 0);
  }


  public void keyPressed(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      keys[0] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      keys[1] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      keys[2] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      keys[3] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
      keys[4] = true;
    }
    repaint();
  }

  public void keyReleased(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      keys[0] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      keys[1] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      keys[2] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      keys[3] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
      keys[4] = false;
    }
    repaint();
  }

  public void keyTyped(KeyEvent e)
  {
  }

  public void run()
  {
    try
    {
      while(true)
      {
        Thread.currentThread().sleep(5);
        repaint();
        if(3000 == love)
        	break;
      }
    }catch(Exception e)
    {
    }
  }
}

