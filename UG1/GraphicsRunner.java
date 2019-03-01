//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import javax.swing.JFrame;
import java.awt.Color;

public class GraphicsRunner extends JFrame
{
  private static final int WIDTH = 800;
  private static final int HEIGHT = 600;
  
  public GraphicsRunner()
  {
    super("Graphics Runner");
      
    setSize(WIDTH,HEIGHT);
    
    //getContentPane().add(new SmileyFace());
    //getContentPane().add(new BigHouse());
    //getContentPane().add(new ShapePanel());
    getContentPane().add(new Robot());
    //add other classes to run them 
    //BigHouse, Robot, or ShapePanel 
    
    setVisible(true);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public static void main(String args[])
  {
    GraphicsRunner run = new GraphicsRunner();
  }
}