package leetcode;

/**
 * Created by amit.bhengra on 13/09/18.
 *
 * https://leetcode.com/problems/paint-house/description/
 */
public class PaintHouse {

    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length==0)
            return 0;
        for(int i = costs.length-1; i>=0; i--){
            if(i == costs.length-1)
                continue;
            for(int j = 0; j <3; j++){
                if(j==0)
                    costs[i][j] = costs[i][j]+Math.min(costs[i+1][j+1],costs[i+1][j+2]);
                if(j==1)
                    costs[i][j] = costs[i][j]+Math.min(costs[i+1][j-1],costs[i+1][j+1]);
                if(j==2)
                    costs[i][j] = costs[i][j]+Math.min(costs[i+1][j-2],costs[i+1][j-1]);
            }
        }

        int min = costs[0][0];
        min = costs[0][1] < min ? costs[0][1] : min;
        min = costs[0][2] < min ? costs[0][2] : min;
        return min;
    }
}
