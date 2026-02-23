1class Solution {
2    public List<Integer> eventualSafeNodes(int[][] graph) {
3        int n = graph.length;
4        List<List<Integer>>  reverse = new ArrayList<>();
5        int[] outdegree = new int[n];
6        for (int i = 0; i < n; i++) {
7            reverse.add(new ArrayList<>());
8        }
9        for (int u=0;u<n;u++) {
10            outdegree[u] = graph[u].length;
11            for (int v : graph[u]) {
12                reverse.get(v).add(u);
13            }
14        }
15        Queue<Integer> q = new LinkedList<>();
16        List<Integer> l1 = new ArrayList<>();
17        for(int i=0;i<n;i++){
18            if(outdegree[i]==0){
19                q.offer(i);
20                l1.add(i);
21            }
22        }
23        while(!q.isEmpty()){
24            int node = q.poll();
25            for(int neigh:reverse.get(node)){
26                outdegree[neigh]--;
27                if(outdegree[neigh]==0){
28                    q.add(neigh);
29                    l1.add(neigh);
30                }
31            }
32        }
33        Collections.sort(l1);
34        return l1;
35    }
36}