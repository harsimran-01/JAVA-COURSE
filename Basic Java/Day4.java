import java.util.Scanner;

public class Day4{
    public static void main(String args[]){
       Scanner sc = new Scanner(System.in);
       String name = sc.next();

       name = name.replaceAll("\\d", " ");
       
       System.out.println(name);
       sc.close();



    }
}