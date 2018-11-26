package leetcode;

/**
 * Created by amit.bhengra on 01/11/18.
 *
 * https://leetcode.com/problems/find-peak-element/description/
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length ==0)
            return -1;
        int start = 0;
        int end = nums.length-1;
        while(start < end){
            if(end-start==1)
                return nums[end] > nums[start] ? end : start;
            int mid = start + (end-start)/2;
            if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1])
                return mid;
            if(nums[mid+1] > nums[mid])
                start = mid;
            else
                end = mid;
        }
        return 0;
    }
}
