
import java.util.Scanner;

public class Day2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter  First Number : ");
        int num = sc.nextInt();
        System.out.println("Enter  Second Number : ");
        int num2 = sc.nextInt();
        System.out.println("Enter the Operand");
        String op = sc.next();
        System.out.print("Result : ");

        switch(op){
            case "+":System.out.println(num+num2);
            break;
            case "-":System.out.println(num-num2);
            break;
            case "*":System.out.println(num*num2);
            break;
            case "/":System.out.println(num/num2);
            break;
            case "%":System.out.println(num%num2);
            break;
            default:System.out.println("Invalid number");
        }
        
        // if(num == 0){
        //     System.out.println("Zero");
        // }else if(num < 0){
        //     System.out.println("Negative");
        // }else{
        //     System.out.println("Positive");
        // }
        sc.close();

    }
    
}
