package com.glendoncheney.stacks;

public class ArrayStackDemo {

	public static void main(String[] args) {

		ArrayStack<Integer> st = new ArrayStack<Integer>(5);
		int i = 1;
		
		while (!st.isFull()) {
			st.push(i);
			i*=3;
		}
			
		
		System.out.println("Value at the top of the stack is " 
					+ st.peek());
		
		while (!st.isEmpty()) {
			System.out.println(st.pop() + " ");
		}

	}

}
