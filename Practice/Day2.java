
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//**************************************************** 
        System.out.println("Printing a PATTERN ");
        System.out.println("*****");
        System.out.println("****");
        System.out.println("***");
        System.out.println("**");
        System.out.println("*");

        //**************************************************** 
        System.out.println("Variables");

        int a = 10;
        int b = 20;
        int sum = a + b;
        System.out.println("Sum " + sum);
        String name = "Harsimran";
        System.out.println("Name " + name);

        b = 30;
        System.out.println("Now b is " + b);

        //**************************************************** 
        System.out.println("Data types and there Size");
        System.out.println("Byte  = 1 Byte");
        System.out.println("char = 2 Byte");
        System.out.println("Short = 2 Byte");
        System.out.println("Int = 4 Byte");
        System.out.println("float = 4 Byte");
        System.out.println("Long = 8 Byte");
        System.out.println("Double = 8 Byte");
        System.out.println("Boolean = 1 Byte");

//**************************************************** 
        System.out.println("Printing Sum of TWO varibles");
        System.out.println("Enter num1 ");
        int num1 = sc.nextInt();
        System.out.println("Enter num2 ");
        int num2 = sc.nextInt();
        int num_sum = num1 + num2;
        System.out.println("Sum = "+num_sum);

        //**************************************************** 

        System.out.println("Product of Two Numbers");
        System.out.println("Enter num1 ");
        int pnum1 = sc.nextInt();
        System.out.println("Enter num2 ");
        int pnum2 = sc.nextInt();
        int product = pnum1 * pnum2;
        System.out.println("Product = "+product);

        //**************************************************** 

        System.out.println("Area of CIRCLE");
        System.out.println("Enter Radius ");
        double r = sc.nextDouble();
        double area = 3.14 * Math.pow(r,2);
        System.out.println("Area = "+area);

    }
}
