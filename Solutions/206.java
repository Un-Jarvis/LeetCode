/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/* Iterative */
class Solution {
    public ListNode reverseList(ListNode head) {
        // corner
        if (head == null || head.next == null) return head;

        ListNode cur = head, prev = null, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}

/* Recursive */
class Solution {
    public ListNode reverseList(ListNode head) {
        return reverseList(null, head);
    }
    
    public ListNode reverseList(ListNode prev, ListNode node) {
        if (node == null) return prev;
        
        ListNode aux = node.next;
        node.next = prev;
        
        return reverseList(node, aux);
    }
}