public class no_of_islands {
    public static int islands=0;
    public static void solution(char[][] grid,int i,int j,boolean[][] vis){
        int m=grid.length;
        int n = grid[0].length;
        if(i<0 || i>=m){
            return;
        }
        if(j<0 || j>=n){
            return;
        }
        if(vis[i][j]==true || grid[i][j]=='0'){
            return;
        }
        vis[i][j] = true;
        //for upper element
        solution(grid, i-1, j,vis);
        //for bottom element
        solution(grid, i+1, j,vis);
        //for left element
        solution(grid, i, j-1,vis);
        //for right element
        solution(grid, i, j+1,vis);
    }
    
    public static void main(String[] args) {
        // char [][] grid = {
        //     {'1','1','1','1','0'},
        //     {'1','1','0','1','0'},
        //     {'1','1','0','0','0'},
        //     {'0','0','0','0','0'}
        // };
        char[][] grid ={
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };

        int m=grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1' && vis[i][j] ==false){
                    islands++;
                    solution(grid, i, j, vis);

                }
            }
        }
        System.out.println(islands);
    }
}


