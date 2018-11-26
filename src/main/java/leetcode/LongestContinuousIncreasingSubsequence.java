package leetcode;

/**
 * Created by amit.bhengra on 18/10/18.
 *
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
 */
public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int max = 1;
        int temp = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i-1] < nums[i])
                temp++;
            else{
                max = max < temp ? temp : max;
                temp = 1;
            }
        }
        max = max < temp ? temp : max;
        return max;
    }
}
