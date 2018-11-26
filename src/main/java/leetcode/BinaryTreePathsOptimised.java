package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit.bhengra on 08/09/18.
 *
 * https://leetcode.com/problems/binary-tree-paths/description/
 *
 * Time Complexity O(nh), Space Complexity : O(h * 2 pow h)
 */
public class BinaryTreePathsOptimised {
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> allPaths = new ArrayList<>();
        if(root == null)
            return allPaths;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(root.val);
        if(root.left == null && root.right == null){
            allPaths.add(stringBuilder.toString());
        }

        if(root.left!=null){
            fillPaths(new StringBuilder(stringBuilder),root.left,allPaths);
        }
        if(root.right!=null){
            fillPaths(new StringBuilder(stringBuilder),root.right,allPaths);
        }
        return allPaths;
    }

    public void fillPaths(StringBuilder builder, TreeNode node, List<String> allPaths){
        if(node.left == null && node.right == null){
            builder.append("->");
            builder.append(node.val);
            allPaths.add(builder.toString());
            return;
        }
        if(node.left!=null){
            StringBuilder stringBuilder = new StringBuilder(builder);
            stringBuilder.append("->");
            stringBuilder.append(node.val);
            fillPaths(stringBuilder,node.left,allPaths);
        }
        if(node.right!=null){
            StringBuilder stringBuilder = new StringBuilder(builder);
            stringBuilder.append("->");
            stringBuilder.append(node.val);
            fillPaths(stringBuilder,node.right,allPaths);
        }
    }

    public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
