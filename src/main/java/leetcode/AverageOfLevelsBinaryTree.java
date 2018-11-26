package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by amit.bhengra on 16/09/18.
 *
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 */
public class AverageOfLevelsBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root  == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            calAverage(q,result);
        }
        return result;
    }

    public void calAverage(Queue<TreeNode> q, List<Double> result){
        int size = q.size();
        double sum = 0;
        int i = 0;
        while(i < size){
            TreeNode node = q.poll();
            sum += node.val;
            if(node.left!=null)
                q.add(node.left);
            if(node.right!=null)
                q.add(node.right);
            i++;
        }
        result.add(sum/size);
    }
}
