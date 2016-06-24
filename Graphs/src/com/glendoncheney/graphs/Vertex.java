package com.glendoncheney.graphs;


import java.util.*;

/**
 * The Vertex class represents a single vertex in  graph
 * @author Glendon Cheney
 */
public class Vertex<E> implements Iterable<Edge<E>> {

	//number of vertices
    private static int NUM_VERTS = 0; 

    /*
      When working with weighted Graphs,
      having an element becomes important.
      For example, in game programming, the
      weights could represent a lag or a hidden
      bonus that could make winning significantly
      easier.
    */
    private E element; 	
    private int id; 	
    private int weight;	 
    private boolean visited; 
    private LinkedList<Edge<E>> edges;

    /**
     * Default constructor, creates a vertex with an infinite weight
     */
    public Vertex() {
       this(null, Integer.MAX_VALUE);
    }

    /**
     * Vertex constructor
     * @param element The element to store in this vertex
     * @param weight the weight value of this vertex
     */
    public Vertex(E element, int weight) {
       this.element = element;
       this.weight = weight;
       id = NUM_VERTS++; 
       edges = new LinkedList<Edge<E>>();
    }

    /**
     * Returns the id for this Vertex
     * @return the id for this Vertex
     */
    public int getId(){
    	return id;
	}
    
    
    public boolean wasVisited() {
    	return visited;
    }
    
    public void setVisited(boolean visited) {
    	this.visited = visited;
    }

    /**
     * Returns the element stored at this vertex
     * @return The element stored at this vertex
     */
    public E getElem(){
    	return element;
	}
    
    /**
     * Sets this vertices element to the new parameter
     * @param element The new element at this vertex
     */
    public void setElem(E element){
    	this.element = element;
	}

    public int getWeight(){
    	return weight;
	}
    
    public void setWeight(int weight){
    	this.weight = weight;
	}
    
    /**
     * add a edge not taking weight into account
     * @param other The other vertex to connect to
     */
    public void addEdge(Vertex<E> other) {
        Edge<E> edge = new Edge<E>(this, other);
        //prevents adding duplicate edges
        if (!edges.contains(edge)) {
        	edges.add(edge);
        }
    }

    /**
     * Add edge with weight for this vertex
     * @param other The Vertex to connect to 
     * @param weight The weight of the new edge
     */
    public void addEdge(Vertex<E> other, int weight) {
        Edge<E> edge = new Edge<E>(this, other, weight);
        if (!edges.contains(edge)) {
        	edges.add(edge);
        }
    }

    public LinkedList<Edge<E>> getEdges() {
    	return edges;
    }

    public void sortEdges(){ 
    	Collections.sort(edges); 
    }
    
    public Iterator<Edge<E>> iterator(){
    	return edges.iterator();
    }

    /**
     * one Vertex is equal to another if the two elements are equal to each other
     * and they have the same Edges
     * @param other The other vertex to compare to
     * @return True if both vertices are the same, false otherwise
     */
    public boolean equals(Vertex<E> other) {
        if (other.edges.size() != edges.size()) {
             return false;
        }
        LinkedList<Edge<E>> temp = new LinkedList<Edge<E>>(edges);

        //if the elements are equal and the Lists are equal, regardless of order
        //then the vertices are equal
        return element.equals(other.getElem()) && temp.retainAll(other.edges);
    }

    @Override
    public String toString() {
    	return this.element.toString();
    }
    
}