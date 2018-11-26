package leetcode;

/**
 * Created by amit.bhengra on 26/08/18.
 * https://leetcode.com/problems/move-zeroes/description/
 */
public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes moveZeroesObj = new MoveZeroes();
        int[] nums= {0,1,0,3,12};
        moveZeroesObj.moveZeroes(nums);
        System.out.println(nums);
    }
    public void moveZeroes(int[] nums) {
        int start = 0;
        while(start<nums.length){
            int zeroIndex = findNumber(nums,start,true);
            if(zeroIndex == -1)
                return;
            int nonZeroIndex = findNumber(nums,zeroIndex,false);
            if(nonZeroIndex == -1)
                return;
            int temp = nums[zeroIndex];
            nums[zeroIndex] = nums[nonZeroIndex];
            nums[nonZeroIndex] = temp;

            start = start+1;
        }
    }

    public int findNumber(int[] nums, int startIndex, boolean isZero){
        int ret = -1;
        while(startIndex < nums.length){
            if(isZero){
                if(nums[startIndex] == 0)
                    return startIndex;
            }else{
                if(nums[startIndex] != 0)
                    return startIndex;
            }
            startIndex++;
        }
        return ret;
    }
}
