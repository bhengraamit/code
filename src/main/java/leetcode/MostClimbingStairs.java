package leetcode;

/**
 * Created by amit.bhengra on 13/09/18.
 *
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 */
public class MostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length <= 1 )
            return 0;
        // atleast length 2
        if(cost.length >=3){
            for(int i =cost.length-3; i>=0;i--){
                cost[i] = cost[i] + Math.min(cost[i+1],cost[i+2]);
            }
        }
        return Math.min(cost[0],cost[1]);
    }
}
