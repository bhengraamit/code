package uber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by amit.bhengra on 20/02/17.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bi.readLine());

        List<Integer> startingList= new ArrayList<>();
        List<Integer> endingList = new ArrayList<>();
        while (testCases-- >0){
            String input = bi.readLine();
            String num[] = input.split(" ");
            startingList.add(Integer.valueOf(num[0]));
            endingList.add(Integer.valueOf(num[1]));
        }
        Collections.sort(startingList);
        Collections.sort(endingList);
        int max = findMaxUbers(startingList,endingList);
        System.out.println(max);
    }

//    private static int findMaxUbers(List<Integer> startingList, List<Integer> endingList) {
//        if (startingList!=null && endingList!=null){
//            //assuming both the list size is same
//            int startCounter = 0;
//            int endCounter = 0;
//            int maxUbers = 0;
//            int currentUbers = 0;
//            while (startCounter < startingList.size()){
//                if (startingList.get(startCounter).equals(endingList.get(endCounter))){
//                    if ((currentUbers+1) > maxUbers)
//                        maxUbers = currentUbers +1;
//                    startCounter++;
//                    endCounter++;
//                }else{
//                    if (startingList.get(startCounter) <  endingList.get(endCounter)){
//                        currentUbers += 1;
//                        if (currentUbers > maxUbers)
//                            maxUbers = currentUbers;
//                        startCounter++;
//                    }else{
//                        currentUbers -= 1;
//                        endCounter++;
//                    }
//                }
//            }
//            return maxUbers;
//        }
//        return 0;
//    }

    private static int findMaxUbers(List<Integer> startingList, List<Integer> endingList) {
        if (startingList!=null && endingList!=null){
            //assuming both the list size is same
            int startCounter = 0;
            int endCounter = 0;
            int maxUbers = 0;
            int currentUbers = 0;

            while(startCounter < startingList.size()){
                if (startingList.get(startCounter) <= endingList.get(endCounter)){
                    currentUbers +=1;
                    if (currentUbers > maxUbers)
                        maxUbers = currentUbers;
                    startCounter++;
                }else{
                    endCounter++;
                    currentUbers -= 1;
                }
            }
            return maxUbers;
        }
        return 0;
    }
}
