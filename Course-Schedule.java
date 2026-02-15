1class Solution {
2    public boolean canFinish(int numCourses, int[][] prerequisites) {
3
4        List<Integer>[] grid = new ArrayList[numCourses];
5        for (int i = 0; i < numCourses; i++) {
6            grid[i] = new ArrayList<>();
7        }
8        int[] indegree = new int[numCourses];
9        for (int[] p : prerequisites) {
10            int cr = p[0];
11            int pr = p[1];
12            grid[pr].add(cr);
13            indegree[cr]++;
14        }
15        Queue<Integer> q = new LinkedList<>();
16        for (int i = 0; i < numCourses; i++) {
17            if (indegree[i] == 0) {
18                q.add(i);
19            }
20        }
21        int c=0;
22        while (!q.isEmpty()) {
23            int node = q.poll();
24            c++;
25            for (int neigh : grid[node]) {
26                indegree[neigh]--;
27                if (indegree[neigh] == 0) {
28                    q.add(neigh);
29                }
30            }
31        }
32
33        return c == numCourses;
34    }
35}
36