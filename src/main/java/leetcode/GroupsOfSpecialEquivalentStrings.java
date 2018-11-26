package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by amit.bhengra on 01/11/18.
 *
 * https://leetcode.com/problems/groups-of-special-equivalent-strings/description/
 */
public class GroupsOfSpecialEquivalentStrings {

    public int numSpecialEquivGroups(String[] A) {
        if(A == null || A.length == 0)
            return 0;
        Set<String> groups = new HashSet<String>();
        for(String str : A){
            char[] chArr = str.toCharArray();
            int[] oddArr = new int[26];
            int[] evenArr = new int[26];
            int count = 1;
            for(char ch: chArr){
                if(count % 2 == 0){
                    evenArr[ch - 'a']++;
                }else{
                    oddArr[ch - 'a']++;
                }
                count++;
            }
            String evenHash = createHash(evenArr);
            String oddHash = createHash(oddArr);
            groups.add(oddHash+"#"+evenHash);
        }
        return groups.size();
    }

    public String createHash(int[] arr){
        StringBuilder finalStr = new StringBuilder();
        for(int i =0; i<arr.length; i++){
            if(arr[i] == 0)
                continue;
            char ch = (char)('a' + i);
            finalStr.append(ch+":"+arr[i]+",");
        }
        return finalStr.toString();
    }
}
