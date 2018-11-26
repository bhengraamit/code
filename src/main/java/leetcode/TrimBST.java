package leetcode;

/**
 * Created by amit.bhengra on 16/09/18.
 *
 * https://leetcode.com/problems/trim-a-binary-search-tree/description/
 */
public class TrimBST {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null)
            return root;
        if(root.val >=L && root.val<=R){
            TreeNode left = trimBST(root.left,L,root.val);
            TreeNode right = trimBST(root.right,root.val,R);
            root.left = left;
            root.right = right;
            return root;
        }
        else if(root.val < L){
            return trimBST(root.right,L,R);
        }
        else if(root.val > R){
            return trimBST(root.left,L,R);
        }
        return root;
    }
}
