package leetcode;

/**
 * Created by amit.bhengra on 09/09/18.
 *
 * https://leetcode.com/contest/weekly-contest-101/problems/rle-iterator/
 */
public class RLEIterator {

    int [] array = null;
    int currentIndex = 0;
    int arraySize = 0;
    public RLEIterator(int[] A) {
        array = A;
        arraySize = A.length-1;
    }

    public int next(int n) {
        if(currentIndex > arraySize)
            return -1;
        if(array[currentIndex] - n >= 0){
            int num = array[currentIndex+1];
            array[currentIndex] = array[currentIndex] - n;
            return num;
        }else{
            //currentIndex += 2;
            while(currentIndex <= arraySize){
                if(array[currentIndex] > 0){
                    if(array[currentIndex] - n >= 0){
                        int num = array[currentIndex+1];
                        array[currentIndex] = array[currentIndex] - n;
                        return num;
                    }else{
                        n = n - array[currentIndex];
                    }
                }
                currentIndex +=2;
            }
            return -1;
        }
    }
}
