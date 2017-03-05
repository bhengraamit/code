import java.util.Scanner;

/**
 * Created by amit.bhengra on 08/11/16.
 * https://www.hackerrank.com/challenges/maxsubarray?h_r=next-challenge&h_v=zen
 *
 *
 *
 */
public class MaximumSubArray {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int testCases = reader.nextInt();
        reader.nextLine();

        while (testCases-- > 0) {
            int totalNums = reader.nextInt();
            reader.nextLine();
            String numSet = reader.nextLine();
            String nums[] = numSet.split(" ");
            int size = nums.length;
            MaxInfo sum = maxSubArray(0,size-1,nums);
        }



    }

    private static MaxInfo maxSubArray(int i, int n, String[] nums) {
        int num = Integer.valueOf(nums[i]);
        if (i==n) {
            MaxInfo sum  = new MaxInfo(num, i);
            return sum;
        }
        MaxInfo maxSum = maxSubArray(i+1,n,nums);
        if (num >=0){
            // positive number
            if (maxSum.sum < 0){
                // sum is negative make this positive number as maxSum
                return new MaxInfo(num,i);
            }else {
                // sum is positive, check for
            }

        }else{
            // negative number
        }

        return  null;

    }

    private static class MaxInfo {
        int sum;
        int startIndex;

        public MaxInfo(int num, int i) {
            this.sum = num;
            this.startIndex = i;
        }
    }
}
