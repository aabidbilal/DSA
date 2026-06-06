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
        if(head == null || head.next == null) return;
        ListNode temp = head;
        int counter = 0;
        while (temp != null) {
            counter = counter + 1;
            temp = temp.next;
        }
        int mid = (counter + 1) / 2;

        reverseLL(head, mid + 1, counter);

        ListNode temp1 = head, temp2 = head, x = null;
       int pos = mid + 1; 

        while (pos > 1) { 
            x = temp2;
            temp2 = temp2.next;
            pos--; 
        }
        x.next = null;
        while(temp1 != null && temp2 != null) { 

            ListNode c1 = temp1.next; 
            ListNode c2 = temp2.next; 

            temp1.next = temp2; 
            temp2.next = c1;   

            temp1 = c1;         
            temp2 = c2;         
        }

    }

    public void reverseLL(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        if (head == null || left == right)
            return;

        ListNode temp1 = dummy, prev = null;
        int i = 0;
        while (i < left - 1) {
            temp1 = temp1.next;
            i = i + 1;
        }
        ListNode temp2 = temp1.next, curr = temp1.next;

        for (int j = 1; j <= right - left + 1; j = j + 1) {
            ListNode Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        temp1.next = prev;
        temp2.next = curr;
        return;
    }
}