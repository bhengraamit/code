import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by amit.bhengra on 02/01/17.
 *
 * Reasoning behind the algorithm which is used here is that, if a pawn is able to visit all the chequerboard positions
 * then it doesn't matter where it starts from as it will be reachable from any node. BFS should do the job here,
 * children of a node will be all the possible steps the pawn can take from the current node position.
 *
 * Main algorithm which is used here is BFS Traversal (Breadth First Search) and
 * I have used queue to add the children of a node.
 * I start from  0,0 or any given position and traverse for all the valid children (which are not already visited),
 * keeps on doing this until I find all the valid positions. In the end I check for the count of valid positions,
 * if it is equivalent to total positions, in this case its  100(10x10). Print 'Yes' if it exists else 'No'
 *
 *
 *
 */
public class TrueCaller {

    static int startX = 0;
    static int startY = 0;

    public static void main(String[] args) {
        try {
            if (args.length > 0)
                startX = Integer.valueOf(args[0]);
            if (args.length > 1)
                startY = Integer.valueOf(args[1]);

            // given arguments should be in range
            if (!(startX >= 0 && startX <= 9 && startY >= 0 && startY <= 9)){
                startX = 0;
                startY = 0;
            }
        }catch (Exception e){
            // if some exception comes, will start from 0,0 position
            startX = 0;
            startY = 0;
        }
        Boolean print = false;
        if (args.length>2 && args[2]!=null)
            print = Boolean.valueOf(args[2]);

        boolean[][] grid = new boolean[10][10];                     // default values are false
        Node startNode = new Node(startX,startY);                   // starting from the 0,0 or given position
        grid[startX][startY] = true;                                // this is marking if this node has been visited or not
        Queue<Node> queue = new ArrayBlockingQueue<Node>(100);
        queue.add(startNode);
        int count=0;                                                // this count for counting all the nodes inserted in the queue

        // keep on adding all the valid nodes to the queue
        while (!queue.isEmpty()){
            Node node = queue.poll();                               // take out the first node
            count++;
            getEligibleNodesFrom(node, grid, queue);                // adding possible children of the current node
            if (print)
                printGrid(grid);
        }

        if (count==100)                                             // if the total nodes inserted into queue was 100 (10x10) then we have visited all the nodes
            System.out.println("Yes");
        else
            System.out.println("No");

    }

    private static void printGrid(boolean[][] grid){
        System.out.println("==========================");
        for (int i =0;i<10;i++){
            for (int j=0;j<10;j++){
                if (grid[i][j]==true)
                    System.out.print("1,");
                else
                    System.out.print("0,");
            }
            System.out.println();
        }
        System.out.println("==========================");
    }

    /*
        this method is responsible for adding all the directional nodes to the queue
     */
    private static void getEligibleNodesFrom(Node startNode, boolean[][] grid, Queue<Node> queue) {

        int EWNSDiff = 3;
        int midDiff = 2;

        // Calculating position in all the directions required and checking if the position is not visited earlier

        //north node;
        if (startNode.row -EWNSDiff >=0 && !grid[startNode.row-EWNSDiff][startNode.col]) {  // checks for the boundary conditions of matrix and if the position is already visited or not
            Node northNode = new Node(startNode.row-EWNSDiff, startNode.col);               // setting the required position
            queue.add(northNode);                                                           // adding to the queue
            grid[northNode.row][northNode.col] = true;                                      // marking the node as visited
        }
        // south node
        if (startNode.row +EWNSDiff <=9 && !grid[startNode.row+EWNSDiff][startNode.col]){
            Node southNode = new Node(startNode.row +EWNSDiff,startNode.col);
            queue.add(southNode);
            grid[southNode.row][southNode.col] = true;
        }

        // east node
        if (startNode.col +EWNSDiff <=9 && !grid[startNode.row][startNode.col+EWNSDiff]){
            Node eastNode = new Node(startNode.row,startNode.col+EWNSDiff);
            queue.add(eastNode);
            grid[eastNode.row][eastNode.col] = true;
        }

        // west node
        if (startNode.col -EWNSDiff >=0 && !grid[startNode.row][startNode.col-EWNSDiff]){
            Node westNode = new Node(startNode.row, startNode.col-EWNSDiff);
            queue.add(westNode);
            grid[westNode.row][westNode.col] = true;
        }

        //north east node
        if (startNode.row-midDiff >=0 && startNode.col+midDiff <=9 && !grid[startNode.row-midDiff][startNode.col+midDiff]){
            Node northEastNode = new Node(startNode.row-midDiff,startNode.col+midDiff);
            queue.add(northEastNode);
            grid[northEastNode.row][northEastNode.col] = true;
        }

        //north west node
        if (startNode.row-midDiff >=0 && startNode.col-midDiff >=0 && !grid[startNode.row-midDiff][startNode.col-midDiff]){
            Node northWestNode = new Node(startNode.row-midDiff,startNode.col-midDiff);
            queue.add(northWestNode);
            grid[northWestNode.row][northWestNode.col] = true;
        }

        //south west node
        if (startNode.row+midDiff <=9 && startNode.col-midDiff >=0 && !grid[startNode.row+midDiff][startNode.col-midDiff]){
            Node southWestNode = new Node(startNode.row+midDiff,startNode.col-midDiff);
            queue.add(southWestNode);
            grid[southWestNode.row][southWestNode.col] = true;
        }

        //south east node
        if (startNode.row+midDiff <=9 && startNode.col+midDiff <=9 && !grid[startNode.row+midDiff][startNode.col+midDiff]){
            Node southEastNode = new Node(startNode.row+midDiff,startNode.col+midDiff);
            queue.add(southEastNode);
            grid[southEastNode.row][southEastNode.col] = true;
        }

    }

    // this datastructure mainly is for holding the x,y coordinates
    static class Node{
        int row; // row
        int col; // column

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
