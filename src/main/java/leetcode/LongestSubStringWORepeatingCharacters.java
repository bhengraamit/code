package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amit.bhengra on 07/10/18.
 */
public class LongestSubStringWORepeatingCharacters {

    public static void main(String[] args) {
        LongestSubStringWORepeatingCharacters longestSubStringWORepeatingCharacters = new LongestSubStringWORepeatingCharacters();
        System.out.println(longestSubStringWORepeatingCharacters.lengthOfLongestSubstring("eeydgwdykpv"));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length()==0)
            return 0;
        Map<String,Integer> uniqueMap = new HashMap<>();
        int i=-1, j=0;
        int dup_count = 0;
        int length = 0;
        while(j < s.length()){
            if(dup_count == 0){
                String ch = s.substring(j,j+1);
                if(uniqueMap.get(ch)!=null){
                    uniqueMap.put(ch,uniqueMap.get(ch)+1);
                    dup_count++;
                }else{
                    uniqueMap.put(ch,1);
                    length = j-i > length ? j-i : length;
                }
                j++;
            }else{
                i++;
                String ch = s.substring(i,i+1);
                int count  = uniqueMap.get(ch);
                if(count > 1){
                    dup_count--;
                }
                count--;
                if(count == 0)
                    uniqueMap.remove(ch);
                else
                    uniqueMap.put(ch,count);
            }
        }

        return length;
    }
}
