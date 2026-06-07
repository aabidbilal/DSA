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
    public ListNode swapNodes(ListNode head, int k) {
        if ( head == null || head.next == null) return head;

        ListNode slow = head;
        int i = 1;
        
        while (i < k ){
            slow = slow.next;
            i = i + 1;
        }
        ListNode temp1 = slow, temp2 = head;

        while (slow.next != null){
            slow = slow.next;
            temp2 = temp2.next;
        }

        int temp = temp1.val;
        temp1.val = temp2.val;
        temp2.val = temp;

        return head;

    }
}