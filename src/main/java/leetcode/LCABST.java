package leetcode;

/**
 * Created by amit.bhengra on 18/10/18.
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 */
public class LCABST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root.val == p.val || root.val == q.val ){
            return root;
        }
        else {
            boolean bothLess = (p.val < root.val && q.val < root.val);
            boolean bothMore = (p.val > root.val && q.val > root.val);
            if(bothLess)
                return lowestCommonAncestor(root.left,p,q);
            if(bothMore)
                return lowestCommonAncestor(root.right,p,q);
            return root;
        }
    }
}
