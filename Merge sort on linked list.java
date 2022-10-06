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
    public ListNode sortList(ListNode head) {
        if ((head == null) || (head.next==null)){
            return head;
        }
        
        ListNode mid = middleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        
        return mergeTwoLists(left , right);
        
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode temp = new ListNode(); //Creating new node , this will be null in starting 
        ListNode dummyHead = temp; //Saving the head of new list , this is dummy as our real head will be dummyHead.next at last .
        while ((node1 != null) && (node2 != null)){
            //We are directly adding nodes in ascending order 
            if (node1.val > node2.val){
                temp.next = node2;
                temp = temp.next; //It will point to null until assigned 
                node2 = node2.next;
            }else if (node1.val < node2.val){
                temp.next = node1;
                temp = temp.next; //It will point to null until assigned 
                node1 = node1.next;
            }else {
                temp.next= node1; //As they are same 
                node1 = node1.next;
                temp = temp.next; //It will point to null until assigned 
            }
        }
        
        if (node1 == null){
            //list1 ended 
            while (node2 != null){
                temp.next = node2;
                temp = temp.next; //It will point to null until assigned
                node2 = node2.next;
            }
        }
        
        if (node2 == null){
            //list2 ended
            while (node1 != null){
                temp.next = node1;
                temp = temp.next; //It will point to null until assigned
                node1 = node1.next;          
            }
        }
        
        if ((node1 == null) && (node2 == null)){
            //Both list ended 
        }
        return dummyHead.next;
    }
    
    
    public ListNode middleNode(ListNode head) {
        /*Here I have to maintain the previous of middle element also , because atlast I have to say midPrev.next = null , as I have to 
        break the two list from middle .We have done this in merge sort , in it we actually break our list in two parts and then pass it. */
        
        ListNode s = head;
        ListNode f = head;
        s = null;
        while (f != null && f.next != null){
            if (s == null){
                s = head;
            }else {
                s = s.next;
            }
            f = f.next.next;
        }
        
        /* After this while loop s will be just behind the middle element .
        Because I have started moving s after one iteration , means after one
        iteration s is pointing to head but f has moved to 3rd element , So this
        will make s point to one element behind the middle . Now you can return
        the middle element by s.next along with breaking the list in two diff
        lists by s.next = null .  */
        
        ListNode middle = s.next;
        s.next = null;
        
        return middle;
    }
}
