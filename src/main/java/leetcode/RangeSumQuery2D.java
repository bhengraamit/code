package leetcode;

/**
 * Created by amit.bhengra on 10/09/18.
 *
 * https://leetcode.com/problems/range-sum-query-2d-immutable/description/
 */
public class RangeSumQuery2D {

    int totalsum[][] = null;

    public static void main(String[] args) {
        int[][] matrix = new int[2][1];
        matrix[0][0] = 1;
        matrix[1][0] = -7;
         RangeSumQuery2D rangeSumQuery2D = new RangeSumQuery2D(matrix);
        //System.out.println(rangeSumQuery2D.sumRegion(0,0,0,0));
        System.out.println(rangeSumQuery2D.sumRegion(1,0,1,0));
        System.out.println(rangeSumQuery2D.sumRegion(0,0,1,0));
    }

    public RangeSumQuery2D(int[][] matrix) {
        if(matrix.length <=0 || matrix[0].length <=0)
            ;
        else{
            int sum[][]= new int[matrix.length][matrix[0].length];
            sum[0][0] = matrix[0][0];
            for(int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix[0].length; j++){
                    sum[i][j] = matrix[i][j];
                    if(j-1 >=0)
                        sum[i][j] += sum[i][j-1];
                }
            }

            for(int i=0; i<matrix[0].length; i++){
                for(int j=0; j<matrix.length; j++){
                    if(j-1 >=0)
                        sum[j][i] += sum[j-1][i];
                }
            }
            totalsum = sum;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(totalsum == null)
            return 0;
        int sum = 0;
        sum += totalsum[row2][col2];
        if(row1 == 0 && col1 == 0)
            return sum;
        if(col1-1 >=0){
            sum -= totalsum[row2][col1-1];
        }
        if(row1-1 >=0){
            sum -= totalsum[row1-1][col2];
        }

        if(col1-1 >=0 && row1-1 >=0)
            sum += totalsum[row1-1][col1-1];
        return sum;
    }
}
