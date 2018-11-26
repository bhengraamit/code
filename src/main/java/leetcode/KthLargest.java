package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by amit.bhengra on 26/08/18.
 */
public class KthLargest {

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest();
        int[] nums ={1,2,3,4,5,6,7,8};
        int kthLargest1 = kthLargest.findKthLargest(nums, 9);
        System.out.println(kthLargest1);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(nums.length,new Comparator<Integer>()      {
            public int compare(Integer o1, Integer o2){
                if(o1.intValue() > o2.intValue())
                    return 1;
                if(o1.intValue() < o2.intValue())
                    return -1;
                return 0;
            }
        });
        for(int i : nums){
            pQ.add(i);
        }

        int ret = Integer.MIN_VALUE;
        int nthSmallest = nums.length - k;
        for(int i=0;i<=nthSmallest ;i++){
            ret = pQ.poll();
        }
        return ret;
    }
}
