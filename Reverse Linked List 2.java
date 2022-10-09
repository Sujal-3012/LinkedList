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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right){
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        
        //Take 'current' to from where you have to reverse
        for (int i = 0 ; current != null && i < left - 1 ; i++){
            prev = current;
            current = current.next;
        }
        
        //Now save the 'prev' as 'last' , it will serve as your left link of the LL
        ListNode Last =  prev;
        //Now save the 'current' as 'newEnd' , it will be the last element of reversed list . 
        ListNode last =  prev;
        ListNode newEnd = current;
        
        //Now Reverese
        ListNode Next = current.next;
        for (int i = 0 ; current != null && i < (right - left) + 1 ; i++){
            current.next = prev;
            prev = current;
            current = Next;
            if (Next != null){
                Next = Next.next;
            }
        }
        if (last != null){
            last.next = prev;
        } else {
            head = prev;
        }
        newEnd.next = current;
        return head;
    }
}
    
