/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next; //fast.next should not be null , fast.next.next can be null (in this condition loop will terminate).
            if (fast == slow){
                return true;
            } //This if block must come after two conditions otherwise ot will always return true 
        }
        return false;
    }
}
