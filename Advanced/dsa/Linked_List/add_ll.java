


class Node {

    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }

}

class linked_list {

    int size;

    linked_list() {
        this.size = 0;
    }

// Add at FIRST
    Node head;

    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        size++;
    }

    // Add at Last
    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        size++;

    }

    //delete first
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        head = head.next;
        size--;
    }

    //delete last
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            size--;
            return;
        }

        Node secondlast = head;
        Node lastNode = head.next;

        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondlast = secondlast.next;
        }

        secondlast.next = null;
        size--;

    }

    //print function
    public void display_nodes() {

        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println(" null");

    }

    public int sizedisplay() {
        return size;
    }

    public void reverse_iterate() {

        if (head == null || head.next == null) {
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;
        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }

    public Node recursiveIterate(Node head){
        if(head == null || head.next ==null){
            return head;
        }
        Node newHead = recursiveIterate(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}

public class add_ll {

    public static void main(String[] args) {

        linked_list ll = new linked_list();

        System.out.println("Printing of list");
        ll.addFirst("World");

        ll.addFirst("Hello");
        ll.addLast("Simmi");

        ll.addLast("!");

        System.out.println("Before deletion");

        ll.display_nodes();

        ll.deleteFirst();
        System.out.println("After deletion at First");
        ll.display_nodes();

        System.out.println("After deletion at Last");
        ll.deleteLast();
        ll.display_nodes();
        System.out.println("Size of linked list: " + ll.sizedisplay());

        ll.display_nodes();

        // System.out.println("Reversing A list using Iteration");
        // ll.reverse_iterate();

        // ll.display_nodes();

        System.out.println("Reversing a list using Recursion");
        ll.head = ll.recursiveIterate(ll.head);
        ll.display_nodes();




    }

}
