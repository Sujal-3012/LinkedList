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
        ListNode temp = head;
        int size = 1;
        while (temp.next != null){
            temp = temp.next;
            size++;
        }
        
        //If only one element is there 
        if (head.next == null){
            head = null;
            return head;
        }
        
        //If n = size
        if (n == size){
            head = head.next;
            return head;
        }
        
        //Reset pointers -
        temp = head;
        ListNode temp2 = temp;
        
        
        //one just behind and one just after.
        for(int i = 1 ; i< size - n ; i++){
            temp = temp.next;
        }
        
        for (int j = 1; j <= size - n + 1; j++){
            temp2 = temp2.next;
        }
        
        temp.next = temp2;
        return head;
    }
}
