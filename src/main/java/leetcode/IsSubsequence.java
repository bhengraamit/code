package leetcode;

/**
 * Created by amit.bhengra on 04/10/18.
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if( s==null || t == null )
            return true;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int sLength = 0;
        int tLength = 0;
        while( sLength < s.length() && tLength < t.length()){
            if(tChar[tLength] == sChar[sLength])
                sLength++;
            tLength++;
        }
        return sLength == s.length();

    }
}
