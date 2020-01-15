package practice.graphs;

import java.util.LinkedList;

class GraphAdjList{

    public static void main(String[] args) {
        
    		Graph g = new Graph(6);
    		g.addEdge(0, 1);
    		g.addEdge(1, 2);
    		g.addEdge(2, 3);
    		g.addEdge(3, 4);
    		g.addEdge(4, 5);
    		g.addEdge(5, 0);
    		g.addEdge(1, 5);
    		g.addEdge(2, 5);
    		g.addEdge(2, 4);
    		
    		System.out.println(" dfs ");
    		g.dfs();
    		
    		System.out.println(" bfs ");
    		g.bfs();
    		
    		
    }


    static class Graph{
        int V;
        LinkedList<Integer>[] adjListArr;

        Graph(int V){
            this.V = V;
            adjListArr = new LinkedList[V];
            for ( int i=0; i < V; i++)
            		adjListArr[i] = new LinkedList();  
        }

        void addEdge(int src, int dest){
            adjListArr[src].addLast(dest);
            adjListArr[dest].addLast(src);
        }

        void dfs(){

            boolean[] visited = new boolean[V];
            for (int i =0; i < V; i++){
                if ( !visited[i] )
                    dfsUtil(visited, i);
            }
        }

        void dfsUtil(boolean[] visited, int u){

            visited[u] = true;
            System.out.println(u);

            LinkedList<Integer> adjList = adjListArr[u];

            for ( int i=0; i < adjList.size(); i++){
                int v = adjList.get(i);
                if ( !visited[v])
                    dfsUtil(visited,v);
            }
        }

        void bfs(){
            boolean[] visited = new boolean[V];

            LinkedList<Integer> queue = new LinkedList();
            queue.add(0);
            visited[0] = true;

            while ( !queue.isEmpty() ){
                int u = queue.poll();
                System.out.println(u);

                LinkedList<Integer> list = adjListArr[u];
                
                for ( int i=0; i < list.size(); i++){
                    int v = list.get(i);
                    if ( !visited[v] ){
                        queue.add(v);
                        visited[v] = true;
                    }
                }

            }
        }
    }
}