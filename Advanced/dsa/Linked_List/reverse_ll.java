
import java.util.LinkedList;
import java.util.Scanner;

public class reverse_ll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<String>();
        list.add("Hii");
        list.add("How");
        list.add("are");
        list.add("you");

        System.out.println("Printing List");

        for(int i = 0;i<list.size();i++){
            String s = list.get(i);
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.println("Printing List in reverse Order");

        for(int i=list.size();i>0;i--){
            String s = list.get(i-1);
            System.out.print(s+ " ");
        }
        System.out.println();


        

    }
}
