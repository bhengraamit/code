package leetcode;

import java.util.*;

/**
 * Created by amit.bhengra on 17/10/18.
 *
 * https://leetcode.com/problems/random-pick-index/description/
 */
public class RandomPickIndex {
    public static void main(String[] args) {
        int nums[]  = {3,3,3};
        RandomPickIndex randomPickIndex  = new RandomPickIndex(nums);
        for (int i = 0; i <100 ; i++) {
            System.out.println(randomPickIndex.pick(3));
        }


    }

    Map<Integer,State> stateMap = new HashMap<>();

    public RandomPickIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            State state = stateMap.getOrDefault(nums[i], new State());
            state.totalCount++;
            state.index.add(i);
            if(state.startIndex == -1) {
                state.startIndex = i;
                state.random = new Random();
            }
            stateMap.put(nums[i],state);
        }

    }

    public int pick(int target) {
        State state = stateMap.get(target);
        int count = state.totalCount;
        int random = state.random.nextInt(count);
        return state.index.get(random);
    }

    public class State{
        int startIndex = -1;
        Random random;
        int totalCount;
        List<Integer> index = new ArrayList<>();
    }
}
