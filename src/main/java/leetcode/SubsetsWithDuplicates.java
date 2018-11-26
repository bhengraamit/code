package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by amit.bhengra on 17/10/18.
 *
 * https://leetcode.com/problems/subsets-ii/description/
 */
public class SubsetsWithDuplicates {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums==null || nums.length == 0)
            return list;
        Arrays.sort(nums);
        list = getList(nums,0);
        list.add(new ArrayList<>());
        return list;
    }

    public List<List<Integer>> getList(int[] nums,int index){
        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> tempList = new ArrayList<>();
        // populate from previous list
        if(index < nums.length-1 && index+1 < nums.length){
            boolean duplicate = false;
            int dupNum = Integer.MIN_VALUE;
            if(nums[index] == nums[index+1]){
                duplicate = true;
                dupNum = nums[index];
            }

            tempList = getList(nums,index+1);
            for(List<Integer> arr : tempList){
                if(duplicate){
                    if(arr.get(arr.size()-1) == dupNum){
                        arr.add(dupNum);
                        list.add(arr);
                    }else{
                        List<Integer> newArr = new ArrayList<>(arr);
                        newArr.add(nums[index]);
                        list.add(arr);
                        list.add(newArr);
                    }
                }else{
                    List<Integer> newArr = new ArrayList<>(arr);
                    newArr.add(nums[index]);
                    list.add(arr);
                    list.add(newArr);
                }

            }
        }

        List<Integer> newArr = new ArrayList<>();
        newArr.add(nums[index]);
        list.add(newArr);
        return list;

    }
}
