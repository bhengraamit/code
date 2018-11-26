package leetcode;

import java.util.Stack;

/**
 * Created by amit.bhengra on 06/10/18.
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 *
 * You can solve it using recursion as well
 */
public class KthSmallestInBST {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int counter = 0;
        fillStack(root,stack);
        while(!stack.empty()){
            TreeNode pop = stack.pop();
            counter++;
            if(counter == k)
                return pop.val;
            fillStack(pop.right,stack);
        }
        return -1;
    }

    public void fillStack(TreeNode node, Stack<TreeNode> stack){
        if(node == null)
            return;
        while(node!=null){
            stack.push(node);
            node = node.left;
        }
    }
}
