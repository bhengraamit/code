package leetcode;

/**
 * Created by amit.bhengra on 06/10/18.
 *
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 */
public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return new TreeNode(head.val);
        if(head.next.next == null){
            TreeNode root = new TreeNode(head.next.val);
            TreeNode left = new TreeNode(head.val);
            root.left = left;
        }

        ListNode beforeMid = findBeforeMid(head);
        ListNode mid = beforeMid.next;
        beforeMid.next = null;
        ListNode afterMid = mid.next;
        mid.next = null;
        TreeNode root = new TreeNode(mid.val);
        TreeNode left = sortedListToBST(head);
        TreeNode right = sortedListToBST(afterMid);
        root.left = left;
        root.right = right;
        return root;
    }

    public ListNode findBeforeMid(ListNode node){
        ListNode slowNode = node;
        ListNode fastNode = node.next;
        ListNode prevNode = slowNode;
        while(fastNode.next!=null && fastNode.next.next!=null){
            fastNode = fastNode.next.next;
            prevNode = slowNode;
            slowNode = slowNode.next;
        }
        if(fastNode.next == null){      // even nodes
            return prevNode;
        }else{
            return slowNode;
        }
    }
}
