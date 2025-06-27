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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n == 1 && head.next == null)
            return null;
        int count = 0;
        ListNode temp = head;
        while(temp != null)
        {
            temp = temp.next;
            count++;
        }
        if(count == n)
        {
            return head.next;
        }
        int counter = count - n;
        temp = head;
        while(temp != null)
        {
            counter--;
            if(counter == 0)
                break;
            temp = temp.next;
        }
        ListNode delNode = temp;
        temp.next = temp.next.next;
        delNode = null;
        return head;
    }
}

----
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for(int i = 0; i < n; i++)
        {
            fast = fast.next;
        }
        //nth node from end is head;
        if(fast == null)
            return head.next;

        while(fast.next != null)
        {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode delNode = slow.next;
        slow.next = slow.next.next;
        delNode = null;
        return head;
    }
}