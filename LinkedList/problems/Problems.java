package LinkedList.problems;

import LinkedList.ListNode;

import java.util.Objects;

public class Problems {

    public static void main(String[] args) {
        System.out.println(addOneToList(ListNode.of(new int[]{1, 2, 3, 6, 9})));
    }

    /**
     * Given the head of a singly linked list, return the middle node of the linked list.
     * If there are two middle nodes, return the second middle node.
     * 1 -> 2 -> 3 -> 4 output 3
     */
    private static ListNode<Integer> findMiddle(ListNode<Integer> head) {

        ListNode<Integer> slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * Given the heads of two singly linked-lists headA and headB,
     * return the node at which the two lists intersect.
     * If the two linked lists have no intersection at all, return null
     */

    private static <T extends Number> ListNode<T> findIntersect(ListNode<T> A, ListNode<T> B) {


        ListNode<T> currA = A, currB = B;
        int lenA = 0, lenB = 0;

        while (currA != null) {
            currA = currA.next;
            lenA++;
        }
        while (currB != null) {
            currB = currB.next;
            lenB++;
        }

        currA = A;
        currB = B;

        if (lenA > lenB) {
            while (lenA > lenB) {
                currA = currA.next;
                lenA--;
            }
        } else {
            while (lenB > lenA) {
                currB = currB.next;
                lenB--;
            }
        }

        while (currA != null) {

            if (currA == currB) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }

    /**
     * Given the head of a singly linked list, reverse the list,
     * and return the reversed list.
     */
    private static <T extends Number> ListNode<T> reverse(ListNode<T> head) {

        ListNode<T> prev = null, curr = head;

        while (curr != null) {

            ListNode<T> temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    /**
     * Remove duplicate elements from sorted linked list.
     * For example,
     * if the given linked list is 1->2->2->2->5->6 then
     * the output should be 1->2->5->6.
     */
    private static <T extends Number> ListNode<T> removeDuplicates(ListNode<T> head) {

        ListNode<T> lastSorted = head;
        ListNode<T> next = head.next;

        while (next != null) {

            if (!Objects.equals(lastSorted.data, next.data)) {
                lastSorted.next = next;
                lastSorted = next;
            }
            next = next.next;
        }
        return head;
    }

    /**
     * Add 1 to a number represented as linked list.
     * For example 1999 is represented as (1-> 9-> 9 -> 9)
     * and adding 1 to it should change it to (2->0->0->0)
     */
    private static ListNode<Integer> addOneToList(ListNode<Integer> head) {
        ListNode<Integer> node = reverse(head);

        ListNode<Integer> res = node;
        ListNode<Integer> temp = null;
        int carry = 1;
        int sum;

        while(node != null) {
            sum = carry + node.data;

            carry = sum >= 10 ? 1 : 0;
            sum = sum % 10;

            node.data = sum;
            temp = node;
            node = node.next;
        }
        if(carry > 0) {
            assert temp != null;
            temp.next = new ListNode<>(carry);
        }
        return reverse(res);
    }
}
