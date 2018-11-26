package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by amit.bhengra on 15/09/18.
 */
public class BinaryTreeInorderTraversalStack {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        if(root == null)
            return inorder;
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode startNode = root;
        while(true){
            stackFill(startNode,nodeStack);
            if(nodeStack.empty())
                break;
            TreeNode pop = nodeStack.pop();
            inorder.add(pop.val);
            startNode = pop.right;
        }
        return inorder;
    }

    public void stackFill(TreeNode root,Stack<TreeNode> nodeStack){
        if(root == null)
            return;
        while(root!=null){
            nodeStack.push(root);
            root = root.left;
        }
    }
}
