package leetcode;

/**
 * Created by amit.bhengra on 07/10/18.
 *
 * https://leetcode.com/contest/weekly-contest-105/problems/maximum-sum-circular-subarray/
 */
public class MaximumSumCircularSubArray {
    public static void main(String[] args) {
        MaximumSumCircularSubArray maximumSumCircularSubArray = new MaximumSumCircularSubArray();
        int[] nums = {1,-2,3,-2};
        int[] nums1 = {5,-3,5};
        int[] nums2 = {3,-1,2,-1};
        int[] nums3 = {3,-2,2,-3};
        System.out.println(maximumSumCircularSubArray.maxSubarraySumCircular(nums));
        System.out.println(maximumSumCircularSubArray.maxSubarraySumCircular(nums1));
        System.out.println(maximumSumCircularSubArray.maxSubarraySumCircular(nums2));
        System.out.println(maximumSumCircularSubArray.maxSubarraySumCircular(nums3));
    }

    public int maxSubarraySumCircular(int[] A) {
        if(A == null || A.length ==0)
            return 0;
        if(A.length == 1)
            return A[0];
        int max_sum = A[0];
        int curr_sum = A[0];

        for(int i=1; i<A.length; i++){
            curr_sum = Math.max(A[i],curr_sum+A[i]);
            max_sum = Math.max(max_sum,curr_sum);
        }
        return max_sum;
    }
}
