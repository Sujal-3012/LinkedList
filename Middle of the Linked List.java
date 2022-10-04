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
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int length = 1;
        while (temp.next != null){
            temp = temp.next;
            length++;
        }
        
        //reset temp
        temp = head;
        
        for (int i = 0 ; i < length / 2; i++){
            temp = temp.next;
        }
        
        return temp;
    }
}
