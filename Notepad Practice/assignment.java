
//import java.util.*;
//public class assignment{
//public static void main(String args[]){

//Scanner sc = new Scanner(System.in);
//System.out.print("Enter number :");
//int num = sc.nextInt();

//if(num % 2 == 0)System.out.println(num +" is an EVEN Number");
//else System.out.println(num + " is an ODD Number");

//}
//}

//import java.util.*;
//public class assignment{
//public static void main(String args[]){

//Scanner sc = new Scanner(System.in);
//System.out.print("Enter Principal value :");
//double principal = sc.nextDouble();
//System.out.print("Enter Rate :");
//double rate = sc.nextDouble();
//System.out.print("Enter Time :");
//double time = sc.nextDouble();

//double simpleInterest = (principal * rate * time) / 100.0;

//System.out.print("Simple Interest = "+ simpleInterest);

//}
//}

//import java.util.*;
//public class assignment{
//public static void main(String args[]){

//Scanner sc = new Scanner(System.in);
//System.out.print("Enter Number 1 :");
//int num1 = sc.nextInt();
//System.out.print("Enter Number 2 :");
//int num2 = sc.nextInt();

//if(num1 > num2){
//System.out.println("Maximum number = "+num1);
//}else{
//System.out.println("Maximum number = "+num2);
//}
//}}


//import java.util.*;
//public class assignment{
//public static void main(String args[]){

//Scanner sc = new Scanner(System.in);
//System.out.print("Enter Number whose Multiplication Table you want to print :");
//int num = sc.nextInt();
//System.out.println("Multiplication Table of "+num);
//for(int i=1;i<=10;i++){
//System.out.println(num + " * " + i +" = " + (num * i));
//}
//}}

//import java.util.*;
//public class assignment{
//public static void main(String args[]){

//Scanner sc = new Scanner(System.in);
//System.out.print("Enter Number :");
//int num = sc.nextInt();
//boolean isPrime = true;

//if(num < 2) {
//System.out.println(num + " is not a PRIME Number ");
//return;
//}
//for(int i=2;i<=Math.sqrt(num);i++){
//if(num % i == 0){
//isPrime = false;
//break;
//}}

//if(isPrime) System.out.println(num + " is a PRIME Number ");
//else System.out.println(num +" is not a PRIME Number ");

//}}

//import java.util.*;
//public class assignment{
//public static void main(String args[]){

//Scanner sc = new Scanner(System.in);
//System.out.print("Enter the Size of Array :");
//int size = sc.nextInt();
//int arr[] = new int[size];

//System.out.print("Enter Elements of Array :");
//for(int i=0;i<size;i++){
//arr[i] = sc.nextInt();
//}

//int max = arr[0];
//for(int i=0;i<size;i++){
//if(arr[i] > max){
//max = arr[i];
//}}

//System.out.println("Largest Element in Array is = " + max);


//}}

//import java.util.*;
//public class assignment{
//public static void main(String args[]){

//Scanner sc = new Scanner(System.in);
//System.out.print("Enter Number :");
//int num = sc.nextInt();


//int rev = 0;
//while(num>0){
//int lastDigit = num % 10;
//rev = (rev * 10) + lastDigit;
//num/=10;
//}

//System.out.println("Reversed Number = " +rev);


//}}

//import java.util.*;
//public class assignment{
//public static void main(String args[]){

//Scanner sc = new Scanner(System.in);
//System.out.print("Enter a String :");
//String s = sc.nextLine();


//String rev = "";
//for(int i=s.length()-1;i>=0;i--){
//rev+=s.charAt(i);
//}

//if(s.equals(rev)) System.out.println("String is Palindrome");
//else System.out.println("String is Not Palindrome");


//}}


//import java.util.*;
//public class assignment{
//public static void main(String args[]){

//Scanner sc = new Scanner(System.in);
//System.out.print("Enter Number of Row:");
//int row = sc.nextInt();

//String px = "";
//for(int i=1;i<row;i++){
//px+=i;
//System.out.println(px);
//}

//}}


import java.util.*;
public class assignment{
public static void main(String args[]){

Scanner sc = new Scanner(System.in);
System.out.print("Enter the Size of Array :");
int size = sc.nextInt();
int arr[] = new int[size];

System.out.print("Enter Elements of Array :");
for(int i=0;i<size;i++){
arr[i] = sc.nextInt();
}

System.out.println("Printing Elements:");
for(int i=0;i<size;i++){
System.out.print(arr[i] + " ");
}

for(int i=0;i<size-1;i++){
for(int j=0;j<size-1;j++){

if(arr[j] > arr[j+1]){
int temp = arr[j];
arr[j] = arr[j+1];
arr[j+1] = temp;
}

}}

System.out.println();
System.out.println("Printing Elements in Sorted Order:");
for(int i=0;i<size;i++){
System.out.print(arr[i] + " ");
}


}}


























