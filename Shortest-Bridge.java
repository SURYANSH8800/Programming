1class Solution {
2    private Queue<int[]> q = new LinkedList<>();
3    public int shortestBridge(int[][] grid) {
4        //phase 1 using dfs to identify an island
5        int m=grid.length;
6        int n=grid[0].length;
7        boolean found = false;
8        for(int i=0;i<m;i++){
9            for(int j=0;j<n;j++){
10                if(grid[i][j]==1){
11                    dfs(grid,i,j);
12                    found = true;
13                    break;
14                }
15            }
16            if(found) break;
17        }
18
19        //phase 2 use multi source bfs to count the number if zeros which are needed to be coverted to bridge(2)
20        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
21        int size = 0;
22        int minsize = 0;
23        while(!q.isEmpty()){
24            int s = q.size();
25            for(int i=0;i<s;i++){
26                int[] curr = q.poll();
27                for(int[] d : dir){
28                    int r = curr[0]+d[0];
29                    int c = curr[1]+d[1];
30                    if(r>=m||r<0||c>=n||c<0){
31                        continue;
32                    }
33                    if(grid[r][c]==1) return size;
34
35                    if(grid[r][c]==0){
36                        grid[r][c]=2;
37                        q.add(new int[]{r,c});
38                    }
39                }
40            
41            }
42            size++;
43        }
44        return -1;
45    }
46    private void dfs(int[][] grid,int r,int c){
47        if(r<0||r>=grid.length||c<0||c>=grid[0].length||grid[r][c]!=1){
48            return;
49        }
50        grid[r][c]=2;
51        q.add(new int[]{r,c});
52        dfs(grid,r-1,c);
53        dfs(grid,r+1,c);
54        dfs(grid,r,c-1);
55        dfs(grid,r,c+1);
56    }
57}