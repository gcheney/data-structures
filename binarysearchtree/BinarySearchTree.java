package com.glendoncheney.binarysearchtree;

import java.util.*;               // for Stack class


/**
 * Generic Binary Search Tree class 
 * @author glen
 *
 */
public class BinarySearchTree<E extends Comparable<? super E>> implements Iterable<E>{
	
	/*****************************************************
   *
   *            the Inner Node class
   *
   ******************************************************/
   private class Node {
	   private E data;              // data item (key)
	   private Node left;         // this node's left child
	   private Node right;        // this node's right child
	   
	   /**
	    * constrcutor
	    * @param data The data stored in this Node
	    */
	   private Node(E data){
		   this.data = data;
		   left = null;
		   right = null;
	   }	   
   }    
   
   private Node root;             // first node of tree

   /**
    * Constructs an Empty GenericBST
    */
   public BinarySearchTree() { 
	   root = null; 				  // no nodes in tree yet
   }        
   
      
   /*****************************************************
	*
	*            INSERT 
	*
	******************************************************/
	   public void insert(E data) {
	      root = insert(root, data);
	   }
	   
	   private Node insert(Node curr, E toInsert) {
	      if (curr == null) {
	         return new Node(toInsert);
	      }
	
	      if (toInsert.compareTo(curr.data) == 0) {
	      	return curr;
	      }
	
	      if (toInsert.compareTo(curr.data) < 0) {
	         curr.left = insert(curr.left, toInsert);
	      }
	      else {
	         curr.right = insert(curr.right, toInsert);
	      }
	
	      return curr;
	   }
	   
	   
	   //Iterative Insert
	   public void insertIt(E key)
	   {
	      Node newNode = new Node(key);   // make new node
	      
	      if(root==null)  {              // no node in root
	         root = newNode;
	      }
	      else {                         // root occupied
	         Node current = root;       // start at root
	         Node parent;
	         while(true) {               // (exits internally)
	            parent = current;
	            
	            if(key.compareTo(current.data) == 0) {
	            	System.out.println("No duplicate keys are allowed.");
	            	return;
	            }
	            else if(key.compareTo(current.data) < 0){  // go left?
	               current = current.left;
	               if(current == null) { 				// if end of the line,insert on left
	                  parent.left = newNode;
	                  return;
	                }
	            }  									  // end if go left
	            else {                   				// or go right?
	               current = current.right;
	               if(current == null) { 					// if end of the line, insert on right
	                  parent.right = newNode;
	                  return;
	               }
	            }  // end else go right
	         }  // end while
	      }  // end else not root
	   }  // end insert()
	
	   
	/*****************************************************
	*
	*            SEARCH 
	*
	******************************************************/
	   public boolean search(E toFind) {
	      return search(root, toFind);
	   }
	   
	   private boolean search(Node curr, E toFind) {
	      if (curr == null) {
	         return false;
	      }
	      else if (toFind.compareTo(curr.data) == 0) {
	      	return true;
	      }
	      else if (toFind.compareTo(curr.data) < 0) {
	         return search(curr.left, toFind);
	      } 
	      else {
	         return search(curr.right, toFind);
	      }
	   }
	   
	   //Iterative search
	   public Node searchIt(E key) {     // find node with given key
		  //assumes non-empty tree 
	      Node curr = root;               // start at root
	      while(curr.data.compareTo(key) != 0) {       // while no match,
	         if(key.compareTo(curr.data) < 0)  {       // go left?
	            curr = curr.left;
	         }
	         else {                           // or go right?
	            curr = curr.right;
	         }
	         
	         if(curr == null) {            // if no child,
	            return null;                 // didn't find it
	         }
	      }
	      
	      return curr;                    // found it
	   }  // end find()
	
	/*****************************************************
	*
	*            	DELETE RECURSIVE
	*
	******************************************************/
	
	   public void delete(E toDelete)
	   {
	      root = delete(root, toDelete);
	   }
	   
	   private Node delete(Node curr, E toDelete)
	   {
	      if (curr == null) { //Node is empty
	    	  throw new RuntimeException("Cannot delete " + toDelete);
	      }
	      else if (toDelete.compareTo(curr.data) < 0) { //smaller than current = on the left
	    	  curr.left = delete (curr.left, toDelete);
	      }
	      else if (toDelete.compareTo(curr.data)  > 0) {// larger than current = on the right
	    	  curr.right = delete (curr.right, toDelete);
	      }
	      //foudn the Node to delete
	      else {
	         if (curr.left == null) {
	        	 return curr.right;
	         }
	         else if (curr.right == null) {
	        	 return curr.left;
	         }	         
	         else{
	         // get data from the rightmost node in the left subtree
	            curr.data = retrieveData(curr.left);
	         // delete the rightmost node in the left subtree
	            curr.left =  delete(curr.left, curr.data) ;
	         }
	      }
	      
	      return curr;
	   }
	   
