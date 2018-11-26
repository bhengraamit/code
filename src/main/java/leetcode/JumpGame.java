package leetcode;

/**
 * Created by amit.bhengra on 19/10/18.
 *
 * https://leetcode.com/problems/jump-game/description/
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0)
            return true;
        int lastValidIndex = nums.length-1;
        for(int i=nums.length-1; i>=0 ; i--){
            if(nums[i] >= lastValidIndex -i)
                lastValidIndex = i;
        }

        return lastValidIndex==0;
    }
}
