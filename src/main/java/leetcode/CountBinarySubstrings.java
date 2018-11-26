package leetcode;

/**
 * Created by amit.bhengra on 15/09/18.
 *
 * https://leetcode.com/problems/count-binary-substrings/description/
 */
public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        if(s== null || s.length() <= 1)
            return 0;
        //min length 2
        int totalSum = 0;
        int lastZero = 0;
        int lastOne = 0;
        int tempZero = 0;
        int tempOne = 0;
        char lastChar = s.charAt(0);
        for(int i=0; i< s.length(); i++){
            if(s.charAt(i) == '0' && lastChar!='0'){
                lastOne = tempOne;
                tempOne = 0;
            }
            if(s.charAt(i) == '1' && lastChar!='1'){
                lastZero = tempZero;
                tempZero = 0;
            }
            if(s.charAt(i) == '0'){
                tempZero++;
                if(lastOne >= tempZero)
                    totalSum++;
            }
            if(s.charAt(i) == '1'){
                tempOne++;
                if(lastZero >= tempOne)
                    totalSum++;
            }
            lastChar = s.charAt(i);
        }

        return totalSum;
    }
}
