package leetcode;

/**
 * Created by amit.bhengra on 07/10/18.
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
public class MergeTwoSortedLinkedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null &&  l2 == null)
            return null;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode head = null;
        ListNode curr = null;
        ListNode prev = null;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                curr = l1;
                l1 = l1.next;
            }
            else{
                curr = l2;
                l2 = l2.next;
            }

            if(head == null){
                head = curr;
            }
            if(prev!=null)
                prev.next = curr;
            prev = curr;
        }

        ListNode traverseNode = (l1 == null ? l2 : l1);

        while(traverseNode!=null){
            prev.next = traverseNode;
            prev = traverseNode;
            traverseNode = traverseNode.next;
        }
        return head;
    }
}
