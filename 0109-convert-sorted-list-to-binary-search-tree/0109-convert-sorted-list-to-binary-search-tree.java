
class Solution {
    public TreeNode sortedListToBST(ListNode head) {

        return helper(head, null);
    }
    public TreeNode helper(ListNode start, ListNode end){
        if(start == end ){
            return null;
        }
        ListNode mid = findMid(start, end); 
        TreeNode root = new TreeNode(mid.val);
        root.left = helper(start, mid);
        root.right = helper(mid.next, end);

        return root;
    } 
    public ListNode findMid( ListNode start, ListNode end){
        ListNode slow = start,
            fast = start;
        while(fast != end && fast.next != end){
            slow = slow.next;
            fast = fast.next.next;
            
        }
        return slow;
    }
    }
