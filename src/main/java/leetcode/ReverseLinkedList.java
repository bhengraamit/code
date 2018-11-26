package leetcode;

/**
 * Created by amit.bhengra on 11/09/18.
 *
 * https://leetcode.com/problems/reverse-linked-list/description/
 */
public class ReverseLinkedList {

     public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }

    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        return reverse(null,head);
    }

    public ListNode reverse(ListNode nodeToPoint, ListNode currNode){
        if(currNode == null)
            return nodeToPoint;
        ListNode temp = currNode.next;
        currNode.next = nodeToPoint;
        return reverse(currNode,temp);
    }
}
