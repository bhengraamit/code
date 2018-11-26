package leetcode;

/**
 * Created by amit.bhengra on 13/09/18.
 *
 * https://leetcode.com/problems/house-robber/description/
 */
public class HouseRobber {

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        int[] nums = {1,2,3,1};
        System.out.println(houseRobber.rob(nums));
    }
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0],nums[1]);
        // with min length 3;
        int maxSum = Math.max(nums[0],nums[1]);;
        int ppprev = 0;
        int pprev = nums[0];
        int prev = nums[1];
        for(int i = 2;i<nums.length;i++){
            nums[i] += Math.max(pprev,ppprev);
            maxSum = nums[i] > maxSum ? nums[i] : maxSum;
            ppprev = pprev;
            pprev = prev;
            prev = nums[i];
        }
        return maxSum;
    }
}
