package leetcode;

/**
 * Created by amit.bhengra on 26/08/18.
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 */
public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        if(s.isEmpty() || s.length() ==1)
            return true;
        int i = 0;
        int mid = (s.length()/2) - 1;
        int j = s.length() - 1;
        char[] array = s.toCharArray();
        while(array[i] == array[j] && i <= mid){
            i++;
            j--;
        }
        if(i > mid)
            return true;
        boolean checkPalindrome = false;
        checkPalindrome |= checkPalindrome(array,i+1,j);
        checkPalindrome |= checkPalindrome(array,i,j-1);
        return checkPalindrome;
    }

    public boolean checkPalindrome(char[] array, int start, int end){
        int mid = (start+end)/2;
        while(start<=mid){
            if(array[start]!=array[end])
                return false;
            start++;
            end--;
        }
        return true;
    }
}
