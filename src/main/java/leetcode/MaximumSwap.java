package leetcode;

/**
 * Created by amit.bhengra on 17/09/18.
 *
 * https://leetcode.com/problems/maximum-swap/description/
 */
public class MaximumSwap {

    public int maximumSwap(int num) {
        String numStr = String.valueOf(num);
        char[] chArr = numStr.toCharArray();
        boolean found = false;
        for(int i=0; i< chArr.length; i++){
            if(found)
                break;
            int index = i;
            for(int j = i+1; j< chArr.length; j++){
                if(chArr[j] > chArr[index]){
                    index = j;
                }
            }
            if(chArr[index] > chArr[i]){
                char ch = chArr[i];
                chArr[i] = chArr[index];
                chArr[index] = ch;
                break;
            }
        }
        String newNum = new String(chArr);
        return Integer.valueOf(newNum);
    }
}
