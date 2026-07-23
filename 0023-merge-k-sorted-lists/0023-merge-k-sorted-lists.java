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
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;
        for (int i = 0; i < lists.length - 1; i = i + 1) {
            ListNode list1 = lists[i];
            ListNode list2 = lists[i + 1];

            ListNode prevMerged = mergeTwoLists(list1, list2);
            lists[i + 1] = prevMerged;
        }
        return lists[lists.length - 1];
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);

        ListNode temp = dummy;
        ListNode p1 = list1,
                p2 = list2;

        while (p1 != null && p2 != null) {
            ListNode n1 = p1.next;
            ListNode n2 = p2.next;
            if (p1.val <= p2.val) {
                p1.next = temp.next;
                temp.next = p1;
                p1 = n1;
            } else if (p2.val < p1.val) {
                p2.next = temp.next;
                temp.next = p2;
                p2 = n2;
            }
            temp = temp.next;
        }
        while (p1 != null) {
            ListNode n1 = p1.next;
            p1.next = temp.next;
            temp.next = p1;
            p1 = n1;
            temp = temp.next;
        }
        while (p2 != null) {
            ListNode n2 = p2.next;
            p2.next = temp.next;
            temp.next = p2;
            p2 = n2;
            temp = temp.next;
        }
        return dummy.next;

    }
}