	   private E retrieveData(Node curr)
	   {
	      while (curr.right != null) 
	    	  curr = curr.right;
	
	      return curr.data;
	   }
	   
	   
	   /*****************************************************
		*
		*            	DELETE ITERATIVE
		*
		******************************************************/
	   
	   
	   //Iterative Delete
	   public boolean deleteIt(E key) 	// delete node with given key
	   {                           		// (assumes non-empty list)
	      Node current = root;
	      Node parent = root;
	      boolean isLeftChild = true;

	      while(current.data.compareTo(key) != 0)        // search for node
	      {
	         parent = current;
	         if(key.compareTo(current.data) < 0)         // go left?
	         {
	            isLeftChild = true;
	            current = current.left;
	         }
	         else                            // or go right?
	         {
	            isLeftChild = false;
	            current = current.right;
	         }
	         if(current == null)             // end of the line,
	            return false;                // didn't find it
	     }  // end while
	      
	      // found node to delete
	      // if no children, simply delete it
	      if(current.left == null && current.right == null)
	      {
	         if(current == root)             // if root,
	            root = null;                 // tree is empty
	         else if(isLeftChild)
	            parent.left = null;     // disconnect
	         else                            // from parent
	            parent.right = null;
	      }
	      
	      // if no right child, replace with left subtree
	      else if(current.right==null) 
	      {
	         if(current == root)
	            root = current.left;
	         else if(isLeftChild)
	            parent.left = current.left;
	         else
	            parent.right = current.left;
	      }
	      
	      // if no left child, replace with right subtree
	      else if(current.left==null)
	      {
	         if(current == root)
	            root = current.right;
	         else if(isLeftChild)
	            parent.left = current.right;
	         else
	            parent.right = current.right;
	      }
	      
	      else  // two children, so replace with inorder successor
	      {
	         // get successor of node to delete (current)
	         Node successor = getSuccessor(current);

	         // connect parent of current to successor instead
	         if(current == root)
	            root = successor;
	         else if(isLeftChild)
	            parent.left = successor;
	         else
	            parent.right = successor;

	         // connect successor to current's left child
	         successor.left = current.left;
	      }  // end else two children
	      
	      // (successor cannot have a left child)
	      
	      return true;                                // success
	   }  // end delete()

	   
	   // returns node with next-highest value after delNode
	   // goes to right child, then right child's left descendents
	   private Node getSuccessor(Node delNode)
	   {
	      Node successorParent = delNode;
	      Node successor = delNode;
	      Node current = delNode.right;   // go to right child
	      
	      while(current != null)               // until no more
	      {                                 // left children,
	         successorParent = successor;
	         successor = current;
	         current = current.left;      // go to left child
	      }
	                                           // if successor not
	      if(successor != delNode.right)  // right child,
	      {                                 // make connections
	         successorParent.left = successor.right;
	         successor.right = delNode.right;
	      }
	      
	      return successor;
	   }
	   
	   /*****************************************************
	   *
	   *            TRAVERSE
	   *
	   ******************************************************/
   
   
   public void traverse(int traverseType) {
      switch(traverseType) {
         case 1: 
        	 System.out.print("\nPreorder traversal: ");
        	 preOrder(root);
             break;
             
         case 2: 
        	 System.out.print("\nInorder traversal:  ");
             inOrder(root);
             break;
             
         case 3:
        	 System.out.print("\nPostorder traversal: ");
             postOrder(root);
             break;
      }
      
      System.out.println();
   }

   
   private void preOrder(Node localRoot)
   {
      if(localRoot != null)
      {
         System.out.print(localRoot.data + " ");
         preOrder(localRoot.left);
         preOrder(localRoot.right);
      }
   }

   
   private void inOrder(Node localRoot)
   {
      if(localRoot != null)
      {
         inOrder(localRoot.left);
         System.out.print(localRoot.data + " ");
         inOrder(localRoot.right);
      }
   }

   
   private void postOrder(Node localRoot)
   {
      if(localRoot != null)
      {
         postOrder(localRoot.left);
         postOrder(localRoot.right);
         System.out.print(localRoot.data + " ");
      }
   }
   
   
   public void breadthFirstTraversal()
   {
	   levelOrder(root);
   }
   
