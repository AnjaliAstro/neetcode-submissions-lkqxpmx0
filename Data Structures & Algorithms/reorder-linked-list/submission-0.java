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
        if(head.next == null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        head2 = reverse(head2);

        ListNode mergedHead = merge(head, head2);
        return;
    }

    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private ListNode merge(ListNode head1, ListNode head2){
        ListNode head = head1;
        while(head1 != null && head2 != null){
            ListNode temp1 = head1.next;
            head1.next = head2;
            ListNode temp2 = head2.next;
            head2.next = temp1;
            head1 = temp1;
            head2 = temp2;
        }
        return head;
    }
}

//2 10 4 8 6

// 2 4 6 
// 8 10

// 10 8 

// 2->10->4->8->6

//  8 10 11
// 