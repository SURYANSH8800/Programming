package Array;
public class sort_0_1_2 {
    public static int[] solution(int[] nums){
        int zeros=0,ones=0,tows=0;
        for(int num : nums) {
            if (num == 0) {
                zeros++;
            }
            else if(num==1){
                ones++;
            }
            else{
                tows++;
            }
        }
        int i = 0;
        while(zeros>0){
            nums[i] = 0;
            i++;
            zeros--;
        }
        while(ones>0){
            nums[i] = 1;
            i++;
            ones--;
        }
        while(tows>0){
            nums[i] = 2;
            i++;
            tows--;
        }
        return nums;
    }
    public static void main(String[] args){
        int[] nums = {0,2,1,1,0,1,0,2,0,1};
        nums = solution(nums);
        for(int i = 0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
}
