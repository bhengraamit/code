package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit.bhengra on 08/09/18.
 *
 * https://leetcode.com/problems/binary-tree-paths/description/
 *
 * Not a good solution its O(h * 2powh)
 */
public class BinaryTreePathsV1 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root == null)
            return paths;
        if(root.left==null && root.right==null){
            String strVal = String.valueOf(root.val);
            paths.add(strVal);
            return paths;
        }
        List<String> totalChildPaths = new ArrayList<>();
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        if(leftPaths!=null)
            totalChildPaths.addAll(leftPaths);
        if(rightPaths!=null)
            totalChildPaths.addAll(rightPaths);
        for(String path:totalChildPaths){
            StringBuilder builder = new StringBuilder();
            builder.append(root.val);
            builder.append("->");
            builder.append(path);
            paths.add(builder.toString());
        }
        return paths;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
