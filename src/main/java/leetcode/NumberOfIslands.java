package leetcode;

/**
 * Created by amit.bhengra on 09/09/18.
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grids = new char[3][3];
        grids[0] =new char[]{'1','1','1'};
        grids[1] = new  char[]{'0','1','0'};
        grids[2] =new char[]{'1','1','1'};
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(grids));
    }
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if(row<=0)
            return 0;
        int col = grid[0].length;
        if(col<=0)
            return 0;
        int totalIsLands = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == '1')
                    totalIsLands += doBFS(grid,i,j);
            }
        }
        return totalIsLands;
    }

    public int doBFS(char[][] grid, int startRow, int startCol){
        int row = grid.length;
        int col = grid[0].length;
        grid[startRow][startCol] = '2';
        if(startRow+1 < row && grid[startRow+1][startCol] == '1')
            doBFS(grid,startRow+1,startCol);
        if(startRow - 1 >= 0 && grid[startRow-1][startCol] == '1')
            doBFS(grid,startRow-1,startCol);
        if(startCol+1 < col && grid[startRow][startCol+1] == '1')
            doBFS(grid,startRow,startCol+1);
        if(startCol-1 >= 0 && grid[startRow][startCol-1] == '1')
            doBFS(grid,startRow,startCol-1);
        return 1;
    }
}
