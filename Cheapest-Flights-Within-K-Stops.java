1class Solution {
2    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
3        List<List<int[]>> grid = new ArrayList<>();
4        for(int i=0;i<n;i++){
5            grid.add(new ArrayList<>());
6        }
7        for(int[] f : flights){
8            int from = f[0];
9            int to = f[1];
10            int price = f[2];
11            grid.get(from).add(new int[]{to,price});
12        }
13        int[][] prices = new int[n][k+2];
14        for(int[] row : prices){
15            Arrays.fill(row,Integer.MAX_VALUE);
16        }
17        prices[src][0] = 0;
18        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
19        pq.add(new int[]{src,0,0});
20        while(!pq.isEmpty()){
21            int[] p = pq.poll();
22            int node = p[0];
23            int price = p[1];
24            int stops = p[2];
25            if(stops > k+1) continue;
26            for(int[] neigh : grid.get(node)){
27                int next = neigh[0];
28                int nextprice = neigh[1];
29                int newcost = nextprice + price;
30                int newstops = stops+1;
31                if(newstops <= k+1 && newcost<prices[next][newstops]){
32                    prices[next][newstops] = newcost;
33                    pq.add(new int[]{next,newcost,newstops});
34                }
35            }
36        }
37        int ans = Integer.MAX_VALUE;
38        for(int i=0;i<=k+1;i++){
39            ans = Math.min(ans,prices[dst][i]);
40        }
41        return ans == Integer.MAX_VALUE ? -1 : ans;
42    }
43}