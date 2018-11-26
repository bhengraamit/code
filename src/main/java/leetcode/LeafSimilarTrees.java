package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by amit.bhengra on 16/09/18.
 *
 * https://leetcode.com/problems/leaf-similar-trees/description/
 */
public class LeafSimilarTrees {

    boolean earlyBreak = false;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        Queue<Integer> q = new LinkedList<Integer>();
        fillQueue(root1,q);
        dequeue(root2,q);
        if(q.isEmpty())
            return true;
        return false;
    }

    public void fillQueue(TreeNode root, Queue<Integer> q){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            q.add(root.val);
            return;
        }
        if(root.left!=null)
            fillQueue(root.left,q);
        if(root.right!=null)
            fillQueue(root.right,q);
    }

    public void dequeue(TreeNode root, Queue<Integer> q){
        if(root == null)
            return;
        if(earlyBreak)
            return;
        if(root.left == null && root.right == null){
            int val = q.peek();
            if(val!=root.val)
                earlyBreak = true;
            else
                q.poll();
            return;
        }
        if(root.left!=null)
            dequeue(root.left,q);
        if(root.right!=null)
            dequeue(root.right,q);
    }
}
