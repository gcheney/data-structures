package com.glendoncheney.linkedlist;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class represents a generic
 * doubly linked list
 * @author glendon cheney
 *
 * @param <E>The generic type
 */
public class DoublyLinkedList<E extends Comparable<? super E>> 
	implements Iterable<E> {
	
	/**
	 * The private nested class Node
	 * Holds the data for each link, 
	 * and links to the next and previous nodes
	 * @author glen
	 *
	 */
	private static class Node<E> {
	   public E data;                     	   
	   public Node<E> next;              	  
	   public Node<E> prev;             	  

	   public Node(E data, Node<E> next, Node<E> prev) { 
		   this.data = data; 
		   this.next = next;
		   this.prev = prev;
	   }

	   public void displayNode() { 
		   System.out.print(data + " "); 
	   }

	}  // end class Node
	
	private Node<E> first;               	
	private Node<E> last;                	

	public DoublyLinkedList() {
		first = null;           	 
		last = null;
	}

	
	public boolean isEmpty() { 
   		return first == null; 
	}

	
	public boolean contains(E element) {
		Node<E> currNode = first;
		
		while (currNode != null) {
			if (currNode.data.equals(element)) {
				return true;
			}
		}
		
		return false;
	}
	
	/*******************************************************
    *
    *  INSERT
    *
    ********************************************************/
	
	public void insertFirst(E element) {
		Node<E> newNode = new Node<E>(element, first, null);  

		if (isEmpty()) {       	
			last = newNode;         
		}
		else {
			first.prev = newNode; 
		}
      
		first = newNode;               
	}

	
	public void insertLast(E element) {
		Node<E> newNode = new Node<E>(element, null, last);   
      
		if (isEmpty()) {             
		    first = newNode;     
		}
		else {
			last.next = newNode;  
		}
      
		last = newNode;                
    }

                                   
   public boolean insertAfter(E key, E element) {                              
      Node<E> current = first;          
      
      while (current.data != key) {
         current = current.next;     
         if (current == null) {
            return false;     
         }
      }
      
      Node<E> newNode = new Node<E>(element, null, current);   

      if (current==last) {              
         last = newNode;  
      }
      else {
         newNode.next = current.next; 
         current.next.prev = newNode;
      }
      
      current.next = newNode;       
      return true;                   
   }

   /*******************************************************
   *
   *  REMOVE
   *
   ********************************************************/
   
   
	public E removeFirst() {                              
		Node<E> toDelete = first;
	
		if (first.next == null) {
			last = null;               
		}
		else {
			first.next.prev = null; 
		}
	
		first = first.next;            
		return toDelete.data;
	}

	
	  public E removeLast() {                              
		   Node<E> toDelete = last;
	     
		   if (last.prev == null) {         
			   first = null;      
		   }
		   else {
			   last.prev.next = null;  
		   }
		   
		   last = last.prev;          
		   return toDelete.data;
	  }
	   
	   public Node<E> removeKey(E key)   		
	   {                              		
	      Node<E> current = first;         		 
	      while (current.data != key) {
	         current = current.next;     		
	         if (current == null) {
	            return null;       
	         }
	      }
	      
	      if (current==first) {            		 
	         first = current.next;  
	      }
	      else {                          		 
	         current.prev.next = current.next;	
	      }
	
	      if (current==last) {             		
	         last = current.prev;  
	      }
	      else {                         	 	
	         current.next.prev = current.prev; 	
	      }
	      
	      return current;                		
	   	}
	   
	   /*******************************************************
	   *
	   *  DELETE DUPLICATES
	   *
	   ********************************************************/
	   
	   public void deleteDuplicates() {
	  		deleteDuplicates(first);
	  	}
	  	
	  	private void deleteDuplicates(Node<E> head) {
	  		if (head == null) {
	  			return;
	  		}
	  		
	  		HashSet<E> set = new HashSet<E>();
			Node<E> currNode = head;
			Node<E> prevNode = null;
			
			while (currNode != null) {
				if (set.contains(currNode.data)) {
					prevNode.next = currNode.next;
				} 
				else {
					set.add(currNode.data);
					prevNode = currNode;
				}
				
				currNode = currNode.next;
			}
	  	}
	
	
	  	
	  	 /*******************************************************
	    *
	    *  DISPLAY
	    *
	    ********************************************************/
	   
	   	public void displayForward() {
	      System.out.print("List (first-->last): ");
	      Node<E> current = first;          
	      
	      while (current != null) {
	         current.displayNode();      
	         current = current.next;     
	      }
	      
	      System.out.println("");
	   	}
	
	   	
	   	public void displayBackward() {
	      System.out.print("List (last-->first): ");
	      Node<E> current = last; 
	      
	      while (current != null) {
	         current.displayNode();      
	         current = current.prev; 
	      }
	      
	      System.out.println("");
	   	}
	   	
	   	
	   	/**
	     * Returns a new Iterator for the class
	     */
	    public Iterator<E> iterator() {
	       return new LinkedListIterator();
	    }
	
	  /*******************************************************
	  *
	  *  The Iterator class
	  *
	  ********************************************************/
	
	    private class LinkedListIterator implements Iterator<E> {
	       private Node<E> currNode;
	
	       public LinkedListIterator() {
	     	  currNode = first;
	       }
	
	       public boolean hasNext() {
	          return currNode != null;
	       }
	
	       public E next() {
	          if (!hasNext()) {
	         	 throw new NoSuchElementException("No more elements in the list");
	          }
	          
	          E element = currNode.data;
	          currNode = currNode.next;
	          return element;
	       }
	
	       public void remove() { 
	     	  throw new UnsupportedOperationException("This operation is unsupported"); 
	       }
	       
	    }


}  // end class DoublyLinkedList
