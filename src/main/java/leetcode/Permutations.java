package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit.bhengra on 07/10/18.
 *
 * https://leetcode.com/problems/permutations/description/
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return list;
        if(nums.length == 1){
            List<Integer> newList = new ArrayList<>();
            newList.add(nums[0]);
            list.add(newList);
            return list;
        }

        int[] track = new int[nums.length];
        for(int i=0 ;i<nums.length;i++){
            track[i] = 1;
            List<List<Integer>> newList = permute(nums,track,1);
            appendNum(nums[i],newList);
            list.addAll(newList);
            track[i] = 0;
        }
        return list;
    }

    public  List<List<Integer>> permute(int[] nums, int[] track, int count){
        List<List<Integer>> newList  = new ArrayList<>();
        if(nums.length - count == 1){
            for(int i=0; i<nums.length ;i++){
                if(track[i]!=1){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    newList.add(list);
                    return newList;
                }
            }
        }else{
            for(int i=0 ;i<nums.length;i++){
                if(track[i]!=1){
                    track[i] = 1;
                    List<List<Integer>> list = permute(nums,track,count+1);
                    appendNum(nums[i],list);
                    newList.addAll(list);
                    track[i] = 0;
                }
            }
        }
        return newList;
    }

    public void appendNum(int num, List<List<Integer>> list){
        for(List<Integer> innerList : list){
            innerList.add(num);
        }
    }
}
