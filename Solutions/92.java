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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode curr = null;
        dummy.next = head;
        
        for (int i = 0 ; i < m - 1 ; i++) {
            prev = prev.next;
        }
        
        curr = prev.next;
        
        while (m < n) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
            m++;
        }
        
        return dummy.next;  
    }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) return head;

        ListNode reverseBetween = head;
        ListNode front = null;
        ListNode reverse = null;
        ListNode end = null;

        int pos = 1;
        while (head != null) {
            if (pos == m - 1) {
                front = head;
                head = head.next;
                front.next = null;
            } else {
                if (pos == m) {
                    reverse = head;
                } else if (pos == n) {
                    end = head.next;
                    head.next = null;
                }
                head = head.next;
            }
            pos++;
        }
        reverse = reverseList(reverse);
        if (front != null) front.next = reverse;
        else reverseBetween = reverse;

        while (reverse.next != null) {
            reverse = reverse.next;
        }
        reverse.next = end;

        return reverseBetween;
    }

    public ListNode reverseList(ListNode head) {
        ListNode reversed = null;
        while (head != null) {
            reversed = new ListNode(head.val, reversed);
            head = head.next;
        }
        return reversed;
    }
}