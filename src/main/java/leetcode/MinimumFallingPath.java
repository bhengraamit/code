package leetcode;

/**
 * Created by amit.bhengra on 28/10/18.
 *
 * https://leetcode.com/contest/weekly-contest-108/problems/minimum-falling-path-sum/
 */
public class MinimumFallingPath {
    public int minFallingPathSum(int[][] A) {
        if(A == null || A.length == 0 || A[0].length == 0)
            return 0;
        int colSize = A[0].length;
        for(int row=A.length-2;  row>=0; row--){
            for(int col=0; col<colSize; col++){
                int minCol  =  A[row+1][col];
                if(col-1  >=0 && A[row+1][col-1] < minCol)
                    minCol = A[row+1][col-1];
                if(col+1 < colSize && A[row+1][col+1] < minCol)
                    minCol = A[row+1][col+1];
                A[row][col] += minCol;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int col=0;col < colSize;col++){
            if(A[0][col] < min)
                min = A[0][col];
        }
        return min;
    }
}
