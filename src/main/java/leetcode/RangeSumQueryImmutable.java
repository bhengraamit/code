package leetcode;

/**
 * Created by amit.bhengra on 13/09/18.
 *
 * https://leetcode.com/problems/range-sum-query-immutable/description/
 */
public class RangeSumQueryImmutable {

    int[] sums = null;
    public RangeSumQueryImmutable(int[] nums) {
        int sum = 0;
        sums = new int[nums.length];
        for(int i = 0 ; i<nums.length; i++){
            sum += nums[i];
            sums[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        if(i==0)
            return sums[j];
        return sums[j] - sums[i-1];
    }
}
