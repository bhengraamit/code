package leetcode;

/**
 * Created by amit.bhengra on 18/10/18.
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int prevDup = nums[0];
        int currentIndex = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] != prevDup){
                nums[currentIndex++] = nums[i];
                prevDup = nums[i];
            }
        }
        return currentIndex;
    }
}
