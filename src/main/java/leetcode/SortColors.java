package leetcode;

/**
 * Created by amit.bhengra on 10/09/18.
 *
 * https://leetcode.com/problems/sort-colors/description/
 *
 * Could have been a cleaner code
 */
public class SortColors {

    public static void main(String[] args) {
        SortColors sortColors  = new SortColors();
        int[] nums = {2,0,2,1,1,0};
        sortColors.sortColors(nums);
        System.out.println(nums);
    }
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0)
            return;

        int zeroPointer = 0;
        int twoPointer = nums.length;
        int i = 0;

        while(i < twoPointer){
            if(nums[i]==2){
                twoPointer = placetwo(nums,i,twoPointer);
                continue;
            }
            if(nums[i]==0){
                zeroPointer = placezero(nums,i,zeroPointer);
                i++;
                continue;
            }
            i++;
        }
    }

    public int placetwo(int[] nums,int replaceIndex,int twoPointer){
        twoPointer--;
        if(replaceIndex == twoPointer)
            return twoPointer;
        if(nums[twoPointer]!=2){
            nums[replaceIndex] = nums[twoPointer];
            nums[twoPointer] = 2;
            return twoPointer;
        }else{
            // find two pointer;
            int i = twoPointer-1;
            while(i >= 0){
                if(nums[i]!=2)
                    break;
                i--;
            }
            if(i < 0)
                return 0;
            else {
                nums[replaceIndex] = nums[i];
                nums[i] = 2;
                return i;
            }
        }

    }

    public int placezero(int[] nums,int replaceIndex,int zeroPointer){
        nums[replaceIndex] = nums[zeroPointer];
        nums[zeroPointer] = 0;
        return ++zeroPointer;
    }
}
