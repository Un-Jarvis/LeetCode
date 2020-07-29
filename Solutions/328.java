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

/* 简单点的解法，不需要index判断奇偶 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode even = head;
        ListNode odd = head.next;

        ListNode evenHead = even;
        ListNode oddHead = odd;

        while (even.next != null && odd.next != null) {
            even.next = even.next.next;
            even = even.next;

            odd.next = odd.next.next;
            odd = odd.next;
        }

        even.next = oddHead;

        return head;
    }
}

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode even = new ListNode(-1);
        ListNode odd = new ListNode(-1);

        ListNode evenHead = even;
        ListNode oddHead = odd;

        int index = 0;
        while (head != null) {
            if (index % 2 == 0) {
                even.next = head;
                even = even.next;
            } else {
                odd.next = head;
                odd = odd.next;
            }

            ListNode tmp = head.next;
            head.next = null;
            head = tmp;

            index++;
        }

        evenHead = evenHead.next;
        oddHead = oddHead.next;
        even.next = oddHead;

        return evenHead;
    }
}