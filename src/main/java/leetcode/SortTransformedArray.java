package leetcode;

/**
 * Created by amit.bhengra on 06/10/18.
 *
 * https://leetcode.com/problems/sort-transformed-array/description/
 */
public class SortTransformedArray {

    public static void main(String[] args) {
        SortTransformedArray sortTransformedArray = new SortTransformedArray();
        int nums[] = {-100,-84,-84,-82,-68,-56,-40,-30,48,56,59,73,73,73,87};
        sortTransformedArray.sortTransformedArray(nums,96,-66,28);
    }

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int pivot = findPivot(nums,a,b,c);
        int p1,p2;
        boolean outward = true;
        if(pivot == -1){
            p1 = 0; p2=nums.length-1 ; outward = false;
        }else{
            p1 = pivot; p2 = pivot+1; outward = true;
        }
        int[] result = new int[nums.length];
        int index = 0;
        while(p1<=p2  && p1>=0 && p2<nums.length){
            int p1Val = calVal(nums[p1],a,b,c);
            int p2Val = calVal(nums[p2],a,b,c);
            if(p1Val <= p2Val){
                result[index] = p1Val;
                if(outward) p1--;
                else p1++;
            }else{
                result[index] = p2Val;
                if(outward) p2++;
                else p2--;
            }
            index++;
        }
        if(outward){
            if(p1 >= 0){
                for(int i=p1 ; i>=0; i--,index++)
                    result[index] = calVal(nums[i],a,b,c);
            }else if(p2 < nums.length){
                for(int i=p2; i<nums.length;i++,index++)
                    result[index] = calVal(nums[i],a,b,c);
            }
        }
        return result;
    }

    public int findPivot(int[] nums, int a, int b, int c){
        int firstNum = calVal(nums[0],a,b,c);
        int prev = firstNum ;
        int i = 0;
        String status = "plain";
        for(i=1; i<nums.length;i++){
            int curr = calVal(nums[i],a,b,c);
            if(status.equalsIgnoreCase("decreasing") && curr > prev)
                return i-1;
            if(status.equalsIgnoreCase("plain") && curr > prev)
                return -1;
            if(status.equalsIgnoreCase("plain") && curr < prev)
                status = "decreasing";
            prev = curr;
        }
        return i-1;
    }

    public int calVal(int num, int a, int b, int c){
        return (a*num*num) + (b*num) + c;
    }
}
