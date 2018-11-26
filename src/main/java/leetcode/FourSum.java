package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by amit.bhengra on 12/09/18.
 *
 * https://leetcode.com/problems/4sum/description/
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> totalComb = new ArrayList<>();
        if(nums == null || nums.length <4)
            return totalComb;
        Arrays.sort(nums);


        for(int i=0; i<=nums.length-4; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for(int j = i+1; j<=nums.length-3; j++){
                if(j>i+1 && nums[j] == nums[j-1])
                    continue;
                int k=j+1, l=nums.length-1;
                int kEnd = nums[k];boolean kloop = false;
                int lEnd = nums[l];boolean lloop = false;
                while(k<l){
                    if(kloop){
                        if(nums[k] == kEnd)
                            k++;
                        else
                            kloop = false;
                        continue;
                    }
                    if(lloop){
                        if(nums[l] == lEnd)
                            l--;
                        else
                            lloop = false;
                        continue;
                    }

                    int sum = nums[i]+nums[j]+nums[k]+nums[l];
                    if( sum == target){
                        List<Integer> newComb = new ArrayList<>();
                        newComb.add(nums[i]);newComb.add(nums[j]);newComb.add(nums[k]);newComb.add(nums[l]);
                        totalComb.add(newComb);
                        kEnd = nums[k]; lEnd = nums[l];k++;l--;
                        kloop = true; lloop = true;
                    }else{
                        if(sum < target)
                            k++;
                        else
                            l--;
                    }
                }
            }
        }
        return totalComb;
    }
}
