package leetcode;

/**
 * Created by amit.bhengra on 26/08/18.
 * https://leetcode.com/problems/reorder-list/description/
 */
public class ReorderList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode mid = findMidList(head);
        ListNode reverseFromMid = reverseList(mid.next,null); // reversing from mid's Next
        ListNode mergedList = mergeList(head,mid,reverseFromMid);
    }

    public ListNode mergeList(ListNode head, ListNode mid, ListNode reverseMid){
        if(head == null)
            return reverseMid;
        if(reverseMid == null)
            return head;
        ListNode origHead = head;
        ListNode reverseNext = reverseMid.next;
        ListNode headNext = head.next;
        while(head!=mid){
            head.next = reverseMid;
            reverseMid.next = headNext;
            head = headNext;
            if(headNext!=null)
                headNext = headNext.next;

            reverseMid = reverseNext;
            if(reverseNext!=null)
                reverseNext = reverseNext.next;
        }

        //last node merge
        if(head!=null)
            head.next = reverseMid;
        return origHead;
    }

    public ListNode reverseList(ListNode mid, ListNode toPoint){
        if(mid == null)
            return mid;
        if(mid.next == null){
            mid.next = toPoint;
            return mid;
        }
        if(mid.next != null){
            ListNode nextNode = mid.next;
            mid.next = toPoint;
            return reverseList(nextNode,mid);
        }
        return null;
    }

    public ListNode findMidList(ListNode head){
        ListNode slowHead = head;
        ListNode previousSlowHead = null;
        ListNode fastHead = head.next; // have ensured only list two elements come here
        while(true){
            previousSlowHead = slowHead;
            slowHead = slowHead.next;
            if(fastHead.next == null)
                return previousSlowHead;
            if(fastHead.next.next == null)
                return slowHead;
            fastHead = fastHead.next.next;
        }
    }
}
