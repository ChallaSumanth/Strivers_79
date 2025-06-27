Brute force 

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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;

        while(temp1 != null)
        {
             ListNode temp2 = headB;
             while(temp2 != null)
             {
                if(temp1 == temp2)
                    return temp1;
                temp2 = temp2.next;
             }
             temp1 = temp1.next;
        }
        return null;
    }
}

---------

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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode Node1 = headA;
        ListNode Node2 = headB;

        while(Node1 != Node2)
        {
            Node1 = Node1 == null ? headB : Node1.next;
            Node2 = Node2 == null ? headA : Node2.next;
        }
        return Node1;
    }
}