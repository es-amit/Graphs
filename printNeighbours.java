import java.util.*;
public class printNeighbours {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        // storing empty arraylist to array because by default null is stored so we can not store directly edges
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        //undirected graph
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 6));
        graph[5].add(new Edge(5, 4));
        graph[6].add(new Edge(6, 5));

        
    }
    public static void printNeighbour(ArrayList<Edge> graph[],int vertex){
        for(int i=0;i<graph[vertex].size();i++){
            Edge e = graph[vertex].get(i);
            System.out.print(e.dest+" ");
        }
    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        // //Adding edges between vertices
        createGraph(graph);
        printNeighbour(graph, 2);
    }
}
