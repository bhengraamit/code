package leetcode;

/**
 * Created by amit.bhengra on 06/10/18.
 *
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        return findMin(root,0);
    }

    public int findMin(TreeNode node, int depth){
        if(node == null)
            return depth;
        depth += 1;
        if(node.left == null && node.right == null)
            return depth;
        if(node.left == null)
            return findMin(node.right,depth);
        if(node.right == null)
            return findMin(node.left,depth);

        int leftMin  = findMin(node.left,depth);
        int rightMin = findMin(node.right, depth);
        return leftMin < rightMin ? leftMin : rightMin;
    }

}
