package com.glendoncheney.graphs;

/**
 * 
 * @author glen
 *
 * @param <E>
 */
public class Edge<E> implements Comparable<Edge<E>> {
	   private Vertex<E> one, two;
	   private int weight;
	   private final static int BASE_DISTANCE = 0;

	   /*T his constructor creates
	    * an Edge object to Connect two Nodes
	    *  together with a standard distance of 0
	    *  By using this constructor, it is assumed
	    *  That distance is either weighted through the
	    *  vertices or otherwise is irrelevant 
	   */  
	   public Edge(Vertex<E> one, Vertex<E> two) {
	      this(one, two, BASE_DISTANCE); 
	   }

	   public Edge(Vertex<E> one, Vertex<E> two, int distance) { 
	        this.one = one;
	        this.two = two;
	        this.weight = distance;
	   }

	   public Vertex<E> getOne() {
		   return one;
	   }
	   
	   public Vertex<E> getTwo(){
		   return two;
	   }
	   
	   public int getWeight(){
		   return weight;
	   }
	   
	   public void setWeight(int distance){
		   this.weight = distance;
	   }

	   /**
	    * Two edges are equal if the two vertices
	    * @param other The Edge to check equality with
	    * @return True if the edges are equal, false otherwise
	    */
	   public boolean equals(Edge<E> other) {
	      return one.equals(other.getOne()) && 
	             two.equals(other.getTwo()) &&
	             weight == other.getWeight();
	   }

	   @Override
	   public String toString(){ 
		   return "(" + one.getElem() + ", " + two.getElem() + "): " + weight; 
	   }

	   @Override
	   public int compareTo(Edge<E> other){
	       return this.weight - other.getWeight();
	   }
	}

