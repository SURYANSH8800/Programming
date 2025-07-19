package C1;
import java.util.HashMap;
public class SubarraySumEqualsK {
    // Brute force - 1st approach O(N^2)
    public static int subarraySumI(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        for(int i =0; i<nums.length; i++){
            sum = 0;
            for(int j = i; j<nums.length;j++){
                sum = sum + nums[j];
                if(sum==k){
                    count++;
                }
            }
        }
        return count;
    }
    // Approach 2 - optimized hashmap
    public static int subarraySumII(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int c = 0, s=0;
        for(int num : nums){
            s+=num;
            if(map.containsKey(s-k)){
                c = c + map.get(s-k);
            }
            map.put(s,map.getOrDefault(s,0)+1);
        }
        return c;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3};
        int ans1 =  subarraySumI(nums,3);
        int ans2 =  subarraySumII(nums,3);
        System.out.println(ans1);
        System.out.println(ans2);
    }
}
