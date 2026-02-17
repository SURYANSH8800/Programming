1class Solution {
2    public int numberOfSubarrays(int[] nums, int k) {
3        Map<Integer,Integer> map = new HashMap<>();
4        map.put(0,1);
5        int sum = 0;
6        int c = 0;
7        for(int num : nums){
8            sum = sum + num%2;
9            if(map.containsKey(sum-k)){
10                c = c + map.get(sum-k);
11            }
12            map.put(sum,map.getOrDefault(sum,0)+1);
13        }
14        return c;
15    }
16}