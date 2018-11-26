package leetcode;

/**
 * Created by amit.bhengra on 13/09/18.
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * Code can be more cleaner : https://leetcode.com/problems/maximum-subarray/discuss/
 */
public class MaximumSumSubarray {

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;
        if(nums.length == 1)
            return nums[0];

        int maxSum = Integer.MIN_VALUE;
        //find first positive
        int i = 0;
        while(i<nums.length){
            if(nums[i] >= 0)
                break;
            else
                maxSum = maxSum < nums[i] ? nums[i] : maxSum;
            i++;
        }
        if(i == nums.length)
            return maxSum;

        maxSum = nums[i];
        int tempSum = nums[i];   // first positive as tempSum
        i++;
        boolean findPositive = false;
        for(;i<nums.length;i++){
            if(findPositive){
                if(nums[i] >=0){
                    findPositive = false;
                }else{
                    continue;
                }
            }

            tempSum += nums[i];
            maxSum = tempSum > maxSum ? tempSum : maxSum;
            if(tempSum < 0){
                findPositive = true;
                tempSum = 0;
            }
        }
        return maxSum;
    }

    /**
     * Brilliant code
     *
     * public int maxSubArray(int[] A) {
     int max = Integer.MIN_VALUE, sum = 0;
     for (int i = 0; i < A.length; i++) {
     if (sum < 0)
     sum = A[i];
     else
     sum += A[i];
     if (sum > max)
     max = sum;
     }
     return max;
     }
     */
}
