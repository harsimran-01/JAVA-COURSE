import java.util.Scanner;

public class Day6 {
    public static void table(int a) {
        for(int i=1;i<=10;i++){
            System.out.println(a + " * " + i + " = " + (a*i));
        }
        
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num");
        int num1 = sc.nextInt();
        table(num1);

        sc.close();

    }
    
}
