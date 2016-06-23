package com.glendoncheney.stacks;

public class QueuedStackDemo {

	public static void main(String[] args) {
		QueuedStack<Integer> stack = new QueuedStack<Integer>();
    	
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        
        System.out.println("Peek: " + stack.peek());
        System.out.println("Is Empty: " + stack.isEmpty());

        System.out.println("1st = " + stack.pop());
        System.out.println("2nd = " + stack.pop());
        System.out.println("3rd = " + stack.pop());
        System.out.println("4th = " + stack.pop());
        System.out.println("5th = " + stack.pop());
        System.out.println("6th = " + stack.pop());
        System.out.println("7th = " + stack.pop());
        System.out.println("8th = " + stack.pop());
        System.out.println("9th = " + stack.pop());
        System.out.println("10th= " + stack.pop());
	}

}
