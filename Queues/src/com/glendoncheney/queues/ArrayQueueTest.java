package com.glendoncheney.queues;

import java.util.Arrays;

/**
 * Test class for the ArrayQueue
 * @author glendon cheney
 *
 */
public class ArrayQueueTest {

	/**
	 * Test: constructor
	 */
	public static void test_constructor() {
		System.out.println("Test: constructor");
		
		printTestStatement("Queue q = new ArrayQueue(3);");
		Queue<Object> q = new ArrayQueue<Object>(3);
		printTestResult("q.size() == 0", q.size(), 0);
		
		System.out.println();
	}

	/**
	 * Test: constructor, negative capacity
	 */
	@SuppressWarnings("unused")
	public static void test_constructorNegativeCapacity() {
		System.out.println("Test: constructor, negative capacity");
		
		// test code
		printTestStatement("boolean thrown = false;");
		boolean thrown = false;
		printTestStatement("try {");
		try {
			printTestStatement("// should throw a NegativeArraySizeException");
			// should throw a NegativeArraySizeException
			printTestStatement("Queue q = new ArrayQueue(-3);");
			Queue<?> q = new ArrayQueue<Object>(-3);
		} catch (NegativeArraySizeException e) {
			printTestStatement("thrown = true;");
			thrown = true;
		}
		printTestResult("thrown == true", thrown, true);
		
		System.out.println();
	}

	/**
	 * Test: toString
	 */
	public static void test_toString() {
		System.out.println("Test: toString");
		
		// test code
		printTestStatement("Queue q = new ArrayQueue(3);");
		Queue<?> q = new ArrayQueue<Object>(3);
		printTestResult("q.toString() == \"<ArrayQueue[]>\"", q.toString(), "<ArrayQueue[]>");
		
		System.out.println();
	}

	/**
	 * Test: front, empty queue
	 */
	public static void test_frontEmptyQueue() {
		System.out.println("Test: front, empty queue");
		
		// test code
		printTestStatement("Queue q = new ArrayQueue(3);");
		Queue<?> q = new ArrayQueue<Object>(3);
		
		printTestStatement("Trying to acces front of an empty queue");

		printTestResult("q.front() == null", q.front(), null);
		
		System.out.println();
	}

	/**
	 * Test: dequeue, empty queue
	 */
	public static void test_dequeueEmptyQueue() {
		System.out.println("Test: dequeue, empty queue");
		
		// test code
		printTestStatement("Queue q = new ArrayQueue(3);");
		Queue<?> q = new ArrayQueue<Object>(3);
		
		printTestStatement("boolean thrown = false;");
		boolean thrown = false;
		printTestStatement("try {");
		try {
			printTestStatement("// should throw EmptyQueueException");
			// should throw EmptyQueueException
			printTestStatement("q.dequeue();");
			q.dequeue();
		} catch (EmptyQueueException e) {
			printTestStatement("thrown = true;");
			thrown = true;
		}
		printTestResult("thrown == true", thrown, true);
		
		System.out.println();
	}

	/**
	 * Test: enqueue, front and dequeue
	 */
	public static void test_enqueueFrontAndDequeue() {
		System.out.println("Test: enqueue, front and dequeue");
		
		// test code
		printTestStatement("Queue q = new ArrayQueue(3);");
		Queue<Integer> q = new ArrayQueue<Integer>(3);
		printTestStatement("q.enqueue(4);");
		q.enqueue(4);
		
		printTestResult("q.toString() == \"<ArrayQueue[4]>\"", q.toString(), "<ArrayQueue[4]>");
		printTestResult("q.front()    == 4", (int)q.front(), 4);
		printTestResult("q.dequeue()  == 4", (int)q.dequeue(), 4);
		printTestResult("q.toString() == \"<ArrayQueue[]>\"", q.toString(), "<ArrayQueue[]>");
		
		System.out.println();
	}

	/**
	 * Test: enqueue, dequeue combined
	 */
	public static void test_enqueueDequeueCombined() {
		System.out.println("Test: enqueue, dequeue combined");
		
		// test code
		printTestStatement("Queue q = new ArrayQueue(3);");
		Queue<Integer> q = new ArrayQueue<Integer>(3);
		printTestStatement("q.enqueue(1);q.enqueue(2);");
		q.enqueue(1);q.enqueue(2);
		printTestStatement("q.enqueue(3);q.dequeue();");
		q.enqueue(3);q.dequeue();
		printTestStatement("q.enqueue(4);q.dequeue();");
		q.enqueue(4);q.dequeue();
		printTestStatement("q.enqueue(5);");
		q.enqueue(5);
		printTestResult("q.toString() == \"<ArrayQueue[3,4,5]>\"", q.toString(), "<ArrayQueue[3,4,5]>");
		
		printTestStatement("boolean thrown = false;");
		boolean thrown = false;
		printTestStatement("try {");
		
		try {
			printTestStatement("// should throw FullQueueException");
			// should throw FullQueueException
			printTestStatement("q.enqueue(6);");
			q.enqueue(6);
		} catch (FullQueueException e) {
			printTestStatement("thrown = true;");
			thrown = true;
		}
		printTestResult("thrown == true", thrown, true);
		
		System.out.println();
	}

