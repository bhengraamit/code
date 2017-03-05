import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by amit.bhengra on 18/12/16.
 */
public class ContiguousAnagrams {

    public static void main(String[] args) {
        System.out.println(solution("0001"));
    }

    public static int solution(String input) {
        if (input != null){
            // initialise 0-9 Array
            Map<Character,List<Integer>> map = new HashMap<>();
            char[] chars = input.toCharArray();
            char[] inputCh = new char[]{'0','1','2','3','4','5','6','7','8','9'};
            for (char ch : inputCh){
                map.put(ch,new ArrayList<>(chars.length));
            }
            //populate  map
            int index = 0;
            for (char ch:chars){
                List<Integer> counts = map.get(ch);
                Integer count = null;
                if (counts.size()> index)
                    count = counts.get(index);
                Integer prevCount = null;
                if (index==0)
                    prevCount =0;
                else
                    prevCount = counts.get(index-1);
                if (count == null){
                    count = prevCount+1;
                    counts.add(index,count);
                }

                //update other symbols
                for (Character symbol: map.keySet()){
                    if (ch!=symbol){
                        List<Integer> symbolsCount = map.get(symbol);
                        if (index==0)
                            prevCount = 0;
                        else {
                            prevCount = symbolsCount.get(index-1);
                        }
                        symbolsCount.add(index,prevCount);
                    }
                }
                index++;
            }


            //create windows and traverse
            int totalPal = 0;
            int window = 1;
            while (window <= chars.length) {
                for (int i = 0; i <= chars.length - window; i++) {
                    int start = i;
                    int end = i+window-1;
                    int prevFreq = 0;
                    int evenCount = 0;
                    int oddCount = 0;

                    for (Character ch:map.keySet()) {
                        if (i != 0) {
                            prevFreq = map.get(ch).get(i-1);
                        }
                        if ((map.get(ch).get(end) - prevFreq) % 2 == 0)
                            evenCount++;
                        else
                            oddCount++;
                    }

                    if (oddCount==1)
                        totalPal++;
                    else if (evenCount > 0 && oddCount <=1)
                        totalPal++;

                }
                window++;
            }

//            System.out.println(totalPal);
            return totalPal;
        }
        return 0; // if input is null
    }
}
