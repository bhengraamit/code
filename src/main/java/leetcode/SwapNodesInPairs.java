package leetcode;

/**
 * Created by amit.bhengra on 18/10/18.
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return null;
        ListNode tempHead = null;
        if(head.next!=null && head.next.next!=null){
            tempHead = swapPairs(head.next.next);
            head.next.next = head;
            ListNode newHead = head.next;
            head.next = tempHead;
            return newHead;
        }

        if(head.next == null)
            return head;
        else{
            head.next.next = head;
            ListNode newHead = head.next;
            head.next = null;
            return newHead;
        }

    }
}
