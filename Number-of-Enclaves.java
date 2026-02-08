1class Solution {
2    public int numEnclaves(int[][] grid) {
3        int c = 0;
4        int m = grid.length;
5        int n = grid[0].length;
6        //remove boundry check
7        for(int i=0;i<m;i++){
8            if(grid[i][0]==1) dfs(grid,i,0);
9            if(grid[i][n-1]==1) dfs(grid,i,n-1);
10        }
11        for(int j=0;j<n;j++){
12            if(grid[0][j]==1) dfs(grid,0,j);
13            if(grid[m-1][j]==1) dfs(grid,m-1,j);
14        }
15        // now check 1's
16        for(int  i = 0;i<m;i++){
17            for(int j = 0;j<n;j++){
18                if(grid[i][j]==1){
19                    c++;
20                }
21            }
22        }
23        return c;
24    }
25    private void dfs(int[][] grid,int r,int c){
26        if(r<0||r>=grid.length||c<0||c>=grid[0].length||grid[r][c]==0){
27            return;
28        }
29        grid[r][c] = 0;
30        
31        dfs(grid,r-1,c);
32        dfs(grid,r+1,c);
33        dfs(grid,r,c-1);
34        dfs(grid,r,c+1);
35    }
36}