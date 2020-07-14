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
/* 1. 先找中间值 2. 分成两段 3. 重新组合排序 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;

        // 找到链表中间值
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 分成前后两段链表
        ListNode list1 = head, list2 = slow.next;
        slow.next = null;

        // Reverse list2
        list2 = reverseList(list2);

        // Pair merge
        while (list1 != null && list2 != null) {
            ListNode tmp1 = list1.next;
            ListNode tmp2 = list2.next;
            list1.next = list2;
            list2.next = tmp1;
            
            list1 = tmp1;
            list2 = tmp2;
        }
    }

    public ListNode reverseList(ListNode head) {
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

/* 超时解 */
class Solution {
    public void reorderList(ListNode head) {
        while (head != null && head.next != null) {
            ListNode last = getLast(head);
            ListNode tmp = head.next;
            head.next = last;
            last.next = tmp;
            head = tmp;
        }
    }

    public ListNode getLast(ListNode head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
}