   private void levelOrder(Node root)
   {
	   Queue<Node> queue = new LinkedList<Node>();
	   queue.add(root);
	   while(!queue.isEmpty())
	   {		   
		   Node curr = queue.remove();
		   System.out.print(curr.data + " ");
		   if(curr.left != null) 
			   queue.add(curr.left);
		   if(curr.right != null)
			   queue.add(curr.right);
	   }
   }

   
   /*****************************************************
   *
   *            DISPLAY
   *
   ******************************************************/
   
   
   public void displayTree()
   {
      Stack<Node> globalStack = new Stack<Node>();
      globalStack.push(root);
      int nBlanks = 32;
      boolean isRowEmpty = false;
      System.out.println(
    		  
      "......................................................");
      while(isRowEmpty==false)
      {
         Stack<Node> localStack = new Stack<Node>();
         isRowEmpty = true;

         for(int j=0; j<nBlanks; j++)
            System.out.print(' ');

         while(globalStack.isEmpty()==false)
         {
            Node temp = (Node)globalStack.pop();
            
            if(temp != null)
            {
               System.out.print(temp.data);
               localStack.push(temp.left);
               localStack.push(temp.right);

               if(temp.left != null || temp.right != null)
                  isRowEmpty = false;
            }
            else
            {
               System.out.print("--");
               localStack.push(null);
               localStack.push(null);
            }
            
            for(int j=0; j<nBlanks*2-2; j++)
               System.out.print(' ');
            
         }  // end while globalStack not empty
         
         System.out.println();
         nBlanks /= 2;
         while(localStack.isEmpty()==false)
            globalStack.push( localStack.pop() );
      // end while isRowEmpty is false
         
      } 
      
      System.out.println(
      "......................................................");
      
   }  // end displayTree()
   
   
   /*****************************************************
	*
	*            TREE ITERATOR
	*
	******************************************************/
	
   public Iterator<E> iterator()
   {
      return new TreeIterator();
   }
   
   //pre-order
   private class TreeIterator implements Iterator<E>
   {
      Stack<Node> stack = new Stack<Node>();

      public TreeIterator()
      {
         if(root != null) 
        	 stack.push(root);
      }
      
      public boolean hasNext()
      {
         return !stack.isEmpty();
      }

      public E next()
      {
         Node current = stack.peek();
         
         if(current.left != null)
         {
            stack.push(current.left);
         }
         else
         {
            Node tmp = stack.pop();
            
            while( tmp.right == null )
            {
               if(stack.isEmpty()) {
            	   return current.data;
               }
               
               tmp = stack.pop();
            }
            
            stack.push(tmp.right);
         }

         return current.data;
      }//end of next()

      public void remove()
      {
    	  throw new RuntimeException("Cannot remove.");
      }
      
   }//end of MyIterator
	   
	   
	   
   /*************************************************
 *
 *            MISC
 *
 **************************************************/
   
	   //-----------------MINIMUM AND MAXIMUM----------------//
	   
	   public E minimum() 
	   {
		   Node curr = root; 
		   Node min = null;

		   while(curr != null)
		   {
			   min = curr;
			   curr = curr.left;
		   }
		   
		   return min.data;
	   }
	   
	   
	   public E maximum() 
	   {
		   Node curr = root; 
		   Node max = null;

		   while(curr != null)
		   {
			   max = curr;
			   curr = curr.right;
		   }
		   
		   return max.data;
	   }
   
	//----------------HEIGHT-----------------------------//
   public int height()
   {
      return height(root);
   }
   
   private int height(Node curr)
   {
      if(curr == null) 
    	  return -1;
      else
    	  return 1 + Math.max( height(curr.left), height(curr.right));
   }

   
 //----------------COUNT LEAVES-----------------------------//
   public int countLeaves()
   {
      return countLeaves(root);
   }
   
   private int countLeaves(Node curr)
   {
      if(curr == null) 
    	  return 0;
      else if(curr.left == null && curr.right == null) 
    	  return 1;
      else
    	  return countLeaves(curr.left) + countLeaves(curr.right);
   }


   
 //----------------WIDTH-----------------------------//
   //The width of a binary tree is the maximum number of elements on one level of the tree.
   public int width()
   {
      int max = 0;
      
      for(int i = 0; i <= height(); i++)
      {
         int tmp = width(root, i);
         if(tmp > max) 
        	 max = tmp;
      }
      
      return max;
   }
   
   //rerturns the number of node on a given level
   private int width(Node curr, int depth)
   {
      if(curr == null) 
    	  return 0;
      else if(depth == 0) 
    	  return 1;
      else
    	  return width(curr.left, depth-1) + width(curr.right, depth-1);
   }

   
 //----------------DIAMETER-----------------------------//
   
