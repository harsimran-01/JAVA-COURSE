
import java.util.Scanner;

public class Day5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter Number");
        // int n = sc.nextInt();
        // while(n>0){
        //     System.out.print(n + " ");
        //     n--;
        // }

        // int n = 1;
        // while(n<=10){
        //     System.out.print(n + " ");
        //     n++;
        // }
        // int i = 1;
        // while (i <= n) {
        //     System.out.print(i + " ");
        //     i++;
        // }
        // int sum = 0;
        // int i = 1;
        // while(i<=n){
        //     sum+=i;
        //     i++;
        // }
        // System.out.println("Sum = "+ sum);
        // for (int i = 0; i < n; i++) {
        //     System.out.println("Hello World " + i);
        // }
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=n;j++){
        //         System.out.print(" * ");
        //     }
        //     System.out.println();
        // }
        // int i = 1;
        // while (i <= n) {
        //     System.out.println(" * * * * ");
        //     i++;
        // }
        // while(n>0){
        //     int lastdigit = n % 10;
        //     System.out.print(lastdigit+" ");
        //     n/=10;
        // }
        // for(;n>0;n/=10){
        //     int lastdigit = n%10;
        // System.out.print(lastdigit+" ");
        // }
        // int rev = 0;
        // while(n>0){
        //     int lastdigit = n%10;
        //     rev = (rev*10) + lastdigit;
        //     n/=10;
        // }
        // System.out.println(rev);
        // do { 
        //     int n = sc.nextInt();
        //     if(n % 10 == 0){
        //         break;
        //     }
        //     System.out.println(n);
        // } while (true);
        // for(int i=1;i<=5;i++){
        //     if(i==3){
        //         continue;
        //     }System.out.println(i);
        // }
        // do { 
        //     int n = sc.nextInt();
        //     if(n%10==0){
        //         continue;
        //     }
        //     System.out.println(n);
        // } while (true);
        // boolean isPrime = true;
        // for (int i = 2; i <= n / 2; i++) {
        //     if (n % i == 0) {
        //         isPrime = false;
        //         break;
        //     }
        // }
        // if (isPrime) {
        //     System.out.println("Prime Number");
        // } else {
        //     System.out.println("Not a Prime Number");
        // }



//         int number;
//         int choice = 0;
//         int evensum = 0;
//         int oddsum = 0;

//         do {
//             System.out.println("Enter number");
//             number = sc.nextInt();

//             if (number % 2 == 0) {
//                 evensum += number;
//             } else {
//                 oddsum += number;
//             }

//             System.out.println("enter 1 to enter more number and 0 to no");
//             choice = sc.nextInt();
//         } while (choice == 1);

// System.out.println("Even sum " + evensum);
// System.out.println("Odd sum " + oddsum);


// System.out.println("Enter number");
// int num = sc.nextInt();
// int fact = 1;
// for(int i=1;i<=num;i++){
//     fact*=i;
// }
// System.out.println("Factorial of "+num+" is "+ fact);

System.out.println("Enter number whose multiplication table you want to print");
int num = sc.nextInt();

for(int i=1;i<=10;i++){
    System.out.println(num + " * "+i+" = "+num*i);
}

    }

}
