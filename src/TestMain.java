import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

public class TestMain extends Main {

	@Test
	public void testZero() {
		Assert.assertTrue(calculate(0, 0));
		Assert.assertTrue(calculate(3, 3));
		Assert.assertFalse(calculate(3, 5));
	}

	/**
	 * Test (X, Y) values
	 */
	@Test
	public void testIsQuadrantOne() {

		// end-points
		Assert.assertTrue(calculate(1, 2));
		Assert.assertTrue(calculate(3, 4));
		Assert.assertTrue(calculate(5, 6));
		Assert.assertTrue(calculate(7, 8));

		// vertical edge points
		Assert.assertTrue(calculate(3, 2));
		Assert.assertTrue(calculate(7, 5));

		// horizontal edge points
		Assert.assertTrue(calculate(3, 6));
		Assert.assertTrue(calculate(4, 8));

		// negative tests
		Assert.assertFalse(calculate(2, 3));
		Assert.assertFalse(calculate(6, 1));
	}

	/**
	 * Test (X, -Y) values
	 */
	@Test
	public void testIsQuadrantTwo() {

		// end-points
		Assert.assertTrue(calculate(3, -2));
		Assert.assertTrue(calculate(5, -4));
		Assert.assertTrue(calculate(7, -6));
		Assert.assertTrue(calculate(9, -8));

		// vertical edge points
		Assert.assertTrue(isQuadrantTwo(5, -2));
		Assert.assertTrue(isQuadrantTwo(7, -3));

		// horizontal edge points
		Assert.assertTrue(calculate(1, -4));
		Assert.assertTrue(calculate(3, -6));

		// negative tests
		Assert.assertFalse(calculate(2, -1));
		Assert.assertFalse(calculate(4, -3));
	}

	/**
	 * Test (-X, -Y) values
	 */
	@Test
	public void testIsQuadrantThree() {
		// end-points
		Assert.assertTrue(calculate(-2, -2));
		Assert.assertTrue(calculate(-4, -4));
		Assert.assertTrue(calculate(-6, -6));
		Assert.assertTrue(calculate(-8, -8));

		// vertical edge points
		Assert.assertTrue(calculate(-2, -1));
		Assert.assertTrue(calculate(-4, -3));

		// horizontal edge points
		Assert.assertTrue(calculate(-4, -2));
		Assert.assertTrue(calculate(-6, -2));

		// negative tests
		Assert.assertFalse(calculate(-2, -3));
		Assert.assertFalse(calculate(-5, -5));
	}

	/**
	 * Test (-X, Y) values
	 */
	@Test
	public void testIsQuadrantFour() {
		// end-points
		Assert.assertTrue(calculate(-2, 2));
		Assert.assertTrue(calculate(-4, 4));
		Assert.assertTrue(calculate(-6, 6));
		Assert.assertTrue(calculate(-8, 8));

		// vertical edge points
		Assert.assertTrue(calculate(-4, 2));
		Assert.assertTrue(calculate(-6, 3));

		// horizontal edge points
		Assert.assertTrue(calculate(-2, 4));
		Assert.assertTrue(calculate(-4, 6));

		// negative tests
		Assert.assertFalse(calculate(-2, 5));
		Assert.assertFalse(calculate(-5, 5));
	}

	/**
	 * Verify that we are parsing input correctly.
	 */
	@Test
	public void testInput() {
		String input = "3\n  3 3\n  3 5\n  0 0";
		InputStream stream = new ByteArrayInputStream(input.getBytes());
		start(stream);
	}
}
