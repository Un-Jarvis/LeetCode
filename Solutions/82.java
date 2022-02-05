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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        // Remove heading duplicates
        while (head != null && head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            head = head.next;
        }

        if (head == null || head.next == null) return head;
            
        // Remove duplicates
        ListNode prev = new ListNode();
        ListNode curr = head;
        prev.next = curr;
        
        while (curr.next != null) {
            if (curr.val != curr.next.val) {
                prev = prev.next;
                curr = curr.next;
            } else {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                if (curr.next != null) {
                    curr = curr.next;
                    prev.next = curr;
                } else {
                    prev.next = null;
                }
            }
        }
        
        return head;
    }
}

class Solution {    
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = new ListNode(-110, head);
        head = prev;
        while (prev != null) {
            ListNode cur = prev.next;
            while (cur != null && cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (prev.next == cur && (cur == null || prev.val != cur.val)) {
                prev.next = cur;
                prev = prev.next;
            } else {
                prev.next = cur.next;
            }
        }
        
        return head.next;
    }
}