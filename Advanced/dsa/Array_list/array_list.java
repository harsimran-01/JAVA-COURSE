
import java.util.ArrayList;
import java.util.Collections;

public class array_list {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        //adding elements in ArrayList

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list);

        //adding at specific index

        list.add(2, 01);

        System.out.println(list);

        //Printing or Getting elements from ArrayList (returns the element from the indx)

        int indx = list.get(2);
        System.out.println(indx);

        //set element at specific indx or changing the value of element from specific indx

        list.set(3, 7);
        System.out.println(list);

        //removing or deleting an element from the arraylist

        list.remove(3);
        System.out.println(list);

        list.add(21);
        list.add(12);
        System.out.println(list);

        list.remove(0);
        System.out.println(list);

        int size_array = list.size();
        System.out.println(size_array);

        System.out.println(list.isEmpty());

        System.out.println(list.contains(10));
        System.out.println(list.contains(21));

        System.out.println(list.indexOf(21));

        System.out.println(list);

        // Integer[] arr = list.toArray(new Integer[0]);
        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i]);
        // }

        Collections.sort(list);
        System.out.println(list);










    }

}
