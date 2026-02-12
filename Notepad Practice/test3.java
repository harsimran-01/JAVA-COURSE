import java.util.*;
public class test3{

public static void main(String args[]){

Scanner sc = new Scanner(System.in);
System.out.println("Enter the String ");
String name = sc.nextLine();

String res = "";

for(int i=name.length()-1;i>=0;i--){
res+=name.charAt(i);

}

if(name.equals(res)) System.out.println("String is Palindrome");
else System.out.println("String is Not Palindrome");

}

}