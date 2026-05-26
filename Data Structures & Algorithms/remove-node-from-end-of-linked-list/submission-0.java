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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int totalNodes = 0;
        ListNode fast = head;

        while(fast != null){
            fast = fast.next;
            totalNodes++;
        }

        int removeTheNode = totalNodes-n+1; // from the start

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while(removeTheNode > 1){
            prev = curr;
            curr = curr.next;
            removeTheNode--;
        }

        prev.next = curr.next;
        return dummy.next;
    }
}

// 1 2 3 4 5 6 7