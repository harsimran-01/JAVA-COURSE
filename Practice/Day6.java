
import java.util.Scanner;

public class Day6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int n = sc.nextInt();
        //basic approach
        // String px = "";
        // for (int i = 0; i < n; i++) {
        //     px += " * ";
        //     System.out.println(px);
        // }

//STAR PATTERN
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<=i;j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
//INVERTED STAR PATTERN
// for(int i=1;i<=n;i++){
//     for(int j=n;j>=i;j--){
//         System.out.print("*");
//     }
//     System.out.println();
// }
//other approach
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= n - i + 1; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
        //HALF PYRAMID
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=i;j++){
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }
        //CHARACTER PATTERN
        // char ch = 'A';

        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= i; j++) {
        //         System.out.print(ch + " ");
        //         ch++;
        //     }
        //     System.out.println();
        // }

        //other approach

        // char a = 97;
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=i;j++){
        //         System.out.print(a);
        //         a++;
        //     }
        //     System.out.println();
        // }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
