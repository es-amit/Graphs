import java.util.*;
public class CycleUndirected {
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
    // cycle detection in undirected graph
    public static boolean detectCycle(ArrayList<Edge> graph[],boolean vis[],int curr,int parent){
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e =graph[curr].get(i);
            // 1st condition - cycle detection (if neighbour is visited by other node and also not it is parent)
            if(!vis[e.dest] && parent!= e.dest){
                return true;
            }
            //2nd condtion not needed -(if neighbour is visited by other node and also it is parent)
            // 3rd condition - if not visited 
            if(!vis[e.dest]){
                if(detectCycle(graph, vis, e.dest, curr)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        // //Adding edges between vertices
        createGraph(graph);
        boolean[] vis = new boolean[V];
        System.out.println(detectCycle(graph, vis, 0, -1));
    }
}
