package practice.algorithm;



/*
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LinkAdd {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return addTwoNumbers(l1, l2, 0);
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2, int bit) {
		if (l1 == null && l2 == null) {
			if (bit == 1) {
				return new ListNode(bit);
			}else {
				return null;
			}
		}
		ListNode next1 = null, next2 = null;
		int sum = bit;
		if (l1 != null) {
			sum += l1.val;
			next1 = l1.next;
		}
		if (l2 != null) {
			sum += l2.val;
			next2 = l2.next;
		}
		ListNode sumNode = new ListNode(sum%10);
		sumNode.next = addTwoNumbers(next1, next2, sum/10);
		return sumNode;
	}
}

class ListNode{
	int val;
	ListNode next;
	public ListNode(int x) {
		this.val = x;
	}
}
