/**
 * Created by amit.bhengra on 25/03/17.
 */
public class RegionsOnPlane {

    public static void main(String[] args) {
        System.out.println(RegionsInPlane(56));
    }

    public static int RegionsInPlane(int input1){
        // so the formula which I arrived was ((n*(n+1))/2  + 1)
        /**
         * Let me explain how this formula was arrived.
         *
         * Base case N = 0, Regions = 1
         * N =1 , Regions = 2
         * N =2 , Regions = 4
         *
         * Now here the tricky thing is how to maximize the regions,
         * so the point is we can only maximize the regions if we try to cut
         * each and every line, its like nth line producing n more regions,
         * for example n=1 produces 1 more region,
         * n = 2 produces 2 more regions
         * n = 3 produces 3 more regions and so on ,
         * which will result in following:
         *
         * N = 3, Regions = 7
         * N = 4, Regions = 11
         * N = 5, Regions = 16 and so on.
         *
         * If you try to see the pattern then it occurs it is ((n*(n+1))/2  + 1)
         */

        return (input1*(input1+1))/2  + 1;
    }
}
