import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter num 1 ");
        // int num1 = sc.nextInt();
        // System.out.println("Enter num 2 ");
        // int num2 = sc.nextInt();
        // System.out.println("Enter num 3 ");
        // int num3 = sc.nextInt();
        
        // int avg = (num1 + num2 + num3) / 3;
        // System.out.println("Average of three numbers is "+avg);

        // System.out.println("Enter side of Sqaure ");
        // int side = sc.nextInt();
        // int area = side * side;
        // System.out.println("Area of Square = "+ area);

        System.out.println("Enter cost of pencil ");
        float n1 = sc.nextFloat();
        System.out.println("Enter cost of pen ");
        float n2 = sc.nextFloat();
        System.out.println("Enter cost of scale ");
        float n3 = sc.nextFloat();

        float sum = n1+n2+n3;
        float result = (sum) * 0.18f;
        float total = sum + result;
        System.out.println("Total cost after 18% GST " + total);
    }
}
