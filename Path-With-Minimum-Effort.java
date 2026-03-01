1class Solution {
2    public int minimumEffortPath(int[][] heights) {
3        int row = heights.length;
4        int col = heights[0].length;
5        int[][] dist = new int[row][col];
6        for(int[] rows: dist){
7            Arrays.fill(rows,Integer.MAX_VALUE);
8        }
9        dist[0][0] = 0;
10        int steps = 0;
11        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
12        pq.add(new int[]{0,0,0});
13        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
14        while(!pq.isEmpty()){
15            int[] curr = pq.poll();
16            int effort = curr[0];
17            int r = curr[1];
18            int c = curr[2];
19            if(r==row-1&&c==col-1) return effort;
20            for(int[] d:dir){
21                int nr = r+d[0];
22                int nc = c+d[1];
23                if(nr>=0&&nr<row&&nc<col&&nc>=0){
24                    int edge = Math.abs(heights[r][c] - heights[nr][nc]);
25                    int ne = Math.max(effort, edge);
26                    if(ne<dist[nr][nc]){
27                        dist[nr][nc] = ne;
28                        pq.add(new int[]{ne,nr,nc});
29                    }
30                }
31                
32            }
33        }
34        return 0;
35    }
36}
37class pair{
38    int node;
39    int weight;
40    pair(int node,int weight){
41        this.node = node;
42        this.weight = weight;
43    }
44}