package leetcode;

/**
 * Created by amit.bhengra on 11/09/18.
 *
 * https://leetcode.com/problems/product-of-array-except-self/description/
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length <=1)
            return nums;
        int[] mult = new int[nums.length];
        int prev = 1;
        for(int i =0; i <nums.length;i++){
            mult[i] = prev*nums[i];
            prev = mult[i];
        }
        prev = 1;
        for(int j = nums.length-1; j>0; j--){
            mult[j] = prev * mult[j-1];
            prev = prev * nums[j];
        }
        mult[0] = prev;
        return mult;
    }
}
