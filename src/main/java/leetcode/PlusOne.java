package leetcode;

/**
 * Created by amit.bhengra on 19/10/18.
 *
 * https://leetcode.com/problems/plus-one/description/
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length ==0)
            return new int[]{1};
        int[] ret = new int[digits.length+1];
        int carry = 1;
        for(int i=digits.length-1 ;i>=0; i--){
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }

        if(carry!=0){
            ret[0] = carry;
            for(int i=1,j=0; i<digits.length; i++,j++)
                ret[i] = digits[j];
            return ret;
        }else{
            return digits;
        }
    }
}
