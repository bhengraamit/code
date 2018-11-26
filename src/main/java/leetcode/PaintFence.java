package leetcode;

/**
 * Created by amit.bhengra on 13/09/18.
 *
 * https://leetcode.com/problems/paint-fence/description/
 */
public class PaintFence {

    public int numWays(int n, int k) {
        if(n ==0 || k ==0)
            return 0;
        int[][] dp= new int[n+1][k+1];

        for(int i=0; i<=n; i++){
            for(int j=1; j<=k; j++){
                if(i==0)
                    dp[i][j] = 1;
                else if(i==1)
                    dp[i][j] = j;
                else
                    dp[i][j] = j*dp[i-1][j-1] + j*j*dp[i-2][j-1];
            }
        }
        return dp[n][k];
    }
}
