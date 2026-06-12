class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = head;
        int x = 0;
        while ( temp != null ){
            x++;
            temp = temp.next;
        }
         k = k%x; 

        for (int i = 0; i < k; i++) {

            ListNode curr = dummy.next;
            ListNode prev = null;

            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }

            prev.next = null;
            curr.next = dummy.next;
            dummy.next = curr;
        }

        return dummy.next;
    }
}