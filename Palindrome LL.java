**
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
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        //Reverse the second half(i.e. from middle till last)
        //Reverse fn returns the head of the reversed LL
        ListNode secondHead = reverseList(mid);
        //we need to save this head because we need to re reverse the 2nd half.
        ListNode reReversehead = secondHead;
        
        while (head != null && secondHead != null){
            if (head.val != secondHead.val){
                break;
            }
            head = head.next;
            secondHead = secondHead.next;
        }
        //LL is palindrome if the loop has not broken , implies any one of them has became null
        if (head == null || secondHead == null){
            return true;
        }
        mid = reverseList(reReversehead); //Rereversing 
        return false;
    }
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
