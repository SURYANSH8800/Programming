import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args){
        int[] nums = {4, 5, 2, 25};
        int[] res = nge(nums);
        for(int i : res){
            System.out.println(i);
        }
    }

    private static int[] nge(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        st.push(0);

        for(int i = 1; i < n; i++){
            while(!st.isEmpty() && nums[i] > nums[st.peek()]){
                res[st.peek()] = nums[i];
                st.pop();
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            res[st.pop()] = -1;
        }

        return res;
    }
}
