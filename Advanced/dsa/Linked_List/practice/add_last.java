class Node{

    int val;
    Node next;

    public Node(int val){
        this.val = val;
        this.next = null;
    }
}

class linked_list{

    Node head;
    public void add_last(int val){
        Node new_node = new Node(val);
        System.out.println("Inserting " + val);
        if(head == null){
            head = new_node;
        }else{
            Node currNode = head;
            while(currNode.next != null){
                currNode = currNode.next;
            }
            currNode.next = new_node;
        }
    }

    public int get_value(){
        if(head == null){
            return -1;
        }
        else{
            return head.val;
        }
    }
}



public class add_last {
    public static void main(String[] args) {
        linked_list ll = new linked_list();
        ll.add_last(100);
        System.out.println(ll.get_value()+ " is inserted at Last");
        ll.add_last(99);
        System.out.println(ll.get_value()+ " is inserted at Last");
        
    }
}
