import java.util.ArrayList;

public class graph_basic{
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
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
    }
    public static void printNeighbour(ArrayList<Edge> graph[],int vertex){
        for(int i=0;i<graph[vertex].size();i++){
            Edge e = graph[vertex].get(i);
            System.out.print(e.dest+" ");
        }
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        // //Adding edges between vertices
        createGraph(graph);
        
       // createGraph(graph);
        printNeighbour(graph, 2);
    }
}