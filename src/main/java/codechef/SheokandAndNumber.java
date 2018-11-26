package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by amit.bhengra on 04/08/18.
 * https://www.codechef.com/AUG18B/problems/SHKNUM
 */
public class SheokandAndNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.valueOf(br.readLine());
        int[] twoNums = preprocess();
        while (testCases-- > 0) {
            int input = Integer.valueOf(br.readLine());
            int distance = calculateDistance(input,twoNums);
            System.out.println(distance);
        }
    }

    private static int calculateDistance(int input, int[] twoNums) {
        int i=0,j=30;
        int distance = Integer.MAX_VALUE;
        while (true && i<j && i>=0 && j<=30){
            int tempDistance = input - (twoNums[i] + twoNums[j]);
            if (tempDistance == 0)
                return 0;
            int absTempDistance = Math.abs(tempDistance);
            if (absTempDistance < distance){
                distance = absTempDistance;
            }
            if (tempDistance > 0){
                i++;
            }else {
                j--;
            }
        }
        return distance;
    }

    private static int[] preprocess() {
        int[] twoNums = new int[31];
        int twosum =1;
        twoNums[0] =1;
        for (int i=1; i<31; i++){
            twosum = twosum*2;
            twoNums[i] = twosum;
        }
        return twoNums;
    }
}
