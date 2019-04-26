import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
	///////////////////// constructors //////////////////////////////////

	/**
	* Constructor that takes no arguments 
	*/
	public Picture ()
	{
		/* not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor 
		 */
		super();  
	}

	/**
	* Constructor that takes a file name and creates the picture 
	* @param fileName the name of the file to create the picture from
	*/
	public Picture(String fileName)
	{
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	* Constructor that takes the width and height
	* @param height the height of the desired picture
	* @param width the width of the desired picture
	*/
	public Picture(int height, int width)
	{
		// let the parent class handle this width and height
		super(width,height);
	}

	/**
	* Constructor that takes a picture and creates a 
	* copy of that picture
	* @param copyPicture the picture to copy
	*/
	public Picture(Picture copyPicture)
	{
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	* Constructor that takes a buffered image
	* @param image the buffered image to use
	*/
	public Picture(BufferedImage image)
	{
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	* Method to return a string with information about this picture.
	* @return a string with information about the picture such as fileName,
	* height and width.
	*/
	public String toString()
	{
		String output = "Picture, filename " + getFileName() + 
		  " height " + getHeight() 
		  + " width " + getWidth();
		return output;

	}

	public void fixUnderwater()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
		  for (Pixel pixelObj : rowArray)
		  {
		    pixelObj.setBlue((int)(pixelObj.getBlue()*1.25));
		    pixelObj.setGreen((int)(pixelObj.getGreen()*0.4));
		    pixelObj.setRed((int)(pixelObj.getRed()*2.4));
		  }
		}
	}

	public void grayscaleAverage()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
		  for (Pixel pixelObj : rowArray)
		  {
		    pixelObj.setGrayAverage();
		  }
		}
	}
	public void grayscaleLightness()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
		  for (Pixel pixelObj : rowArray)
		  {
		    pixelObj.setGrayLightness();
		  }
		}
	}
	public void grayscaleLuminosity()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
		  for (Pixel pixelObj : rowArray)
		  {
		    pixelObj.setGrayLuminosity();
		  }
		}
	}

	public void negate()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
		  for (Pixel pixelObj : rowArray)
		  {
		    pixelObj.setBlue(255-pixelObj.getBlue());
		    pixelObj.setRed(255-pixelObj.getRed());
		    pixelObj.setGreen(255-pixelObj.getGreen());
		  }
		}
	}

	/** Method to set the blue to 0 */
	public void zeroBlue()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
		  for (Pixel pixelObj : rowArray)
		  {
		    pixelObj.setBlue(0);
		  }
		}
	}
	public void zeroRed()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
		  for (Pixel pixelObj : rowArray)
		  {
		    pixelObj.setRed(0);
		  }
		}
	}
	public void zeroGreen()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
		  for (Pixel pixelObj : rowArray)
		  {
		    pixelObj.setGreen(0);
		  }
		}
	}

	public void keepOnlyBlue()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
		  for (Pixel pixelObj : rowArray)
		  {
		    pixelObj.setRed(0);
		    pixelObj.setGreen(0);
		  }
		}
	}
	public void keepOnlyRed()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
		  for (Pixel pixelObj : rowArray)
		  {
		    pixelObj.setBlue(0);
		    pixelObj.setGreen(0);
		  }
		}
	}
	public void keepOnlyGreen()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
		  for (Pixel pixelObj : rowArray)
		  {
		    pixelObj.setBlue(0);
		    pixelObj.setRed(0);
		  }
		}
	}

	/** Method that mirrors the picture around a 
	* vertical mirror in the center of the picture
	* from left to right */
	public void mirrorVertical()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
		  for (int col = 0; col < width / 2; col++)
		  {
		    leftPixel = pixels[row][col];
		    rightPixel = pixels[row][width - 1 - col];
		    rightPixel.setColor(leftPixel.getColor());
		  }
		} 
	}
	public void mirrorVerticalRightToLeft()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
		  for (int col = 0; col < width / 2; col++)
		  {
		    leftPixel = pixels[row][col];
		    rightPixel = pixels[row][width - 1 - col];
		    leftPixel.setColor(rightPixel.getColor());
		  }
		} 
	}
	public void mirrorHorizontal()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel botPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length / 2; row++)
		{
		  for (int col = 0; col < width; col++)
		  {
		    topPixel = pixels[row][col];
		    botPixel = pixels[pixels.length - 1 - row][col];
		    botPixel.setColor(topPixel.getColor());
		  }
	} 
	}
	public void mirrorHorizontalBotToTop()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel botPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length / 2; row++)
		{
		  for (int col = 0; col < width; col++)
		  {
		    topPixel = pixels[row][col];
		    botPixel = pixels[pixels.length - 1 - row][col];
		    topPixel.setColor(botPixel.getColor());
		  }
		} 
	}
	public void mirrorDiagonal()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel botPixel = null;
		for (int row = 0; row < pixels.length; row++)
		{
		  for (int col = 0; col < row; col++)
		  {
		    topPixel = pixels[col][row];
		    botPixel = pixels[row][col];
		    topPixel.setColor(botPixel.getColor());
		  }
		} 
	}

	/** Mirror just part of a picture of a temple */
	public void mirrorTemple()
	{
		/*int mirrorPoint = 276;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int count = 0;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 27; row < 97; row++)
		{
		  // loop from 13 to just before the mirror point
		  for (int col = 13; col < mirrorPoint; col++)
		  {
		    count++;
		    leftPixel = pixels[row][col];      
		    rightPixel = pixels[row]                       
		                     [mirrorPoint - col + mirrorPoint];
		    rightPixel.setColor(leftPixel.getColor());
		  }
		}
		System.out.println(count);*/
		System.out.println(mirrorRectangle(13, 27, 276, 97, true));
	}
	public void mirrorArms()
	{
		/*int mirrorPoint = 191;
		Pixel topPixel = null;
		Pixel botPixel = null;
		Pixel[][] pixels = this.getPixels2D();

		for (int row = 157; row < mirrorPoint; row++)
		{
		  for (int col = 104; col < 170; col++)
		  {
		    topPixel = pixels[row][col];      
		    botPixel = pixels[mirrorPoint - row + mirrorPoint]                       
		                     [col];
		    botPixel.setColor(topPixel.getColor());
		  }
		}
		mirrorPoint = 190;
		for (int row = 170; row < mirrorPoint; row++)
		{
		  for (int col = 239; col < 294; col++)
		  {
		    topPixel = pixels[row][col];      
		    botPixel = pixels[mirrorPoint - row + mirrorPoint]                       
		                     [col];
		    botPixel.setColor(topPixel.getColor());
		  }
		}*/
		mirrorRectangle(104, 157, 170, 191, false);
		mirrorRectangle(239, 170, 294, 190, false);
	}
	public void mirrorGull()
	{
		mirrorRectangle(234, 233, 348, 326, true);
		/*int mirrorPoint = 348;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 233; row < 326; row++)
		{
		  // loop from 13 to just before the mirror point
		  for (int col = 234; col < mirrorPoint; col++)
		  {
		    leftPixel = pixels[row][col];      
		    rightPixel = pixels[row]                       
		                     [mirrorPoint - col + mirrorPoint];
		    rightPixel.setColor(leftPixel.getColor());
		  }
		}*/
	}
	public int mirrorRectangle(int x1, int y1, int x2, int y2, boolean vertical)
	{
		int mirrorPoint = 0;
		Pixel fromPixel = null;
		Pixel toPixel = null;
		int count = 0;
		Pixel[][] pixels = this.getPixels2D();
		if(vertical)
		{
			mirrorPoint = x2;
		    for (int row = y1; row < y2; row++)
		    {
		    	if(mirrorPoint > x1)
					for (int col = x1; col < mirrorPoint; col++)
					{
						count++;
						fromPixel = pixels[row][col];      
						toPixel = pixels[row]                       
						                 [mirrorPoint - col + mirrorPoint];
						toPixel.setColor(fromPixel.getColor());
					}
				else
					for (int col = x1; col > mirrorPoint; col--)
					{
						count++;
						fromPixel = pixels[row][col];      
						toPixel = pixels[row]                       
						                 [mirrorPoint - col + mirrorPoint];
						toPixel.setColor(fromPixel.getColor());
					}
		    }
		} else
		{
			mirrorPoint = y2;
			if(mirrorPoint > y1)
			    for (int row = y1; row < mirrorPoint; row++)
			    {
					for (int col = x1; col < x2; col++)
					{
						count++;
						fromPixel = pixels[row][col];      
						toPixel = pixels[mirrorPoint - row + mirrorPoint]                       
						                 [col];
						toPixel.setColor(fromPixel.getColor());
					}
			    }
			else
			    for (int row = y1; row > mirrorPoint; row--)
			    {
					for (int col = x1; col < x2; col++)
					{
						count++;
						fromPixel = pixels[row][col];      
						toPixel = pixels[mirrorPoint - row + mirrorPoint]                       
						                 [col];
						toPixel.setColor(fromPixel.getColor());
					}
			    }
		}
		return count;
	}

	/** copy from the passed fromPic to the
	* specified startRow and startCol in the
	* current picture
	* @param fromPic the picture to copy from
	* @param startRow the start row to copy to
	* @param startCol the start col to copy to
	*/
	public void copy(Picture fromPic, 
	             int startRow, int startCol)
	{
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; 
		     fromRow < fromPixels.length &&
		     toRow < toPixels.length; 
		     fromRow++, toRow++)
		{
		  for (int fromCol = 0, toCol = startCol; 
		       fromCol < fromPixels[0].length &&
		       toCol < toPixels[0].length;  
		       fromCol++, toCol++)
		  {
		    fromPixel = fromPixels[fromRow][fromCol];
		    toPixel = toPixels[toRow][toCol];
		    toPixel.setColor(fromPixel.getColor());
		  }
		}   
	}
	public void copy2(Picture fromPic, int startRow, int startCol,
	     int fromRowStart, int fromColStart, int fromRowEnd, int fromColEnd)
	 {
	   Pixel fromPixel = null;
	   Pixel toPixel = null;
	   Pixel[][] toPixels = this.getPixels2D();
	   Pixel[][] fromPixels = fromPic.getPixels2D();
	   for (int fromRow = fromRowStart, toRow = startRow; fromRow < fromRowEnd
	       && toRow < toPixels.length; fromRow++, toRow++)
	   {
	     for (int fromCol = fromColStart, toCol = startCol; fromCol < fromColEnd
	         && toCol < toPixels[0].length; fromCol++, toCol++)
	     {
	       fromPixel = fromPixels[fromRow][fromCol];
	       toPixel = toPixels[toRow][toCol];
	       toPixel.setColor(fromPixel.getColor());
	     }
	   }
	 }

	/** Method to create a collage of several pictures */
	public void createCollage()
	{
		Picture flower1 = new Picture("flower1.jpg");
		Picture flower2 = new Picture("flower2.jpg");
		this.copy(flower1,0,0);
		this.copy(flower2,100,0);
		this.copy(flower1,200,0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue,300,0);
		this.copy(flower1,400,0);
		this.copy(flower2,500,0);
		this.mirrorVertical();
		this.write("collage.jpg");
	}
	public void myCollage()
	{
		Picture flower1 = new Picture("flower1.jpg");
		Picture flower2 = new Picture("flower2.jpg");
		this.copy2(flower1,0,0,0,26,37,68);
		this.copy2(flower2,100,0,18,17,62,58);
		flower1.zeroBlue();
		this.copy(flower1,200,0);
		Picture flowerNoGreen = new Picture(flower2);
		flowerNoGreen.zeroGreen();
		this.copy(flowerNoGreen,300,0);
		flower1.zeroRed();
		this.copy(flower1,400,0);
		flower2.zeroRed();
		this.copy(flower2,500,0);
		this.mirrorVertical();
		this.write("collage2.jpg");
	}


	/** Method to show large changes in color 
	* @param edgeDist the distance for finding edges
	*/
	public void edgeDetection(int edgeDist)
	{
	Pixel leftPixel = null;
	Pixel rightPixel = null;
	Pixel[][] pixels = this.getPixels2D();
	Color rightColor = null;
	for (int row = 0; row < pixels.length; row++)
	{
	  for (int col = 0; 
	       col < pixels[0].length-1; col++)
	  {
	    leftPixel = pixels[row][col];
	    rightPixel = pixels[row][col+1];
	    rightColor = rightPixel.getColor();
	    if (leftPixel.colorDistance(rightColor) > 
	        edgeDist)
	      leftPixel.setColor(Color.BLACK);
	    else
	      leftPixel.setColor(Color.WHITE);
	  }
	}
	}


	/* Main method for testing - each class in Java can have a main 
	* method 
	*/
	public static void main(String[] args) 
	{
		Picture flower1 = new Picture("flower1.jpg");
		flower1.explore();
		Picture flower2 = new Picture("flower2.jpg");
		flower2.explore();
	}
  
} // this } is the end of class Picture, put all new methods before this
