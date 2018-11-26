package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by amit.bhengra on 16/09/18.
 *
 *
 * https://leetcode.com/problems/brick-wall/description/
 */
public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        if(wall == null || wall.size() == 0)
            return 0;
        Map<Integer,Integer> indexCount = new HashMap<>();
        int mostIndex = 0;
        for(int i=0; i<wall.size();i++){
            List<Integer> bricks = wall.get(i);
            int sum = 0;
            for(int j=0; j<bricks.size(); j++){
                sum +=bricks.get(j);
                if(indexCount.containsKey(sum)){
                    int count = indexCount.get(sum);
                    indexCount.put(sum,++count);
                }else{
                    indexCount.put(sum,1);
                }
                if(indexCount.get(sum) > mostIndex && j!=bricks.size()-1)
                    mostIndex = indexCount.get(sum);
            }
        }
        return wall.size() - mostIndex;
    }
}
