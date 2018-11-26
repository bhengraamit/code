package leetcode;

/**
 * Created by amit.bhengra on 13/09/18.
 *
 * https://leetcode.com/problems/flipping-an-image/description/
 */
public class FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] A) {
        if(A == null || A.length == 0)
            return A;
        for(int row=0; row<A.length ; row++){
            if(A[0].length ==1){
                A[row][0] = A[row][0]^1;
                continue;
            }
            int colSize = A[0].length;
            for(int col=0; col < colSize/2; col++){
                int temp = A[row][colSize-1-col];
                A[row][colSize-1-col] = A[row][col]^1;
                A[row][col] = temp^1;
            }
            int rem = colSize % 2;
            if(rem == 1)
                A[row][colSize/2] = A[row][colSize/2]^1;
        }
        return A;
    }
}
