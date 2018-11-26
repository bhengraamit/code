package leetcode;

/**
 * Created by amit.bhengra on 31/10/18.
 *
 * https://leetcode.com/problems/wildcard-matching/description/
 */
public class RegexRecursion {

    Boolean [][] dp;
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()+2][p.length()+2];
        return isMatch(s.toCharArray(),p.toCharArray(),0,0);
    }
    public boolean isMatch(char[] input, char[] pattern, int inIndex, int patIndex){
        if(dp[inIndex][patIndex]!=null)
            return dp[inIndex][patIndex];
        if(inIndex==input.length && patIndex == pattern.length) {
            dp[inIndex][patIndex] = true;
            return true;
        }
        if(patIndex == pattern.length) {
            dp[inIndex][patIndex] = false;
            return false;
        }
        if(inIndex < input.length && (pattern[patIndex] == '?' || pattern[patIndex] == input[inIndex])){
            boolean match =  isMatch(input,pattern,inIndex+1,patIndex+1);
            dp[inIndex][patIndex] = match;
            return match;
        }

        if(inIndex <= input.length && pattern[patIndex] == '*'){
            boolean match1 = isMatch(input,pattern,inIndex,patIndex+1);
            dp[inIndex][patIndex+1] = match1;
            boolean match2 = isMatch(input,pattern,inIndex+1,patIndex);
            dp[inIndex+1][patIndex] = match2;
            boolean match3 = isMatch(input,pattern,inIndex+1,patIndex+1);
            dp[inIndex+1][patIndex+1] = match3;
            dp[inIndex][patIndex] = match1 || match2 || match3;
            return dp[inIndex][patIndex];
        }
        return false;
    }
}
