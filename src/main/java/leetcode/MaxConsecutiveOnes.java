package leetcode;

/**
 * Created by amit.bhengra on 14/09/18.
 *
 * https://leetcode.com/problems/max-consecutive-ones/description/
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;
        int maxOne = 0;
        int tempOne = 0;
        for(int i=0; i<nums.length ;i++){
            if(nums[i] == 0)
                tempOne = 0;
            if(nums[i] == 1)
                tempOne++;
            maxOne = tempOne > maxOne ? tempOne : maxOne;
        }
        return maxOne;
    }
}
