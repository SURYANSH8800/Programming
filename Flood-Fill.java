1class Solution {
2    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
3        int m = grid.length;
4        int n = grid[0].length;
5        Queue<int[]> q = new LinkedList<>();
6        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
7        q.add(new int[]{sr,sc});
8        int curr_color = grid[sr][sc];
9        if(curr_color == color) return grid;
10        grid[sr][sc] = color;
11        while(!q.isEmpty()){
12            int s = q.size();
13            int[] curr = q.poll();
14            for(int[] d : dir){
15                int nr = curr[0]+d[0];
16                int nc = curr[1]+d[1];
17                if(nr<0||nr>=m||nc<0||nc>=n){
18                    continue;
19                }
20                if(grid[nr][nc]==curr_color){
21                    grid[nr][nc] = color;
22                    q.add(new int[]{nr,nc});
23                }
24            }
25        }
26        return grid;
27    }
28}