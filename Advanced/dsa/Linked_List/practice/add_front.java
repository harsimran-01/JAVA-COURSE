
class Node {

    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class linkedlist {

    Node head;

    public void insertFirst(int val) {
        System.out.println("Inserting " + val);
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public int getValue() {
        if (head == null) {
            return -1;
        } else {
            return head.val;
        }
    }
}

public class add_front {

    public static void main(String[] args) {
        linkedlist ll = new linkedlist();
        ll.insertFirst(10);
        System.out.println(ll.getValue()+" is inserted at Beginning ");
        ll.insertFirst(11);
        System.out.println(ll.getValue()+" is inserted at Beginning ");

    }
}
