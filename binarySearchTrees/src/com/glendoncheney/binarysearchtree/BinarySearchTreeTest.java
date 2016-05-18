package com.glendoncheney.binarysearchtree;

public class BinarySearchTreeTest {
	
	 public static void main(String [] args)
	   {
		   BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		   
		   tree.insert(50);
		   tree.insert(25);
		   tree.insert(75);
		   tree.insert(12);
		   tree.insert(37);
		   tree.insert(43);
		   tree.insert(30);
		   tree.insert(33);
		   tree.insert(87);
		   tree.insert(93);
		   tree.insert(97);
		   
		   System.out.println("Tree Diameter: " + tree.diameter());
		   System.out.println("Tree width: " + tree.width());
		   System.out.println("Tree height: " + tree.height());
		   System.out.println("Number of leaves on tree: " + tree.countLeaves());
		   
		   tree.displayTree();
		   tree.traverse(1);
		   tree.traverse(2);
		   tree.traverse(3);
		   
		   System.out.println("Adding Numbers...");
		   tree.insert(22);		
		   tree.insert(41);	
		   tree.insert(45);	
		   tree.insert(85);	
		   tree.insert(91);	
		   tree.displayTree();
		   
		   System.out.println("Deleting 37...");
		   tree.deleteIt(37);
		   tree.delete(87);
		   tree.displayTree();
		   
		   System.out.println("Tree Diameter: " + tree.diameter());
		   System.out.println("Tree width: " + tree.width());
		   System.out.println("Tree height: " + tree.height());
		   System.out.println("Number of leaves on tree: " + tree.countLeaves());
		   System.out.println("The smallest item is: " + tree.minimum());
		   System.out.println("The largest item is: " + tree.maximum());
		   
		   tree.displayTree();
		   System.out.println("Breadth First traversal...");
		   tree.breadthFirstTraversal();
		   
		   tree.delete(33);
		   if(tree.deleteIt(25)) {
			   System.out.println("25 deleted");
		   }
		   
		   tree.insert(21);
		   tree.displayTree();
		   
		   tree.printLevelOrderBFS();
		   tree.printInOrderDFS();
		   //theTree.printLevelOrderDFS();
		   
		   System.out.println("Is valid? " + tree.isValidBST(-500, 500));
		   
		   tree.displayTree();
		   int numLeaves = tree.countLeaves();
		   System.out.println("The tree has " + numLeaves + " leaves: ");
		   tree.displayLeaves();
		   
		   System.out.println("The trees max depth recursive is: " + tree.maxDepthRec());
		   System.out.println("The trees max depth is: " + tree.maxDeothIterative());
		   
		   System.exit(0);
	   }

}
