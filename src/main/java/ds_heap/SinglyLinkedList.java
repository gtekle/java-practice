package ds_heap;

public class SinglyLinkedList {
    private ListNode head;

    public SinglyLinkedList() {
        this.head = null;
    }

    private static class ListNode {
        private int data;
        private ListNode nextNode;

        public ListNode(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public ListNode getNextNode() {
            return nextNode;
        }

        public void setNextNode(ListNode nextNode) {
            this.nextNode = nextNode;
        }
    }

    private void add(int data) {
        ListNode newNode = new ListNode(data);
        if (this.head == null) {
            this.head = newNode;
            return;
        }

        ListNode currentNode = this.head;

        while (currentNode != null) {
            ListNode next = currentNode.getNextNode();
            if (next == null) {
                currentNode.setNextNode(newNode);
            }
            currentNode = next;
            System.out.println("end of while..." + next);
        }
    }

    private void reverseList() {
        if (this.head == null) {
            System.out.println("The LinkedList is empty!");
            return;
        }

        ListNode prevNode = null;
        ListNode currentNode = this.head;

        while (currentNode != null) {
            ListNode next = currentNode.getNextNode();
            if (next == null) {
                this.head = currentNode;
            }

            currentNode.setNextNode(prevNode);
            prevNode = currentNode;
            currentNode = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode currentNode = this.head;
        while (currentNode != null) {
            sb.append(currentNode.data).append(", ");
            currentNode = currentNode.getNextNode();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList ll = new SinglyLinkedList();
        ll.add(3);
        ll.add(5);
        ll.add(4);
        ll.add(6);
        ll.add(7);
        System.out.println(ll);
        ll.reverseList();
        System.out.println(ll);
    }
}
