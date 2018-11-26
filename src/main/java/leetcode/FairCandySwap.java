package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by amit.bhengra on 13/09/18.
 *
 * https://leetcode.com/problems/fair-candy-swap/description/
 */
public class FairCandySwap {

    public int[] fairCandySwap(int[] A, int[] B) {
        int[] ret = new int[2];
        if(A==null || B==null || A.length == 0 || B.length == 0)
            return ret;
        Set<Integer> aSet = new HashSet<>();
        int aSum = 0;
        for(int i=0; i< A.length;i++){
            aSum += A[i];
            aSet.add(A[i]);
        }
        int bSum = 0;
        for(int j=0; j<B.length;j++){
            bSum += B[j];
        }
        int eqSum = (aSum+bSum)/2;
        int diffSum = eqSum - bSum;
        for(int k=0;k<B.length;k++){
            if(aSet.contains(B[k]+diffSum)){
                ret[0] = B[k]+diffSum;
                ret[1] = B[k];
            }
        }
        return ret;
    }
}
