1class Solution {
2    public int maxAreaOfIsland(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5        int area = 0;
6        int maxarea = 0;
7        Queue<int[]> q = new LinkedList<>();
8        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
9        
10        for(int i=0;i<m;i++){
11            for(int j=0;j<n;j++){
12                if(grid[i][j]==1){
13                    q.add(new int[]{i,j});
14                    grid[i][j]=2;//marked as  visited
15                    
16                        area = 0;
17                    while(!q.isEmpty()){
18                        int[] curr = q.poll();
19                        area++;
20                        for(int[] d : dir){
21                            int r = curr[0]+d[0];
22                            int c = curr[1]+d[1];
23                            if(r<0||r>=m||c<0||c>=n) continue;
24
25                            if(grid[r][c] == 1){
26                                grid[r][c] = 2;
27                                q.add(new int[]{r,c});
28                            }
29                        }
30
31                    }
32                }
33                maxarea = Math.max(maxarea,area);
34            }
35        }
36        return maxarea;
37    }
38}