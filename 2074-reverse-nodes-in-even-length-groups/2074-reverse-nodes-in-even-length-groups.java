class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {

        ListNode temp = head, p1 = head, p3 = null;
        int grp = 1;

        while (temp != null){ 
        ListNode curr =  temp;
        
        int counter = 0;
        while ( counter < grp && temp != null){
            p3 = temp;
            counter = counter + 1;
            temp = temp.next;
        }
        // check even
        if ( counter % 2 == 0 ){
        // reverse
        ListNode prev = null, p2 = curr;
            while( curr != temp ){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
                p1.next = prev;
                p2.next = curr;
                p1 = p2;  
        }else{
            p1 = p3;
        }
        grp = grp + 1;
        }
        return head;
    }
}