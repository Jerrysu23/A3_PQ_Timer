package assign03;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class is for testing the class SimplePriorityQueueTest.
 * 
 * @author Junlin Su, Luan Xing.
 * @version February 10, 2021
 * 
 */

// Set up a instant value
class SimplePriorityQueueTester {
	private SimplePriorityQueue<Integer> intSeries;

	@BeforeEach
	void setUP() throws Exception {
		intSeries = new SimplePriorityQueue<Integer>();
	}

	@Test
	// Test
	// isEmpty-----------------------------------------------------------------------

	void testisEmpty() {

		assertEquals(true, intSeries.isEmpty());

	}

	// Test Emptyfalse
	@Test
	void testIsEmptyFalse() {
		// create a int list.
		List<Integer> size = List.of(2, 4, 6, 7, 8, 9, 100, 666, 888);
		intSeries.insertAll(size);
		assertFalse(intSeries.isEmpty());
	}

	// Test smallest
	@Test
	void testToFindMin() {

		// build a list
		intSeries.insert(2);
		intSeries.insert(4);
		intSeries.insert(6);
		intSeries.insert(8);
		intSeries.insert(666);
		intSeries.insert(888);
		assertEquals(2, intSeries.findMin());
	}

	@Test
	void testToFindMin2() {
		// create a string type
		SimplePriorityQueue<String> words = new SimplePriorityQueue<String>();
		// insert "apple", "Orange", "Peach"these String
		words.insert("Apple");
		words.insert("Orange");
		words.insert("Peach");
		assertEquals("Apple", words.findMin());
	}

	@Test
	void testToFindMin3() {

		// build a list
		intSeries.insert(2);//insert data.
		intSeries.insert(4);
		intSeries.insert(6);
		intSeries.insert(8);
		intSeries.insert(666);
		intSeries.insert(888);
		assertEquals(2, intSeries.findMin());
	}

	@Test
	void testToFindMin4() {
		List<Integer> list = List.of(8, 6, 888, 666);
		intSeries.insertAll(list);
		assertEquals(6, intSeries.findMin());
	}
	

	@Test
	void testToDeleteMin() {

		intSeries.insert(1);
		intSeries.insert(12);
		intSeries.insert(365);
		intSeries.insert(4);
		intSeries.insert(7);
		intSeries.insert(24);

		assertEquals(1, intSeries.deleteMin());
	}

	@Test
	void testToDeleteMin2() {
		SimplePriorityQueue<Double> testDouble = new SimplePriorityQueue<Double>();
		testDouble.insert(1.1);
		testDouble.insert(6.6);
		testDouble.insert(8.8);
		assertEquals(1.1, testDouble.deleteMin());
	}

	@Test

	void testSize() {
		intSeries.insert(365);
		intSeries.insert(89);
		intSeries.insert(33);
		intSeries.insert(1);
		intSeries.insert(5678);
		intSeries.insert(1000);

		assertEquals(6, intSeries.size());
	}

	@Test
	void testClear() {

		intSeries.insert(365);
		intSeries.insert(89);
		intSeries.insert(33);
		intSeries.insert(1);
		intSeries.insert(5678);
		intSeries.insert(1000);
		intSeries.clear();
		assertEquals(true, intSeries.isEmpty());
		;
	}

	@Test
	void testEmptyArray() {
		int size = 0;
		assertEquals(size, intSeries.size());
	}
}
