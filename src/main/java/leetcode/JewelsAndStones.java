package leetcode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by amit.bhengra on 23/08/18.
 */
public class JewelsAndStones {
    public int numJewelsInStones(String j, String s) {
        if(null!=j && j.length() > 0 && null!=s && s.length() > 0 ){
            List<Character> jewels = j.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
            Set<Character> jewelSet = new HashSet<Character>(jewels);
            List<Character> stones = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
            int[] count = {0};
            stones.stream().forEach(stone -> {
                if(jewelSet.contains(stone))
                    count[0]++;
            });
            return count[0];
        }
        return 0;
    }
}
