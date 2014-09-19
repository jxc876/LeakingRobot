import static java.lang.Math.abs;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Solution to 'Leaking Robot' problem from CodeChef.
 * http://www.codechef.com/problems/CRAWA
 * 
 * This solution emphasizes code readability & testability.
 * 
 * @author mramirez
 * @date 08/19/2014
 */
public class Main {

	public static void main(String[] args) {
		start(System.in);
	}
	
	/*
	 *  Parse input & pass it to calculate method. 
	 */
	public static void start(InputStream stream){
		Scanner scanner = new Scanner(stream);
		int numTests = scanner.nextInt();
		
		for (int i = 0; i < numTests; i++){
			
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			
			if (calculate(x, y))
				System.out.println("YES");
			else 
				System.out.println("NO");
		}
		
		if (scanner != null){
			scanner.close();
		}
	}

	/**
	 * Purpose: Figure out if the x/y coordinate lies on the robot's path.
	 * 
	 * Algorithm: Determine which quadrant the coordinate resides in, then call
	 * appropriate function to see if on path.
	 * 
	 * <pre>
	 *  Q4 | Q1
	 * ----------
	 *  Q3 | Q2
	 * </pre>
	 */
	public static boolean calculate(int x, int y) {

		if (x == 0 && y == 0)
			return true;

		if (x > 0 && y > 0)
			return isQuadrantOne(x, y);
		else if (x > 0 && y < 0)
			return isQuadrantTwo(x, y);
		else if (x < 0 && y < 0)
			return isQuadrantThree(x, y);
		else if (x < 0 && y > 0)
			return isQuadrantFour(x, y);
		else
			return false;
	}

	/**
	 * Figure out if valid point in first quadrant
	 */
	protected static boolean isQuadrantOne(int x, int y) {
		// check vertical points
		if (isDivBy1(x) && y <= x + 1) {
			return true;
		}
		// check horizontal points
		else if (isDivBy2(y) && x <= y - 1) {
			return true;
		}
		return false;
	}

	/**
	 * Figure out if valid point in second quadrant
	 */
	protected static boolean isQuadrantTwo(int x, int y) {
		// check vertical points
		if (isDivBy1(x) && abs(y) <= x - 1)
			return true;

		// check horizontal points
		if (isDivBy2(y) && x <= abs(y) + 1)
			return true;

		return false;
	}
	
	/**
	 * Figure out if the point lines in the third quadrant
	 */
	protected static boolean isQuadrantThree(int x, int y) {
		// check vertical points
		if (isDivBy2(x) && abs(y) <= abs(x))
			return true;

		// check horizontal points
		if (isDivBy2(y) && abs(x) <= abs(y))
			return true;

		return false;
	}

	/**
	 * Figure out if valid point in fourth quadrant
	 */
	protected static boolean isQuadrantFour(int x, int y) {
		// check vertical points
		if (isDivBy2(x) && y <= abs(x))
			return true;

		// check horizontal points
		if (isDivBy2(y) && abs(x) <= y)
			return true;

		return false;
	}

	public static boolean isDivBy2(int i) {
		return abs(i) % 2 == 0;
	}

	public static boolean isDivBy1(int i) {
		return abs(i) % 2 == 1;
	}

}
