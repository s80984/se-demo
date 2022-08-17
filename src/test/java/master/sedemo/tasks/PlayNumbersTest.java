package master.sedemo.tasks;

import master.sedemo.tasks.PlayNumbers;
import org.junit.jupiter.api.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;


/**
 * Test class to for PlayNumbers class.
 * 
 * @author sgra64
 *
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlayNumbersTest {
	//
	// test object, created for each test-run that executes one @Test method
	private final PlayNumbers pn = new PlayNumbers();
	//
	// test numbers
	private static final int[] numbers   = {-2, 4, 9, 4, -3, 4, 9, 5};
	private static final int[] numbers_2 = {8, 10, 2, 14, 4};
	private static final int[] numbers_3 = {2, 14, 23, 8, 48, 15, 97, 10, 28, 4, 3};


	// test methods
	@Test @Order(100)
	void test100_sum() {
		int result = pn.sum(numbers);
		assertEquals(30, result);		// expected sum of numbers[] is 30
		result = pn.sum(numbers_2);
		assertEquals(38, result);		// expected sum of numbers_2[] is 38
		//
		result = pn.sum(numbers_3);
		assertEquals(252, result);		// expected sum of numbers_3[] is 252
	}
/*
	@Test @Order(200)
	void test200_sumPositiveEvenNumbers() {
		int result = pn.sumPositiveEvenNumbers(numbers);
		assertEquals(12, result);
		result = pn.sumPositiveEvenNumbers(numbers_2);
		assertEquals(38, result);
		//
		result = pn.sumPositiveEvenNumbers(numbers_3);
		assertEquals(114, result);
	}

	@Test @Order(300)
	void test300_findFirst() {
		int result = pn.findFirst(4, numbers);
		assertEquals(1, result);
		result = pn.findFirst(-3, numbers);
		assertEquals(4, result);
		result = pn.findFirst(1, numbers);
		assertEquals(-1, result);
		//
		result = pn.findFirst(23, numbers_3);
		assertEquals(2, result);
	}

	@Test @Order(310)
	void test310_findLast() {
		int result = pn.findLast(4, numbers);
		assertEquals(5, result);
		result = pn.findLast(-3, numbers);
		assertEquals(4, result);
		result = pn.findLast(1, numbers);
		assertEquals(-1, result);
		//
		result = pn.findLast(10, numbers_3);
		assertEquals(7, result);
	}

	@Test @Order(320)
	void test320_findAll() {
		int result[] = pn.findAll(4, numbers);
		assertArrayEquals(new int[] {1, 3, 5}, result);
		result = pn.findAll(-3, numbers);
		assertArrayEquals(new int[] {4}, result);
		result = pn.findAll(1, numbers);
		assertArrayEquals(new int[] {}, result);
		//
		result = pn.findAll(10, numbers_3);
		assertArrayEquals(new int[] {7}, result);
	}

	@Test @Order(400)
	void test400_findAllAdjacent() {
		int result[][] = pn.findAllAdjacent(4, 9, numbers);
		assertArrayEquals(new int[][] {{1, 2}, {5, 6}}, result);
		result = pn.findAllAdjacent(9, 4, numbers);
		assertArrayEquals(new int[][] {{2, 3}}, result);
		result = pn.findAllAdjacent(2, 3, numbers);
		assertArrayEquals(new int[][] {}, result);
		//
		result = pn.findAllAdjacent(97, 10, numbers_3);
		assertArrayEquals(new int[][] {{6, 7}}, result);
	}

	@Test @Order(500)
	void test500_findSums() {
		int result[][] = pn.findSums(10, numbers_2);
		assertArrayEquals(new int[][] {{8, 2}}, result);
		result = pn.findSums(12, numbers_2);
		assertArrayEquals(new int[][] {{8, 4}, {10, 2}}, result);
		result = pn.findSums(15, numbers_2);
		assertArrayEquals(new int[][] {}, result);
		//
		result = pn.findSums(18, numbers_3);
		assertArrayEquals(new int[][] {{14, 4}, {8, 10}, {15, 3}}, result);
	}

	@Test @Order(600)
	void test600_findAllSums() {
		int result[][] = pn.findAllSums(14, numbers_2);
		assertArrayEquals(new int[][] {{14}, {10, 4}, {8, 2, 4}}, result);
		result = pn.findAllSums(20, numbers_2);
		assertArrayEquals(new int[][] {{8, 10, 2}, {2, 14, 4}}, result);
		result = pn.findAllSums(32, numbers_2);
		assertArrayEquals(new int[][] {{8, 10, 14}}, result);
		result = pn.findAllSums(33, numbers_2);
		assertArrayEquals(new int[][] {}, result);
		//
		result = pn.findAllSums(28, numbers_3);
		assertArrayEquals(new int[][] {
			{28}, {2, 14, 8, 4}, {14, 10, 4}, {2, 23, 3}, {2, 8, 15, 3}, {15, 10, 3}
		}, result);
	}
*/
}
