package leetcode;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by amit.bhengra on 07/10/18.
 * https://leetcode.com/contest/weekly-contest-105/problems/complete-binary-tree-inserter/
 */
public class CompleteBinaryTreeInserter {


    List<TreeNode> nodeList = new ArrayList<>();
    int currentSize;

    public CompleteBinaryTreeInserter(TreeNode root) {
        insertToList(root);
        currentSize = nodeList.size();
    }

    private void insertToList(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        doBFS(linkedList);
    }

    private void doBFS(LinkedList<TreeNode> linkedList) {
        if(linkedList.isEmpty())
            return;
        int size = linkedList.size();
        while(size > 0 && !linkedList.isEmpty()){
            TreeNode poll = linkedList.poll();
            nodeList.add(poll);
            if(poll.left!=null)
                linkedList.add(poll.left);
            if(poll.right!=null)
                linkedList.add(poll.right);
            size--;
        }
        doBFS(linkedList);
    }

    public int insert(int v) {

        TreeNode parent = nodeList.get((currentSize - 1)/2);
        TreeNode newNode = new TreeNode(v);
        if (currentSize % 2 == 0){
            parent.right = newNode;
        }else{
            parent.left = newNode;
        }
        nodeList.add(newNode);
        currentSize++;
        return parent.val;
    }

    public TreeNode get_root() {
        return nodeList.get(0);
    }


}
