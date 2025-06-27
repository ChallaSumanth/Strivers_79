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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode temp = head;
        ListNode temp1 = head.next;
        while(temp.next != null && temp.next.next != null)
        {
            ListNode odd = temp;
            ListNode even = temp.next;
            temp = odd.next.next;
            odd.next = null;
            odd.next = temp;
            even.next = null;
            even.next = temp.next;
        }

         temp.next = temp1;
    return head;
    }
   
}