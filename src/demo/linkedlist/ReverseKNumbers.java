package demo.linkedlist;

/**
 * @auther
 */

public class ReverseKNumbers {

    class ListNode<T> {
        ListNode(T x) {
            value = x;
        }
        T value;
        ListNode<T> next;
    }

    ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
        if (l == null || l.next ==null || k == 1) return l;
        int count = countNodes(l);
        int i = 1;
        ListNode last = new ListNode(0);
        ListNode res = last;
        ListNode curr = l;
        while (i++ <= count/k) {
            ListNode prev = null;
            ListNode node = curr;
            int j = 1;
            while (j++ <= k) {
                ListNode next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }
            last.next = prev;
            last = curr;
            curr = node;
        }
        last.next = curr;
        return res.next;
    }

    private int countNodes(ListNode l) {
        int count = 0;
        ListNode curr = l;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    private ListNode reverseNodes(ListNode node, int k, ListNode prev) {
        ListNode curr = node;
        int n =1;
        while (n++ <= k) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return curr;
    }

    private ListNode<Integer> getLinkedList(int x) {
        return new ListNode<Integer>(x);
    }

    public static void main(String[] args) {
        ReverseKNumbers r = new ReverseKNumbers();
        ListNode<Integer> node = r.getLinkedList(1);
        node.next = r.getLinkedList(2);
        node.next.next = r.getLinkedList(3);
        node.next.next.next = r.getLinkedList(4);
        node.next.next.next.next = r.getLinkedList(5);

        ListNode res = r.reverseNodesInKGroups(node, 2);
        System.out.println(res);

    }
}
