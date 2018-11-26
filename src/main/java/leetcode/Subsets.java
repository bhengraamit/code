package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit.bhengra on 10/09/18.
 *
 * https://leetcode.com/problems/subsets/description/
 */
public class Subsets {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1,2,3};
        int[] nums2 = new int[0];
        System.out.println(subsets.subsets(nums2));
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> emptyList = new ArrayList<>();

        if (nums == null || nums.length ==0) {
            subsets.add(emptyList);
            return subsets;
        }

        List<List<Integer>> lists = generateSubsets(nums, 0);
        lists.add(emptyList);     // this is for empty set
        return lists;
    }

    private List<List<Integer>> generateSubsets(int[] nums, int i) {
        if (i >= nums.length)
            return new ArrayList<>();
        List<List<Integer>> retList = new ArrayList<>();
        List<List<Integer>> subsets = generateSubsets(nums, i + 1);
        for (List<Integer> subset :subsets){
            List<Integer> newSet = new ArrayList<>();
            newSet.add(nums[i]);
            newSet.addAll(subset);
            retList.add(newSet);
            retList.add(subset);
        }
        ArrayList<Integer> selfList = new ArrayList<>();
        selfList.add(nums[i]);
        retList.add(selfList);
        return retList;
    }
}
