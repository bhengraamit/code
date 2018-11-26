package leetcode;

import java.util.Arrays;

/**
 * Created by amit.bhengra on 16/09/18.
 */
public class Citations {

    public static void main(String[] args) {
        Citations citations = new Citations();
        int[] cite = {3,0,6,1,5,4};
        citations.hIndex(cite);
    }

    public int hIndex(int[] citations) {
        if(citations == null || citations.length ==0)
            return 0;
        Arrays.sort(citations);
        int count = 1;
        for(int i=citations.length-1;i>=0;i--){
            if(count >= citations[i])
                return citations[i];
            count++;
        }
        return 0;
    }
}
