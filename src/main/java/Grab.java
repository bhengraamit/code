import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by amit.bhengra on 15/03/17.
 */
public class Grab {
    public static void main(String[] args) {
        int[] A = {40,40,100,80,20};
        int[] B = {3,3,2,2,3};
        int M = 3;
        int X = 2;
        int Y = 101;
        System.out.println(solution(A,B,M,X,Y));
    }

    public static int solution(int[] A, int[] B, int M, int X, int Y) {
        int[] weights = A;
        int[] floors = B;
        int highestFloor = M;
        int maxPeople = X;
        Integer weightLimit = Y;
        if ((weights!=null && weights.length > 0) || (floors!=null && floors.length > 0)){
            int peopleTransferred = 0;
            int peopleIndex = 0;
            int totalStops = 0;
            while (peopleTransferred <= weights.length){
                BigInteger totalWeight = new BigInteger("0");
                int peopleOnboard = 0;
                Set<Integer> uniqueFloors = new HashSet<>();
                while (peopleIndex < weights.length && peopleTransferred<= weights.length && peopleOnboard <= maxPeople && totalWeight.compareTo(new BigInteger(weightLimit.toString())) <=0){
                    if (floors[peopleIndex] <= highestFloor && (peopleOnboard + 1) <= maxPeople && (totalWeight.add(new BigInteger(String.valueOf(weights[peopleIndex]))).compareTo(new BigInteger(weightLimit.toString())) <=0)) {
                        totalWeight = totalWeight.add(new BigInteger(String.valueOf(weights[peopleIndex])));
                        peopleOnboard += 1;
                        uniqueFloors.add(floors[peopleIndex]);
                        peopleIndex++;
                        peopleTransferred++;
                    }else{
                        break;
                    }
                }
                if (uniqueFloors.size() > 0) {          // only adding when there were any people in the lift
                    totalStops += uniqueFloors.size() + 1;   // 1 here is for the ground floor stop
                }
                if (peopleIndex >= weights.length)         // this is for breaking the outer loop
                    break;
            }
            return totalStops;
        }
        return 0;
    }
}
