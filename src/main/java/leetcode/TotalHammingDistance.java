package leetcode;

/**
 * Created by amit.bhengra on 17/10/18.
 *
 * https://leetcode.com/problems/total-hamming-distance/description/
 *
 * Solution : https://leetcode.com/problems/total-hamming-distance/solution/
 */
public class TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int sum = 0;
        for(int i=0; i<nums.length-1 ; i++){
            for(int j=i+1; j<nums.length; j++){
                sum += findHammingDistance(nums[i],nums[j]);
            }
        }
        return sum;
    }

    public int findHammingDistance(int num1 ,int num2){
        int xor = num1^num2;
        int count=0;
        while(xor > 0){
            xor &= xor-1;
            count++;
        }
        return count;
    }
}
