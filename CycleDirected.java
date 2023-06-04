import java.util.*;
public class CycleDirected {
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
        //Directed graph -cycle graph
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));

        // directed graph- non cyclic 
        // graph[0].add(new Edge(0, 2));
        // graph[0].add(new Edge(0, 1));
        // graph[1].add(new Edge(1, 3));
        // graph[2].add(new Edge(2, 3));
    }
    //cycle detection in directed graph
    public static boolean detectCycleDir(ArrayList<Edge> graph[],boolean vis[],int curr,boolean[] rec){
        vis[curr] =true;
        rec[curr] =true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(rec[e.dest] == true){
                return true;
            }
            else if(!vis[e.dest]){
                return detectCycleDir(graph, vis, e.dest, rec);
            }
            
        }
        rec[curr] =false;
        return false;
        
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        // //Adding edges between vertices
        createGraph(graph);
        boolean[] vis = new boolean[V];
        boolean[] rec = new boolean[V];
        System.out.println(detectCycleDir(graph, vis, 0, rec));
    }
}
