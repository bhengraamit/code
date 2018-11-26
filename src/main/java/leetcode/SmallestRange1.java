package leetcode;

/**
 * Created by amit.bhengra on 23/09/18.
 *
 * https://leetcode.com/contest/weekly-contest-103/problems/smallest-range-i/
 */
public class SmallestRange1 {
    public int smallestRangeI(int[] A, int K) {
        if(A == null || A.length == 0)
            return -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : A){
            if(num < min)
                min = num;
            if(num > max)
                max = num;
        }

        return max-min > 2*K ? max-min-(2*K) : 0;
    }
}
