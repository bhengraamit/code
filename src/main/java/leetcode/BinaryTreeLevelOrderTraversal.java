package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by amit.bhengra on 07/10/18.
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        fillList(queue,list);
        return list;
    }
    public void fillList(LinkedList<TreeNode> queue,List<List<Integer>> list){
        if(queue.isEmpty())
            return;
        List<Integer> retList = new ArrayList<>();
        int size = queue.size();
        while(size > 0){
            TreeNode node = queue.pop();
            retList.add(node.val);
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
            size--;
        }
        list.add(retList);
        fillList(queue,list);
    }
}
