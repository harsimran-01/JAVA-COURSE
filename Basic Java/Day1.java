
import java.util.Scanner;
public class Day1{
    public static void main(String[] args) {
        // System.out.println("Simmi");
        // System.out.print("Simmi loves sagar");

        // String name = "Simmi";
        // System.out.println(name);

        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter your name");
        // String name = sc.nextLine();
        // System.out.println("Hello "+ name);

        System.out.println("Enter the number");
        int a = sc.nextInt();
        System.out.println("Table of "+ a);
        for(int i=1;i<=10;i++){
            System.out.println(a+" * " + i + " = " + (a*i));
        }
        // System.out.println(a + " * " + 1 + " = " + (a*1));
        // System.out.println(a + " * " + 2 + " = " + (a*2));
        // System.out.println(a + " * " + 3 + " = " + (a*3));
        // System.out.println(a + " * " + 4 + " = " + (a*4));
        // System.out.println(a + " * " + 5 + " = " + (a*5));
        // System.out.println(a + " * " + 6 + " = " + (a*6));
        // System.out.println(a + " * " + 7 + " = " + (a*7));
        // System.out.println(a + " * " + 8 + " = " + (a*8));
        // System.out.println(a + " * " + 9 + " = " + (a*9));
        // System.out.println(a + " * " + 10 + " = " + (a*10));
        

        // String px = "";
        // for(int i=0;i<4;i++){
        //     px = px + " *";
        //     System.out.println(px);
            
        // }
        sc.close();

    }
}