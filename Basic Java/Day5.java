import java.util.Scanner;


public class Day5 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        // int col = sc.nextInt();
    
        upper(row);
        below(row);
        sc.close();

        

    
        
    }
    public static void upper(int num){
        for(int i=1;i<=num;i++){
            int spaces = num - i;
            for(int j=1;j<=spaces;j++){
                System.out.print(" ");
                
            }
            for(int j=i;j>=1;j--){
                System.out.print("*");
            }

            for(int j=2;j<=i;j++){
                System.out.print("*");
            }
            int spaces2 = num - i;
            for(int j=1;j<=spaces2;j++){
                System.out.print(" ");
                
            }
            System.out.println();
        }
    }
    public static void below(int num){
        for(int i=num;i>=1;i--){
            int spaces = num - i;
            for(int j=1;j<=spaces;j++){
                System.out.print(" ");
                
            }
            for(int j=i;j>=1;j--){
                System.out.print("*");
            }

            for(int j=2;j<=i;j++){
                System.out.print("*");
            }
            int spaces2 = num - i;
            for(int j=1;j<=spaces2;j++){
                System.out.print(" ");
                
            }
            System.out.println();
        }

    }
    
}
