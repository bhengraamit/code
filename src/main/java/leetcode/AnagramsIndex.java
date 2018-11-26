package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by amit.bhengra on 26/08/18.
 * https://leetcode.com/problems/find-all-anagrams-in-a-string
 */
public class AnagramsIndex {

    public static void main(String[] args) {
        AnagramsIndex anagramsIndex = new AnagramsIndex();
        List<Integer> anagrams = anagramsIndex.findAnagrams("cbaebabacd", "abc");
        System.out.println(anagrams);
    }
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.isEmpty() || s.length() < p.length())
            return null;
        Map<Character,Integer> origMap = createOrigMap(p.toCharArray());
        Map<Character,Integer> currMap = new HashMap<>();

        int exactCount = 0;
        //first traverse the window
        char[] array = s.toCharArray();
        int i = 0;
        List<Integer> startIndexes = new ArrayList<>();
        while(i < p.length()){
            char ch = array[i];
            if(origMap.get(ch) == null){
                i++;
                continue;
            }

            if(currMap.get(ch) == null)
                currMap.put(ch,0);
            int oldCount = currMap.get(ch);
            int count = oldCount+1;
            currMap.put(ch,count);

            if(origMap.get(ch).equals(count))
                exactCount++;
            else{
                if(oldCount == origMap.get(ch))
                    exactCount--;
            }

            if(exactCount == origMap.size())
                startIndexes.add(0);

            i++;
        }

        // window traverse
        // using the same index i
        if(s.length() == p.length())
            return startIndexes;
        i = 0;
        int j = p.length();

        while(j<s.length()){

            //take out count first
            char ch = array[i];
            if(origMap.get(ch) == null){
                i++;
            }else{
                // curr ch will always be there in the window
                int oldCount = currMap.get(ch);
                int newCount = oldCount - 1;
                currMap.put(ch,newCount);

                if(oldCount == origMap.get(ch))
                    exactCount--;
                else if(newCount == origMap.get(ch))
                    exactCount++;
                i++;
            }

            char endCh = array[j];
            if(origMap.get(endCh) == null){
                j++;
            }else{
                if(currMap.get(endCh)==null)
                    currMap.put(endCh,0);
                int oldCount = currMap.get(endCh);
                int newCount = oldCount + 1;
                currMap.put(endCh,newCount);

                if(oldCount == origMap.get(endCh))
                    exactCount--;
                else if(newCount == origMap.get(endCh))
                    exactCount++;
                j++;
            }

            if(origMap.size() == exactCount)
                startIndexes.add(i);


        }

        return startIndexes;
    }

    public Map<Character,Integer> createOrigMap(char[] array){
        Map<Character,Integer> map = new HashMap<>();
        for(char ch:array){
            if(map.get(ch)!=null)
                map.put(ch,map.get(ch)+1);
            else
                map.put(ch,1);
        }
        return map;
    }
}
