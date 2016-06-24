package com.glendoncheney.graphs;

public class GraphSearchTest {
	
	public static void main(String[] args) {
		Graph<Character> graph = new Graph<Character>();
	    Vertex<Character> i = new Vertex<Character>('i', 0);
	    Vertex<Character> j = new Vertex<Character>('j', 0);
	    Vertex<Character> k = new Vertex<Character>('k', 0);
	    Vertex<Character> l = new Vertex<Character>('l', 0);
	    Vertex<Character> m = new Vertex<Character>('m', 0);
	    Vertex<Character> n = new Vertex<Character>('n', 0);

	    graph.addVertex(i);
	    graph.addVertex(j);
	    graph.addVertex(k);
	    graph.addVertex(l);
	    graph.addVertex(m);
	    graph.addVertex(n);
	    
	    i.addEdge(j, 7);
	    i.addEdge(k, 9);
	    i.addEdge(n, 14);

	    j.addEdge(k, 10);
	    j.addEdge(l, 15);

	    k.addEdge(n, 2);
	    k.addEdge(l, 11);

	    l.addEdge(m, 6);
	    
	    n.addEdge(m, 9);
	    
	    GraphSearch<Character> test = new GraphSearch<Character>(graph);
	    
	    System.out.println("Depth first search visits: ");
	    test.depthFirstSearch();
	    System.out.println();
	    
	    System.out.println("Breadth first search visits: ");
	    test.breadthFirstSearch();
	    System.out.println();
	}
}
