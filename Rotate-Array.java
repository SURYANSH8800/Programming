1class Solution {
2    public void rotate(int[] nums, int k) {
3        k = k % nums.length;
4        nums = reverse(nums,0, nums.length-1);
5        nums = reverse(nums,0, k-1);
6        nums = reverse(nums,k, nums.length-1);
7    }
8    public int[] reverse(int[] nums, int i, int j){
9        while(i<j){
10            int t = nums[i];
11            nums[i] = nums[j];
12            nums[j] = t;
13            i++;
14            j--;
15        }
16        return nums;
17    }
18}