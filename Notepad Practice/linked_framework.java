import java.util.*;

public class linked_framework{
public static void main(String args[]){

LinkedList<String> list = new LinkedList<>();
System.out.println("Adding at First in List");
list.addFirst("World");
list.addFirst("Hello");
list.addFirst("Welcome");

for(int i=0;i<list.size();i++){
System.out.print(list.get(i)+" -> ");
}

System.out.println();

System.out.println("Adding at Last in List");
list.addLast("Hii");
list.addLast("Hello");
list.addLast("Simmi");

for(int i=0;i<list.size();i++){
System.out.print(list.get(i)+" -> ");

}

System.out.println();

System.out.println("Adding in Sequence");
list.add("Simmi");
list.add("Is");
list.add("Cutie");

for(int i=0;i<list.size();i++){
System.out.print(list.get(i)+" -> ");

}
System.out.println();

System.out.println("Searching an Element in List");
String search = "Hii";
boolean found = false;
for(int i=0;i<list.size();i++){
if(list.get(i).equals(search)){
found = true;
} 
}

if(found) System.out.println("Found in List");
else System.out.println("Not found in List");


list.addLast("World");
for(int i=0;i<list.size();i++){
System.out.print(list.get(i)+" -> ");

}
System.out.println();
System.out.println("Removing last Element");
list.removeLast();
for(int i=0;i<list.size();i++){
System.out.print(list.get(i)+" -> ");

}


System.out.println();
System.out.println("Removing First Element");
list.removeFirst();
for(int i=0;i<list.size();i++){
System.out.print(list.get(i)+" -> ");

}



}

}