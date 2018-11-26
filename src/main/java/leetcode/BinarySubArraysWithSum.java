package leetcode;

/**
 * Created by amit.bhengra on 28/10/18.
 *
 * https://leetcode.com/contest/weekly-contest-108/problems/binary-subarrays-with-sum/
 */
public class BinarySubArraysWithSum {
    public static void main(String[] args) {
        BinarySubArraysWithSum binarySubArraysWithSum = new BinarySubArraysWithSum();
        int[] array = {0,0,0,0,0};
        System.out.println(binarySubArraysWithSum.numSubarraysWithSum(array,0));
    }

    public int numSubarraysWithSum(int[] A, int S) {
        if(A == null || A.length == 0)
            return 0;
        int i=0,j=0;
        int tempSum = 0;
        int count = 0;
        boolean secondTurn = true;

        while(i<=j && j<A.length){
            if(secondTurn){
                tempSum += A[j];
                if(tempSum == S){
                    count++;
                    if(j+1 < A.length && A[j+1] == 0){
                        j++;
                        continue;
                    }else{
                        secondTurn = false;
                    }
                }else{
                    j++;
                }

            }else{
                tempSum -= A[i];
                i++;
                if(tempSum == S)
                    count++;
                else{
                    secondTurn = true;
                    j++;
                }
                if(i>=j){
                    secondTurn = true;
                    j++;
                }
            }
        }
        return count;
    }
}
