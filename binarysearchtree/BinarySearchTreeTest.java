package com.glendoncheney.binarysearchtree;

public class BinarySearchTreeTest {
	
	 public static void main(String [] args)
	   {
		   BinarySearchTree<Integer> theTree = new BinarySearchTree<Integer>();
		   
		   theTree.insert(50);
		   theTree.insert(25);
		   theTree.insert(75);
		   theTree.insert(12);
		   theTree.insert(37);
		   theTree.insert(43);
		   theTree.insert(30);
		   theTree.insert(33);
		   theTree.insert(87);
		   theTree.insert(93);
		   theTree.insert(97);
		   
		   System.out.println("Tree Diameter: " + theTree.diameter());
		   System.out.println("Tree width: " + theTree.width());
		   System.out.println("Tree height: " + theTree.height());
		   System.out.println("Number of leaves on tree: " + theTree.countLeaves());
		   
		   theTree.displayTree();
		   theTree.traverse(1);
		   theTree.traverse(2);
		   theTree.traverse(3);
		   
		   System.out.println("Adding Numbers...");
		   theTree.insert(22);		
		   theTree.insert(41);	
		   theTree.insert(45);	
		   theTree.insert(85);	
		   theTree.insert(91);	
		   theTree.displayTree();
		   
		   System.out.println("Deleting 37...");
		   theTree.deleteIt(37);
		   theTree.delete(87);
		   theTree.displayTree();
		   
		   System.out.println("Tree Diameter: " + theTree.diameter());
		   System.out.println("Tree width: " + theTree.width());
		   System.out.println("Tree height: " + theTree.height());
		   System.out.println("Number of leaves on tree: " + theTree.countLeaves());
		   System.out.println("The smallest item is: " + theTree.minimum());
		   System.out.println("The largest item is: " + theTree.maximum());
		   
		   theTree.displayTree();
		   System.out.println("Breadth First traversal...");
		   theTree.breadthFirstTraversal();
		   
		   theTree.delete(33);
		   if(theTree.deleteIt(25)) {
			   System.out.println("25 deleted");
		   }
		   
		   theTree.insert(21);
		   theTree.displayTree();
		   
		   theTree.printLevelOrderBFS();
		   theTree.printInOrderDFS();
		   //theTree.printLevelOrderDFS();
		   
		   System.out.println("Is valid? " + theTree.isValidBST(-500, 500));
		   
		   theTree.displayTree();
		   int numLeaves = theTree.countLeaves();
		   System.out.println("The tree has " + numLeaves + " leaves: ");
		   theTree.displayLeaves();
		   
		   System.out.println("The trees max depth recursive is: " + theTree.maxDepthRec());
		   System.out.println("The trees max depth is: " + theTree.maxDeothIterative());
		   
		   System.exit(0);
	   }

}
