package com.glendoncheney.binarysearchtree;

import java.util.Iterator;

public interface Tree<E extends Comparable<? super E>> {

	public void insert(E data);

	public boolean search(E toFind);
	
	public void delete(E toDelete);
 
	public void traverse(int traverseType);
 
	public void breadthFirstTraversal();

	public void displayTree();
	
	public Iterator<E> iterator();
	   
    public E minimum();
	   	   
    public E maximum();

    public int height();

    public int countLeaves();

    public int width();

    public int diameter();

	 public int maxDepthRec();
		
	 public void displayLeaves();
		 
	 public void printLevelOrderBFS();	 
	  
	 public void printInOrderDFS();
	  
	 public boolean isValidBST(E min, E max);
}
