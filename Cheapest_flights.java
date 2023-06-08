import java.util.*;

public class Cheapest_flights {
    public static class Pair implements Comparable<Pair>{
        int dest;
        int wt;
        int k;
        public Pair(int d,int w,int k){
            this.dest = d;
            this.wt =w;
            this.k =k;
        }
        public int compareTo(Pair p2){
            return this.wt - p2.wt;
        }
    }
    public static int solution(int[][] flights,int n,int src,int des,int k){
        Map<Integer,List<int[]>> map = new HashMap<>();
        for(int[] f: flights){
            map.putIfAbsent(f[0], new ArrayList<>());
            map.get(f[0]).add(new int[]{f[1],f[2]});
        }
        PriorityQueue<Pair> pq =new PriorityQueue<>();
        pq.add(new Pair(src, 0, k));
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            int currNode = curr.dest;
            int cost = curr.wt;
            int stop = curr.k;
            if(currNode == des){
                return cost;
            }
            if(stop>=0){
                if(!map.containsKey(currNode)){
                    continue;
                }
                for(int[] next: map.get(currNode)){
                    pq.add(new Pair(next[0], cost+next[1], k-1));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int n=4;
        int[][] flights={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0;
        int dest=3;
        int k=1;
        System.out.println(solution(flights, n, src, dest, k));
    }
}
