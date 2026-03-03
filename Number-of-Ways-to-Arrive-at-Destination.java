1class Solution {
2    public int countPaths(int n, int[][] roads) {
3        List<List<long[]>> graph = new ArrayList<>();
4        for(int i=0;i<n;i++){
5            graph.add(new ArrayList<>());
6        }
7        for(int[] r : roads){
8            int u = r[0];
9            int v = r[1];
10            int w = r[2];
11            graph.get(u).add(new long[]{v,w});
12            graph.get(v).add(new long[]{u,w});
13        }
14        long[] dist = new long[n];
15        long[] ways = new long[n];
16        int mod = (int)1e9+7;
17        ways[0] = 1;
18        Arrays.fill(dist,Long.MAX_VALUE);
19        dist[0] = 0;
20        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[1], b[1]));
21        pq.add(new long[]{0,0});
22        while(!pq.isEmpty()){
23            long[] p = pq.poll();
24            int node = (int)p[0];
25            long dis = p[1];
26            if(dis > dist[node]) continue;
27            for(long[] neigh :graph.get(node)){
28                int next =(int)neigh[0];
29                long nextdist = neigh[1];
30                if(dist[node]+nextdist<dist[next]){
31                    dist[next]=dist[node]+nextdist;
32                    pq.add(new long[]{next,dist[next]});
33                    ways[next] = ways[node];
34                }
35                else if(dist[next]==dist[node]+nextdist){
36                    ways[next] = (ways[next] + ways[node])%mod;
37                }
38            }
39        }
40        return (int)ways[n-1];
41    }
42}