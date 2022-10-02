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
    public ListNode detectCycle(ListNode head) {
        int length = 0;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next; 
            if (fast == slow){
                ListNode temp = slow;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                break; //break after calculating length
            }
        }
        //Length done 
        //Check if cycle exist or not
        if (length != 0){
            ListNode first = head;
            ListNode second = head;
            for (int i = 0 ; i < length ; i++){
                second = second.next;
            }
            while (first != second){
                first = first.next;
                second = second.next;
            }
            return first;
        }
        return null;
    }
}
