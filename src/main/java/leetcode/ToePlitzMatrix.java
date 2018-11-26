package leetcode;

/**
 * Created by amit.bhengra on 13/09/18.
 *
 * https://leetcode.com/problems/toeplitz-matrix/description/
 */
public class ToePlitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix == null || matrix.length ==0 || matrix[0].length == 0)
            return false;

        // row start points
        int row = 0;
        for(int col=0;col<matrix[0].length; col++){
            int dRow = row+1;
            int dCol = col+1;
            int prevVal = matrix[row][col];
            while(dRow < matrix.length && dCol < matrix[0].length){
                if(matrix[dRow][dCol]!=prevVal)
                    return false;
                dRow++;dCol++;
            }
        }

        int col = 0;
        for(int crow=1;crow<matrix.length;crow++){
            int dRow = crow+1;
            int dCol = col+1;
            int prevVal = matrix[crow][col];
            while(dRow < matrix.length && dCol < matrix[0].length){
                if(matrix[dRow][dCol]!=prevVal)
                    return false;
                dRow++;dCol++;
            }
        }

        return true;
    }
}
