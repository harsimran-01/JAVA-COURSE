//check if number is prime
import java.util.*;
public class test{

public static void main(String args[]){

Scanner sc = new Scanner(System.in);
System.out.println("Enter Number");
int n = sc.nextInt();
boolean isPrime = true; 
for(int i=2;i<=n/2;i++){
if(n % i == 0){
isPrime = false;
break;
}
}

if(isPrime) System.out.println("Prime Number");
else System.out.println("Not a Prime Number");

}

}