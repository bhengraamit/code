package leetcode;

/**
 * Created by amit.bhengra on 17/10/18.
 */
public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        uniquePaths.uniquePaths(10,6);
    }

    public int uniquePaths(int m, int n) {
        return calFact(m+n-2) / (calFact(m-1)*calFact(n-1));
    }

    public int calFact(int num){
        int fact = 1;
        while(num >0){
            fact *= num;
            num--;
        }
        return fact;
    }
}
