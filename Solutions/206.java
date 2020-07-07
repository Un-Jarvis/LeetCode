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
        ListNode reversed = null;
        while (head != null) {
            reversed = new ListNode(head.val, reversed);
            head = head.next;
        }
        return reversed;
    }
}

/* Recursive */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode reversed = null;
        if (head != null) {
            reversed = new ListNode(head.val, reverseList(head.next));
        }
        return reversed;
    }
}