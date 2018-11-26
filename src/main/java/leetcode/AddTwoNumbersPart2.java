package leetcode;

/**
 * Created by amit.bhengra on 18/10/18.
 *
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 *
 * Without reversing the list
 *
 * Using Stack is much simpler solution
 */
public class AddTwoNumbersPart2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        int l1Len = findLength(l1);
        int l2Len = findLength(l2);
        if(l1Len == l2Len){
            SumNode sumNode = calSum(l1,l2);
            if(sumNode.carry !=0){
                ListNode node = new ListNode(sumNode.carry);
                node.next = sumNode.root;
                return node;
            }
            return sumNode.root;
        }
        ListNode firstNode = null;
        ListNode secondNode = null;
        ListNode lengthyNodeStart = null;
        int diff = 0;
        if(l1Len > l2Len){
            firstNode = l1;
            secondNode = l2;
            lengthyNodeStart = findStartNode(firstNode,l1Len-l2Len);
            diff = l1Len-l2Len;
        }
        else{
            firstNode = l2;
            secondNode = l1;
            lengthyNodeStart = findStartNode(firstNode,l2Len-l1Len);
            diff = l2Len-l1Len;
        }
        SumNode sumNode = calSum(lengthyNodeStart,secondNode);
        ListNode retNode = merge(firstNode,sumNode,diff-1);
        return retNode;
    }

    public ListNode merge(ListNode node, SumNode tailNode, int diff){
        SumNode sumNode = getList(node,tailNode.carry,diff,tailNode.root);
        if(sumNode.carry!=0){
            ListNode root = new ListNode(sumNode.carry);
            root.next = sumNode.root;
            return root;
        }
        return sumNode.root;
    }

    public SumNode getList(ListNode node, int carry, int diff, ListNode tailNode){
        if(diff == 0){
            int sum = node.val + carry;
            ListNode root = new ListNode(sum%10);
            root.next = tailNode;
            SumNode sumNode = new SumNode();
            sumNode.root = root;
            sumNode.carry = sum/10;
            return sumNode;
        }else{
            SumNode sumNode = getList(node.next,carry,diff-1,tailNode);
            int sum = node.val + sumNode.carry;
            ListNode root = new ListNode(sum%10);
            SumNode newNode = new SumNode();
            root.next = sumNode.root;
            newNode.root = root;
            newNode.carry = sum/10;
            return newNode;
        }
    }

    public ListNode findStartNode(ListNode node, int diff){
        while(diff-- > 0){
            node = node.next;
        }
        return node;
    }

    public int findLength(ListNode node){
        int count =0;
        while(node!=null){
            count++;
            node = node.next;
        }
        return count;
    }


    public SumNode calSum(ListNode n1, ListNode n2){
        if(n1.next == null){
            SumNode node = new SumNode();
            int sum = n1.val + n2.val;
            ListNode root = new ListNode(sum%10);
            node.root = root;
            node.carry = sum/10;
            return node;
        }else{
            SumNode node = calSum(n1.next,n2.next);
            int sum = n1.val + n2.val +  node.carry;
            SumNode newNode = new SumNode();
            ListNode root = new ListNode(sum%10);
            root.next = node.root;
            newNode.root = root;
            newNode.carry = sum/10;
            return newNode;
        }
    }

    public class SumNode{
        ListNode root;
        int carry;
    }
}
