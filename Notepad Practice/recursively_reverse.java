import java.util.*;



public class recursively_reverse{


public static void push_at_bottom(int data,Stack<Integer> sc){
if(sc.isEmpty()){
sc.push(data);
return;
}
int top = sc.pop();
push_at_bottom(data,sc);
sc.push(top);
}

public static void reverse(Stack<Integer> sc){
if(sc.isEmpty()){
return;
}

int top = sc.pop();
reverse(sc);
push_at_bottom(top,sc);


}



public static void main(String args[]){
Stack<Integer> sc = new Stack<>();
sc.push(1);
sc.push(2);
sc.push(3);
sc.push(4);
sc.push(5);
reverse(sc);

while(!sc.isEmpty()){
System.out.print(sc.peek() + " ");
sc.pop(); 
}



}

}