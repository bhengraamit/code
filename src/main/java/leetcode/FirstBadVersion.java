package leetcode;

/**
 * Created by amit.bhengra on 08/09/18.
 *
 * https://leetcode.com/problems/first-bad-version/description/
 *
 */
public class FirstBadVersion {
    int firstBadVersion(int n) {
        int low = 1,high = n;
        int lastFalse = 0;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(isBadVersion(mid) == false){
                low = mid +1;
            }
            else if(isBadVersion(mid)==true){
                high = mid-1;
                lastFalse = mid;
            }
        }
        return lastFalse;
    }
    boolean isBadVersion(int version){
        return false;
    }
}
