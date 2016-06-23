package com.glendoncheney.linkedlist;

import java.util.*;

/**
   * The LinkedList1 class implements a 
   * generic-based singly Linked list.
   * @author glendon cheney
   *
   * @param <E>The generic type
*/

public class LinkedList<E extends Comparable<? super E>> {
    /**
       The Node class stores a list element
       and a reference to the next node.
    */
    
    private class Node {
        E value;   
        Node next;      
        
        /**
           Constructor.            
           @param val The element to store in the node.
           @param n The reference to the successor node.
        */        
        Node(E val, Node n) {
            value = val;
            next = n;
        } 
        
        /**
           Constructor. 
           @param val The element to store in the node.
        */      
        Node(E val) {
           // Call the other (sister) constructor.
           this(val, null);            
        }
    }	
	 
    private Node head;  // list head
    private Node last;   // last element in list
	     
    /**
       Constructor.
    */  
    public LinkedList() {
        head = null;
        last = null;        
    }
    
    /**
       The isEmpty method checks to see 
		 if the list is empty.
		 @return true if list is empty, 
		 false otherwise.
    */    
    public boolean isEmpty() {        
        return head == null;       
    }
    
    /**
       The size method returns the length of the list.
       @return The number of elements in the list.
    */    
    public int size() {
       int count = 0;
       Node p = head;     
       while (p != null) {
           count ++;
           p = p.next;
       }
		 
       return count;
    }
    
    /**
       	The add method adds an element to
	 	the end of the list.
       	@param e The value to add to the
	 	end of the list.       
    */
    
    public void add(E element) {
      if (isEmpty()) {
          head = new Node(element);
          last = head;
      }
      else {
          last.next = new Node(element);
          last = last.next;
      }      
    }
    
    /**
       The add method adds an element at a position.
       @param e The element to add to the list.
       @param index The position at which to add 
		 the element.
       @exception IndexOutOfBoundsException When 
		 index is out of bounds.  
    */   
    public void add(int index, E element) {
         if (index < 0  || index > size()) {
             String message = String.valueOf(index);
             throw new IndexOutOfBoundsException(message);
         }
         

         if (index == 0) {
             // New element goes at beginning
             head = new Node(element, head);
             if (last == null) {
                 last = head;
             }
             return;
         }
         

         Node pred = head;        
         for (int k = 1; k <= index - 1; k++) {
            pred = pred.next;           
         }
         
         // Splice in a node containing the new element
         pred.next = new Node(element, pred.next);  
         
         // Is there a new last element ?
         if (pred.next.next == null) {
             last = pred.next;        
         }
    }
    
    /**
       The toString method computes the string
       representation of the list.
       @return The string form of the list.
    */   
    public String toString() { 
      StringBuilder strBuilder = new StringBuilder();
      
      for (Node curr = head; curr != null; curr = curr.next) {
         strBuilder.append(curr.value + "\n"); 
      }

      return strBuilder.toString(); 
    }
    
    /**
       The remove method removes the element at an index.
       @param index The index of the element to remove. 
       @return The element removed.  
       @exception IndexOutOfBoundsException When index is 
                  out of bounds.     
    */ 
    public E remove(int index) {
       if (index < 0 || index >= size()) {  
           String message = String.valueOf(index);
           throw new IndexOutOfBoundsException(message);
       }
       
       E element;  // The element to return     
       if (index == 0) {
          // Removal of first item in the list
          element = head.value;    
          head = head.next;
          if (head == null)
          {
              last = null;  
          }
       }
       else {
          // To remove an element other than the first,
          // find the predecessor of the element to
          // be removed.
          Node pred = head;
          
          for (int i = 1; i <= index -1; i++) {
              pred = pred.next;
          }
          
          element = pred.next.value;       
          pred.next = pred.next.next;  
          
          if (pred.next == null) {
              last = pred;        
          }
       }
       
       return element;        
    }  
    
    /**
       The remove method removes an element.
       @param element The element to remove.
       @return true if the remove succeeded, 
		 false otherwise.
    */
    
    public boolean remove(E element) {
       if (isEmpty()) {
           return false; 
       }
      
       if (element.equals(head.value)) {
          // Removal of first item in the list
          head = head.next;
          if (head == null) {
              last = null;  
          }
          return true;
       }
      
      // Find the predecessor of the element to remove
      Node pred = head;
      while (pred.next != null && !pred.next.value.equals(element)) {
          pred = pred.next;
      }

      if (pred.next == null) {
          return false;
      }
      
      pred.next = pred.next.next;    
      
      // Check if pred is now last
      if (pred.next == null) {
          last = pred;
      }
      
      return true;       
    }
    
    /**
     * The sort method turns the list into an array 
     * and sorts it
     * @return A String array representation of
     * the linked list
     */
    public void sort() {
    	ArrayList<E> sortedList = new ArrayList<E>();
    	
    	Node temp = head;
    	int index = 0;
    	
    	while (temp != null) {
    		sortedList.add(temp.value);
    		index++;
    		temp = temp.next;
    	}
    	
    	Collections.sort(sortedList);
    	
    	temp = head;
    	index = 0;
    	while (temp != null) {
    		temp.value = sortedList.get(index);
    		index++;
    		temp = temp.next;
    	}
    }
    
    /**
     * This method uses recursive method to reverse a singly linked list.
     */
    public void reverse() {
    	recursiveReverse(head);
    }
    
    public void recursiveReverse(Node currentNode ) {  
    	//check for empty list 
    	if (currentNode == null) {
    		return;
    	}

    	/* if we are at the TAIL node:
        	recursive base case:
        */
     	if (currentNode.next == null) { 
     		//set HEAD to current TAIL since we are reversing list
     		head = currentNode; 
     		return; 
    	}

    	recursiveReverse(currentNode.next);
    	currentNode.next.next = currentNode;
    	currentNode.next = null;
    }
    
    /**
     * This method uses iterative approach to reverse a singly linked list.
     */
    public void reverseIterative(){
    	//empty or just one node in list
    	if (head == null || head.next == null) {
    		return;
    	}
    	
    	//store the second node
    	Node second = head.next;
    	
    	//store the third node before we change
    	Node third = second.next;
    	
    	//set the second nodes pointer
    	second.next = head; 
    	head.next = null; 	
    	
    	//if only two nodes, reverse is finished
    	if (third==null) {
    		return;
    	}
    	
    	//declare nodes
    	Node curr = third;
    	Node prev = second;
    	Node next;
    	
    	//enter reversing while loop
    	while (curr != null) {
    		next = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    	}
    	
    	//end of loop, reset the head Node
    	head = prev;
    }

}