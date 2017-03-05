/**
 * Created by amit.bhengra on 21/12/16.
 */
public class StairCase {
    public static void main(String[] args) {
        StairCase(6);
    }

    static void StairCase(int n) {
        for (int i =0; i <n ;i++){
            for (int j=n-1;j>=0; j--){
                if(j>i)
                    System.out.print(" ");
                else
                    System.out.print("#");
            }
            System.out.println();
        }

    }
}
