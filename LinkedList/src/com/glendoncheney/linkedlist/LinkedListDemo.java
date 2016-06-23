package com.glendoncheney.linkedlist;

public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		
        list.add("Amy");
        list.add("Bob");
        list.add(2, "Al");
        list.add(0, "Beth");
        list.add(3, "Carol");
        
        System.out.println("The members of the list are:");
        System.out.print(list);
        
        System.out.println("\nSorting the list...");
        list.sort();
        System.out.println("The members of the list are:");
        System.out.print(list);
        
        System.out.println("\nReversing the list iteratively...");
        list.reverseIterative();
        System.out.println("The members of the list are:");
        System.out.print(list);
        
        System.out.println("\nSorting the list back to ascending order...");
        list.sort();
        System.out.println("The members of the list are:");
        System.out.print(list);
        
        System.out.println("\nReversing the list recursively...");
        list.reverse();
        System.out.println("The members of the list are:");
        System.out.print(list);

	}

}
