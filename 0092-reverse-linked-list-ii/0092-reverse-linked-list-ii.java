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
        if ( head == null || left == right )return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode temp1 = dummy, prev = null;
        int i = 0;
        while( i < left - 1){
            temp1 = temp1.next;
            i = i + 1;
        }
        ListNode temp2 = temp1.next, curr = temp1.next;

        for (int j = 1; j <= right - left + 1; j = j + 1){
            ListNode Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        temp1.next = prev;
        temp2.next = curr;
        return dummy.next;
    }
}