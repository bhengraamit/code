package leetcode;

/**
 * Created by amit.bhengra on 26/08/18.
 *
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/description/
 */
public class BST2DLinkedList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    class DoublyList{
        Node head;
        Node tail;
        public DoublyList(Node head, Node tail)
        {
            this.head = head;
            this.tail = tail;
        }
    }
    public Node treeToDoublyList(Node root) {
        DoublyList list = createDoublyList(root);
        if(list == null)
            return null;
        list.head.left = list.tail;
        list.tail.right = list.head;
        return list.head;
    }

    public DoublyList createDoublyList(Node node){
        if(node == null)
            return null;
        Node head = null;
        Node tail = null;
        DoublyList leftList = null;
        DoublyList rightList = null;
        if(node.left!=null)
            leftList = createDoublyList(node.left);
        if(node.right!=null)
            rightList= createDoublyList(node.right);

        if(leftList!=null){
            head = leftList.head;
            leftList.tail.right = node;
            node.left = leftList.tail;
        }else{
            head = node;
        }

        if(rightList!=null){
            node.right = rightList.head;
            rightList.head.left = node;
            tail = rightList.tail;
        }else{
            tail = node;
        }

        return new DoublyList(head,tail);
    }
}
