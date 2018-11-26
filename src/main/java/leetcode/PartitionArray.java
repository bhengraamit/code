package leetcode;

/**
 * Created by amit.bhengra on 30/09/18.
 *
 * https://leetcode.com/contest/weekly-contest-104/problems/partition-array-into-disjoint-intervals/
 */
public class PartitionArray {

    public int partitionDisjoint(int[] A) {
        int[] mins = getMins(A);
        int max = A[0];
        for(int i =1 ; i<A.length; i++){
            if(max <= mins[i])
                return i;
            if(A[i] > max)
                max = A[i];
        }
        return A.length;
    }

    public int[] getMins(int[] A){
        int min = Integer.MAX_VALUE;
        int[] mins = new int[A.length];
        for(int i=A.length-1; i>=0; i--){
            if(A[i] < min){
                mins[i] = A[i];
                min = A[i];
            }
            else
                mins[i] = min;
        }
        return mins;
    }
}
