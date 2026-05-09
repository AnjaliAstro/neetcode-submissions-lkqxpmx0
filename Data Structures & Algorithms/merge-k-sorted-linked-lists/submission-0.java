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
        PriorityQueue<Pair<ListNode, Integer>> pq = new PriorityQueue<>((a,b)->a.getKey().val-b.getKey().val);

        for(int i=0; i<lists.length; i++){
            ListNode node = lists[i];
            pq.add(new Pair<>(node, i));
        }

        ListNode root = new ListNode(-1);
        ListNode itr = root;
        while(!pq.isEmpty()){
            Pair<ListNode, Integer> curr = pq.poll();
            ListNode currNode = curr.getKey();
            int pos = curr.getValue();

            if(currNode.next != null){
                pq.add(new Pair<>(currNode.next, pos));
            }
            itr.next = new ListNode(currNode.val);
            itr = itr.next;
        }

        return root.next;
    }
}
