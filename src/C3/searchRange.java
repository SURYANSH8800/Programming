package C3;

// LeetCode: 34. Find First and Last Position of Element in Sorted Array
import java.util.Arrays;
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearchFirstOccurrence(nums, target);
        if (first == -1) {
            return new int[]{-1, -1};
        }

        int last = first;
        while (last < nums.length && nums[last] == target) {
            last++;
        }

        return new int[]{first, last - 1};
    }

    private int binarySearchFirstOccurrence(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                right = mid - 1; // search on the left side for first occurrence
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
    public class searchRange{

        public static void main(String[] args) {
            Solution solution = new Solution();

            // Sample test input
            int[] nums = {5, 7, 7, 8, 8, 10};
            int target = 8;

            // Call the method
            int[] result = solution.searchRange(nums, target);

            // Print the result
            System.out.println("Input Array: " + Arrays.toString(nums));
            System.out.println("Target: " + target);
            System.out.println("Output Range: " + Arrays.toString(result));
        }
    }
}
