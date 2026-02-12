import java.util.*;

public class reverse_ll{
public static void main(String args[]){

LinkedList<String> list = new LinkedList<>();
list.add("Hello");
list.add("simmi");
list.add("!");
list.add("How");
list.add("are");
list.add("You");
list.add("?");

System.out.println("Printing a List");
for(int i=0;i<list.size();i++){
System.out.print(list.get(i)+" -> ");
}

System.out.println();

System.out.println("Reversing a List");
for(int i=list.size()-1;i>=0;i--){
System.out.print(list.get(i)+" -> ");
}



}
}