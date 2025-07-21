package Array;

class Solution {
    //Approach 1 - Two pointer approach
    public int[] minandmax_I(int[] arr) {
        int minsofar = arr[0];
        int maxsofar = arr[0];
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            minsofar = Math.min(minsofar, arr[l]);
            maxsofar = Math.max(maxsofar, arr[l]);

            if (l != r) { // Avoid repeating when l == r
                minsofar = Math.min(minsofar, arr[r]);
                maxsofar = Math.max(maxsofar, arr[r]);
            }
            l++;
            r--;
        }

        return new int[]{minsofar, maxsofar};
    }
}
public class FindMinandMax {
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] arr = {3, 5, 1, 2, 9, 7};

        int[] result = sol.minandmax_I(arr);
        System.out.println("Min: " + result[0]);
        System.out.println("Max: " + result[1]);
    }
}
