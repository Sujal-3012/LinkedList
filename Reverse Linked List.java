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
  //Three pointer method - previous , present and Next .
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode prev = null;
        ListNode pres = head;
        ListNode Next = pres.next;

        while (pres != null){
            pres.next = prev;
            prev = pres;
            pres = Next;
            if (Next != null){
                Next = Next.next;
            }
        }
        head = prev;
        return head;
    }
}
