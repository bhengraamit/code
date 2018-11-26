package leetcode;

/**
 * Created by amit.bhengra on 26/08/18.
 *
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 */
public class DiameterBinaryTree {

    public class TreeNode {
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    static int longestPath = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        longestPath = 0;
        findLongestPath(root);
        return longestPath;
    }

    public int findLongestPath(TreeNode root){
        if(root == null)
            return 0;
        int leftValue = 0;
        int rightValue = 0;
        if(root.left!=null)
            leftValue = 1 + findLongestPath(root.left);
        if(root.right!=null)
            rightValue = 1 + findLongestPath(root.right);

        int sum = leftValue + rightValue;
        if(sum > longestPath)
            longestPath = sum;
        return leftValue > rightValue ? leftValue : rightValue;
    }
}
