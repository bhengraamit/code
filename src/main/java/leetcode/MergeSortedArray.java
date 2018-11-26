package leetcode;

/**
 * Created by amit.bhengra on 01/11/18.
 *
 * https://leetcode.com/problems/merge-sorted-array/description/
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;n--;
        int index = nums1.length-1;
        while(m>=0 || n>=0){
            int bigNum;
            if(n == -1)
                bigNum = nums1[m--];
            else if(m == -1)
                bigNum = nums2[n--];
            else if(nums1[m] > nums2[n])
                bigNum = nums1[m--];
            else
                bigNum = nums2[n--];
            nums1[index--] = bigNum;
        }
    }
}
