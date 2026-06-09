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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
             return head;
            }
       ListNode dummy = new ListNode(0);
       dummy.next = head;
       
       ListNode temp = dummy, prev = head, curr = head.next;

       while ( prev != null && curr != null){

        ListNode next = curr.next;
        curr.next = prev;
        prev.next = next;
        temp.next = curr;

        temp = prev;
        prev = next;
        if(next != null){
        curr = next.next;
        }}
       return dummy.next;
    }
}
