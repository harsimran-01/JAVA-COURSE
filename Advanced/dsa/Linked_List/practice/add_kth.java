


class Node{
    int val;
    Node next;

    public Node(int val){
        this.val = val;
        this.next = null;
    }
}

class linked__list {
    Node head;

    // Insert at Kth position (1-based index)
    public void insertAtK(int val, int k) {
        Node newNode = new Node(val);

        if (k == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node currNode = head;
        for (int i = 1; i < k - 1 && currNode != null; i++) {
            currNode = currNode.next;
        }

        if (currNode == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        newNode.next = currNode.next;
        currNode.next = newNode;
    }

    // Method to print list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}


public class add_kth {
    public static void main(String[] args) {
        linked__list ll = new linked__list();
ll.insertAtK(10, 1);
ll.insertAtK(5, 2);
ll.printList();

    }
}
