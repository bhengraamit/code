/**
 * Created by amit.bhengra on 19/12/16.
 */
public class Elevator {

    public static void main(String[] args) {

    }

    public int solution(int[] weights, int[] floors, int highestFloor, int maxPeople, int weightLimit) {
        // write your code in Java SE 8
        // was not able to test my code or complete the entire code
        int numberOfStops = 0;
        int peopleReached = 0;
        int peopleIndex = 0;
        while (peopleReached <= weights.length){        // loop till all people reach their floors

            //calculate how many people can be taken
            int currentWeight = 0;
            int peopleOnboard = 0;
            while ((peopleIndex< weights.length) &&((currentWeight <= weightLimit) || (peopleOnboard <=maxPeople))){

                if((weights[peopleIndex] + currentWeight) > weightLimit)            // if weight exceeds break the loop
                    break;
                else {

                    if ((peopleOnboard+1) > maxPeople)                      // if people exceeds break the loop
                        break;
                    else {
                        currentWeight += weights[peopleIndex];              // if everything satisfies increase weight and people
                        peopleOnboard++;
                    }

                }
                    peopleIndex++;
            }

            numberOfStops = numberOfStops+peopleOnboard+1;  // extra 1 is for ground stop
            peopleReached += peopleOnboard;
        }
        return numberOfStops;
    }
}
