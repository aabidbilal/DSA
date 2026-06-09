
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        ListNode curr = head;
        int len = 0;

        while (curr != null){
            len = len + 1;
            curr = curr.next;
        }

        int reqNum = len / k,
            remNum = len % k;
        
        ListNode[] arr = new ListNode[k];
        curr = head;

        for( int i = 0; i < k; i = i + 1){
            ListNode temp = curr;
            int count = reqNum;
            if(remNum > 0 ){
                count = count + 1;
                remNum = remNum - 1;
            }
            int counter = 0;
            ListNode prev = null;
            while (counter < count){
               prev = curr;
               curr = curr.next;
               counter = counter + 1; 
            }
            if( prev != null){
                prev.next = null;
            }
            arr[i] = temp;
        }
        return arr;
    }
}