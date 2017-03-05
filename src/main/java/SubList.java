import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit.bhengra on 21/12/16.
 */
public class SubList {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        Integer length = Integer.valueOf(bi.readLine());

        List<Integer> firstList = new ArrayList<>();
        while (length-- > 0){
            Integer num = Integer.valueOf(bi.readLine());
            firstList.add(num);
        }

        Integer secondLength = Integer.valueOf(bi.readLine());
        List<Integer> secondList = new ArrayList<>();
        while (secondLength-- >0){
            secondList.add(Integer.valueOf(bi.readLine()));
        }

        int index = find(firstList,secondList);
        System.out.println(index);
    }

    private static int find(List<Integer> firstList, List<Integer> secondList) {
        if (firstList.size()<secondList.size())
            return -1;
        int secondIndex = 0;
        for (int i = 0; i<firstList.size(); i++){
            if (firstList.get(i).equals(secondList.get(secondIndex))){
                if (compareList(firstList,secondList,i,secondIndex))
                    return i;
                else
                    continue;
            }
        }
        return -1;
    }

    private static boolean compareList(List<Integer> firstList, List<Integer> secondList, int firstIndex, int secondIndex) {
        while (secondIndex<secondList.size() && firstList.get(firstIndex).equals(secondList.get(secondIndex))){
            secondIndex++;
            firstIndex++;
        }
        if (secondIndex!=secondList.size())
            return false;
        else
            return true;
    }

}
