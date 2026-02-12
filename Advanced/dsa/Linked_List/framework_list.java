import java.util.LinkedList;
import java.util.Scanner;

public class framework_list {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<String>();
        list.add("Add ");
        list.add("Elements in sequence");
        System.out.println(list);

        System.out.println("Add element at the begining of the List");
        list.addFirst("Kaur");
        list.addFirst("Harsimran");
        System.out.println(list);

        System.out.println("Adding elements at Last");
        list.addLast("hello World");
        list.addLast("Hello People");
        System.out.println(list);

        System.out.println("Size of the Linked List  = " + list.size());

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i) + " -> ");
        }
        System.out.println("null");

        System.out.println("Enter the element you want to search");
        String search = sc.nextLine();
        boolean found = false;

        for(int i=0;i<list.size();i++){
            if(list.get(i).equals(search)){
                System.out.println("Element found at Index " + i);
                found = true;
                break;

            }
            
        }
        if(!found){
                System.out.println("Element not found");
            }
            
list.addFirst("Hi");
            System.out.println("After removing the first");
            list.removeFirst();
            System.out.println(list);

            System.out.println("After removing the Last");

            list.removeLast();
            System.out.println(list);
    }


    
}
