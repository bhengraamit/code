import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by amit.bhengra on 17/12/16.
 * https://www.hackerrank.com/contests/zalando-codesprint/challenges/match-the-shoes
 */
public class MatchTheShoes {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String params = bi.readLine();
        String[] split = params.split(" ");
        int popular = Integer.valueOf(split[0]);
        int shoesNum  = Integer.valueOf(split[1]);
        int orderNum = Integer.valueOf(split[2]);

        Map<Integer,Set<Integer>> freqToOrderMap = new HashMap<>();
        Map<Integer,Integer> orderIdToFreqMap = new HashMap<>();

        while (orderNum-- > 0){
            Integer orderID  = Integer.valueOf(bi.readLine());
            Integer currentFreq = null;
            Integer latestFreq = null;
            if (!orderIdToFreqMap.containsKey(orderID)) {
                orderIdToFreqMap.put(orderID, 1);
                currentFreq = 1;
                latestFreq = currentFreq;
            }
            else {
                currentFreq = orderIdToFreqMap.get(orderID);
                latestFreq = currentFreq +1;
                orderIdToFreqMap.put(orderID,latestFreq);
            }

            //delete old freq if it exists
            if (freqToOrderMap.containsKey(currentFreq)){
                Set<Integer> ids = freqToOrderMap.get(currentFreq);
                if (ids!=null)
                    ids.remove(orderID);
            }

            if (!freqToOrderMap.containsKey(latestFreq))
                freqToOrderMap.put(latestFreq,new HashSet<>());

            freqToOrderMap.get(latestFreq).add(orderID);
        }

        // till here all order freq is collected
        ArrayList<Integer> freqList = new ArrayList<Integer>(freqToOrderMap.keySet());
        Collections.sort(freqList);

        int topProds = 0;
        int k = 1;
        int size = freqList.size();
        while (topProds < popular){
            int num = freqList.get(size-k);
            Set<Integer> ids = freqToOrderMap.get(num);
            Integer idsToTake = popular-topProds >= ids.size() ? ids.size(): popular-topProds;
            topProds  += idsToTake;
            List<Integer> idsList = new ArrayList<>(ids);
            Collections.sort(idsList);
            int idsIndex = 0;
            while (idsToTake > 0){
                System.out.println(idsList.get(idsIndex));
                idsIndex++;
                idsToTake--;
            }

            k++;
        }

    }
}
