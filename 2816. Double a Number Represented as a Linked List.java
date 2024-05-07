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
    public ListNode doubleIt(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur!= null) {
            int val = cur.val;
            int doubleVal = val * 2;
            int carry = doubleVal / 10;
            int newVal = doubleVal % 10;
            cur.val = newVal;
            if (carry > 0) {
                if (prev == null) {
                    ListNode newNode = new ListNode(carry);
                    newNode.next = cur;
                    head = newNode;
                } else {
                    prev.val += carry;
                }
            }
            prev = cur;
            cur = cur.next;
        }
        return head;
    }
}
