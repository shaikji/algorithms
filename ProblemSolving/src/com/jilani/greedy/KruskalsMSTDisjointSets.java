package com.jilani.greedy;

import java.util.Collections;
import java.util.LinkedList;

import com.jilani.greedy.KruskalsMSTDisjointSets.Graph.Edge;

class KruskalsMSTDisjointSets{

    public static void main(String[] args) {


        Graph graph = new Graph(4);
        graph.addEdge(0,1,10);
        graph.addEdge(0,2,6);
        graph.addEdge(2,3,4);
        graph.addEdge(1,3,15);
        graph.addEdge(0,3,5);

        kruskalsMST(graph);
    }

    static void kruskalsMST( Graph graph){

        Collections.sort(graph.edgeList);
        DisjointSets ds = new DisjointSets();

        for ( int i=0; i < graph.V; i++){
            ds.makeSet(i);
        }   

        for ( Edge edge: graph.edgeList){
            int x = ds.findSet(edge.src);
            int y = ds.findSet(edge.dest);

            if ( x == y ){
                continue;
            }

            ds.union(x, y);
            System.out.println("Edge " + edge.src+ " --> " + edge.dest +" [ "+ edge.weight +" ] " + " is included in MST");
        }



    }



    static class Graph{
        int V;

        LinkedList<Edge> edgeList;

        Graph(int V){
            this.V = V;
            edgeList = new LinkedList();
        }

        void addEdge(int src, int dest, int weight){
            edgeList.add(new Edge(src, dest, weight));
        }

        static class Edge implements Comparable<Edge>{
            int src;
            int dest;
            int weight;
            
            Edge(int s, int d, int w){
            		src = s;
            		dest = d;
            		weight = w;
            }
			@Override
			public int compareTo(Edge e) {
				return this.weight-e.weight;
			}
            
            
        }
    }
}