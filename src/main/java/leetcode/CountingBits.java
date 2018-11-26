package leetcode;

/**
 * Created by amit.bhengra on 13/09/18.
 *
 * https://leetcode.com/problems/counting-bits/description/
 */
public class CountingBits {

    public int[] countBits(int num) {
        int[] count = new int[num+1];
        for(int i=0; i<=num; i++){
            if(i == 0)
                count[i] = 0;
            if(i==1)
                count[i] = 1;
            if(i == 2)
                count[i] = 1;
            int rem = i % 2;
            if(rem == 1)
                count[i] = count[i/2] +1;
            else
                count[i] = count[i/2];
        }
        return count;
    }
}
