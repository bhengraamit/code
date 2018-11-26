package leetcode;

/**
 * Created by amit.bhengra on 09/09/18.
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("8V8K;G;K;V;"));
    }

    public boolean isPalindrome(String s) {
        if(s == null || s.isEmpty())
            return true;
        s = s.toLowerCase();
        char[] chrs = s.toCharArray();
        int i = 0, j = s.length()-1;

        while(i<j){
            if(((chrs[i] >= 97 && chrs[i] <= 122) || (chrs[i] >= 48 && chrs[i] <= 57)) &&
                    ((chrs[j] >= 97 && chrs[j] <= 122) || (chrs[j] >= 48 && chrs[j] <= 57))){
                if(chrs[i]!=chrs[j])
                    return false;
                else{
                    i++;j--;
                }
            }else{
                if(!((chrs[i] >= 97 && chrs[i] <= 122) || (chrs[i] >= 48 && chrs[i] <= 57)))
                    i++;
                if(!((chrs[j] >= 97 && chrs[j] <= 122) || (chrs[j] >= 48 && chrs[j] <= 57)))
                    j--;
            }
        }
        return true;
    }
}
