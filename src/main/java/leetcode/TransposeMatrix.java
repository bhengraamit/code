package leetcode;

/**
 * Created by amit.bhengra on 13/09/18.
 *
 * https://leetcode.com/problems/transpose-matrix/description/
 */
public class TransposeMatrix {

    public int[][] transpose(int[][] A) {
        if(A == null || A.length==0 || A[0].length == 0)
            return A;
        int[][] tp = new int[A[0].length][A.length];
        for(int row=0; row<A.length; row++){
            for(int col=0; col<A[0].length; col++){
                tp[col][row]= A[row][col];
            }
        }
        return tp;
    }
}
