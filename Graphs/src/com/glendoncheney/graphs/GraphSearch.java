package com.glendoncheney.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * The GraphSearch class implements two methods 
 * for searching a Graph, one using depth-first search 
 * and another using breadth-first search
 * @author Glendon Cheney
 *
 * @param <E>
 */
public class GraphSearch<E> {
	
	private final int START_INDEX = 0;
	
	public void depthFirstSearch(Graph<E> g) {    
		ArrayList<Vertex<E>> verticies = g.getVerticies();
		Stack<Vertex<E>> stack = new Stack<Vertex<E>>(); 
		Vertex<E> startingVert = verticies.get(START_INDEX);
		
		startingVert.setVisited(true);   	
		displayVertex(startingVert);                 	
		stack.push(startingVert);                 	

		while (!stack.isEmpty()) {
	      // get an unvisited vertex adjacent to stack top
	      Vertex<E> v = getAdjUnvisitedVertex(stack.peek());
	      if (v == null) {                   		
	         stack.pop();
	      }
	      else {
	    	 v.setVisited(true);  
	         displayVertex(v);    
	         stack.push(v);    
	      }
		}  
       
		//reset flags
		for (int j=0; j< verticies.size(); j++) {         
			verticies.get(j).setVisited(false);
		}
       
    }  

    public void breadthFirstSearch(Graph<E> g) {     
	   ArrayList<Vertex<E>> verticies = g.getVerticies();
       Queue<Vertex<E>> queue = new LinkedList<Vertex<E>>(); 
       Vertex<E> startingVert = verticies.get(START_INDEX);
       
       startingVert.setVisited(true);   	
       displayVertex(startingVert);                 	
       queue.add(startingVert);  
 	   Vertex<E> v2;
 	
 	   while (!queue.isEmpty()) {
 	      Vertex<E> v1 = queue.remove(); 
 	      
 	      // while vertex has unvisited neighbors
 	      while ((v2 = getAdjUnvisitedVertex(v1)) != null ) {                                  
 	    	 v2.setVisited(true);  				
 	         displayVertex(v2);                
 	         queue.add(v2);               	
 	      }   
 	   }  
 	
 	   // queue is empty, so we're done. Reset flags
 	   for (int i = 0; i < verticies.size(); i++) {            
 		  verticies.get(i).setVisited(false);
 	   }
 	   
    }  
    
    private Vertex<E> getAdjUnvisitedVertex(Vertex<E> vertex) {
       for (Edge<E> edge : vertex) {
    	   Vertex<E> nextVert = edge.getTwo(); 
           if (!nextVert.wasVisited()) {
             return nextVert;
          }
       }
       
       //all vertices have been visited
       return null;       
    } 
    
    private void displayVertex(Vertex<E> v) {
    	System.out.println(v);
    }

}
