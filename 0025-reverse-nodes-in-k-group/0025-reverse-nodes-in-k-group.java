
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = 0;
        ListNode curr = head;

        while(curr != null){
            len = len + 1;
            curr = curr.next;
        }
        int reps = len / k;
        curr = head;

        ListNode t1 = dummy, t2 = curr;

        for ( int i = 1; i <= reps; i = i + 1){
            
            int counter = 0;
            while ( counter < k ){
                counter = counter + 1;
                t2 = t2.next;
            }
            ListNode prev = t2;
            while( curr != t2 ){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
          ListNode oldHead = t1.next;
            t1.next = prev;
            t1 = oldHead;
        }
    return dummy.next;
    }
}