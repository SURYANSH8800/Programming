1class Solution {
2    public int search(int[] nums, int target) {
3        if (nums == null || nums.length == 0) return -1;
4
5        int l = 0;
6        int r = nums.length - 1;
7
8        while (l <= r) {
9            int mid = l + (r - l) / 2;
10            if (nums[mid] == target) return mid;
11
12            if (nums[l] <= nums[mid]) {
13                if (nums[l] <= target && target < nums[mid]) {
14                    r = mid - 1;
15                } else {
16                    l = mid + 1;
17                }
18            } 
19            else {
20                if (nums[mid] < target && target <= nums[r]) {
21                    l = mid + 1;
22                } else {
23                    r = mid - 1;
24                }
25            }
26        }
27        return -1;
28    }
29}
30