package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by amit.bhengra on 02/03/18.
 * https://www.codechef.com/MARCH18B/problems/XXOR
 */
public class ChefAndEasyProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String nAndQ = bi.readLine();
        String[] split = nAndQ.split(" ");
        int n = Integer.valueOf(split[0]);
        int q = Integer.valueOf(split[1]);
        String nList = bi.readLine();
        String[] nSplit = nList.split(" ");
        int[][] bitN1COunt = preprocess(nSplit);
        for (int i=0;i<q;i++)
            processQueries(bitN1COunt,bi);
    }

    private static void processQueries(int[][] bitN1COunt, BufferedReader bi) throws IOException {
        String lR = bi.readLine();
        String[] split = lR.split(" ");
        int l = Integer.valueOf(split[0])-1;
        int r = Integer.valueOf(split[1])-1;
        int totalBits = r-l+1;
        int nextToLeftIndex = l-1;
        //if (l!=0)
        //    nextToLeftIndex -= 1;
        int xor = 0;
        for (int i=30;i >=0; i--){
            int tosubtract = 0;
            if (nextToLeftIndex != -1)
                tosubtract = bitN1COunt[i][nextToLeftIndex];

            int numOf1 = bitN1COunt[i][r]- tosubtract;
            int numOf0 = totalBits - numOf1;
            if (numOf0 > numOf1)
                xor += 1;
            if (i!=0)
                xor = xor << 1;
        }
        System.out.println(xor);
    }

    private static int[][] preprocess(String[] nSplit) {
        if (nSplit!=null){
            int[][] bitNumberCount = new int[31][nSplit.length];
            int i = 0;
            for (String n: nSplit){
                preprocess(Integer.valueOf(n),i,bitNumberCount);
                i++;
            }
            for (int j =0; j<31; j++){
                int sum = 0;
                for (int k =0; k< nSplit.length; k++){
                    sum = bitNumberCount[j][k] + sum;
                    bitNumberCount[j][k] = sum;
                }
            }
            return bitNumberCount;
        }
        return null;
    }

    private static void preprocess(Integer num, int index, int[][] bitNumberCount) {
        for (int i = 0;i<31; i++){

            int bit = (num & ( 1 << i )) >> i;
            if (bit == 1)
                bitNumberCount[i][index]++;
        }
    }

}
