package leetcode;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by amit.bhengra on 10/09/18.
 *
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * It can be optimised further like checking shorter set and total count of matched using maps
 */
public class IntersectionOf2Arrays {

    public static void main(String[] args) {
        IntersectionOf2Arrays intersectionOf2Arrays = new IntersectionOf2Arrays();
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        System.out.println(intersectionOf2Arrays.intersection(num1,num2));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length ==0 )
            return nums2;
        if (nums2.length == 0)
            return nums1;

        Set<Integer> firstSet = new HashSet<>();
        Set<Integer> secondSet = new HashSet<>();
        for (int num : nums1){
            firstSet.add(num);
        }
        Set<Integer> finalSet = new HashSet<>();
        for (int num : nums2){
            secondSet.add(num);
        }

        int i =0;
        for (int num:secondSet){
            if (firstSet.contains(num)) {
                finalSet.add(num);
            }
        }

        int[] ints = finalSet.stream().mapToInt(Number::intValue).toArray();
        return ints;
    }
}