	/**
	 * Test: size, isEmpty, isFull
	 */
	public static void test_sizeIsEmptyIsFull() {
		System.out.println("Test: size, isEmpty, isFull");
		
		// test code
		printTestStatement("ArrayQueue q = new ArrayQueue(3);");
		ArrayQueue<Integer> q = new ArrayQueue<Integer>(3);
		printTestResult("q.size() == 0", q.size(), 0);
		printTestResult("q.isEmpty() == true", q.isEmpty(), true);
		printTestResult("q.isFull() == false", q.isFull(), false);
		
		printTestStatement("q.enqueue(1);q.enqueue(2);");
		q.enqueue(1);q.enqueue(2);
		
		printTestResult("q.size() == 2", q.size(), 2);
		printTestResult("q.isEmpty() == false", q.isEmpty(), false);
		printTestResult("q.isFull() == false", q.isFull(), false);
		
		printTestStatement("q.enqueue(3);q.dequeue();");
		q.enqueue(3);q.dequeue();
		printTestStatement("q.enqueue(4);q.dequeue();");
		q.enqueue(4);q.dequeue();
		printTestStatement("q.enqueue(5);");
		q.enqueue(5);
		
		printTestResult("q.size() == 3", q.size(), 3);
		printTestResult("q.isEmpty() == false", q.isEmpty(), false);
		printTestResult("q.isFull() == true", q.isFull(), true);
		
		System.out.println();
	}

	/** Prints the statement */
	public static void printTestStatement(String testStatement) {
		System.out.println(" "+testStatement);
	}

	/**
	 * Compares the actual result with the expected result
	 * and prints the result of this test
	 */
	public static void printTestResult(String testName, int actual, int expected) {
		System.out.printf(" %-50s => ", testName);
		if (expected == actual) {
			System.out.println("passed");
		} else {
			System.out.println(" FAILED");
			System.out.println("  -> expected " + expected + " but was " + actual);
			System.out.println();
		}
	}

	/**
	 * Compares the actual result with the expected result
	 * and prints the result of this test
	 */
	public static void printTestResult(String testName, double actual, double expected) {
		System.out.printf(" %-50s => ", testName);
		if (Math.abs(expected - actual) < 1e-10) {
			System.out.println("passed");
		} else {
			System.out.println(" FAILED");
			System.out.println("  -> expected " + expected + " but was " + actual);
			System.out.println();
		}
	}

	/**
	 * Compares the actual result with the expected result
	 * and prints the result of this test
	 */
	public static void printTestResult(String testName, boolean actual, boolean expected) {
		System.out.printf(" %-50s => ", testName);
		if (expected == actual) {
			System.out.println("passed");
		} else {
			System.out.println(" FAILED");
			System.out.println("  -> expected " + expected + " but was " + actual);
			System.out.println();
		}
	}

	/**
	 * Compares the actual result with the expected result
	 * and prints the result of this test
	 */
	public static void printTestResult(String testName, int[] actual, int[] expected) {
		System.out.printf(" %-50s => ", testName);
		if (Arrays.equals(expected, actual)) {
			System.out.println("passed");
		} else {
			System.out.print(" FAILED\\n -> expected:\\n ");
			System.out.println(java.util.Arrays.toString(expected));
			System.out.print("    but was:\\n ");
			System.out.println(java.util.Arrays.toString(actual));
			System.out.println();
		}
	}

	/**
	 * Compares the actual result with the expected result
	 * and prints the result of this test
	 */
	public static void printTestResult(String testName, Object actual, Object expected) {
		System.out.printf(" %-50s => ", testName);
		if ((expected==null && actual==null) || (expected!=null && expected.equals(actual))) {
			System.out.println("passed");
		} else {
			System.out.print(" FAILED\\n -> expected:\\n");
			System.out.print(" \"" + expected + "\"");
			System.out.print("    but was:\\n    ");
			System.out.print(" \"" + actual+ "\"");
			System.out.println();
		}
	}

	/**
	 * Main method: run all tests.
	 */
	public static void main(String[] args) {
		test_constructor();
		test_constructorNegativeCapacity();
		test_toString();
		test_frontEmptyQueue();
		test_dequeueEmptyQueue();
		test_enqueueFrontAndDequeue();
		test_enqueueDequeueCombined();
		test_sizeIsEmptyIsFull();
	}

}


