import java.util.*;

public class stack_arraylist{

static class Node{
int data;
Node next;
public Node(int data){
this.data = data;
this.next = null;
}
}

static class Stack_arrayList{

static ArrayList<Integer> list = new ArrayList<>();

public static boolean isEmpty(){
return list.size() == 0;
}

public static void push(int data){
list.add(data);
}

public static int pop(){
if(isEmpty()){
return -1;
}
int top = list.get(list.size()-1);
list.remove(list.get(list.size()-1));
return top;
}

public static int peek(){
if(isEmpty()){
return -1;
}
int top = list.get(list.size()-1);
return top;
}


}





public static void main(String args[]){
Stack_arrayList.push(1);
Stack_arrayList.push(2);
Stack_arrayList.push(3);
Stack_arrayList.push(4);
Stack_arrayList.push(5);
System.out.println("Created using Array List");
while(!Stack_arrayList.isEmpty()){
System.out.print(Stack_arrayList.peek() + " ");
Stack_arrayList.pop();
}

}
}