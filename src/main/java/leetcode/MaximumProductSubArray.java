package leetcode;

/**
 * Created by amit.bhengra on 18/10/18.
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 */
public class MaximumProductSubArray {

    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int max_product = Integer.MIN_VALUE;
        int temp = 1;
        int tempIndex = 0;
        for(int i=0; i<nums.length ; i++){
            if(nums[i] ==0){
                max_product = max_product < nums[i] ? nums[i] : max_product;
                int tempMax = findMax(tempIndex,i-1,nums,temp);
                max_product = max_product < tempMax ? tempMax : max_product;
                temp = 1;
                tempIndex = i+1;
            }else{
                temp = temp * nums[i];
                max_product = max_product < temp ? temp : max_product;
            }
        }
        if(tempIndex < nums.length){
            int tempMax = findMax(tempIndex,nums.length-1,nums,temp);
            max_product = max_product < tempMax ? tempMax : max_product;
        }
        return max_product;
    }

    public int findMax(int start, int end,int[] nums, int tempProd){
        if(start > end)
            return Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;

        while(start < end){
            tempProd = tempProd / nums[start];
            max = max < tempProd ? tempProd : max;
            start++;
        }
        return max;
    }
}
