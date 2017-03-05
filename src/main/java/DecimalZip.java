import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit.bhengra on 19/12/16.
 */
public class DecimalZip {
    public static void main(String[] args) {
        System.out.println(solution(12,56));
        System.out.println(solution(0,100000000));
    }

    public static int solution(int A, int B) {
        // write your code in Java SE 8
        String firstInt = String.valueOf(A);
        String secondInt = String.valueOf(B);

        char[] firstIntArr = firstInt.toCharArray();
        char[] secondIntArr = secondInt.toCharArray();

        int indexToLoop = firstIntArr.length > secondIntArr.length ? secondIntArr.length:firstIntArr.length;
        char[] interleavedNumber = new char[firstIntArr.length+secondIntArr.length];
        int interleaveIndex = 0;
        for (int i = 0; i< indexToLoop ;i++){

            interleavedNumber[interleaveIndex]= firstIntArr[i];
            if (interleavedNumber.length>8 && !checkValidNumber(String.valueOf(interleavedNumber)))
                return -1;
            interleaveIndex++;
            interleavedNumber[interleaveIndex]= secondIntArr[i];
            if (interleavedNumber.length>8 && !checkValidNumber(String.valueOf(interleavedNumber)))
                return -1;
            interleaveIndex++;

        }
        char[] arrToAppend = firstIntArr.length > secondIntArr.length ? firstIntArr:secondIntArr;

        for (int i = indexToLoop; i<arrToAppend.length; i++){
            interleavedNumber[interleaveIndex] = arrToAppend[i];
            if (interleavedNumber.length>8 && !checkValidNumber(String.valueOf(interleavedNumber)))
                return -1;
            interleaveIndex++;
        }

        return Integer.valueOf(new String(interleavedNumber).trim());

    }

    public static boolean checkValidNumber(String number){
        try{
            Integer intNum = Integer.parseInt(number.trim());
            if(intNum  > 100000000)
                return false;
            else
                return true;

        }catch (Exception e){
            return false;
        }
    }
}
