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

 public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode removeNodes(ListNode head) {
         if (head == null || head.next == null) {
            return head; // No need to process if there are 0 or 1 nodes
        }

        head = reverse(head); // Reverse the linked list

        ListNode dummy = new ListNode(0); // Dummy node to handle cases where the head needs to be removed
        dummy.next = head;
        ListNode current = dummy;
        ListNode maxNode = null;
        int max = Integer.MIN_VALUE;

        while (current.next != null) {
            if (current.next.val < max) {
                // Remove the current node
                current.next = current.next.next;
            } else {
                // Update the maximum value encountered so far
                max = current.next.val;
                maxNode = current.next;
                current = current.next;
            }
        }

        head = reverse(dummy.next); // Reverse the linked list again to get the original order
        return head;
    }
}
