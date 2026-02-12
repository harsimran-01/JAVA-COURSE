
import java.util.Scanner;

public class Day4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num  ");
        int num1 = sc.nextInt();
        // System.out.println("Enter num 2 ");
        // int num2 = sc.nextInt();
        // System.out.println("Enter the operation to perform ");
        // char op = sc.next().charAt(0);
        // System.out.println("Enter num 3 ");
        // int num3 = sc.nextInt();
        // //Largest of Two numbers
        // if(num1 > num2){
        //     System.out.println(num1 + " is greater than "+num2);
        // }else{
        //     System.out.println(num2 + " is greater than "+num1);
        // }

        // if(num % 2 == 0){
        //     System.out.println("Even Number");
        // }else{
        //     System.out.println("Odd Number");
        // }

        // String type = ((num1 % 2 == 0) ? "Even " : "Odd ");
        // System.out.println(type);

        // String result = ((num1>=33) ? "Pass ":"Fail");
        // System.out.println(result);


        // if(num >= 18){
        //     System.out.println("Adult");
        // }else if(num>=14 && num<= 17){
        //     System.out.println("Teenager");
        // }else{
        //     System.out.println("Child");
        // }


        // int tax = 0;
        // if (num < 500000) {
        //     tax = 0;
        // } else if (num >= 500000 && num < 1000000) {
        //     tax = (int) (num * 0.2);
        // } else {
        //     tax = (int) (num * 0.3);
        // }

        // System.out.println(tax);

        // int max = num1;
        // if(num2 > max){
        //     max = num2;
        // }
        // if(num3>max){
        //     max = num3;
        // }
        // System.out.println("Largest of Three Numbers " + max);


        // switch(num1){
        //     case 1:System.out.println("Burger");
        //     break;
        //     case 2:System.out.println("Samosa");
        //     break;
        //     case 3: System.out.println("Pizza");
        //     break;
        //     default: System.out.println("Junk food is not Healthy");
        // }

        // switch(op){
        //     case '+':System.out.println("Sum = "+(num1+num2));
        //     break;
        //     case '-':System.out.println("Subtract = "+(num1-num2));
        //     break;
        //     case '*':System.out.println("Product = "+(num1*num2));
        //     break;
        //     case '/':System.out.println("Divisor = "+(num1/num2));
        //     break;
        //     case '%':System.out.println("Remainder = "+(num1%num2));
        //     break;
            
        // }

        // if(num1 > 0){
        //     System.out.println("Positive Number");
        // }else if(num1<0){
        //     System.out.println("Negative Number");
        // }else{
        //     System.out.println("Number is Zero");
        // }


        // double temp = sc.nextDouble();
        // if(temp >= 100){
        //     System.out.println("You have Fever");
        // }else{
        //     System.out.println("You are Normal");
        // }

        // switch(num1){
        //     case 1:System.out.println("Monday");
        //     break;
        //     case 2:System.out.println("Tuesday");
        //     break;
        //     case 3:System.out.println("Wednesday");
        //     break;
        //     case 4:System.out.println("Thursday");
        //     break;
        //     case 5:System.out.println("Friday");
        //     break;
        //     case 6:System.out.println("Saturday");
        //     break;
        //     case 7:System.out.println("Sunday");
        //     break;
        // }

        if(num1 % 4 == 0){
            if(num1 % 100 == 0){
                if(num1 % 400 == 0){
                    System.out.println("Leap Year");
                }else{
                    System.out.println("Not a Leap Year");
                }
            }else{
                System.out.println("Leap Year");
            }
        }else{
            System.out.println("Not a Leap Year");
        }





    }

}
