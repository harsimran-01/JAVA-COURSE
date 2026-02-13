
import java.util.HashSet;
import java.util.Iterator;

public class hash_set {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(10);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(6); // duplicate elements will not get print
        System.out.println("Printing all the Elements of Set");
        System.out.println("Basic");
        System.out.println(set);

        System.out.println("Printing Using Iterator");
        Iterator it = set.iterator();

        //two inbuilt functions = .hasNext() and .next()

        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();

        //Searching element in Hashset
        System.out.println("Searching element in Hashset");

        if(set.contains(6)){
            System.out.println("Element is Present in HashSet");
        }

        System.out.println("Removing element from HashSet");

        set.remove(3);
        System.out.println(set);

        System.out.println("Checking whether hashset is empty or not");

        if(set.isEmpty()){
            System.out.println("HashSet is Empty");
        }else{
            System.out.println("Hashset is not Empty");
        }

        System.out.println("Displaying Size of Hashset");

        System.out.println("Size of HashSet = "+ set.size());

        System.out.println("Clearing all the Elements of HashSet");
        set.clear();

        System.out.println(set);

         System.out.println("Checking whether hashset is empty or not");

        if(set.isEmpty()){
            System.out.println("HashSet is Empty");
        }else{
            System.out.println("Hashset is not Empty");
        }
    }
}
