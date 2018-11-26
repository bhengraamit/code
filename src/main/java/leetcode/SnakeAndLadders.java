package leetcode;

/**
 * Created by amit.bhengra on 23/09/18.
 *
 * https://leetcode.com/contest/weekly-contest-103/problems/snakes-and-ladders/
 */
public class SnakeAndLadders {

    public static void main(String[] args) {
       int[][] board = new int[6][6];

int[] row1 = {-1,-1,-1,-1,-1,-1};
int[] row2 = {-1,-1,-1,-1,-1,-1};
int[] row3 = {-1,-1,-1,-1,-1,-1};
int[] row4 = {-1,35,-1,-1,13,-1};
int[] row5 = {-1,-1,-1,-1,-1,-1};
int[] row6 = {-1,15,-1,-1,-1,-1};
        board[0] = row1;
        board[1] = row2;
        board[2] = row3;
        board[3] = row4;
        board[4] = row5;
        board[5] = row6;
        SnakeAndLadders snakeAndLadders = new SnakeAndLadders();
        snakeAndLadders.snakesAndLadders(board);
    }
    public int snakesAndLadders(int[][] board) {
        if(board.length == 1)
            return 0;
        int[][] moves = new int[board.length][board.length];
        int steps = 1;
        int minMoves = 1;
        int loopCount = 2;
        int row = board.length-1, col = 1;
        int rightMove = 1;
        while(steps < board.length * board.length){
            // ladder check
            if(board[row][col] > steps){
                moves[row][col] = minMoves;
                int value = board[row][col];
                int rem = value % board.length;
                int quot = value / board.length;
                int rowValue = quot;
                int colValue = rem;
                if(rem == 0){
                    rowValue -= 1;
                    colValue = board.length;
                }
                if(quot % 2 == 1){
                    colValue = board.length - colValue;
                }
                moves[rowValue][colValue-1] = minMoves;
            }else{
                if(moves[row][col] == 0)
                    moves[row][col] = minMoves;
            }
            if(loopCount == board.length){
                loopCount = 0;
                minMoves++;
            }
            if(rightMove == 1)
                col++;
            else
                col--;
            if(col == board.length || col < 0){
                row--;
                rightMove = rightMove^1;
                if(rightMove == 1)
                    col++;
                else
                    col--;
            }
            loopCount++;
            steps++;
        }
        return moves[0][0];
    }
}
