import java.util.*;
public class TopologicalSort {
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
        // directed graph- non cyclic 
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 3));
    }
    public static void topSortUtil(ArrayList<Edge> graph[],boolean vis[],int curr,Stack<Integer> s){
        vis[curr] =true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topSortUtil(graph, vis, e.dest, s);
            }
        }
        s.push(curr);
    }
    public static void topSort(ArrayList<Edge> graph[],int V){
        boolean vis[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<V;i++){
            if(!vis[i]){
                topSortUtil(graph, vis, i, stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
    public static void main(String[] args) {
        int V =4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        // //Adding edges between vertices
        createGraph(graph);
        topSort(graph, V);
    }
}
