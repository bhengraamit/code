package leetcode;

/**
 * Created by amit.bhengra on 09/09/18.
 */
public class FlattenBinaryTreeToLinkedList {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode5;

        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        treeNode5.right =treeNode6;

        FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();
        flattenBinaryTreeToLinkedList.flatten(treeNode1);
    }

    public class LinkedList{
        TreeNode head;
        TreeNode tail;
    }

    public void flatten(TreeNode root) {
        if(root == null)
            return;
        LinkedList linkedList = getLinked(root);
        return;
        //return linkedlist.head;
    }

    public LinkedList getLinked(TreeNode root){
        if(root == null)
            return null;
        LinkedList rootList = new LinkedList();
        rootList.head = root;
        rootList.tail = root;

        LinkedList leftChildLinked = null;
        LinkedList rightChildLinked = null;
        if(root.left!=null){
            leftChildLinked = getLinked(root.left);
            root.left = null;
            //rootList.tail = leftChildLinked.head;
        }
        if(root.right!=null){
            rightChildLinked = getLinked(root.right);
            root.right = null;
        }
        if(leftChildLinked!=null){
            rootList.tail.right = leftChildLinked.head;
            rootList.tail = leftChildLinked.tail;
            if(rightChildLinked!=null) {
                leftChildLinked.tail.right = rightChildLinked.head;
                rootList.tail = rightChildLinked.tail;
            }
        }else{
            if(rightChildLinked!=null) {
                rootList.tail.right = rightChildLinked.head;
                rootList.tail = rightChildLinked.tail;
            }
        }
        return rootList;
    }
}
