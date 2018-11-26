package leetcode;

import java.util.*;

/**
 * Created by amit.bhengra on 07/10/18.
 *
 * https://leetcode.com/problems/combination-sum/description/
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] cand = {2,3,5};
        combinationSum.combinationSum(cand,7);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> finalList = new ArrayList<>();
        Set<String> calculatedComb = new HashSet<>();
        for(int i =0; i < candidates.length; i++){
            List<Integer> tempList  = new ArrayList<>();
            getComb(candidates, target, 0,finalList,tempList,calculatedComb);
        }
        return finalList;
    }

    public void getComb(int[] candidates, int target, int index, List<List<Integer>> finalList, List<Integer> tempList, Set<String> calculatedComb){
        if(index >= candidates.length)
            return;
        int currNum = candidates[index];
        if(currNum == target){
            if(!calculatedComb.contains(target+"#"+(index+1))) {
                List<Integer> retList = new ArrayList<>(tempList);
                retList.add(currNum);
                finalList.add(retList);
                getComb(candidates, target, index + 1, finalList, tempList, calculatedComb);
                calculatedComb.add(target+"#"+(index+1));
            }
        }else{
            if(target > currNum){
                List<Integer> retList = new ArrayList<>(tempList);
                retList.add(currNum);
                getComb(candidates, target-currNum, index+1, finalList,retList, calculatedComb);
                getComb(candidates, target-currNum, index, finalList,retList, calculatedComb);
                getComb(candidates, target, index+1, finalList,tempList, calculatedComb);
            }else{
                getComb(candidates, target, index+1, finalList, tempList, calculatedComb);
            }
        }
    }
}
