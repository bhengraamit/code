package leetcode;

/**
 * Created by amit.bhengra on 07/10/18.
 *
 * https://leetcode.com/contest/weekly-contest-105/problems/reverse-only-letters/
 */
public class ReverseOnlyLetters {
    public static void main(String[] args) {
        ReverseOnlyLetters reverseOnlyLetters = new ReverseOnlyLetters();
        System.out.println(reverseOnlyLetters.reverseOnlyLetters("ab-cd"));
        System.out.println(reverseOnlyLetters.reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(reverseOnlyLetters.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
        System.out.println(reverseOnlyLetters.reverseOnlyLetters("123ABCD=-926439jsgdf"));
        System.out.println(reverseOnlyLetters.reverseOnlyLetters(""));
    }

    public String reverseOnlyLetters(String S) {
        if(S == null || S.isEmpty())
            return S;
        char[] chArr = S.toCharArray();
        int i=0,j=S.length()-1;

        while(i<j){
            if(ifCharacters(chArr[i]) && ifCharacters(chArr[j])){
                char temp = chArr[i];
                chArr[i] = chArr[j];
                chArr[j] = temp;
                i++;j--;
            }else {
                if (!ifCharacters(chArr[i]))
                    i++;
                if (!ifCharacters(chArr[j]))
                    j--;
            }
        }
        return new String(chArr);
    }

    public boolean ifCharacters(char ch){
        if((ch >= 65 && ch <=90) || (ch>=97 && ch<=122))
            return true;
        return false;
    }
}