   //The diameter of a tree is the number of nodes
   //on the longest path between two leaves in the tree.
   public int diameter()
   {
      return diameter(root);
   }
   
   private int diameter(Node curr)
   {
      if(curr==null) 
    	  return 0;

      //the path goes through the root
      int len1 = height(curr.left) + height(curr.right) + 3;

      //the path does not pass the root
      int len2 = Math.max(diameter(curr.left), diameter(curr.right));

      return Math.max(len1, len2);
   }
   
   
   //---------------MAX DEPTH---------------------------------------//
   public int maxDepthRec()
   {
	   return maxDepthRec(root);
   }
   
   private int maxDepthRec(Node root) 
   {
	   if (root == null) {
		   return 0;
	   }
	   
	   int leftHeight = maxDepthRec(root.left);
	   int rightHeight = maxDepthRec(root.right);
	   
	   return (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
   }
   
   
   public int maxDeothIterative()
   {
	   return maxDepthIterative(root);
   }
   
   private int maxDepthIterative(Node root) 
   {
	   if (root == null){ 
		   return 0;
	   }
	   
	   Stack<Node> stack = new Stack<Node>();
	   
	   stack.push(root);
	   int maxDepth = 0;
	   Node prev = null;
	   
	   while (!stack.empty()) 
	   {
		     Node curr = stack.peek();
		     
		     if (prev == null || prev.left == curr || prev.right == curr) 
		     {
		         if (curr.left != null) {
		             stack.push(curr.left);
		         }
		         else if (curr.right != null) {
		    	     stack.push(curr.right);
		         }
		     } 
		     else if (curr.left == prev) 
		     {
		         if (curr.right != null) {
		    	     stack.push(curr.right);
		         }
		     } 
		     else 
		     {
		    	 stack.pop();
		     }
		     
		     prev = curr;
		     
		     if (stack.size() > maxDepth) {
		       maxDepth = stack.size();
		     }	     
	   }
	   
	   return maxDepth;
   }
   
   //----------------DISPLAY LEAVES-----------------------------//
   public void displayLeaves()
   {
      displayLeaves(root);
   }
   
   private void displayLeaves(Node curr)
   {
      if(curr == null) {
    	  return;
      }
      else if(curr.left == null && curr.right == null) {
    	  System.out.println(curr.data);
      }
      else {
    	  displayLeaves(curr.left);
    	  displayLeaves(curr.right);
      }
   }
   
   
   /*************************************************
   *
   *            Print by levels using BFS
   *
   **************************************************/
   
   public void printLevelOrderBFS()
   {
	   printLevelOrderBFS(root);
   }
   
   private void printLevelOrderBFS(Node root)
   {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        
        int currentLevelCount = 1;
        int nextLevelCount = 0;
        
        while(!queue.isEmpty())
        {
        	Node current = queue.remove();
            System.out.print(current.data + " ");
            
            if(current.left != null)
            {
                queue.add(current.left);
                nextLevelCount++;
            }	            
            if(current.right != null)
            {	            	
                queue.add(current.right);
                nextLevelCount++;
            }
            
            currentLevelCount--;
            
            if(currentLevelCount == 0)
            {
                System.out.println("");
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }
    }
    
   /*****************************************************
	*
	*            PRINT IN ORDER USING DFS AND STACK
	*
	******************************************************/
   
    public void printInOrderDFS()
    {
    	printInOrderDFS(root);
    }
   
    private void printInOrderDFS(Node root)
    {
    	if(root == null) {
    		return;
    	}
    	
	    Node current = root;
	    boolean hasRightChild;
	    
        Stack<Node> stack = new Stack<Node>();
        stack.push(current);

        //Until the stack is empty, it means there are nodes to traverse
        while(!stack.isEmpty())
        {
        	hasRightChild = false;
        			
            while (current.left != null)
            {
            	current = current.left;
                stack.push(current);
            }
            while(!hasRightChild && !stack.isEmpty())
            {
            	current = stack.pop();
                System.out.print(current.data + " ");
                
                if(current.right != null)
                {
                    current = current.right;
                    stack.push(current);
                    hasRightChild = true;
                }
                
            }
          
        }
        
        System.out.print("\n");

    }
    
    
   
    public boolean isValidBST(E min, E max)
    {
    	return isValidBST(root, min, max);
    }

    private boolean isValidBST(Node node, E MIN, E MAX) 
    {
         if(node == null) {
             return true;
         }
         if(node.data.compareTo(MIN) > 0  
             && node.data.compareTo(MAX) < 0
             && isValidBST(node.left, MIN, node.data)
             && isValidBST(node.right, node.data, MAX))
         {
             	return true;
         }
         
         return false;
    }

}  // end class Tree





