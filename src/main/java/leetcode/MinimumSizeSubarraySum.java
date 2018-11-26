package leetcode;

/**
 * Created by amit.bhengra on 06/10/18.
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        MinimumSizeSubarraySum minimumSizeSubarraySum  = new MinimumSizeSubarraySum();
        int[] nums = {1,7};
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(7,nums));
    }

    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int i=-1,j=-1;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(j<nums.length && i<=j){
            if(sum < s){
                if(nums.length > j+1)
                    sum += nums[++j];
                else
                    break;
            }else{
                min = j-i < min ? j-i : min;
                sum -= nums[++i];
            }
        }
        return min < Integer.MAX_VALUE ? min : 0;
    }
}
