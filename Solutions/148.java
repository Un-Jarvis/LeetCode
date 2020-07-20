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

/* Merge Sort: Time Complexity: O(nlogn) */
/* 参考 https://www.geeksforgeeks.org/merge-sort/ */
class Solution {
    public ListNode sortList(ListNode head) {
        // Corner case
        if (head == null || head.next == null) return head;
        if (head.next.next == null) {
            if (head.next.val < head.val) {
                ListNode tmp = head;
                head = head.next;
                head.next = tmp;
                tmp.next = null;
            }
            return head;
        }

        // Find mid point
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Divide the list in two halves
        ListNode left = head, right = slow.next;
        slow.next = null;

        // Sort two halves
        if (left != null) left = sortList(left);
        if (right != null) right = sortList(right);

        // Merge two sorted halves
        head = new ListNode(-1);
        ListNode headCopy = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }
        if (left != null) head.next = left;
        if (right != null) head.next = right;
        head = headCopy.next;

        return head;
    }
}