package leetcode;

/**
 * Created by amit.bhengra on 09/09/18.
 */
public class AddBinary {

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("100110","11101"));
    }
    public class Sum{
        char carry;
        char value;
    }


    public String addBinary(String a, String b) {
        char[] firstNum = a.toCharArray();
        char[] secondNum = b.toCharArray();
        char carry = '0';

        int firstNumSize = firstNum.length;
        int secondNumSize = secondNum.length;

        char[] arrayToLoop = firstNum;
        char[] otherArray = secondNum;

        if(firstNumSize > secondNumSize){
            arrayToLoop = secondNum;
            otherArray = firstNum;
        }

        int i = arrayToLoop.length-1;
        int sizeDiff = otherArray.length - arrayToLoop.length;
        String totalSum = "";
        for(;i>=0;i--){
            Sum sum = returnSum(arrayToLoop[i],otherArray[i+sizeDiff],carry);
            carry = sum.carry;
            totalSum =  String.valueOf(sum.value)+ totalSum;
        }

        if(otherArray.length > arrayToLoop.length) {
            int j = sizeDiff;
            while (j >=0) {
                Sum sum = returnSum(carry, otherArray[j], '0');
                carry = sum.carry;
                totalSum = String.valueOf(sum.value) + totalSum;
                j--;
            }
        }
        if(carry == '1')
            return String.valueOf(carry) + totalSum;
        else
            return totalSum;
    }


    public Sum returnSum(char firstCh, char secondCh, char carry){
        if(firstCh!=secondCh){
            if(carry == '0'){
                Sum sum = new Sum();
                sum.value = '1';
                sum.carry = '0';
                return sum;
            }else{
                Sum sum = new Sum();
                sum.value = '0';
                sum.carry = '1';
                return sum;
            }

        }else{
            Sum sum = new Sum();
            sum.value = carry;
            if(firstCh == '0')
                sum.carry = '0';
            else
                sum.carry = '1';
            return sum;
        }
    }
}
