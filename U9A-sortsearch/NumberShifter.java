//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;
import java.util.Random;

public class NumberShifter
{
	public static String toString(int[] array) {
		String ans = "";
		for(int i: array) {
			ans += i + ",";
		}
		return "[" + ans + "]";
	}
	public static int[] makeLucky7Array(int[] array)
	{
		int pos = 0;
		while(array[pos] == 7)
			pos++;
		for(int i = pos, len = array.length; i < len; i++) {
			if(array[i] == 7) {
				array[i] = array[pos];
				array[pos] = 7;
				pos++;
			}
		}
		return array;
	}
}