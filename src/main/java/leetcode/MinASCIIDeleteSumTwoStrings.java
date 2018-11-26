package leetcode;

/**
 * Created by amit.bhengra on 30/09/18.
 */
public class MinASCIIDeleteSumTwoStrings {

    public int minimumDeleteSum(String s1, String s2) {
        if(s1.equals(s2))
            return 0;
        char[] chArr1 = s1.toCharArray();
        char[] chArr2 = s2.toCharArray();
        int min = findMinDelete(s1,s2,0,0);
        return 0;
    }

    public int findMinDelete(String s1,String s2, int pos1, int  pos2){
        getSubString(s1,pos1);
        return 0;
    }

    public String getSubString(String str,int pos1){
        String sub1 = str.substring(0,pos1);
        String sub2 = "";
        if(pos1+1 <= str.length()-1)
            sub2 += str.substring(pos1+1,pos1+2);
        return sub1+sub2;
    }
}
