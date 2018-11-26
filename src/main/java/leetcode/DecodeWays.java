package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amit.bhengra on 25/08/18.
 *
 * https://leetcode.com/problems/decode-ways/description/
 */
public class DecodeWays {

    static Map<String,Integer> globalMap = new HashMap<>();

    static{
        globalMap.put("10",1);
        globalMap.put("11",2);
        globalMap.put("12",2);
        globalMap.put("13",2);
        globalMap.put("14",2);
        globalMap.put("15",2);
        globalMap.put("16",2);
        globalMap.put("17",2);
        globalMap.put("18",2);
        globalMap.put("19",2);
        globalMap.put("20",1);
        globalMap.put("21",2);
        globalMap.put("22",2);
        globalMap.put("23",2);
        globalMap.put("24",2);
        globalMap.put("25",2);
        globalMap.put("26",2);
    }

    static int dp[][]= null;

    public int numDecodings(String s) {
        if(s == null)
            return 0;
        if (s.contains("0")){
            boolean containsZero = s.replaceAll("10","").replaceAll("20","").contains("0");
            if(containsZero)
                return 0;
        }
        int sL = s.length();
        int startIndex = 0;
        int endIndex = sL-1;
        dp = new int[sL][sL];

        int ret = recurse(s,startIndex,endIndex);
        return ret;
    }

    public int recurse(String input, int start, int end){
        if(start == end){
            if(input.substring(start,end+1).equals("0"))
                return 0;
            return 1;
        }
        if(end-start == 1){
            return checkTwoLength(input,start,end);
        }

        if(dp[start][end]!=0)
            return dp[start][end];

        boolean twoLengthCom = false;
        if(checkTwoLength(input,start,start+1)>1)
            twoLengthCom = true;
        int firstSum = recurse(input,start+1,end);
        int secondSum = (twoLengthCom ? recurse(input,start+2,end) : 0);
        int sum = firstSum + secondSum;
        dp[start][end] = sum;
        return sum;
    }


    public int checkTwoLength(String s, int start, int end){
        String sub = s.substring(start,end+1);
        if(globalMap.get(sub)!=null)
            return globalMap.get(sub);
        else
            return 1;
    }
}
