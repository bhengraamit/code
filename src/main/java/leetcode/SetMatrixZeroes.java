package leetcode;

import java.util.Set;

/**
 * Created by amit.bhengra on 17/10/18.
 *
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();

        int[][] matrix = new int[3][4];
        int[] matrix1 = {0,1,2,0};
        matrix[0] = matrix1;
        int[] matrix2 = {3,4,5,2};
        matrix[1] = matrix2;
        int[] matrix3 = {1,3,1,5};
        matrix[2] = matrix3;

        setZeroes(matrix);
    }
    public static  void setZeroes(int[][] matrix) {
        if(matrix == null || matrix[0].length == 0)
            return;
        //row wise
        for(int i=0; i<matrix.length; i++){
            boolean flip = false;
            for(int j=0; j<matrix[0].length ;j++){
                if(flip && matrix[i][j]!=0)
                    matrix[i][j] = -1;
                else if(matrix[i][j] == 0){
                    flip = true;
                }else{
                    matrix[i][j] = -1 * matrix[i][j];
                }
            }
            flip = false;
            for(int j=matrix[0].length-1; j>=0; j--){
                if(flip && matrix[i][j]!=0)
                    matrix[i][j] = -1;
                else if(matrix[i][j] == 0){
                    flip = true;
                }else{
                    matrix[i][j] = -1 * matrix[i][j];
                }
            }
        }
        //column wise
        for(int i=0; i<matrix[0].length; i++){
            boolean flip = false;
            for(int j=0; j<matrix.length ;j++){
                if(flip && matrix[j][i]!=0)
                    matrix[j][i] = -1;
                else if(matrix[j][i] == 0){
                    flip = true;
                }else if(matrix[j][i]==-1){
                    matrix[j][i] = -1 * matrix[j][i];
                }
            }
            flip = false;
            for(int j=matrix.length-1; j>=0; j--){
                if(flip && matrix[j][i]!=0)
                    matrix[j][i] = -1;
                else if(matrix[j][i] == 0){
                    flip = true;
                }else{
                    matrix[j][i] = -1 * matrix[j][i];
                }
            }
        }
        // full scan once
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length ;j++){
                if(matrix[i][j] == -1)
                    matrix[i][j] = 0;
            }
        }

    }
}
