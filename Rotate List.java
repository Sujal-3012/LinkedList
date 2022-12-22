/**
 * Incomplete qus
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
  public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
        int l = length(head);
        int lastNodeAt = (l - k); 
        ListNode temp = head;
        for (int i = 0 ; i < (lastNodeAt - 1); i++){
            if (temp != null && temp.next != null){
                temp = temp.next;
            }
        }
        ListNode newHead = temp.next;
        temp.next = null;
        ListNode temp2 = newHead;
        for (int i = 0 ; i < (k - 1) ; i++){
            if (temp2 != null && temp2.next != null){
                temp2 = temp2.next;
            }
        }
        temp2.next = head;
        head = newHead;
        return head;
    }

    public int length(ListNode head){
        ListNode temp = head;
        int count = 1;
        while (temp != null && temp.next != null){
            temp = temp.next;
            count++;
        }
        return count;
    }
}
