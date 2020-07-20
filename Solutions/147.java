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

 /* Insertion Sort: Time Complexity: O(n^2) */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val < cur.val) {
                ListNode removed = cur.next;
                cur.next = removed.next;
                removed.next = null;
                head = insert(head, removed);
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    private ListNode insert(ListNode head, ListNode toBeAdded) {
        ListNode headCopy = head;

        if (toBeAdded.val < headCopy.val) {
            toBeAdded.next = headCopy;
            head = toBeAdded;
        } else {
            while (toBeAdded.val > headCopy.next.val) {
                headCopy = headCopy.next;
            }
            toBeAdded.next = headCopy.next;
            headCopy.next = toBeAdded;
        }

        return head;
    }
}