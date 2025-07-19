package C1;

public class productofarrayexceptself {
    public static int[] productExceptSelf(int[] nums) {
        int[] multi = new int[nums.length];
        int pre = 1;
        int post = 1;
        for (int i = 0; i < nums.length; i++) {
            multi[i] = pre;
            pre *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            multi[i] *= post;
            post *= nums[i];
        }

        return multi;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        System.out.println("original array : " + nums);
        nums = productExceptSelf(nums);
        System.out.println("Resultant Array : " + nums);
    }
}
