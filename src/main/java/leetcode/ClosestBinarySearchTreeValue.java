package leetcode;

/**
 * Created by amit.bhengra on 19/10/18.
 *
 * https://leetcode.com/problems/closest-binary-search-tree-value/description/
 */
public class ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        if(root == null)
            return 0;

        double minDiff = Double.MAX_VALUE;
        int retVal = root.val;
        while(root!=null){
            if(root.val == target)
                return root.val;
            if(root.val > target){
                if(((double)root.val - target) < minDiff){
                    retVal = root.val;
                    minDiff = (double)root.val - target;
                }
                root = root.left;
            }
            else{
                if((target-(double)root.val) < minDiff){
                    retVal = root.val;
                    minDiff = target-(double)root.val;
                }
                root = root.right;
            }
        }
        return retVal;
    }
}
