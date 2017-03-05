package uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by amit.bhengra on 20/02/17.
 */
public class TopologicalSort {
    public static void main(String[] args) {

    }

    static int tasks(int n, int[] a, int[] b) {
        Map<Integer,Boolean> tasksCompleted = new HashMap<>();
        initMap(tasksCompleted,a,b);
        int counter =0;
        int totalTasks = n;
        while (counter < a.length){
            if (tasksCompleted.get(a[counter])) {
                totalTasks--;
            }else{
                if (tasksCompleted.get(b[counter]))
                    totalTasks--;
                else{
                    tasksCompleted.put(a[counter],true);
                    tasksCompleted.put(b[counter],true);
                }
            }

            counter++;
        }
        return totalTasks;
    }

    private static void initMap(Map<Integer, Boolean> tasksCompleted, int[] a, int[] b) {
        int counter = 0;
        while (counter < a.length){
            tasksCompleted.put(a[counter],false);
            tasksCompleted.put(b[counter],false);
            counter++;
        }
    }


}
