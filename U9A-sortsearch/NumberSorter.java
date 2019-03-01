//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays; 
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSorter
{
	//instance variables and other methods not shown

	private static int getNumDigits(int number)
	{
		int count = 0;
		while(number != 0) {
			count++;
			number /= 10;
		}
		return count;
	}

	public static int[] getSortedDigitArray(int number)
	{
		int numDigits = getNumDigits(number);
		int[] sorted = new int[numDigits];
		for(int i = 0; i < numDigits; i++) {
			sorted[i] = number % 10;
			number /= 10;
		}
		Arrays.sort(sorted);
		return sorted;
	}
}