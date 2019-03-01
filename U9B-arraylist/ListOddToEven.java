//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.List;

public class ListOddToEven
{
  public static int go( List<Integer> ray )
  {
  	int oddPos = -1;
  	int evenPos = -1;
  	for(int i = 0, len = ray.size(); i < len; i++) {
  		if(ray.get(i)%2 == 1) {
  			oddPos = i;
  			break;
  		}
  	}
  	if(oddPos == -1)
  		return -1;
  	for(int i = ray.size()-1; i > oddPos; i--) {
  		if(ray.get(i)%2 == 0) {
  			evenPos = i;
  			break;
  		}
  	}
  	if(evenPos == -1)
  		return -1;
  	return(evenPos - oddPos);
  }
}