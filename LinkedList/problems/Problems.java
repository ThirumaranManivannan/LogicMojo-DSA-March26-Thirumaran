package LinkedList.problems;

import LinkedList.ListNode;

public class Problems {

    public static void main(String[] args) {
        System.out.println(findMiddle(ListNode.of(new int[]{1, 2, 3, 6, 4})).data);
    }

    /**
     * Given the head of a singly linked list, return the middle node of the linked list.
     * If there are two middle nodes, return the second middle node.
     * 1 -> 2 -> 3 -> 4 output 3
     */
    private static ListNode<Integer> findMiddle(ListNode<Integer> head) {

        ListNode<Integer> slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
