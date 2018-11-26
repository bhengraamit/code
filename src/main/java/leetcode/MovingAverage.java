package leetcode;

/**
 * Created by amit.bhengra on 06/10/18.
 *
 * https://leetcode.com/problems/moving-average-from-data-stream/description/
 */
public class MovingAverage {
    int[] nums;
    int start = 0;
    int end = 0;
    boolean full;
    double sum = 0.0;
    int currentSize=0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        nums = new int[size];
    }

    public double next(int val) {
        if(!full){
            nums[end] = val;
            sum += val;
            currentSize++;
        }else{
            sum -= nums[start];
            nums[end] = val;
            sum += val;
            start++;
        }
        end++;
        if(end == nums.length){
            end = 0;
            full = true;
        }
        if(start == nums.length){
            start = 0;
        }
        return sum / currentSize ;
    }
}
