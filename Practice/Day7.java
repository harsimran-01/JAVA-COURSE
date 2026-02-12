
import java.util.Scanner;

public class Day7 {

    public static void printHello() { // function defining
        System.out.println("Hello simmi");
        System.out.println("Hello simmi");
        System.out.println("Hello simmi");
        return; // optional in case of VOID return type

    }

    public static int add(int a, int b) { //parameters or formal parameters
        return a + b;
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        // System.out.println("a = "+a);
        // System.out.println("b = "+b);
    }

    public static int product(int a, int b) {
        return a * b;
    }

    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;

    }
    // public static int factorial(int n) {
    //     if(n==0||n==1){
    //         return 1;
    //     }else{
    //         return n*factorial(n-1);
    //     }

    // }
    public static int binomial_coeff(int n, int r) {
        int n_fact = factorial(n);
        int r_fact = factorial(r);
        int n_r_fact = factorial(n - r);
        return n_fact / (r_fact * n_r_fact);
    }

    public static boolean prime_num(int n) {
        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
        // if(isPrime) System.out.println("Prime Number");
        // else System.out.println("Not a Prime Number");
    }

    public static void primeNumRange(int n) {
        for (int i = 2; i <= n; i++) {
            if (prime_num(i)) {
                System.out.println(i);
            }
        }
    }

    public static int BinToD(int bin) {
        int pow = 0;
        double decimal = 0;
        while (bin > 0) {
            int lastdigit = bin % 10;
            decimal = decimal + (lastdigit * Math.pow(2, pow));
            pow++;
            bin /= 10;
        }
        return (int) decimal;
    }

    public static int DtoBinary(int n) {
        int pow = 0;
        double binary = 0;
        while (n > 0) {
            int rem = n % 2;
            binary = binary + (rem * (Math.pow(10, pow)));
            pow++;
            n /= 2;
        }
        return (int) binary;
    }

    public static int avg(int a, int b, int c) {
        int sum = a + b + c;
        return sum / 3;
    }

    public static boolean isEven(int n) {
        if (n % 2 == 0) {
            return true; 
        }else {
            return false;
        }
    }

    public static boolean isPalindrome(int n) {
        int Palindrome = n;
        int rev = 0;
        while (Palindrome != 0) {
            int rem = Palindrome % 10;
            rev = rev * 10 + rem;
            Palindrome /= 10;
        }
        if (n == rev) {
            return true; 
        }else {
            return false;
        }

    }

    public static int sumOfDigits(int n){
        int sum = 0;
        while(n>0){
            int lastdigit = n % 10;
            sum+=lastdigit;
            n/=10;
        }
        return sum;
     }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("calling printHello()");
        printHello(); // function Calling        
        printHello(); // function Calling  

        System.out.println("Enter two numbers : ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("Sum of Two Numbers = " + add(a, b)); //arguments or actual parameters

        //call by value
        System.out.println("call by value");
        // System.out.println("swapping");
        // int num1 = 5;
        // int num2 = 10;
        // System.out.println("Before swapping");
        // System.out.println(num1);
        // System.out.println(num2);
        // int temp = num1;
        // num1 = num2;
        // num2 = temp;
        // System.out.println("After swapping");
        // System.out.println(num1);
        // System.out.println(num2);

        int num1 = 5;
        int num2 = 10;
        swap(num1, num2);
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("Product of two numbers");
        System.out.println(product(a, b));

        System.out.println("Factorial");
        System.out.println("Enter number whose factorial you want to find");
        int n = sc.nextInt();
        // int fact = 1;
        // for (int i = 1; i <= n; i++) {
        //     fact *= i;
        // }
        System.out.println("Factorial = " + factorial(n));

        System.out.println("Binomial Fcatorial");
        System.out.println("Enter the value of n and r");
        int n1 = sc.nextInt();
        int r = sc.nextInt();
        System.out.println("Binomial Coefficient = " + binomial_coeff(n, r));

        System.out.println("Prime number");
        System.out.println("Enter number");
        int p = sc.nextInt();
        prime_num(p);

        System.out.println("Printing all the prime numbers in a Range");
        int pr = sc.nextInt();
        primeNumRange(pr);

        System.out.println("Conversion of Binary number to Decimal number ");
        int binary = sc.nextInt();
        System.out.println("Decimal number of " + binary + " is " + BinToD(binary));

        System.out.println("Conversion of Decimal number to Binary Number ");
        int decimal = sc.nextInt();
        System.out.println("Binary number of " + decimal + " is " + DtoBinary(decimal));

        System.out.print("Average of three numbers ");
        System.out.println(avg(10, 10, 10));

        System.out.print("Even numbers = ");
        System.out.println(isEven(3));

        System.out.println("Palindrome or not ");
        System.out.println(isPalindrome(121));

        System.out.println("Sum of digits of Integers ");
        System.out.println(sumOfDigits(121));

    }
}
