import java.util.*;

public class rotting_oranges{
    static class Pair{
        int row;
        int col;
        int tm;
        Pair(int r,int c,int t){
            this.row = r;
            this.col = c;
            this.tm= t;
        }
    }
    public static int solution(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] vis=new int[m][n];
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }
                if(grid[i][j]==1){
                    fresh++;
                }
                else{
                    vis[i][j]= 0;
                }  
            }
        }
        int tm=0;
        int drow[] ={-1,0,1,0};
        int dcol[] ={0,-1,0,1};
        int cnt =0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c= q.peek().col;
            int t = q.peek().tm;
            tm = Math.max(tm, t);
            q.remove();
            for(int i=0;i<4;i++){
                int nrow = r+drow[i];
                int ncol= c+dcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.add(new Pair(nrow, ncol, t+1));
                    vis[nrow][ncol]=1;
                    cnt++;
                }
            }
        }
        if(cnt == fresh){
            return tm;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] grid ={{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(solution(grid));
    }
}