package com.glendoncheney.stacks;

public class LinkedStackDemo {
	
		public static void main(String [] args) {
			LinkedStack<String> st = new LinkedStack<String>();
			System.out.println("Adding contents to stack: ");
			String [] names = {"John", "Joe", "Jack" };
			
			try {
				for (String name : names){
					st.push(name);
					System.out.println(st.peek() + " added to stack");
				}
				
				System.out.println(st.toString());
				
				String popped = st.pop();
				System.out.println("Popped " + popped);
				
				System.out.println("New Contents: ");
				System.out.println(st);
			}
			catch(StackEmptyException e) {
				e.getMessage();
			}
	}
	
	
}
