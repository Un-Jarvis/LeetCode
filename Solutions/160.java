/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/* 
 * 笨办法：直接两个loop循环两个list
 * Time Complexity: O(nm)
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Corner case
        if (headA == null || headB == null) return null;

        // Restore headA and headB
        ListNode curA = headA, curB = headB;
        while (curA != null) {
            curB = headB;
            while (curB != null) {
                if (curA == curB) return curA;
                curB = curB.next;
            }
            curA = curA.next;
        }

        return null;
    }
}

/* 思路和上面的基本一样，但是hashset判断存在比上面的方法快 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Restore headA and headB
        ListNode curA = headA, curB = headB;

        Set<ListNode> visited = new HashSet<>();
        while (curA != null) {
            visited.add(curA);
            curA = curA.next;
        }
        
        while (curB != null) {
            if (!visited.add(curB)) return curB;
            curB = curB.next;
        }

        return null;
    }
}

/* 
 * 最优解：Two Pointers 
 * 一个指针先遍历headA再遍历headB，另一个指针先遍历headB再遍历headA，两个指针最后会在两个list的第一个相交点相遇
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Restore headA and headB
        ListNode curA = headA, curB = headB;

        while (curA != curB) {
            if (curA == null) curA = headB;
            else curA = curA.next;

            if (curB == null) curB = headA;
            else curB = curB.next;
        }
        return curA;
    }
}