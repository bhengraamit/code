package leetcode;

/**
 * Created by amit.bhengra on 16/09/18.
 */
public class RotatedSortedArray {

    public static void main(String[] args) {
        RotatedSortedArray rotatedSortedArray = new RotatedSortedArray();
        int[] nums = {1,3};
        int[] nums1 = {5,1,3};
    //    System.out.println(rotatedSortedArray.search(nums,0));
        System.out.println(rotatedSortedArray.search(nums1,5));
    }
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int mid = findMid(nums);
        int found1 = binarySearch(mid, nums.length-1,target,nums);
        int found2 = binarySearch(0,mid-1,target,nums);
        return found1 == -1 ? found2 : found1;
    }

    public int binarySearch(int min, int max, int target, int[] nums){
        while(min <= max){
            int mid = min + (max-min)/2;
            if(nums[mid] == target)
                return mid;
            if(target < nums[mid]){
                max = mid-1;
            }
            else if(target > nums[mid]){
                min = mid+1;
            }
        }
        return -1;
    }

    public int findMid(int[] nums){
        int min = 0;
        int max = nums.length-1;
        int lastIndexValue = nums[nums.length-1];
        int lastIndex = -1;
        while(min <= max){
            if(min == max) {
                return min;
            }
            int mid = min + (max-min)/2;
            lastIndex = mid;
            if(nums[mid] == lastIndexValue)
                return mid;
            if(nums[mid] > lastIndexValue){
                min = mid+1;
            }
            else if(nums[mid] < lastIndexValue){
                max = mid;
            }
        }
        return lastIndex;
    }
}
