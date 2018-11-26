package leetcode;

/**
 * Created by amit.bhengra on 01/11/18.
 *
 * https://leetcode.com/problems/sparse-matrix-multiplication/description/
 */
public class SparseMatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || B==null || A.length <=0 || A[0].length <=0 || B.length <=0 || B[0].length <=0)
            return A;
        int aRow = A.length;
        int aCol = A[0].length;
        int bRow = B.length;
        int bCol = B[0].length;
        int mult[][] = new int[aRow][bCol];
        for(int i=0; i<aRow; i++){
            for(int j=0; j<aCol; j++){
                if(A[i][j]!=0){
                    for(int k=0 ;k<bCol;k++){
                        mult[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }

        return mult;
    }
}
