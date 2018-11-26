package leetcode;

/**
 * Created by amit.bhengra on 16/09/18.
 */
public class SquareRoot {

    public static void main(String[] args) {
        SquareRoot squareRoot = new SquareRoot();
        squareRoot.mySqrt(2147395599);
    }
    public int mySqrt(int x) {
        if(x<=1)
            return x;
        int min = x;
        int max = x;
        int mid = x/2;
        long square = (long)mid*mid;

        while(square > x){
            max = mid ;
            mid = max/2;
            square = (long)mid*mid;
        }

        if(square == x)
            return mid;
        min = mid;
        return binarySearch(min,max,x);
    }

    public int binarySearch(int min, int max, int x){
        int last = min;
        while(min <= max){
            int mid = min + (max-min)/2;
            long square = (long)mid*mid;
            if(square == x)
                return mid;
            if(square < x){
                min = mid+1;
                last = mid;
            }
            else
                max = mid-1;
        }
        return last;
    }
}
