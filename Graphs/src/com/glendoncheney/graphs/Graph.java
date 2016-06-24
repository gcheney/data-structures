package com.glendoncheney.graphs;

import java.util.ArrayList;

public class Graph<E> {

	//vertices of the graph
    private ArrayList<Vertex<E>> vertices; 

    /**
     * Constructs an empty Graph object
     */
    public Graph() {
         vertices = new ArrayList<Vertex<E>>();
    }

    /**
     * add Vertex to the Graph
     * @param vertex The vertex to add
     * @return True if the vertex was added, false otherwise
     */
    public boolean addVertex(Vertex<E> vertex) {
         if (vertices.contains(vertex)) {
        	 return false;
         }         
         vertices.add(vertex);
         return true;
    }

    public boolean contains(Vertex<E> vertex) {
        return vertices.contains(vertex);
    }

    public Vertex<E> get(int index) {
       return vertices.get(index);
    }
   
    public ArrayList<Vertex<E>> getVerticies() {
    	return vertices;
    }
    
    /**
     * returns number of Edges in Graph
     * @return The number of Edges in Graph
     */
    public int count() {
    	return vertices.size();
    }

    /**
     * Compares this Graph to another Graph object
     * @param other The other Graph object
     * @return True if they contain the same number of 
     * vertices, false otherwise. 
     */
    public boolean equals(Graph<E> other) {
        if (other.vertices.size() != vertices.size()) {
            return false;
        }
        
        //store all of Edges of larger Graph 
        ArrayList<Vertex<E>> temp = new ArrayList<Vertex<E>>(other.vertices);
                
        //if temp changed, then the Graphs are not equal
        return temp.retainAll(vertices); 
    }
    
}

