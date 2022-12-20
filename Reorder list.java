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
    public void reorderList(ListNode head) {
        //Base condition 
        if (head == null || head.next == null){
            return;
        }
        ListNode m = middleNode(head);
        ListNode headSecond = reverseList(m);
        ListNode headFirst = head;

        while (headFirst != null && headSecond != null){
        ListNode temp = headFirst.next;
        headFirst.next = headSecond;
        headFirst = temp;

        temp = headSecond.next;
        headSecond.next = headFirst;
        headSecond = temp;
        }

        //To avoid formation of cycle 
        if (headFirst != null){
            headFirst.next = null;
        }
        
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

    public ListNode reverseList(ListNode head) {
        //Reverse fn returns the head of the reversed LL
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
