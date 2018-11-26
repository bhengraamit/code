package leetcode;

/**
 * Created by amit.bhengra on 13/09/18.
 *
 * https://leetcode.com/problems/climbing-stairs/description/
 *
 * https://leetcode.com/problems/climbing-stairs/solution/ - O(logN) - Not trivial methods
 *
 * This solution = O(n)
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if(n<=0)
            return 1;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        // n greater than equal to 3
        int pStep = 2;
        int ppStep = 1;
        for(int i =2; i<=n-1;i++){
            int currentStep = ppStep + pStep;
            int temp = pStep;
            pStep = currentStep;
            ppStep = temp;
        }
        return pStep;
    }
}
