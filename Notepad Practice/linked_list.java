import java.util.*;

class Node{
String data;
Node next;

Node(String data){
this.data = data;
this.next = null;
}

}

public class linked_list{

Node head;
//add first

public void addFirst(String data){
Node newNode = new Node(data);
if(head == null){
head = newNode;
}else{
newNode.next = head;
head = newNode;
}
}


//addLast

public void addLast(String data){
Node newNode = new Node(data);
if(head == null){
head = newNode;
return;
}
Node currNode = head;

while(currNode.next != null){
currNode = currNode.next;
}
currNode.next = newNode;
}

//deleteFirst

public void deleteFirst(){
if(head == null){
System.out.println("List is Empty");
return;
}
head = head.next;
}

//deleteLast

public void deleteLast(){
if(head == null){
System.out.println("List is Empty");
return;
}
if(head.next == null){
head = null;
return;
}

Node secondLast = head;
Node lastNode = head.next;
while(lastNode.next != null){
secondLast = secondLast.next;
lastNode = lastNode.next;
}
secondLast.next = null;

}



//displayNode

public void displayNode(){
if(head == null){
System.out.println("List is Empty");
}

Node currNode = head;
while(currNode != null){
System.out.print(currNode.data + " -> ");
currNode = currNode.next;
}
System.out.println("null");
}

public static void main(String args[]){
linked_list ll = new linked_list();
ll.addFirst("Hello");
ll.addFirst("Simmi");
ll.addFirst("Babyy");
ll.displayNode();

ll.addLast("Hii");
ll.addLast("Hello");
ll.displayNode();

ll.deleteFirst();
ll.displayNode();
ll.deleteLast();


ll.displayNode();
}


}