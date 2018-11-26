package leetcode;

/**
 * Created by amit.bhengra on 30/09/18.
 *
 * https://leetcode.com/problems/arithmetic-slices/description/
 */
public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {
        int totalCount = 0;
        int i=0;
        int currDiff = 0;           // test this var
        int totalSlices = 0;
        while(i<A.length){
            if(totalCount == 0){        // when last slice has ended or its the beginning
                if(i+2 < A.length){
                    if(A[i+1]-A[i] == A[i+2]-A[i+1]){
                        currDiff = A[i+1]-A[i];
                        totalCount = 3;
                        i = i+3;
                    }else{
                        i = i+1;
                    }
                }else{
                    return totalSlices;
                }
            }else{
                if(currDiff == A[i] - A[i-1]){          // continue for last slice
                    totalCount++;
                    i++;
                }
                else{
                    totalSlices += ((totalCount-2)*(totalCount-1))/2;       // last slice ended calculate the count
                    totalCount = 0;
                    i = i-1;
                }
            }
        }
        if(totalCount!=0)                                       // last check if last slice ended on last element
            totalSlices += ((totalCount-2)*(totalCount-1))/2;
        return totalSlices;
    }


    /**
     *
     * Elegant Solution
     *
     * public int numberOfArithmeticSlices(int[] A) {
     int curr = 0, sum = 0;
     for (int i=2; i<A.length; i++)
     if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
     curr += 1;
     sum += curr;
     } else {
     curr = 0;
     }
     return sum;
     }
     */
}
