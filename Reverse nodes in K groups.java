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
    public ListNode reverseKGroup(ListNode head, int k) {
        int l = length(head);
        if (k > l || k == 1){
            return head;
        }
        if (k==l){
            return reverseList(head);
        }
        return reverseGroup(head , k);

    }
    public ListNode reverseGroup(ListNode head , int k){
        if (k == 1 || k > length(head) || head.next == null){
            //if head.next = null -> only one element is left ->return
            return head;
        }
        ListNode temp = head;
        for (int i = 0 ; i < k-1 ; i++){
            temp = temp.next;
        }
        ListNode temp2 = temp.next;
        temp.next = null;
        ListNode revHead = reverseList(head);
        ListNode temp3 = revHead;
        for (int i = 0 ; i < k-1 ; i++){
            temp3 = temp3.next;
        }
        temp3.next = reverseGroup(temp2 , k);
        return revHead;
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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
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
