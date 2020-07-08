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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode swap = head.next;        
        ListNode tail = head;
        while (head != null && head.next != null) {
            // first points to the first node
            ListNode first = head;
            // second points to the second node
            ListNode second = head.next;
            // head points to the rest nodes
            head = second.next;

            // swap first and second
            tail.next = second;
            second.next = first;
            first.next = head;
            
            // update new tail
            tail = first;
        }

        return swap;
    }
}

/* Recursive */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode temp = head; 
        head = head.next; 
        temp.next = head.next; 
        head.next = temp; 
        head.next.next = swapPairs(head.next.next);
        return head;
    }
}