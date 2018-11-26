package leetcode;

/**
 * Created by amit.bhengra on 13/09/18.
 *
 * https://leetcode.com/problems/reshape-the-matrix/description/
 */
public class ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums == null || nums.length == 0 || nums[0].length == 0)
            return nums;
        int row = nums.length;
        int col = nums[0].length;

        if(row*col != r*c)
            return nums;
        int newRow = 0;
        int newCol = 0;
        int[][] newNums = new int[r][c];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                newNums[newRow][newCol] = nums[i][j];
                if(newCol == c-1){
                    newRow++;
                    newCol = 0;
                }else{
                    newCol++;
                }
            }
        }
        return newNums;
    }

    /**
     *
     * Very concise solution
     *
     * public int[][] matrixReshape(int[][] nums, int r, int c) {
     int n = nums.length, m = nums[0].length;
     if (r*c != n*m) return nums;
     int[][] res = new int[r][c];
     for (int i=0;i<r*c;i++)
     res[i/c][i%c] = nums[i/m][i%m];
     return res;
     }
     *
     *
     *
     */
}
