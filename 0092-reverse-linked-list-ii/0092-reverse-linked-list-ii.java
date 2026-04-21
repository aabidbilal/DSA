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
        int len = 0;
        ListNode ll = head;
        while ( ll != null){
            len++;
            ll = ll.next;
        }
        ListNode[] arr = new ListNode[len];
        ll = head;
        int i = 0;
        while ( ll != null){
            arr[i] = ll;
            i++;
            ll = ll.next;
        }
        left--;
        right--;
        while ( left < right ){
            ListNode temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        for ( int j = 0; j < len - 1; j ++){
            arr[j].next = arr[j + 1];
        }
        arr[len - 1].next = null;
        return arr[0];
        
    }
}