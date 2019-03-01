//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.List;
import java.util.ArrayList;

public class ListSumFirst
{
  public static int go(int[] ray)
  {
    if(ray.length <= 1)
    	return -1;
    int first = ray[0];
    int sum = 0;
    boolean larger = false;
    for(int i : ray) {
    	if(i > first) {
    		sum += i;
    		larger = true;
    	}
    }
    if(!larger) {
    	return -1;
    }
    return sum;
  }
}