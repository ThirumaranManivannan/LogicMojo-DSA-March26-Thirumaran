package LinkedList;

public class ListNode<T> {

    public T data;
    public ListNode<T> next;

    private ListNode<T> tail;

    public ListNode() {

    }
    public ListNode(T data) {
        this.data = data;
        this.tail = this;
    }

    public void add(T data) {
        if(this.tail == null) {
            this.tail = this;
        }
        this.tail.next = new ListNode<>(data);
        this.tail = this.tail.next;
    }

    public static ListNode<Integer> of(int[] values) {
        var list = new ListNode<>(values[0]);
        for(int i = 1; i < values.length; i++) {
            list.add(values[i]);
        }
        return list;
    }

    public String toString() {

        var head = this;

        var sb = new StringBuilder();
        sb.append("(");

        while (head != null) {
            sb.append(head.data);
            sb.append(head.next == null ? ")" : ")-->(");
            head = head.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        var node = new ListNode<>(1);
        node.add(2);
        node.add(3);

        System.out.println(node);
        var node2 = ListNode.of(new int[]{1, 3,5});
        System.out.println(node2);
    }
}
