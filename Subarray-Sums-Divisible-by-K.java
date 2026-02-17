1class Solution {
2    public int subarraysDivByK(int[] nums, int k) {
3        Map<Integer,Integer> map = new HashMap<>();
4        map.put(0,1);
5        int sum = 0;
6        int c = 0;
7        for(int num : nums){
8            sum = sum +num;
9            int rem = sum%k;
10            if(rem<0) rem = rem + k;
11            c = c + map.getOrDefault(rem,0);
12            
13            map.put(rem,map.getOrDefault(rem,0)+1);
14        }
15        return c;
16    }
17}