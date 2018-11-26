package leetcode;

/**
 * Created by amit.bhengra on 16/09/18.
 *
 * https://leetcode.com/problems/search-in-a-binary-search-tree/description/
 */
public class SearchInBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;
        if(root.val == val)
            return root;
        if(val < root.val)
            return searchBST(root.left,val);
        if(val > root.val)
            return searchBST(root.right,val);
        return null;
    }
}
