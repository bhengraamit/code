package leetcode;

/**
 * Created by amit.bhengra on 01/11/18.
 *
 *https://leetcode.com/problems/excel-sheet-column-number/description/
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        if(s == null || s.length() == 0)
            return 0;
        char[] chArr = s.toCharArray();
        if(s.length() == 1)
            return chArr[0] - 'A' + 1;
        int sum = chArr[s.length()-1] - 'A' + 1;
        int base26 = 26;
        for(int i=s.length()-2; i>=0 ; i--){
            sum += base26 * (chArr[i] - 'A' + 1);
            base26 *= 26;
        }
        return sum;
    }
}
