package leetcode;

import java.util.Arrays;

/**
 * Created by amit.bhengra on 25/08/18.
 * https://leetcode.com/problems/next-permutation/description/
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if(nums.length == 1)
            return;
        int j=nums.length-2;
        int i = nums.length-1;
        while (j>=0){
            // if(nums[j] > nums[i])
            //     i--;
            if(nums[j] < nums[i])
                break;
            j--;
            i--;
        }
        if(j <0 ){
            Arrays.sort(nums);
            return;
        }
        int k =nums.length-1;
        while(k>j){
            if(nums[k] > nums[j])
                break;
            k--;
        }
        int temp = nums[k];
        nums[k] = nums[j];
        nums[j] = temp;
        Arrays.sort(nums,j+1,nums.length);
    }
}
