package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by amit.bhengra on 07/10/18.
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        fillList(queue,list);
        return list;
    }
    public void fillList(LinkedList<TreeNode> queue,List<Integer> list){
        if(queue.isEmpty())
            return;
        //List<Integer> retList = new ArrayList<>();
        int size = queue.size();
        while(size > 0){
            TreeNode node = queue.pop();
            if(size==1)
                list.add(node.val);
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
            size--;
        }
        fillList(queue,list);
    }
}
