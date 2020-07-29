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
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode smaller = new ListNode(-1);
        ListNode bigger = new ListNode(-1);

        ListNode smallerHead = smaller;
        ListNode biggerHead = bigger;

        while (head != null) {
            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                bigger.next = head;
                bigger = bigger.next;
            }
            ListNode tmp = head.next;
            head.next = null;
            head = tmp;
        }

        biggerHead = biggerHead.next;
        smaller.next = biggerHead;
        smallerHead = smallerHead.next;

        return smallerHead;
    }
}