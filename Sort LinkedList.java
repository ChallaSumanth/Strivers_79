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
    public ListNode sortList(ListNode head) {
        if(head == null)
            return null;
        List<Integer> lst = new ArrayList<>();
        ListNode temp = head;
        while(temp != null)
        {
            lst.add(temp.val);
            temp = temp.next;
        }
        Collections.sort(lst);
        temp = head;
        for(int i = 0 ; i < lst.size(); i++)
        {
            temp.val = lst.get(i);
            temp = temp.next;
        }
        return head;
    }
}

---------
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
    public ListNode sortList(ListNode head) {
           return sortLst(head);
    }
    private ListNode merge(ListNode left, ListNode right)
    {
        ListNode dummy = new ListNode(1);
        ListNode temp = dummy;
        while(left != null && right != null)
        {
            if(left.val <=  right.val)
            {
                temp.next = left;
                left = left.next;
            }
            else
            {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

       if(left != null)
        temp.next = left;
       else
        temp.next = right;

        return dummy.next;
    }
    private ListNode sortLst(ListNode head)
    {
        if(head == null || head.next == null)
            return head;
        ListNode middle = findMiddleNode(head);
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head;

        left = sortLst(left);
        right = sortLst(right);
        return merge(left, right);
    }
    private ListNode findMiddleNode(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}