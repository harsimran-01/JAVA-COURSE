import java.util.*;
public class array_list{
public static void main(String args[]){
ArrayList<Integer> list = new ArrayList<>();
//adding in ArrayList
list.add(1);
list.add(2);
list.add(3);
list.add(4);
list.add(5);
System.out.println("Displaying the Array List");
System.out.println(list);

//adding at specific Index
System.out.println("Adding at 2nd Index");
list.add(2,13);
System.out.println(list);

//Getting the Element through Index
System.out.println("Returning the value of Specific Index");
int a = list.get(2);
System.out.println(a);

//updating values at Specific Index
System.out.println("updating values at Specific Index");
list.set(2,07);
System.out.println(list);

//removing element at index
System.out.println("removing element at index");
list.remove(0);
System.out.println(list);

//returning the size of ArrayList
System.out.println("Size of ArrayList = "+ list.size());

//checking whether the list is empty or not
if(list.isEmpty())
System.out.println("ArrayList is Empty");
else
System.out.println("ArrayList is Not Empty");

//checking whether the element is present in list or not

if(list.contains(7))
System.out.println("Element found in ArrayList");
else
System.out.println("Element Not found in ArrayList");

//Returning the Index of Element
System.out.println("Returning the Index of 7 = "+list.indexOf(7));

//Converting the ArrayList to Array
System.out.println("Converting the ArrayList to Array");
Integer[] arr = list.toArray(new Integer[0]);
for(int i=0;i<arr.length;i++)
System.out.print(arr[i] + " ");

System.out.println();

System.out.println("Sorting ArrayList");
Collections.sort(list);
System.out.println(list);



}
}