package leetcode;

import java.util.Arrays;

/**
 * Created by amit.bhengra on 03/10/18.
 */
public class MaximumLengthPairChain {
    public static void main(String[] args) {
        MaximumLengthPairChain maximumLengthPairChain = new MaximumLengthPairChain();
        int[][] pairs = new int[3][2];
        pairs[0] = new int[]{1,5};
        pairs[1] = new int[]{2,3};
        pairs[2] = new int[]{4,5};
        System.out.println(maximumLengthPairChain.findLongestChain(pairs));
    }
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int sum = 0, n = pairs.length, i = -1;
        while (++i < n) {
            sum++;
            int curEnd = pairs[i][1];
            while (i+1 < n && pairs[i+1][0] <= curEnd) i++;
        }
        return sum;
    }
}
