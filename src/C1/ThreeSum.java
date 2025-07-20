package C1;
import java.util.Arrays;

public class ThreeSum {
    public static void threesum(int[] nums, int target) {
        Arrays.sort(nums);  // Sorting is necessary for two-pointer approach

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    System.out.println(nums[i] + " + " + nums[left] + " + " + nums[right] + " = " + target);
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 12;
        threesum(nums, target);
    }
}