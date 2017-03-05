import java.math.BigInteger;

/**
 * Created by amit.bhengra on 16/12/16.
 */
public class EquilibriumIndex {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{-1, 3, -4, 5, 1, -6, 2, 1}));
        System.out.println(solution(new int[]{1,2,1}));
    }

    public static int solution(int[] nums) {
        // write your code in Java SE 8
        if (nums!=null){
            BigInteger[] frontSum = new BigInteger[nums.length];
            BigInteger[] backSum = new BigInteger[nums.length];
            BigInteger currentSum = new BigInteger("0");
            for (int i=0; i< nums.length; i++){
                currentSum = currentSum.add(new BigInteger(String.valueOf(nums[i])));
                frontSum[i] = currentSum;
            }
            currentSum = new BigInteger("0");
            for (int i=nums.length-1; i >= 0; i--){
                currentSum = currentSum.add(new BigInteger(String.valueOf(nums[i])));
                backSum[i] = currentSum;
            }

            for (int i=0; i <= frontSum.length-3; i++){
                if (frontSum[i].equals(backSum[i+2]))
                    return i+1;
            }
        }
        return -1;
    }
}
