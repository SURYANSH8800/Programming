1class Solution {
2    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
3        if(n==1) return Arrays.asList(0);
4        int[] indegree = new int[n];
5        List<Integer>[] grid = new ArrayList[n];
6        for(int i=0;i<n;i++){
7            grid[i] = new ArrayList<>();
8        }
9        for(int[] pre : edges){
10            int c = pre[1];
11            int p = pre[0];
12            grid[c].add(p);
13            grid[p].add(c);
14            indegree[p]++;
15            indegree[c]++;
16        }
17        Queue<Integer> q = new LinkedList<>();
18        for(int i=0;i<indegree.length;i++){
19            if(indegree[i]==1){
20                q.add(i);
21            }
22        }
23        while(n>2){
24            int s = q.size();
25            n = n-s;
26            for(int i=0;i<s;i++){
27                int node = q.poll();
28                for(int neigh : grid[node]){
29                    indegree[neigh]--;
30                    if(indegree[neigh]==1){
31                        q.add(neigh);
32                    }
33                }
34            }
35        }
36        return new ArrayList<>(q);
37    }
38}