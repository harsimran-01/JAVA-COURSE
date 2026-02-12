public class queue_ll {
    static class Node {
        int data;
        Node next = null;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class queue_class {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty() {
            return tail == null && head == null;
        }

        public static void add(int data) {
            Node newNode = new Node(data);
            if (tail == null) {
                tail = head = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int front = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return front;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        // Correct usage: use queue_class directly
        queue_class.add(1);
        queue_class.add(2);
        queue_class.add(3);
        queue_class.add(4);
        queue_class.add(5);

        System.out.println("Removed element " + queue_class.remove());

        queue_class.add(6);
        System.out.println("Removed element " + queue_class.remove());
        queue_class.add(7);

        while (!queue_class.isEmpty()) {
            System.out.println(queue_class.peek());
            queue_class.remove();
        }
    }
}
