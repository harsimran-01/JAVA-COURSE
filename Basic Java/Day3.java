
import java.util.Scanner;


public class Day3 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number: ");
        int num  = sc.nextInt();
        for(int i=1;i<=10;i++){
            System.out.println(i + "*" + num + "=" + (i*num));
        }
        sc.close();
    }
    
}
